package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Coaltown
 */
public class Rottenburg extends Map {
    /**
     * Constructor
     */
    public Rottenburg() {
        super();
        name = "Rottenburg";
        popfileName = "rottenburg";

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_ROTTENBURG_SENTRY_BUSTER);

        tankRoutes.add(TankRoutes.ROTTENBURG_1);
        tankRoutes.add(TankRoutes.ROTTENBURG_2);
    }

    /**
     * Gets random normal bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        return getRandomNormalOrGiantBotLocations();
    }

    /**
     * Gets random normal bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomGiantBotLocations() {
        return getRandomNormalOrGiantBotLocations();
    }

    /**
     * Gets a random list of normal or giant bot locations
     * @return 85% chance of the normal spawn; 15% chance of the top spawn
     */
    private ArrayList<SpawnLocations> getRandomNormalOrGiantBotLocations() {
        ArrayList<SpawnLocations> spawnLocations = new ArrayList();
        boolean spawnFromTop = PopRandomizer.generateBooleanFromPercentage(15);
        if (spawnFromTop) {
            spawnLocations.add(SpawnLocations.SPAWN_BOT_ROTTENBURG_FLANKERS);
        } else {
            spawnLocations.add(SpawnLocations.SPAWN_BOT);
        }
        return spawnLocations;
    }

    /**
     * Creates the object for StartWaveOutput - this is used for Rottenburg
     * @return the created object
     */
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "wave_start_relay_classic");
        startWaveOutput.addAttribute("Action", "Trigger");

        return startWaveOutput;
    }
}
