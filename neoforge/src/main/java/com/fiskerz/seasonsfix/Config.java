package com.fiskerz.seasonsfix;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue ENABLE_WORLDGEN_FIX;
    public static final ModConfigSpec.BooleanValue ENABLE_LOGGING;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        ENABLE_WORLDGEN_FIX = builder
                .comment("Skip Serene Seasons' seasonal freeze check during chunk generation.")
                .define("enableWorldgenFix", true);

        ENABLE_LOGGING = builder
                .comment("Enable or disable logging to the console.",
                        "If enabled may cause some additional lag")
                .define("enableLogging", false);

        SPEC = builder.build();
    }
}
