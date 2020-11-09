package Pop.Settings;

import Pop.PopRandomizer;
import Pop.Range;

/**
 * Settings used for individual tanks
 */
public class TankSetting {
    /**
     * The amount of tanks to spawn
     */
    private int amount;
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    /**
     * How fast the tanks can go - 75 is the base value used by the real pop files
     */
    private Range speedRange;
    public Range getSpeedRange() { return speedRange; }
    public void setSpeedRange(Range speedRange) { this.speedRange = speedRange; }

    /**
     * How much health the tanks can have
     */
    private Range healthRange;
    public Range getHealthRange() { return healthRange; }
    public void setHealthRange(Range healthRange) { this.healthRange = healthRange; }

    /**
     * How long (in seconds) the wait should be between spawns
     */
    private Range spawnDelay;
    public Range getSpawnDelay() { return spawnDelay; }
    public void setSpawnDelay(Range spawnDelay) { this.spawnDelay = spawnDelay; }

    /**
     * Whether the tank should have zebra-striping
     */
    private boolean isZebraStriped;
    public boolean getIsZebraStriped() { return isZebraStriped; }
    public void setIsZebraStriped(boolean zebraStriped) { isZebraStriped = zebraStriped; }

    /**
     * How likely this tank is to be chosen relative to the other weights
     */
    private int weight;
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    /**
     * Default constructor
     */
    public TankSetting() { }

    /**
     * Constructor
     */
    public TankSetting(int amount, Range speedRange, Range healthRange, Range spawnDelay, boolean isZebraStriped, int weight) {
        this.amount = amount;
        this.speedRange = speedRange;
        this.healthRange = healthRange;
        this.spawnDelay = spawnDelay;
        this.isZebraStriped = isZebraStriped;
        this.weight = weight;
    }

    /**
     * Copies the settings over from the given TankSetting
     * @param tankSetting - the object to copy settings from
     */
    public void copySettings(TankSetting tankSetting) {
        amount = tankSetting.getAmount();
        speedRange = new Range(tankSetting.getSpeedRange());
        healthRange = new Range(tankSetting.getHealthRange());
        isZebraStriped = tankSetting.getIsZebraStriped();
        weight = tankSetting.getWeight();

        Range givenSpawnDelay = tankSetting.getSpawnDelay();
        if (givenSpawnDelay == null) {
            spawnDelay = new Range(45, 60);
        } else {
            spawnDelay = new Range(givenSpawnDelay);
        }
    }

    /**
     * Generates a value for the spawnDelay
     * @return The generated value
     */
    public int generateSpawnDelay() {
        return PopRandomizer.generateNumberInRange(spawnDelay);
    }
}
