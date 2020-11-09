package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import sun.java2d.pipe.SpanClipRenderer;

import java.util.ArrayList;

/**
 * (Community) Waterfront
 */
public class Waterfront extends Map {
    /**
     * Constructor
     */
    public Waterfront() {
        super();
        name = "Waterfront";
        popfileName = "waterfront_rc3";

        normalBotSpawnLocations = new ArrayList<>();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_WATERFRONT_FLANK);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_WATERFRONT_FLANK2);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_WATERFRONT_RANDOM);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_WATERFRONT_FLANK2);

        tankRoutes.add(TankRoutes.WATERFRONT_1);
        tankRoutes.add(TankRoutes.WATERFRONT_2);
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "wave_start_endurance_short_relay");
        startWaveOutput.addAttribute("Action", "trigger");

        return startWaveOutput;
    }
}
