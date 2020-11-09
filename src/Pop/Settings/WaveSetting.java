package Pop.Settings;

import Pop.Range;

/**
 * Settings for each individual wave
 */
public class WaveSetting {
    /**
     * The range of money you can earn this wave
     */
    private Range currencyRange;
    public Range getCurrencyRange() {
        return currencyRange;
    }
    public void setCurrencyRange(Range currencyRange) {
        this.currencyRange = currencyRange;
    }

    /**
     * The range of wave spawns this wave
     */
    private Range waveSpawnRange;
    public Range getWaveSpawnRange() {
        return waveSpawnRange;
    }
    public void setWaveSpawnRange(Range waveSpawnRange) {
        this.waveSpawnRange = waveSpawnRange;
    }

    /**
     * The odds of this wave having missions
     */
    private int percentMissions;
    public int getPercentMissions() {
        return percentMissions;
    }
    public void setPercentMissions(int percentMissions) {
        this.percentMissions = percentMissions;
    }

    /**
     * The odds of this wave having supports (non-mission)
     */
    private int percentSupport;
    public int getPercentSupport() {
        return percentSupport;
    }
    public void setPercentSupport(int percentSupport) {
        this.percentSupport = percentSupport;
    }

    /**
     * The odds of this wave having giants
     */
    private int percentGiants;
    public int getPercentGiants() {
        return percentGiants;
    }
    public void setPercentGiants(int percentGiants) {
        this.percentGiants = percentGiants;
    }

    /**
     * The max number of giant spawns this wave can have
     */
    private int maxGiants;
    public int getMaxGiants() {
        return maxGiants;
    }
    public void setMaxGiants(int maxGiants) {
        this.maxGiants = maxGiants;
    }

    /**
     * The odds of this wave having a tank (provided the map has any tank routes)
     */
    private int percentTanks;
    public int getPercentTanks() { return percentTanks; }
    public void setPercentTanks(int percentTanks) {
        this.percentTanks = percentTanks;
    }

    /**
     * Default constructor
     */
    public WaveSetting() { }

    /**
     * Full constructor
     */
    public WaveSetting(
            Range currencyRange,
            Range waveSpawnRange,
            int percentMissions,
            int percentSupport,
            int percentGiants,
            int maxGiants,
            int percentTanks) {
        this.currencyRange = currencyRange;
        this.waveSpawnRange = waveSpawnRange;
        this.percentMissions= percentMissions;
        this.percentSupport = percentSupport;
        this.percentGiants = percentGiants;
        this.maxGiants = maxGiants;
        this.percentTanks = percentTanks;
    }

    /**
     * Copies the settings over from the given wWveSetting
     * @param waveSetting - the object to copy settings from
     */
    public void copySettings(WaveSetting waveSetting) {
        currencyRange = new Range(waveSetting.getCurrencyRange());
        waveSpawnRange = new Range(waveSetting.getWaveSpawnRange());
        percentMissions = waveSetting.getPercentMissions();
        percentSupport = waveSetting.getPercentSupport();
        percentGiants = waveSetting.getPercentGiants();
        maxGiants = waveSetting.getMaxGiants();
        percentTanks = waveSetting.getPercentTanks();
    }
}
