package com.fiskerz.seasonsfix.fabric;

import com.fiskerz.seasonsfix.IConfigHelper;

public class FabricConfigHelper implements IConfigHelper {
    @Override
    public boolean isWorldgenFixEnabled() {
        return FabricConfig.enableWorldgenFix;
    }
}