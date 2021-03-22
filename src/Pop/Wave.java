package Pop;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Represents an MVM wave
 */
public class Wave extends PopObjectRepresentation {
    /**
     * Defines a set of bots to spawn during this wave
     */
    private ArrayList<WaveSpawn> waveSpawns = new ArrayList<>();
    public ArrayList<WaveSpawn> getWaveSpawns() { return waveSpawns; }

    /**
     * Whether the wave has any spawned bots yet
     */
    private boolean waveHasBots;

    /**
     * Number of giant spawns in this wave
     */
    private int numberOfGiantSpawns;

    /**
     * Pop objects for the wave start, done, and init objects
     */
    private PopObject startWaveOutputObject;
    private PopObject endWaveOutputObject;
    private PopObject initWaveOutputObject;

    /**
     * Constructor
     */
    public Wave() {
        this.name = "Wave";
        startWaveOutputObject = MVMRandomizer.currentMap.createStartWaveOutputObject();
        endWaveOutputObject = MVMRandomizer.currentMap.createDoneOutputObject();
        initWaveOutputObject = MVMRandomizer.currentMap.createInitWaveOutputObject();
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        PopObject popObject = new PopObject(name);

        popObject.addObject(startWaveOutputObject);
        popObject.addObject(endWaveOutputObject);
        popObject.addObject(initWaveOutputObject);

        popObject.addAttribute("Checkpoint", "Yes");

        populateWaveSpawnsIfEmpty();

        ArrayList<PopObjectRepresentation> waveSpawnRepresentation = new ArrayList<>(waveSpawns);
        popObject.addObjectRepresentations(waveSpawnRepresentation);

        return popObject;
    }

    /**
     * This is mostly for testing - fills in the default wave spawn
     * if the list is empty
     */
    private void populateWaveSpawnsIfEmpty() {
        if (waveSpawns.size() == 0) {
            waveSpawns.add(new WaveSpawn());
        }
    }

    /**
     * Generates a random representation of this object
     */
    public void generateRandom(int waveNumber) {
        int numberOfWaveSpawns = MVMRandomizer.waveSettings.getNumberOfWaveSpawnsForWave(waveNumber);
        Double totalCurrency =
            MVMRandomizer.waveSettings.getCurrencyValueForWave(waveNumber) * MVMRandomizer.mapSettings.getCurrencyMultiplier();

        boolean waveShouldHaveTanks =
            MVMRandomizer.currentMap.hasTankRoutes() &&
            MVMRandomizer.waveSettings.shouldGenerateTanks(waveNumber);

        if (waveShouldHaveTanks) {
            numberOfWaveSpawns = Math.max(numberOfWaveSpawns - MVMRandomizer.tankSettings.getWaveSpawnReduction(), 1);
        }

        int tankWaveNumber =  PopRandomizer.generateNumberInRange(1, numberOfWaveSpawns);
        int currencyPerWave = totalCurrency.intValue() / numberOfWaveSpawns;

        for(int i = 0; i < numberOfWaveSpawns; i++) {
            boolean isTankWave = waveShouldHaveTanks && (tankWaveNumber == i + 1);
            boolean isLastWaveSpawn = i == numberOfWaveSpawns - 1;
            generateWaveSpawn(waveNumber, currencyPerWave, isTankWave, isLastWaveSpawn);
        }

        generateSupports(waveNumber);
    }

    /**
     * Generates a set of bots to spawn in the wave
     * @param waveNumber - the current wave number
     * @param currencyPerWave - the amount of currency per wave
     * @param isTankWave - whether this wave has tanks
     */
    private void generateWaveSpawn(int waveNumber, int currencyPerWave, boolean isTankWave, boolean isLastWaveSpawn) {
        WaveSpawn waveSpawn = new WaveSpawn(false);

        if (isTankWave) {
            waveSpawn.generateRandomTanks();
        } else {
            boolean canSpawnGiants =
                numberOfGiantSpawns < MVMRandomizer.waveSettings.getMaxNumberOfGiantSpawns(waveNumber);
            waveSpawn.generateRandomBots(waveNumber, canSpawnGiants, waveHasBots);

            if (waveSpawn.getHasGiant()) {
                numberOfGiantSpawns++;
            }

            waveHasBots = true;
        }

        int waveSpawnNumber = waveSpawns.size() + 1;
        waveSpawn.setWaveSpawnName("wave# " + waveNumber + "-" + waveSpawnNumber);
        waveSpawn.setTotalCurrency(currencyPerWave);

        if (waveSpawnNumber > 1) {
            // waveSpawn.setWaitForAllSpawned("wave " + (waveSpawnNumber - 1)); //TODO: use this?

            int previousWaitBeforeStarting = ((WaveSpawn)waveSpawns.get(waveSpawnNumber - 2)).getWaitBeforeStarting();
            int waitBeforeStarting = previousWaitBeforeStarting + PopRandomizer.generateNumberInRange(5, 15);
            waveSpawn.setWaitBeforeStarting(waitBeforeStarting);
        }

        waveSpawns.add(waveSpawn);
        MVMRandomizer.currentMap.setUpForWaveSpawn(waveSpawn, waveSpawnNumber, isLastWaveSpawn);
    }

    /**
     * Generate supports, currently a 35% chance, or 100 % if the map is Manhattan
     * @param waveNumber - the current wave number
     */
    private void generateSupports(int waveNumber) {
        if (MVMRandomizer.currentMap.usesGateBots() ||
                MVMRandomizer.currentMap.usesChipBots() ||
                MVMRandomizer.waveSettings.shouldGenerateSupports(waveNumber)) {
            WaveSpawn waveSpawn = new WaveSpawn();
            waveSpawn.generateSupports();
            waveSpawn.setWaitBeforeStarting(0);
            waveSpawns.add(waveSpawn);
        }
    }
}
