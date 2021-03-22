package Pop;

import Pop.Enums.NumericValues;
import Pop.Enums.Objectives;
import Pop.Enums.YesOrNo;

import java.util.ArrayList;

/**
 * The WaveSchedule - containing information for the entire set of waves
 */
public class WaveSchedule extends PopObjectRepresentation {
    /**
     * The starting currency for a wave
     */
    public int startingCurrency = MVMRandomizer.mapSettings.getStartingCurrency();

    /**
     * The initial time to respawn on death - if set to 0, stays at 0 throughout
     * Otherwise, increases by 2 each time, to a max of 10
     */
    public int respawnWaveTime = 0;

    /**
     * Whether bots can attack players while they are in the spawn room
     */
    public YesOrNo canBotsAttackWhileInSpawnRoom = YesOrNo.NO;

    /**
     * A list of missions
     */
    public ArrayList<PopObjectRepresentation> missions = new ArrayList<>();

    /**
     * A list of waves
     */
    public ArrayList<PopObjectRepresentation> waves = new ArrayList<>();

    /**
     * Constructor - keeps the default values
     */
    public WaveSchedule() {
        this.name = "WaveSchedule";
    }

    /**
     * Constructor for currency and wave time edits
     * @param startingCurrency - the starting currency
     * @param respawnWaveTime - the initial respawn time
     */
    public WaveSchedule(int startingCurrency, int respawnWaveTime) {
        this.name = "WaveSchedule";
        this.startingCurrency = startingCurrency;
        this.respawnWaveTime = respawnWaveTime;
    }

    /**
     * Adds a mission to the WaveSchedule
     * @param mission - the mission to add
     */
    public void addMission(Mission mission) {
        missions.add(mission);
    }

    /**
     * Adds a wave to the WaveSchedule
     * @param wave - the wave to add
     */
    public void addWave(Wave wave) {
        waves.add(wave);
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        PopObject popObject = new PopObject(name);
        popObject.addAttribute("StartingCurrency", Integer.toString(startingCurrency));
        popObject.addAttribute("RespawnWaveTime", Integer.toString(respawnWaveTime));
        popObject.addAttribute("CanBotsAttackWhileInSpawnRoom", canBotsAttackWhileInSpawnRoom.toString());

        populateMissionsAndWavesIfEmpty();
        popObject.addObjectRepresentations(missions);
        popObject.addObjectRepresentations(waves);

        return popObject;
    }

    /**
     * This is mostly for testing - fills in the default mission and wave
     * if they lists are empty
     */
    private void populateMissionsAndWavesIfEmpty() {
        if (missions.size() == 0) {
            missions.add(new Mission());
        }

        if (waves.size() == 0) {
            waves.add(new Wave());
        }
    }

    /**
     * Generates a random representation of this object
     */
    public void generateRandom() {
        final int NUMBER_OF_WAVES =
            PopRandomizer.generateNumberInRange(MVMRandomizer.waveScheduleSettings.getNumberOfWaves());

        Mission sentryBusterMission = Mission.createSentryBusterMission(NUMBER_OF_WAVES);
        missions.add(sentryBusterMission);

        for (int i = 0; i < NUMBER_OF_WAVES; i++) {
            int waveNumber = i + 1;
            MVMRandomizer.currentMap.setUpForWave(waveNumber);

            Wave wave = new Wave();
            wave.generateRandom(waveNumber);
            generateRandomMissionsForWave(waveNumber);
            addWave(wave);

            MVMRandomizer.currentMap.afterWaveAdded(wave);
        }
    }

    /**
     * Generates random missions for the wave
     * @param waveNumber - the current wave number
     */
    private void generateRandomMissionsForWave(int waveNumber) {
        if (MVMRandomizer.waveSettings.shouldGenerateMission(waveNumber)) {
            ArrayList<WeightedItem> weightedItems = new ArrayList<>();
            weightedItems.add(new WeightedItem<>(NumericValues.ONE, 90));
            weightedItems.add(new WeightedItem<>(NumericValues.TWO, 10));

            WeightedItemCollection weightedItemCollection = new WeightedItemCollection(weightedItems);
            WeightedRandomizer weightedRandomizer = new WeightedRandomizer(weightedItemCollection);

            int numberOfMissions = ((NumericValues)weightedRandomizer.getWeightedItem()).getNumericValue();

            Objectives objective = generateFirstMission(waveNumber);
            if (numberOfMissions == 2) {
                generateSecondMission(waveNumber, objective);
            }
        }
    }

    /**
     * Generates a mission for the wave
     * @param waveNumber - the current wave number
     * @return The objective of the mission
     */
    private Objectives generateFirstMission(int waveNumber) {
        Mission mission = new Mission();
        mission.generateRandom();
        Objectives objective = mission.getObjective();

        if (!objective.equals(Objectives.NONE)) {
            mission.setBeginAtWave(waveNumber);
            mission.setRunForThisManyWaves(1);
            missions.add(mission);
        }

        return objective;
    }

    /**
     * Generates a mission for the wave
     * @param waveNumber - the current wave number
     * @param objective - the objective of the first mission
     */
    private void generateSecondMission(int waveNumber, Objectives objective) {
        if (objective == null) {
            return;
        }

        Mission mission = new Mission();
        mission.generateRandom(objective);

        if (!mission.getObjective().equals(Objectives.NONE)) {
            mission.setBeginAtWave(waveNumber);
            mission.setRunForThisManyWaves(1);
            missions.add(mission);
        }
    }
}
