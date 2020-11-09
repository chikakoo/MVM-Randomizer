package Pop.Maps;

import Pop.Enums.TankRoutes;

/**
 * (Community) Derp
 */
public class Derp extends Map {
    /**
     * Constructor
     */
    public Derp() {
        super();
        name = "Derp";
        popfileName = "derp_v10";

        tankRoutes.add(TankRoutes.DERP_1);
        tankRoutes.add(TankRoutes.DERP_2);
    }
}
