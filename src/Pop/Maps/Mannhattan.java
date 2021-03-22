package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.TFBot;

import java.util.ArrayList;

/**
 * Manhattan
 */
public class Mannhattan extends Map {
    /**
     * Constructor
     */
    public Mannhattan() {
        super();
        name = "Mannhattan";
        popfileName = "mannhattan";
        usesGateBots = true;

        setSpawnLocations(normalBotSpawnLocations);
        setSpawnLocations(giantBotSpawnLocations);

        sniperBotSpawnLocations.remove(SpawnLocations.SPAWN_BOT_SNIPER);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MISSION_MANNHATTAN_SNIPER_0);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_MISSION_MANNHATTAN_SNIPER_1);

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_0);
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1_SLOW);
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_2);
    }

    /**
     * Sets up the spawn locations
     * @param spawnLocations intended to be used by normalBotSpawnLocations and giantBotSpawnLocations
     */
    private void setSpawnLocations(ArrayList<SpawnLocations> spawnLocations) {
        spawnLocations.remove(SpawnLocations.SPAWN_BOT);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_0);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_UPPER_0);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1_SLOW);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_2);
    }

    /**
     * Get random bot locations
     * @return a list of random bot locations
     */
    private ArrayList<SpawnLocations> getRandomBotLocations() {
        ArrayList<SpawnLocations> spawnLocations = new ArrayList();

        boolean spawnFromTop = PopRandomizer.generateBooleanFromPercentage(15);
        if (spawnFromTop) {
            spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_UPPER_0);
        } else {
            spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_0);
        }

        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_2);

        return spawnLocations;
    }

    /**
     * Gets a random location for a normal bot
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        return getRandomBotLocations();
    }

    /**
     * Gets a random location for a giant bot
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomGiantBotLocations() {
        ArrayList<SpawnLocations> spawnLocations = getRandomBotLocations();
        spawnLocations.remove(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1);
        spawnLocations.remove(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_2);

        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_1_SLOW);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_MANNHATTAN_MAIN_2);

        return spawnLocations;
    }

     /**
     * Creates the object for DoneOutput - this is used by Mannhatten
     * @return the created object
     */
     @Override
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("InitWaveOutput");
        doneOutput.addAttribute("Target", "holograms_3way_relay");
        doneOutput.addAttribute("Action", "Trigger");

        return doneOutput;
    }
}
