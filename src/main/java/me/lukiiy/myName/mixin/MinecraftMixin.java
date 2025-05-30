package me.lukiiy.myName.mixin;

import me.lukiiy.myName.MyName;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private void myName_getGameInstnace(CallbackInfo ci) {
        MyName.mc = (Minecraft) (Object) this;
    }
}
