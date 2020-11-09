package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopRandomizer;

/**
 * Coaltown
 */
public class Coaltown extends Map {
    /**
     * Constructor
     */
    public Coaltown() {
        super();
        name = "Coaltown";
        popfileName = getPopFileName();
        canSpawnEngineers = false;

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COALTOWN_GIANT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COALTOWN_GIANT);
        tankRoutes.add(TankRoutes.COALTOWN);
    }

    /**
     * Gets the pop file name - this is done because the ghost town map uses the same settings and is
     * essentially the same map
     * @return - The name of the pop file
     */
    private String getPopFileName() {
        boolean useGhostTown = PopRandomizer.generateBoolean();
        if (useGhostTown) {
            return "ghost_town";
        }
        return "coaltown";
    }
}
