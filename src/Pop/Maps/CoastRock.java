package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopRandomizer;

import java.util.ArrayList;

/**
 * Bigrock
 */
public class CoastRock extends Map {
    /**
     * Constructor
     */
    public CoastRock() {
        super();
        name = "Coast Rock";
        popfileName = "coastrock_rc1_1";
        canSpawnEngineers = false;

        tankRoutes.add(TankRoutes.COAST_ROCK_SAME);
        tankRoutes.add(TankRoutes.COAST_ROCK_ALT);

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        normalBotSpawnLocations.clear();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COAST_ROCK_PARACHUTE);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COAST_ROCK_TUNNEL);

        giantBotSpawnLocations.clear();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COAST_ROCK_PARACHUTE);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_COAST_ROCK_TUNNEL);

        // The SPAWN_BOT location will be used still - see the overridden getRandomSpawnLocation code
    }

    /**
     * Gets the random spawn location for the given list
     * @param spawnLocation the list of spawn locations to choose from
     * @return
     */
    @Override
    protected ArrayList<SpawnLocations> getRandomSpawnLocation(ArrayList<SpawnLocations> spawnLocation) {
        boolean useRarerSpawnLocation = PopRandomizer.generateBooleanFromPercentage(15);
        ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();

        if (useRarerSpawnLocation) {
            int index = PopRandomizer.generateRandomValue(spawnLocation.size());
            spawnLocations.add(spawnLocation.get(index));
        } else {
            spawnLocations.add(SpawnLocations.SPAWN_BOT);
        }

        return spawnLocations;
    }
}
