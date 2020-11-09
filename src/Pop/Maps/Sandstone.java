package Pop.Maps;

import Pop.Enums.TankRoutes;

/**
 * (Community) Sandstone
 */
public class Sandstone extends Map {
    /**
     * Constructor
     */
    public Sandstone() {
        super();
        name = "Sandstone";
        popfileName = "sandstone_s23";

        tankRoutes.add(TankRoutes.SANDSTONE);
    }
}
