package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.PopObject;

/**
 * (Community) Intersection
 */
public class Intersection extends Map {
    /**
     * Constructor
     */
    public Intersection() {
        super();
        name = "Intersection";
        popfileName = "intersection";

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_INTERSECTION_SENTRY_BUSTER);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_INTERSECTION_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_INTERSECTION_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_INTERSECTION_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_INTERSECTION_RIGHT);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
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
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("DoneOutput");
        doneOutput.addAttribute("Target", "bombpath_wavefinished");
        doneOutput.addAttribute("Action", "Trigger");

        return doneOutput;
    }
}
