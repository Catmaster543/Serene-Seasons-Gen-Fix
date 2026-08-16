package com.fiskerz.seasonsfix.forge;

import com.fiskerz.seasonsfix.CommonClass;
import com.fiskerz.seasonsfix.Constants;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

// The value here must match the modId declared in META-INF/mods.toml.
@Mod(Constants.MOD_ID)
public class SeasonsFixForge {

    public SeasonsFixForge() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ForgeConfig.SPEC);
        CommonClass.init();
    }
}
