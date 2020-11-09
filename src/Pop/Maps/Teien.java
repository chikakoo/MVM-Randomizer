package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Teien
 */
public class Teien extends Map {
    /**
     * Constructor
     */
    public Teien() {
        super();
        name = "Teien";
        popfileName = "teien_rc3";

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TEIEN_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TEIEN_LOWER);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TEIEN_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TEIEN_LOWER);

        // TODO: does Teien actually have tanks?
//        tankRoutes.add(TankRoutes.TEIEN_1);
//        tankRoutes.add(TankRoutes.TEIEN_2);
    }
}
