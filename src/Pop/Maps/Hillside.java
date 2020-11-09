package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Hillside
 */
public class Hillside extends Map {
    /**
     * Constructor
     */
    public Hillside() {
        super();
        name = "Hillside";
        popfileName = "hillside_v7";
        canSpawnEngineers = false;

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        engineerBotSpawnLocations = new ArrayList<>();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        tankRoutes.add(TankRoutes.HILLSIDE);
    }
}
