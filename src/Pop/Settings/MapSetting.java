package Pop.Settings;

import Pop.Enums.Maps;
import Pop.Range;

/**
 * Represents settings for a single map
 */
public class MapSetting {
    private Maps map;
    public Maps getMap() {
        return map;
    }
    public void setMap(Maps map) {
        this.map = map;
    }

    private double spawnMultiplier = 1;
    public double getSpawnMultiplier() {
        return spawnMultiplier;
    }
    public void setSpawnMultiplier(double spawnMultiplier) {
        this.spawnMultiplier = spawnMultiplier;
    }

    private double currencyMultiplier = 1;
    public double getCurrencyMultiplier() {
        return currencyMultiplier;
    }
    public void setCurrencyMultiplier(double currencyMultiplier) {
        this.currencyMultiplier = currencyMultiplier;
    }

    private Range startingCurrency = new Range(800, 1300);
    public Range getStartingCurrency() {
        return startingCurrency;
    }
    public void setStartingCurrency(Range startingCurrency) {
        this.startingCurrency = startingCurrency;
    }

    private boolean enabled = true;
    public boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Default constructor
     */
    public MapSetting() { }

    /**
     * Full constructor
     */
    public MapSetting(Maps map, double spawnMultiplier, double currencyMultiplier, Range startingCurrency, boolean enabled) {
        this.map = map;
        this.spawnMultiplier = spawnMultiplier;
        this.currencyMultiplier = currencyMultiplier;
        this.startingCurrency = startingCurrency;
        this.enabled = enabled;
    }

    /**
     * Constructor which defines some default values
     */
    public MapSetting(Maps map) {
        this.map = map;
        this.spawnMultiplier = 1;
        this.currencyMultiplier = 1;
        this.startingCurrency = new Range(800, 1300);
        this.enabled = true;
    }

    /**
     * Copies the settings over from the given MapSetting
     * @param mapSetting - the object to copy settings from
     */
    public void copySettings(MapSetting mapSetting) {
        map = mapSetting.getMap();
        spawnMultiplier = mapSetting.getSpawnMultiplier();
        currencyMultiplier = mapSetting.getCurrencyMultiplier();
        startingCurrency = new Range(mapSetting.getStartingCurrency());
        enabled = mapSetting.getEnabled();
    }
}
