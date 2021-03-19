package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.TFBot;

import java.util.ArrayList;

/**
 * (Community) Affinity
 */
public class Affinity extends Map {
    /**
     * Constructor
     */
    public Affinity() {
        super();
        name = "Affinity";
        popfileName = "affinity_b3";
        canSpawnEngineers = false;

        normalBotSpawnLocations = new ArrayList<>();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_MAIN);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_FLANK);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_UPPER);

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_MAIN);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_UPPER);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_UPPER);

        sentryBusterSpawnLocations = new ArrayList<>();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_AFFINITY_MAIN);

        tankRoutes.add(TankRoutes.AFFINITY);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "wave_start");
        startWaveOutput.addAttribute("Action", "Trigger");

        return startWaveOutput;
    }

    /**
     * Creates the object for DoneOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("DoneOutput");
        doneOutput.addAttribute("Target", "wave_finished");
        doneOutput.addAttribute("Action", "trigger");

        return doneOutput;
    }

    /**
     * Potentially set tags for bots spawning at the flank location; this makes them follow a specific path on the map
     * @param tfBot - the bot to get the tags for
     * @param spawnLocations - the list of locations the bot can spawn from
     * @return The tags
     */
    @Override
    public void setBotTags(TFBot tfBot, ArrayList<SpawnLocations> spawnLocations) {
        // This map only has one spawn location, so just get it
        SpawnLocations spawnLocation = spawnLocations.get(0);
        if (spawnLocation.equals(SpawnLocations.SPAWN_BOT_AFFINITY_FLANK) && PopRandomizer.generateBoolean()) {
            tfBot.tags.add("start_flank");
            tfBot.tags.add("start_flank_upper");
        }
    }
}
