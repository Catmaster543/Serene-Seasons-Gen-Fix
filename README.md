# ❓ What does this mod do?

This mod adds one mixin that bypasses a certain chunk in serene seasons code that uses a known problematic method, thus preventing server crashes. 

Ussualy the error in server log will look something like this:
```
[Server thread/ERROR] [net.minecraft.util.thread.BlockableEventLoop/FATAL]: Error executing task on Chunk source main thread executor for minecraft:overworld
net.minecraft.ReportedException: Exception generating new chunk
	at TRANSFORMER...
...at java.base/java.lang.Thread.run(Thread.java:1474) [?:?]
Caused by: java.lang.IllegalStateException: Requested chunk unavailable during world generation
	at TRANSFORMER/minecraft@1.21.1/net.minecraft.server.level.WorldGenRegion.getChunk(WorldGenRegion.java:129) ~[server-1.21.1-20240808.144430-srg.jar%23195!/:?]
	at TRANSFORMER/minecraft@1.21.1/net.minecraft.world.level.LevelReader.getNoiseBiome(LevelReader.java:59) ~[server-1.21.1-20240808.144430-srg.jar%23195!/:?]
	at TRANSFORMER/minecraft@1.21.1/net.minecraft.world.level.biome.BiomeManager.getBiome(BiomeManager.java:79) ~[server-1.21.1-20240808.144430-srg.jar%23195!/:?]
	at TRANSFORMER/minecraft@1.21.1/net.minecraft.world.level.LevelReader.getBiome(LevelReader.java:39) ~[server-1.21.1-20240808.144430-srg.jar%23195!/:?]
	at TRANSFORMER/sereneseasons@10.1.0.3/sereneseasons.season.SeasonHooks.warmEnoughToRainSeasonal(SeasonHooks.java:106) ~[SereneSeasons%20v10.1.0.3.jar%23254!/:10.1.0.3]
	at TRANSFORMER/sereneseasons@10.1.0.3/sereneseasons.season.SeasonHooks.shouldFreezeWarmEnoughToRainHook(SeasonHooks.java:51) ~[SereneSeasons%20v10.1.0.3.jar%23254!/:10.1.0.3]
```

After which the server crashes. This is because of a "crash chain" :

1. `LakeFeature` calls `biome.shouldFreeze(worldGenLevel, pos, false)` during chunk gen
2. Serene Seasons has a `@Redirect` inside `Biome.shouldFreeze` that replaces the vanilla `warmEnoughToRain(pos)` call
3. Serene Season's hook calls `level.getBiome(pos)` to factor in the current season
4. `WorldGenRegion.getChunk()` throws `IllegalStateException: Requested chunk unavailable during world generation`

Since I have not found any other mod do this, or any optimal solution I decided to make it myself.

---
## ❗Disclaimer 
The mod is very barebones and **I do not guarantee that it will fix the issue**.
From my testing I was able to generate over 200 000 chunks without any problems/crashes (before I made this mod the server crashed after just about 50 chunks were generated), but that does not mean it will fix the issue in your case.

---
## ⭐ Tip 
I reccomend using this alongside [WorldGenFeatureFix](https://modrinth.com/mod/worldgenfeaturefix) (not sponsored or anything)

---
## ❔ Have any questions?
Feel free to ask, I'll try my best to answer.

---

### ⚪Credits
[Claude](https://claude.ai) - help with troubleshooting various issues and collecting information about this issue online
