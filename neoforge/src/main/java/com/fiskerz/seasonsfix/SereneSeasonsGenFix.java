package com.fiskerz.seasonsfix;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

// The value here must match the modId declared in META-INF/neoforge.mods.toml.
@Mod(Constants.MOD_ID)
public class SereneSeasonsGenFix {

    public SereneSeasonsGenFix(IEventBus modEventBus, ModContainer modContainer) {

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        CommonClass.init();
    }
}
