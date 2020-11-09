package Pop.Settings;

import Pop.Range;

/**
 * Settings at the WaveSchedule level
 */
public class WaveScheduleSettings {
    /**
     * How much currency each player starts with
     */
    private Range startingCurrency;
    public Range getStartingCurrency() { return startingCurrency; }
    public void setStartingCurrency(Range startingCurrency) { this.startingCurrency = startingCurrency; }

    /**
     * How many waves are in the mission
     */
    private Range numberOfWaves;
    public Range getNumberOfWaves() { return numberOfWaves; }
    public void setNumberOfWaves(Range numberOfWaves) { this.numberOfWaves = numberOfWaves; }

    /**
     * Copies the settings over from the given WaveScheduleSettings
     * @param waveScheduleSettings - the object to copy settings from
     */
    public void copySettings(WaveScheduleSettings waveScheduleSettings) {
        startingCurrency = new Range(waveScheduleSettings.getStartingCurrency());
        numberOfWaves = new Range(waveScheduleSettings.getNumberOfWaves());
    }
}
