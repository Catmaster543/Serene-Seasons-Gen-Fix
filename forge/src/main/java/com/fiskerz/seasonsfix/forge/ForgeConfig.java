package com.fiskerz.seasonsfix.forge;

import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfig {

    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue ENABLE_WORLDGEN_FIX;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLE_WORLDGEN_FIX = builder
                .comment("Skip Serene Seasons' seasonal freeze check during chunk generation.")
                .define("enableWorldgenFix", true);

        SPEC = builder.build();
    }
}