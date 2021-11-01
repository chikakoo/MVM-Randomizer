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
     * @param waveNumber - the current wave number
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
            int waveSpawnNumber = i + 1;
            boolean isTankWave = waveShouldHaveTanks && (tankWaveNumber == i + 1);
            boolean isLastWaveSpawn = i == numberOfWaveSpawns - 1;
            generateWaveSpawn(waveNumber, waveSpawnNumber, currencyPerWave, isTankWave, isLastWaveSpawn);
        }

        generateSupports(waveNumber);
    }

    /**
     * Generates a set of bots to spawn in the wave
     * @param waveNumber - the current wave number
     * @param waveSpawnNumber - the current wave spawn number
     * @param currencyPerWave - the amount of currency per wave
     * @param isTankWave - whether this wave has tanks
     */
    private void generateWaveSpawn(int waveNumber, int waveSpawnNumber, int currencyPerWave, boolean isTankWave, boolean isLastWaveSpawn) {
        WaveSpawn waveSpawn = new WaveSpawn(false);
        boolean isWave666Mode = MVMRandomizer.botSettings.isWave666Mode();

        if (waveSpawnNumber == 1 && isWave666Mode) {
            numberOfGiantSpawns = 0;

            if (waveNumber > 1) {
                int firstSpawnId = PopRandomizer.generateNumberInRange(1, 12); // There are 12 of these sounds
                waveSpawn.setStartWaveWarningSound("vo/mvm_get_to_upgrade01.mp3");
                waveSpawn.setFirstSpawnWarningSound("vo/mvm_wave_start" + String.format("%02d", firstSpawnId) + ".mp3");
            }
        }

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

        waveSpawn.setWaveSpawnName(getWaveSpawnName(waveNumber, waveSpawnNumber));
        waveSpawn.setTotalCurrency(currencyPerWave);

        if (isWave666Mode)
        {
            // Wait for all previous bots to be dead before spawning the next set
            if (waveNumber > 1) {
                waveSpawn.setWaitForAllDead(getWaveSpawnName(waveNumber - 1, 0));

                // Set a delay on the next groups of bots
                if (waveSpawnNumber == 1) {
                    waveSpawn.setWaitBeforeStarting(PopRandomizer.generateNumberInRange(15, 30));
                }
            }
        }

        if (waveSpawnNumber > 1) {
            int previousWaitBeforeStarting = (waveSpawns.get(waveSpawns.size() - 1)).getWaitBeforeStarting();
            int waitBeforeStarting = previousWaitBeforeStarting + PopRandomizer.generateNumberInRange(5, 15);
            waveSpawn.setWaitBeforeStarting(waitBeforeStarting);
        }

        waveSpawns.add(waveSpawn);
        MVMRandomizer.currentMap.setUpForWaveSpawn(waveSpawn, waveSpawnNumber, isLastWaveSpawn);
    }

    /**
     * Gets the wave spawn name
     * @param waveNumber - the wave number
     * @param waveSpawnNumber - the wave spawn number
     * @return The wave spawn name
     */
    private String getWaveSpawnName(int waveNumber, int waveSpawnNumber)
    {
        if (MVMRandomizer.botSettings.isWave666Mode()) {
            return "wave# " + waveNumber;
        }
        return "wave# " + waveNumber + "-" + waveSpawnNumber;
    }

    /**
     * Generate supports based on the map settings
     * @param waveNumber - the current wave number
     */
    private void generateSupports(int waveNumber) {
        if (MVMRandomizer.botSettings.isWave666Mode() && waveNumber > 1) {
            return;
        }

        if (MVMRandomizer.currentMap.shouldForceGenerateSupports() ||
                MVMRandomizer.waveSettings.shouldGenerateSupports(waveNumber)) {
            WaveSpawn waveSpawn = new WaveSpawn();
            waveSpawn.generateSupports();
            waveSpawn.setWaitBeforeStarting(0);
            waveSpawns.add(waveSpawn);

            MVMRandomizer.currentMap.setUpForSupportWaveSpawn(waveSpawn);
        }
    }
}
