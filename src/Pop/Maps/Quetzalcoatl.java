package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Quetzalcoatl
 */
public class Quetzalcoatl extends Map {
    /**
     * Quetzalcoatl
     */
    public Quetzalcoatl() {
        super();
        name = "Quetzalcoatl";
        popfileName = "quetzalcoatl_b3a";

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_QUETZALCOATL_FLANK);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_QUETZALCOATL_FLANK);

        engineerBotSpawnLocations = new ArrayList<>();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        tankRoutes.add(TankRoutes.QUETZALCOATL_1);
        tankRoutes.add(TankRoutes.QUETZALCOATL_2);
    }
}
