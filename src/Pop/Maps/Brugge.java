package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.Range;

import java.util.ArrayList;

/**
 * Bigrock
 */
public class Brugge extends Map {
    /**
     * Constructor
     */
    public Brugge() {
        super();
        name = "Brugge";
        popfileName = "brugge_rc4b";
        tankRoutes.add(TankRoutes.BRUGGE);

        engineerBotSpawnLocations = new ArrayList<>();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BRUGGE_SIDE);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BRUGGE_FLANK);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BRUGGE_INVASION);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BRUGGE_CHIEF);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_BRUGGE_FLANK);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");

        int waveRelayType = PopRandomizer.generateNumberInRange(new Range(1, 3));
        switch(waveRelayType) {
            case 1:
                startWaveOutput.addAttribute("Target", "wave_start_relay");
                break;
            case 2:
                startWaveOutput.addAttribute("Target", "wave_start_relay_ironman");
                break;
            case 3:
                startWaveOutput.addAttribute("Target", "wave_start_relay_multi");
                break;
            default:
                startWaveOutput.addAttribute("Target", "wave_start_relay");
        }

        startWaveOutput.addAttribute("Action", "trigger");

        return startWaveOutput;
    }
}
