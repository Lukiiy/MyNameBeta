package me.lukiiy.myName.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntityRenderer.class)
public interface LabelRenderAccessor {
    @Invoker("method_818")
    void renderLabel(LivingEntity entity, String str, double x, double y, double z, int dist);
}