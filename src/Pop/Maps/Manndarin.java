package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Manndarin
 */
public class Manndarin extends Map {
    /**
     * Constructor
     */
    public Manndarin() {
        super();
        name = "Manndarin";
        popfileName = "manndarin_final";
        canSpawnEngineers = false; //TODO investigate this

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MANNDARIN_INVASION);
        tankRoutes.add(TankRoutes.MANDARIN);
    }
}
