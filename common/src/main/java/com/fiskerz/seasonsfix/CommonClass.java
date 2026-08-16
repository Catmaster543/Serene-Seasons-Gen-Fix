package com.fiskerz.seasonsfix;

import com.fiskerz.seasonsfix.platform.Services;

// Shared entry point. Each loader's own entry point calls this once the loader specific
// config has been registered, so that the platform services are known to resolve before
// the mixin ever asks for them during world generation.
public class CommonClass {

    public static void init() {

        // Deliberately does NOT call Services.PLATFORM.getEnvironmentName(): that routes to
        // FMLLoader.isProduction(), which NeoForge turned from a static into an instance method in
        // 21.11 (MC 1.21.11). Calling it kills mod construction there with IncompatibleClassChangeError,
        // for a log line we don't need. getPlatformName() just returns a constant and is safe.
        Constants.LOG.info("{} loaded on {}",
                Constants.MOD_NAME,
                Services.PLATFORM.getPlatformName());

        // Touch the config service so a broken/missing META-INF/services registration fails
        // loudly at startup instead of halfway through generating a chunk. Do NOT read a config
        // *value* here: on Forge and NeoForge the config file is not loaded yet at construction
        // time and ForgeConfigSpec/ModConfigSpec would throw "Cannot get config value before
        // config is loaded."
        Constants.LOG.info("Config provider: {}", IConfigHelper.INSTANCE.getClass().getName());
    }
}
