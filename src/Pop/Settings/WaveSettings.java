package Pop.Settings;

import Pop.MVMRandomizer;
import Pop.PopRandomizer;
import java.util.ArrayList;

/**
 * Settings for saves as a whole
 */
public class WaveSettings {
    /**
     * The percentage that each WaveSpawn will have RandomSpawn 1
     * Has a default value of 35 (fallback in case the settings don't have the value
     */
    private Integer percentRandomSpawn;
    public Integer getPercentRandomSpawn() {
        return percentRandomSpawn == null ? 35 : percentRandomSpawn;
    }
    public void setPercentRandomSpawn(Integer percentRandomSpawn) { this.percentRandomSpawn = percentRandomSpawn; }

    /**
     * Settings for each individual wave
     */
    private ArrayList<WaveSetting> waves = new ArrayList<>();
    public ArrayList<WaveSetting> getWaves() { return waves; }
    public void setWaves(ArrayList<WaveSetting> waves) { this.waves = waves; }

    /**
     * Copies the settings over from the given WaveSettings
     * @param waveSettings - the object to copy settings from
     */
    public void copySettings(WaveSettings waveSettings) {
        this.percentRandomSpawn = waveSettings.getPercentRandomSpawn();

        waves = new ArrayList<>();
        for (WaveSetting currentWaveSetting : waveSettings.getWaves()) {
            WaveSetting newWaveSetting = new WaveSetting();
            newWaveSetting.copySettings(currentWaveSetting);
            waves.add(newWaveSetting);
        }
    }

    /**
     * Gets a currency value for the given wave number
     * @param waveNumber - the given wave number
     * @return The generated currency value
     */
    public int getCurrencyValueForWave(int waveNumber) {
        if (!isWaveNumberValid(waveNumber)) { return 0; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateNumberInRange(waveSetting.getCurrencyRange());
    }

    /**
     * Gets a wave spawn value for the given wave number
     * @param waveNumber - the given wave number
     * @return The generated wave spawn value
     */
    public int getNumberOfWaveSpawnsForWave(int waveNumber) {
        if (!isWaveNumberValid(waveNumber)) { return 1; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateNumberInRange(waveSetting.getWaveSpawnRange());
    }

    /**
     * Gets whether this wave should generate a mission
     * @param waveNumber - the given wave number
     * @return True if the wave should generate a mission; false otherwise
     */
    public boolean shouldGenerateMission(int waveNumber) {
        if (!isWaveNumberValid(waveNumber)) { return false; }
        if (MVMRandomizer.botSettings.isWave666Mode() && waveNumber > 1) {
            return false;
        }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateBooleanFromPercentage(waveSetting.getPercentMissions());
    }

    /**
     * Gets whether this wave should set RandomSpawn 1
     * @return True if the wave should set RandomSpawn 1, false otherwise
     */
    public boolean shouldUseRandomSpawns() {
        return PopRandomizer.generateBooleanFromPercentage(percentRandomSpawn);
    }

    /**
     * Gets whether this wave should generate supports
     * @param waveNumber - the given wave number
     * @return True if the wave should generate supports; false otherwise
     */
    public boolean shouldGenerateSupports(int waveNumber) {
        if (!isWaveNumberValid(waveNumber) || MVMRandomizer.botSettings.isWave666Mode()) { return false; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateBooleanFromPercentage(waveSetting.getPercentSupport());
    }

    /**
     * Gets whether this wave should generate a giant bot
     * @param waveNumber - the given wave number
     * @return True if the wave should generate a giant bot; false otherwise
     */
    public boolean shouldGenerateGiantBot(int waveNumber) {
        if (!isWaveNumberValid(waveNumber)) { return false; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateBooleanFromPercentage(waveSetting.getPercentGiants());
    }

    /**
     * Gets the max number of giant spawns for this wave
     * @param waveNumber - the given wave number
     * @return The max number of giant spawns
     */
    public int getMaxNumberOfGiantSpawns(int waveNumber) {
        if (!isWaveNumberValid(waveNumber)) { return 2; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return waveSetting.getMaxGiants();
    }

    /**
     * Gets whether this wave should generate tanks
     * @param waveNumber - the given wave number
     * @return True if the wave should generate tanks; false otherwise
     */
    public boolean shouldGenerateTanks(int waveNumber) {
        if (!MVMRandomizer.tankSettings.hasTankSettings()) { return false; }
        if (!isWaveNumberValid(waveNumber)) { return false; }

        WaveSetting waveSetting = waves.get(waveNumber - 1);
        return PopRandomizer.generateBooleanFromPercentage(waveSetting.getPercentTanks());
    }

    /**
     * Returns whether the given index is within the range of the waveSpawns array
     * @param waveNumber
     * @return
     */
    private boolean isWaveNumberValid(int waveNumber) {
        int index = waveNumber - 1;
        return index >= 0 && index < waves.size();
    }
}
