package com.fiskerz.seasonsfix.forge;

import com.fiskerz.seasonsfix.IConfigHelper;

public class ForgeConfigHelper implements IConfigHelper {
    @Override
    public boolean isWorldgenFixEnabled() {
        return ForgeConfig.ENABLE_WORLDGEN_FIX.get();
    }
}
