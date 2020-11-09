package Pop;

import Pop.Settings.TankSetting;

import java.util.ArrayList;

/**
 * An MVM tank
 */
public class Tank extends PopObjectRepresentation {
    /**
     * How much health the tank has
     */
    private int health;

    /**
     * The speed of the tank
     * Base is 75
     */
    private int speed;

    /**
     * This will set a special skin on the tank
     */
    private PopBoolean useZebraSkin;

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        PopObject popObject = new PopObject("Tank");
        popObject.addAttribute("Health", Integer.toString(health));
        popObject.addAttribute("Speed", Integer.toString(speed));

        if (useZebraSkin.getValue()) {
            popObject.addAttribute("Skin", useZebraSkin.toString());
        }

        if (!MVMRandomizer.currentMap.hasTanksButNoName) {
            popObject.addAttribute("StartingPathTrackNode", MVMRandomizer.currentMap.getRandomTankRoute().toString());
        }

        if (MVMRandomizer.currentMap.getUseOnKilledOutput()) {
            PopObject onKilledOutput = new PopObject("OnKilledOutput");
            onKilledOutput.addAttribute("Target", "boss_dead_relay");
            onKilledOutput.addAttribute("Action", "Trigger");
            popObject.addObject(onKilledOutput);
        }

        PopObject onBombDroppedOutput = new PopObject("OnBombDroppedOutput");
        onBombDroppedOutput.addAttribute("Target", "boss_deploy_relay");
        onBombDroppedOutput.addAttribute("Action", "Trigger");
        popObject.addObject(onBombDroppedOutput);

        return popObject;
    }

    /**
     * Generates a random tank based on the current tank settings
     * @return The number of tanks in the spawn
     */
    public TankSetting generateRandom() {
        TankSetting tankSetting = MVMRandomizer.tankSettings.getRandomTankSetting();
        health = PopRandomizer.generateNumberInRange(tankSetting.getHealthRange());
        speed = PopRandomizer.generateNumberInRange(tankSetting.getSpeedRange());
        useZebraSkin = new PopBoolean(tankSetting.getIsZebraStriped());

        return tankSetting;
    }
}
