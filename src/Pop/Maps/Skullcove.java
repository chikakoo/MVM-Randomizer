package Pop.Maps;


import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

public class Skullcove extends Map {
    /**
     * Constructor
     */
    public Skullcove() {
        super();
        name = "Skullcove";
        popfileName = "skullcove";
        canSpawnEngineers = true;

        engineerBotSpawnLocations.clear();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ENGINEER);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ALL);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ALL);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_RIGHT);

        tankRoutes.add(TankRoutes.SKULLCOVE_1);
        tankRoutes.add(TankRoutes.SKULLCOVE_2);
    }
}
