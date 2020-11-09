package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;

import java.util.ArrayList;

/**
 * (Community) Saddle
 */
public class Saddle extends Map {
    /**
     * Constructor
     */
    public Saddle() {
        super();
        name = "Saddle";
        popfileName = "saddle_s14";
        canSpawnEngineers = false;

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_SADDLE_SENTRY_BUSTER);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "wave_start_relay");
        startWaveOutput.addAttribute("Action", "Trigger");

        if (customStartWaveOutputName != null) {
            startWaveOutput.addAttribute("Target", customStartWaveOutputName);
            startWaveOutput.addAttribute("Action", "trigger");
        }

        return startWaveOutput;
    }

    /**
     * Creates the object for DoneOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("DoneOutput");
        doneOutput.addAttribute("Target", "wave_finished_relay");
        doneOutput.addAttribute("Action", "trigger");

        if (customEndWaveOutputName != null) {
            doneOutput.addAttribute("Target", customEndWaveOutputName);
            doneOutput.addAttribute("Action", "trigger");
        }

        return doneOutput;
    }

    /**
     * Sets up the gates opening and adjusts where the bots spawn from
     * @param waveNumber - the wave number
     */
    @Override
    public void setUpForWave(int waveNumber) {
        tankRoutes.clear();
        if (waveNumber > 4) {
            tankRoutes.add(TankRoutes.SADDLE);
        }

        if (waveNumber != 1) { // The first wave doesn't need to open any of the gates
            String outputNumberString = getOutputNumberForGivenWave(waveNumber);
            customStartWaveOutputName = "wave_" + outputNumberString + "_start_clock_relay";
            customEndWaveOutputName = "wave_stop_clock_relay" + outputNumberString;
        } else {
            customStartWaveOutputName = null;
            customEndWaveOutputName = null;
        }

        adjustSpawnBotLocations(waveNumber);
    }

    /**
     * Gets the number that should be used for the custom output wave given the wave number
     * @param waveNumber - the wave number
     * @return The output number
     */
    private String getOutputNumberForGivenWave(int waveNumber) {
        switch (waveNumber) {
            case 1:
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3"; // Note that 3 is the same as 2 in terms of functionality
            default:
                return "4";
        }
    }

    /**
     * Adjusts the spawn bot locations given the current wave number
     * @param waveNumber
     */
    private void adjustSpawnBotLocations(int waveNumber) {
        normalBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations = new ArrayList<>();

        switch (waveNumber) {
            case 1:
            case 2:
                normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SADDLE_1);
                giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SADDLE_1);
                break;
            case 3:
            case 4:
                normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SADDLE_2);
                giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SADDLE_2);
                break;
            default:
                normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);
                giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);
                break;
        }
    }
}
