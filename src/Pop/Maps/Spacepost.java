package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Spacepost
 */
public class Spacepost extends Map {
    /**
     * Constructor
     */
    public Spacepost() {
        super();
        name = "Spacepost";
        popfileName = "spacepost_b4";
        canSpawnEngineers = false;

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SPACEPOST_UPPER);
        //normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SPACEPOST_BOSS); // glitched?

        tankRoutes.add(TankRoutes.SPACEPOST);
    }
}
