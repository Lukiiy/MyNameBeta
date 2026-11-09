package me.lukiiy.myName.mixin;

import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MobRenderer.class)
public interface LabelRenderAccessor<T extends MobEntity> {
    @Invoker("renderNameTag")
    void myName$renderLabel(T entity, String name, double dx, double dy, double dz, int range);
}