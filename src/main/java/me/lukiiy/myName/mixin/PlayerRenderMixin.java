package me.lukiiy.myName.mixin;

import me.lukiiy.myName.MyName;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerEntityRenderer.class)
public class PlayerRenderMixin {
    @Inject(method = "method_821(Lnet/minecraft/entity/player/PlayerEntity;DDD)V", at = @At("HEAD"), cancellable = true)
    private void myName$render(PlayerEntity d, double e, double f, double par4, CallbackInfo ci) {
        if (MyName.mc.currentScreen != null || d != MyName.mc.player) return; // safeyy

        double y = d.method_1373() ? f - .125 : f;
        ((LabelRenderAccessor) this).myName$renderLabel(d, d.name, e, y, par4, 32);

        ci.cancel();
    }
}
