package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

public class Sharp extends Map {
    public Sharp() {
        super();
        name = "Sharp";
        popfileName = "hideout_b3";
        canSpawnEngineers = true;

        tankRoutes.add(TankRoutes.SHARP);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_SECONDARY);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_INVASION);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_MIDDLE);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_SECONDARY);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_MIDDLE);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_RIGHT);
    }
}
