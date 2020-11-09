package Pop.Maps;

import Pop.Enums.TankRoutes;

/**
 * Mannworks
 */
public class Mannworks extends Map {
    /**
     * Constructor
     */
    public Mannworks() {
        super();
        name = "Mannworks";
        popfileName = "mannworks";
        canSpawnEngineers = false;

        tankRoutes.add(TankRoutes.MANNWORKS_1);
        tankRoutes.add(TankRoutes.MANNWORKS_2);
        useOnKilledOutput = false;
    }
}
