package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

public class Sharp extends Map {
    public Sharp() {
        super();
        name = "Sharp";
        popfileName = "sharp_rc6a";
        canSpawnEngineers = true;

        tankRoutes.add(TankRoutes.SHARP);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_SECONDARY);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_INVASION);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SHARP_SECONDARY);
    }
}
