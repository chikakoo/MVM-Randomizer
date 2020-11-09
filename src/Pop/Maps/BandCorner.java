package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.PopRandomizer;

import java.util.ArrayList;

/**
 * (Community) Band Corner
 */
public class BandCorner extends Map {
    /**
     * Constructor
     */
    public BandCorner() {
        super();
        name = "Band Corner";
        popfileName = "band_corner_alpha";
        canSpawnEngineers = false;

        normalBotSpawnLocations = new ArrayList<>();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_RIGHT);

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_RIGHT);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_LEFT);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_RIGHT);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_LEFT);
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BAND_CORNER_RIGHT);
    }

    /**
     * Gets random sniper bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomSniperBotLocations() {
        int index = PopRandomizer.generateRandomValue(sniperBotSpawnLocations.size());

        ArrayList<SpawnLocations> sniperLocations = new ArrayList<>();
        sniperLocations.add(sniperBotSpawnLocations.get(index));
        return sniperLocations;
    }

    /**
     * Gets random sniper bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomSpyBotLocations() {
        int index = PopRandomizer.generateRandomValue(spyBotSpawnLocations.size());

        ArrayList<SpawnLocations> spyLocations = new ArrayList<>();
        spyLocations.add(spyBotSpawnLocations.get(index));
        return spyLocations;
    }
}
