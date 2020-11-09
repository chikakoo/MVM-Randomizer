package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Overgreen
 */
public class Overgreen extends Map {
    /**
     * Overgreen
     */
    public Overgreen() {
        super();
        name = "Overgreen";
        popfileName = "overgreen";

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        tankRoutes.add(TankRoutes.OVERGREEN);
    }
}
