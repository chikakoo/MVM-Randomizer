package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.PopRandomizer;

import java.util.ArrayList;

/**
 * (Community) Damm
 */
public class Damm extends Map {
    /**
     * Constructor
     */
    public Damm() {
        super();
        name = "Damm";
        popfileName = "damm_r1";

        normalBotSpawnLocations = new ArrayList<>();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN2);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0_SQAUD);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1_SLOW);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_UPPER0);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_UPPER1);

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN2);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0_SQAUD);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1_SLOW);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_UPPER0);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_UPPER1);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1_SLOW);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_SNIPER1);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0_SQAUD);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN0);
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1);

        engineerBotSpawnLocations = new ArrayList<>();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DAMM_MAIN1_SLOW);
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
