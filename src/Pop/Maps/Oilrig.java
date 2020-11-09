package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Oilrig
 */
public class Oilrig extends Map {
    /**
     * Constructor
     */
    public Oilrig() {
        super();
        name = "Oilrig";
        popfileName = "oilrig_rc3";
        canSpawnEngineers = false;

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_OILRIG_BOSS);

        tankRoutes.add(TankRoutes.OILRIG_1);
        tankRoutes.add(TankRoutes.OILRIG_2);
    }
}
