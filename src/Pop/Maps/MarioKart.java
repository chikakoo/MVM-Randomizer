package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Mario Kart
 */
public class MarioKart extends Map {
    /**
     * Overgreen
     */
    public MarioKart() {
        super();
        name = "Mario Kart";
        popfileName = "mario_kart_2_v30";
        canSpawnEngineers = false;

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MARIO_KART_UPPER);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);
    }
}
