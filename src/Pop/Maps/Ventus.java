package Pop.Maps;

import Pop.Enums.TankRoutes;

/**
 * (Community) Ventus
 */
public class Ventus extends Map {
    /**
     * Constructor
     */
    public Ventus() {
        super();
        name = "Ventus";
        popfileName = "ventus_b6";

        // Disabled for now - the tanks don't actually deploy the bomb...
        // tankRoutes.add(TankRoutes.VENTUS_1);
        // tankRoutes.add(TankRoutes.VENTUS_2);
    }
}
