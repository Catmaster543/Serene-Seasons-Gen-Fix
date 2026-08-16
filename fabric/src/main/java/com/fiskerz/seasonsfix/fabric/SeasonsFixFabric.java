package com.fiskerz.seasonsfix.fabric;

import com.fiskerz.seasonsfix.CommonClass;
import net.fabricmc.api.ModInitializer;

public class SeasonsFixFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        FabricConfig.load();
        CommonClass.init();
    }
}
