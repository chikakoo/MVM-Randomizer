package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Mann Co. HQ
 */
public class ManncoHQ extends Map {
    /**
     * Constructor
     */
    public ManncoHQ() {
        super();
        name = "Mann Co. HQ";
        popfileName = "manncohq_v3";
        canSpawnEngineers = false;

        tankRoutes.add(TankRoutes.MANNCOHQ);
    }
}
