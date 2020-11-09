package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Atomgrad
 */
public class Atomgrad extends Map {
    /**
     * Constructor
     */
    public Atomgrad() {
        super();
        name = "Atomgrad";
        popfileName = "atomgrad_rc5";

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_ATOMGRAD_FINAL);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_ATOMGRAD_FINAL);

        tankRoutes.add(TankRoutes.ATOMGRAD);
    }
}
