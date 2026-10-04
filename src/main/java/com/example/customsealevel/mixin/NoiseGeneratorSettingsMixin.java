package com.example.customsealevel.mixin;

import com.example.customsealevel.Config;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin {

    @Shadow @org.spongepowered.asm.mixin.Final private int seaLevel;

    @Inject(method = "seaLevel", at = @At("HEAD"), cancellable = true)
    private void customsealevel$modifySeaLevel(CallbackInfoReturnable<Integer> cir) {
        try {
            if (Config.ENABLED != null && Config.ENABLED.get()) {
                if (this.seaLevel == 63) {
                    cir.setReturnValue(Config.SEA_LEVEL.get());
                }
            }
        } catch (Exception ignored) {
        }
    }
}