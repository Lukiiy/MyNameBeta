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
    private void myName_render(PlayerEntity d, double e, double f, double par4, CallbackInfo ci) {
        if (MyName.mc.currentScreen != null) return;

        ((LabelRenderAccessor) this).renderLabel(d, d.name, e, f, par4, 64);
        ci.cancel();
    }
}
