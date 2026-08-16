package com.fiskerz.seasonsfix.neoforge;

import com.fiskerz.seasonsfix.IConfigHelper;
import com.fiskerz.seasonsfix.Config;

public class NeoForgeConfigHelper implements IConfigHelper {
    @Override
    public boolean isWorldgenFixEnabled() {
        return Config.ENABLE_WORLDGEN_FIX.get();
    }
}