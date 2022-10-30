package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopRandomizer;
import Pop.TFBot;
import Pop.WaveSpawn;

import java.util.ArrayList;

/**
 * (Community) Casino City
 */
public class CasinoCity extends Map {
    /**
     * Whether this map had any spawns defined yet
     */
    private boolean isFirstSpawn = true;

    /**
     * Constructor
     */
    public CasinoCity() {
        super();
        name = "Casino City";
        popfileName = "casino_city_b6";
        usesChipBots = true;
        canSpawnEngineers = false;
        tankRoutes.add(TankRoutes.CASINO_CITY_1);
        tankRoutes.add(TankRoutes.CASINO_CITY_2);
        tankRoutes.add(TankRoutes.CASINO_CITY_SENTRY);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_CENTER);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_CENTER);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_RIGHT);

        // SPAWN_BOT_CASINO_CITY_CHIPS will be used when choosing the location later
    }

    /**
     * Gets the random spawn location for the given list
     * @param spawnLocation the list of spawn locations to choose from
     * @return
     */
    @Override
    protected ArrayList<SpawnLocations> getRandomSpawnLocation(ArrayList<SpawnLocations> spawnLocation) {
        boolean spawnChipBot = PopRandomizer.generateBooleanFromPercentage(20);
        ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();

        if (spawnChipBot || isFirstSpawn) {
            spawnLocations.add(SpawnLocations.SPAWN_BOT_CASINO_CITY_CHIPS);
        } else {
            int index = PopRandomizer.generateRandomValue(spawnLocation.size());
            spawnLocations.add(spawnLocation.get(index));
        }

        isFirstSpawn = false;
        return spawnLocations;
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param spawnLocations - the list of locations the bot can spawn from
     */
    @Override
    public void setBotTags(TFBot tfBot, ArrayList<SpawnLocations> spawnLocations)
    {
        // This map only has one spawn location, so just get it
        SpawnLocations spawnLocation = spawnLocations.get(0);
        if (spawnLocation.equals(SpawnLocations.SPAWN_BOT_CASINO_CITY_CHIPS)) {
            if (tfBot.getIsGiant()) {
                tfBot.tags.add("chips_count_10");
            } else {
                // 90% to give 3 chips, 10% to give 5
                if (PopRandomizer.generateBooleanFromPercentage(90)) {
                    tfBot.tags.add("chips_count_3");
                } else {
                    tfBot.tags.add("chips_count_5");
                }
            }
        }
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param waveSpawn - the WaveSpawn object to manipulate
     */
    @Override
    public void setBotTags(TFBot tfBot, WaveSpawn waveSpawn)
    {
        ArrayList<SpawnLocations> spawnLocations = waveSpawn.getSpawnLocations();
        SpawnLocations currentSpawnLocation = spawnLocations.get(0);

        // Do not allow support bots to be chip bots
        if (waveSpawn.isSupport() && currentSpawnLocation.equals(SpawnLocations.SPAWN_BOT_CASINO_CITY_CHIPS)) {
            SpawnLocations spawnLocation;
            int index;
            if (tfBot.getIsGiant()) {
                index = PopRandomizer.generateRandomValue(giantBotSpawnLocations.size());
                spawnLocation = giantBotSpawnLocations.get(index);
            } else {
                index = PopRandomizer.generateRandomValue(normalBotSpawnLocations.size());
                spawnLocation = normalBotSpawnLocations.get(index);
            }
            spawnLocations.clear();
            spawnLocations.add(spawnLocation);
        }

        // Set the tags as normal if not a support bot
        if (!waveSpawn.isSupport()) {
            setBotTags(tfBot, spawnLocations);
        }
    }
}
