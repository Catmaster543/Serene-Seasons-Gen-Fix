package com.fiskerz.seasonsfix;

import java.util.ServiceLoader;

public interface IConfigHelper {

    IConfigHelper INSTANCE = ServiceLoader.load(IConfigHelper.class)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No IConfigHelper implementation found"));

    boolean isWorldgenFixEnabled();
}
