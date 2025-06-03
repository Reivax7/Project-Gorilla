package com.reivax.projgorilla.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.reivax.projgorilla.entity.animations.ModAnimationDefinitions;
import com.reivax.projgorilla.entity.custom.GorillaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GorillaModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart Gorilla;
	private final ModelPart Body;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart front_right_arm;
	private final ModelPart front_left_arm;
	private final ModelPart back_left_leg;
	private final ModelPart back_right_leg;

	public GorillaModel(ModelPart root) {
		this.Gorilla = root.getChild("Gorilla");
		this.Body = this.Gorilla.getChild("Body");
		this.Torso = this.Body.getChild("Torso");
		this.Head = this.Torso.getChild("Head");
		this.front_right_arm = this.Body.getChild("front_right_arm");
		this.front_left_arm = this.Body.getChild("front_left_arm");
		this.back_left_leg = this.Gorilla.getChild("back_left_leg");
		this.back_right_leg = this.Gorilla.getChild("back_right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gorilla = partdefinition.addOrReplaceChild("Gorilla", CubeListBuilder.create(), PartPose.offset(1.0F, 4.0F, -11.0F));

		PartDefinition Body = Gorilla.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-8.0F, 0.0F, 5.0F, 14.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create()
						.texOffs(20, 54)
						.addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(0, 27)
						.addBox(-5.0F, -7.0F, 1.5F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_right_arm = Body.addOrReplaceChild("front_right_arm",
				CubeListBuilder.create().texOffs(32, 27)
						.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 21.0F, 6.0F),
				PartPose.offset(6.0F, -1.0F, 3.0F));

		PartDefinition front_left_arm = Body.addOrReplaceChild("front_left_arm",
				CubeListBuilder.create().texOffs(0, 46)
						.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 21.0F, 6.0F),
				PartPose.offset(-8.0F, -1.0F, 3.0F));

		PartDefinition back_left_leg = Gorilla.addOrReplaceChild("back_left_leg",
				CubeListBuilder.create().texOffs(52, 48)
						.addBox(-5.5F, -3.0F, 6.0F, 6.0F, 16.0F, 5.0F),
				PartPose.offset(-5.0F, 7.0F, 11.0F));

		PartDefinition back_right_leg = Gorilla.addOrReplaceChild("back_right_leg",
				CubeListBuilder.create().texOffs(52, 27)
						.addBox(-1.5F, -3.0F, 6.0F, 6.0F, 16.0F, 5.0F),
				PartPose.offset(4.0F, 7.0F, 11.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.Gorilla_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((GorillaEntity) entity).attackAnimationState, ModAnimationDefinitions.GORILLA_ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30f, 30f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25f, 45f);

		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Gorilla.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Gorilla;
	}
}
