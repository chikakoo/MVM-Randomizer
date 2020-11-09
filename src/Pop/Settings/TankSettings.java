package Pop.Settings;

import Pop.Range;
import Pop.WeightedItem;
import Pop.WeightedItemCollection;
import Pop.WeightedRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Settings used for tanks as a whole
 */
public class TankSettings {
    /**
     * For each tank spawn, how many less WaveSpawns will there be?
     */
    private int waveSpawnReduction;
    public int getWaveSpawnReduction() { return waveSpawnReduction; }
    public void setWaveSpawnReduction(int waveSpawnReduction) { this.waveSpawnReduction = waveSpawnReduction; }

    /**
     * Settings for individual tanks
     */
    private ArrayList<TankSetting> tanks = new ArrayList<>();
    public ArrayList<TankSetting> getTanks() { return tanks; }
    public void setTanks(ArrayList<TankSetting> tanks) { this.tanks = tanks; }

    /**
     * Copies the settings over from the given TankSettings
     * @param tankSettings - the object to copy settings from
     */
    public void copySettings(TankSettings tankSettings) {
        waveSpawnReduction = tankSettings.getWaveSpawnReduction();
        tanks = new ArrayList<>();

        for (TankSetting tankSetting : tankSettings.getTanks()) {
            TankSetting newTankSetting = new TankSetting();
            newTankSetting.copySettings(tankSetting);
            tanks.add(newTankSetting);
        }
    }

    /**
     * Gets a random TankSetting - takes weights into consideration
     * @return - the retrieved tankSetting
     */
    public TankSetting getRandomTankSetting() {
        if (tanks.size() == 0) { return null; }

        ArrayList<WeightedItem> weightedItems = new ArrayList<>();

        for (TankSetting tankSetting : tanks) {
            weightedItems.add(new WeightedItem<>(tankSetting, tankSetting.getWeight()));
        }
        WeightedItemCollection weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<TankSetting> weightedRandomizer = new WeightedRandomizer<>(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }

    /**
     * Returns whether there are any tank settings
     * @return true if yes, false otherwise
     */
    public boolean hasTankSettings() {
        return tanks.size() > 0;
    }
}
