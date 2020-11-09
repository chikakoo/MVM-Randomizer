package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * ShiverPeak
 */
public class ShiverPeak extends Map {
    /**
     * Constructor
     */
    public ShiverPeak() {
        super();
        name = "Shiver Peak";
        popfileName = "shiverpeak_rc2";
        canSpawnEngineers = false;
        hasTanksButNoName = true;

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        spyBotSpawnLocations.clear();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        sniperBotSpawnLocations.clear();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHIVER_PEAK_FLANK);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SNIPER);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHIVER_PEAK_FLANK);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHIVER_PEAK_FLANK);
    }
}
