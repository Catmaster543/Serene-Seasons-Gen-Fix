package com.fiskerz.seasonsfix.mixin;

import com.fiskerz.seasonsfix.Config;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Fixes a crash caused by Serene Seasons calling level.getBiome() inside its
 * @Redirect on Biome#shouldFreeze during world generation, where chunk data is
 * not yet fully available (WorldGenRegion). We bail out early with false when
 * running inside a WorldGenRegion — water will still freeze naturally via
 * random ticks once the chunk is properly loaded.
 */
@Mixin(value = Biome.class, priority = 2000)
public class MixinBiome {
    @Unique
    private static final Logger LOGGER = LogUtils.getLogger();


    @Inject(
            method = "shouldFreeze(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;Z)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void ssfix_shouldFreeze(
            LevelReader level,
            BlockPos pos,
            boolean mustBeAtEdge,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (level instanceof WorldGenRegion) {
            if (Config.ENABLE_LOGGING.get()) {
                LOGGER.warn("SereneSeasonGenFix: Skipping shouldFreeze in WorldGenRegion at {}", pos);
            }
            cir.setReturnValue(false);
        }
    }

}