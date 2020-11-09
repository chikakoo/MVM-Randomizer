package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Plateau
 */
public class Plateau extends Map {
    /**
     * Construtor
     */
    public Plateau() {
        super();
        name = "Plateau";
        popfileName = "plateau_b5";

        engineerBotSpawnLocations.clear();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_PLATEAU_ENGINEER);

        // These tank routes exist on the map, the but the tank itself is bugged
        //tankRoutes.add(TankRoutes.PLATEAU_1);
        //tankRoutes.add(TankRoutes.PLATEAU_2);
    }
}
