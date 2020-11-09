package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopRandomizer;

import java.util.ArrayList;

/**
 * Decoy
 */
public class Decoy extends Map {
    /**
     * Constructor
     */
    public Decoy() {
        super();
        name = "Decoy";
        popfileName = "decoy";

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DECOY_INVASION);
        tankRoutes.add(TankRoutes.DECOY);
    }

    /**
     * Get random bot locations
     * @return a list of random bot locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        ArrayList<SpawnLocations> spawnLocations = new ArrayList();

        boolean spawnFromTop = PopRandomizer.generateBooleanFromPercentage(15);
        if (spawnFromTop) {
            spawnLocations.add(SpawnLocations.SPAWN_BOT_DECOY_INVASION);
        } else {
            spawnLocations.add(SpawnLocations.SPAWN_BOT);
        }

        return spawnLocations;
    }
}
