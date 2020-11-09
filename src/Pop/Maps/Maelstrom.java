package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

/**
 * (Community) Maelstrom
 */
public class Maelstrom extends Map {
    /**
     * Constructor
     */
    public Maelstrom() {
        super();
        name = "Maelstrom";
        popfileName = "maelstrom_rc1";

        giantBotSpawnLocations.clear();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MAELSTROM_GIANT);

        tankRoutes.add(TankRoutes.MAELSTORM_1);
        tankRoutes.add(TankRoutes.MAELSTORM_2);
    }
}
