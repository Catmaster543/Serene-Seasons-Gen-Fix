package com.fiskerz.seasonsfix.fabric;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class FabricConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("seasonsfix.json");

    public static boolean enableWorldgenFix = true;

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                Data data = GSON.fromJson(reader, Data.class);
                if (data != null) enableWorldgenFix = data.enableWorldgenFix;
            } catch (IOException e) {
                throw new RuntimeException("Failed to read seasonsfix.json", e);
            }
        } else {
            save();
        }
    }

    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            Data data = new Data();
            data.enableWorldgenFix = enableWorldgenFix;
            GSON.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write seasonsfix.json", e);
        }
    }

    private static class Data {
        boolean enableWorldgenFix = true;
    }
}