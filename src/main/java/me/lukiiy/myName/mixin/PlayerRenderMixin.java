package me.lukiiy.myName.mixin;

import me.lukiiy.myName.MyName;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.entity.mob.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerRenderer.class)
public class PlayerRenderMixin {
    @Inject(method = "renderNameTag(Lnet/minecraft/entity/mob/player/PlayerEntity;DDD)V", at = @At("HEAD"), cancellable = true)
    private void myName$render(PlayerEntity entity, double dx, double dy, double dz, CallbackInfo ci) {
        if (MyName.mc.screen != null || entity != MyName.mc.player) return; // safeyy

        double y = entity.isSneaking() ? dy - .125 : dy;
        ((LabelRenderAccessor) this).myName$renderLabel(entity, entity.name, dx, y, dz, 32);

        ci.cancel();
    }
}