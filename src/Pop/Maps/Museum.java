package Pop.Maps;

import Pop.Enums.SpawnLocations;

/**
 *  (Community) Museum
 */
public class Museum extends Map {
    public Museum() {
        super();
        name = "Museum";
        popfileName = "museum_a9";

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_RIGHT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_TOP);

        giantBotSpawnLocations.clear();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_GIANT);

        engineerBotSpawnLocations.clear();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_ENGINEER_RIGHT);
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MUSEUM_ENGINEER_LEFT);
    }
}
