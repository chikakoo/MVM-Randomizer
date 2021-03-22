package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.PopObject;
import Pop.TFBot;

public class Potassium extends Map {
    public Potassium() {
        super();
        name = "Potassium";
        popfileName = "potassium_release3";
        canSpawnEngineers = true;
        usesGateBots = true;
        hasTanksButNoName = true;

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_POTASSIUM_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_POTASSIUM_LEFT);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    @Override
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "bombpath_arrows_clear_relay");
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
        doneOutput.addAttribute("Target", "bombpath_wavefinished");
        doneOutput.addAttribute("Action", "Trigger");

        return doneOutput;
    }
}
