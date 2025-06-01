package com.reivax.projgorilla.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.custom.GorillaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GorillaRenderer extends MobRenderer<GorillaEntity, GorillaModel<GorillaEntity>> {
    public GorillaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GorillaModel<>(pContext.bakeLayer(ModModelLayers.GORILLA_LAYER)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(GorillaEntity gorillaEntity) {
        return new ResourceLocation(ProjectGorilla.MOD_ID, "textures/entity/gorilla.png");
    }

    @Override
    public void render(GorillaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
