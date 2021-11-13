package Pop.Maps;

import Pop.Enums.TankRoutes;
import Pop.MVMRandomizer;
import Pop.PopObject;

/**
 * Mannworks
 */
public class Mannworks extends Map {
    /**
     * Constructor
     */
    public Mannworks() {
        super();
        name = "Mannworks";
        popfileName = "mannworks";
        canSpawnEngineers = false;

        tankRoutes.add(TankRoutes.MANNWORKS_1);
        tankRoutes.add(TankRoutes.MANNWORKS_2);
        useOnKilledOutput = false;
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * If wave 666, sets the bomb so that it can respawn on its own
     * @return the created object
     */
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");

        if (MVMRandomizer.botSettings.isWave666Mode()) {
            startWaveOutput.addAttribute("Target", "bombpath_arrows_clear_relay_ironman");
        } else {
            startWaveOutput.addAttribute("Target", "bombpath_arrows_clear_relay");
        }

        startWaveOutput.addAttribute("Action", "Trigger");

        return startWaveOutput;
    }

    /**
     * Creates the object for DoneOutput - this is the same for each wave
     * @return the created object
     */
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("DoneOutput");
        doneOutput.addAttribute("Target", "bombpath_wavefinished");
        doneOutput.addAttribute("Action", "Trigger");

        return doneOutput;
    }
}
