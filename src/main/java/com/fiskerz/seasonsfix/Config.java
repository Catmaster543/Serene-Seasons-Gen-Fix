package com.fiskerz.seasonsfix;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue ENABLE_LOGGING;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        ENABLE_LOGGING = builder
                .comment("Enable or disable logging to the console.",
                        "If enabled may cause some additional lag")
                .define("enableLogging", false);

        SPEC = builder.build();
    }
}
