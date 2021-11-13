package Pop.Maps;


import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.MVMRandomizer;
import Pop.PopObject;

public class Skullcove extends Map {
    /**
     * Constructor
     */
    public Skullcove() {
        super();
        name = "Skullcove";
        popfileName = "skullcove";
        canSpawnEngineers = true;

        engineerBotSpawnLocations.clear();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ENGINEER);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ALL);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_ALL);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SKULLCOVE_RIGHT);

        tankRoutes.add(TankRoutes.SKULLCOVE_1);
        tankRoutes.add(TankRoutes.SKULLCOVE_2);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * If wave 666, sets the bomb so that it can respawn on its own
     * @return the created object
     */
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");

        if (MVMRandomizer.botSettings.isWave666Mode()) {
            startWaveOutput.addAttribute("Target", "wave_start_relay_ironman");
        } else {
            startWaveOutput.addAttribute("Target", "wave_start_relay");
        }

        startWaveOutput.addAttribute("Action", "Trigger");

        return startWaveOutput;
    }
}
