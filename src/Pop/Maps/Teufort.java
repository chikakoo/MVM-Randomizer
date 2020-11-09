package Pop.Maps;

import Pop.Enums.SpawnLocations;

import java.util.ArrayList;

/**
 * (Community) Teufort
 */
public class Teufort extends Map {
    /**
     * Constructor
     */
    public Teufort() {
        super();
        name = "Teufort";
        popfileName = "2fort_b1_3";

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TEUFORT_GIANT);
    }
}
