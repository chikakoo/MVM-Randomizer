package Pop;

import Pop.Bot.RandomBot;
import Pop.Enums.*;
import Pop.GUI.OutputConsole;
import Pop.Settings.TankSetting;

import java.util.ArrayList;

/**
 * Defines a set of bots to spawn during a wave
 */
public class WaveSpawn extends PopObjectRepresentation {
    /**
     * The place to spawn the bots
     */
    private ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();
    public ArrayList<SpawnLocations> getSpawnLocations() { return spawnLocations; }
    public void setSpawnLocations(ArrayList<SpawnLocations> spawnLocations) { this.spawnLocations = spawnLocations; }

    /**
     * The start wave output object - not used by most maps
     */
    private PopObject startWaveOutput;
    public void setStartWaveOutput(PopObject startWaveOutput) {
        this.startWaveOutput = startWaveOutput;
    }

    /**
     * The start wave output object - not used by most maps
     */
    private PopObject firstSpawnOutput;
    public void setFirstSpawnOutput(PopObject firstSpawnOutput) {
        this.firstSpawnOutput = firstSpawnOutput;
    }

    /**
     * The done output object - not used by most maps
     */
    private PopObject doneOutput;
    public void setDoneOutput(PopObject doneOutput) {
        this.doneOutput = doneOutput;
    }

    /**
     * The name of the wave
     */
    private String waveSpawnName = "";
    public String getWaveSpawnName() { return this.waveSpawnName; }
    public void setWaveSpawnName(String waveSpawnName) {
        this.waveSpawnName = waveSpawnName;
    }

    /**
     * The total number of bots in this set of bots
     */
    private int totalCount = 10;
    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

    /**
     * The max number of bots that can be alive
     */
    private int maxActive = 5;
    public void setMaxActive(int maxActive) { this.maxActive = maxActive; }

    /**
     * The max number of bots that can spawn at once
     */
    private int spawnCount = 2;
    public int getSpawnCount() { return spawnCount; }
    public void setSpawnCount(int spawnCount) { this.spawnCount = spawnCount; }

    /**
     * The amount of time to wait before spawning the first bot
     */
    private int waitBeforeStarting = 0;
    public int getWaitBeforeStarting() { return waitBeforeStarting; }
    public void setWaitBeforeStarting(int waitBeforeStarting) { this.waitBeforeStarting = waitBeforeStarting; }

    /**
     * The amount of time between spawns
     */
    private int waitBetweenSpawns = 0;

    /**
     * The name of the wave to wait for everything to spawn from before spawning this set
     */
    private String waitForAllSpawned = "";
    public void setWaitForAllSpawned(String waitForAllSpawned)
    {
        this.waitForAllSpawned =  "\"" + waitForAllSpawned + "\"";;
    }

    /**
     * The name of the wave to wait for everything to die before spawning this set
     */
    private String waitForAllDead = "";
    public void setWaitForAllDead(String waitForAllDead)
    {
        this.waitForAllDead =  "\"" + waitForAllDead + "\"";
    }

    /**
     * The sound to play before the wave spawn starts
     */
    private String startWaveWarningSound = "";
    public void setStartWaveWarningSound(String startWaveWarningSound) {
        this.startWaveWarningSound = "\"" + startWaveWarningSound + "\"";
    }

    /**
     * The sound to play after the first wave spawn happens
     */
    private String firstSpawnWarningSound = "";
    public void setFirstSpawnWarningSound(String firstSpawnWarningSound) {
        this.firstSpawnWarningSound = "\"" + firstSpawnWarningSound + "\"";
    }

    /**
     * The total amount of money to be dropped by these bots
     */
    private int totalCurrency = 400;
    public int getTotalCurrency() { return totalCurrency; }
    public void setTotalCurrency(int totalCurrency) { this.totalCurrency = totalCurrency; }

    /**
     * Whether the wave spawn has RandomSpawn 1 set to spawn the bots at any spawn point with the same name
     */
    private PopBoolean randomSpawns;

    /**
     * Whether these bots are support
     */
    private PopBoolean support = new PopBoolean(false);
    public boolean isSupport() { return support.getValue(); }

    /**
     * Whether these bots are limited support - overrides the above setting
     */
    private boolean isLimitedSupport;
    public void setLimitedSupport(boolean isLimitedSupport) { this.isLimitedSupport = isLimitedSupport; }

    /**
     * The bot type to spawn
     */
    private Squad squad = new Squad();
    public Squad getSquad() { return squad; }

    /**
     * Whether to hide the icon - this will override the squad object with what's entered here
     */
    private PopObject squadOverride;
    public void setSquadOverride(PopObject squadOverride) { this.squadOverride = squadOverride; }

    /**
     * Whether this WaveSpawn contains a giant
     */
    private boolean hasGiant;
    public boolean getHasGiant() { return hasGiant; }

    /**
     * The tank that's part of this wave spawn
     */
    private Tank tank;

    /**
     * True if the wave has a tank, false otherwise
     */
    private boolean hasTank;

    /**
     * Default constructor
     */
    public WaveSpawn() {
        this.name = "WaveSpawn";
    }

    /**
     * Constructor
     */
    public WaveSpawn(boolean hasTank) {
        this.name = "WaveSpawn";
        this.hasTank = hasTank;

        if (MVMRandomizer.waveSettings.shouldUseRandomSpawns()) {
            this.randomSpawns = new PopBoolean(true);
        }
    }

    /**
     * Adds the given bot to the squad
     * @param tfBot - the bot to add
     */
    public void addToSquad(TFBot tfBot) {
        squad.addToSquad(tfBot);
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        if (hasTank) {
            return getPopObjectForTankWaveSpawn();
        }

        PopObject popObject = new PopObject(name);

        popObject.addObject(startWaveOutput);
        popObject.addObject(firstSpawnOutput);
        popObject.addObject(doneOutput);

        if (!waveSpawnName.equals("")) {
            popObject.addAttribute("Name", "\"" + waveSpawnName + "\"");
        }

        for(SpawnLocations spawnLocation : spawnLocations) {
            popObject.addAttribute("Where", spawnLocation.toString());
        }

        popObject.addAttribute("TotalCount", Integer.toString(totalCount));
        popObject.addAttribute("MaxActive", Integer.toString(maxActive));
        popObject.addAttribute("SpawnCount", Integer.toString(spawnCount));

        if (randomSpawns != null) {
            popObject.addAttribute("RandomSpawn", randomSpawns.toString());
        }

        popObject.addAttribute("WaitBeforeStarting", Integer.toString(waitBeforeStarting));
        popObject.addAttribute("WaitBetweenSpawns", Integer.toString(waitBetweenSpawns));

        if (!waitForAllSpawned.equals("")) {
            popObject.addAttribute("WaitForAllSpawned", waitForAllSpawned);
        }

        if (!waitForAllDead.equals("")) {
            popObject.addAttribute("WaitForAllDead", waitForAllDead);
        }

        if (!startWaveWarningSound.equals("")) {
            popObject.addAttribute("StartWaveWarningSound", startWaveWarningSound);
        }

        if (!firstSpawnWarningSound.equals("")) {
            popObject.addAttribute("FirstSpawnWarningSound", firstSpawnWarningSound);
        }

        if (totalCurrency > 0) {
            popObject.addAttribute("TotalCurrency", Integer.toString(totalCurrency));
        }

        if (isLimitedSupport) {
            popObject.addAttribute("Support", "Limited");
        }
        else if (support.getValue()) {
            popObject.addAttribute("Support", support.toString());
        }

        if (squadOverride != null) {
            popObject.addObject(squadOverride);
        } else {
            popObject.addObjectRepresentation(squad);
        }

        return popObject;
    }

    /**
     * Gets the PopObject if this wave has a Tank
     * @return this PopObject
     */
    private PopObject getPopObjectForTankWaveSpawn() {
        PopObject popObject = new PopObject(name);

        if (!waveSpawnName.equals("")) {
            popObject.addAttribute("Name", "\"" + waveSpawnName + "\"");
        }

        popObject.addAttribute("TotalCount", Integer.toString(totalCount));
        popObject.addAttribute("WaitBeforeStarting", Integer.toString(waitBeforeStarting));
        popObject.addAttribute("WaitBetweenSpawns", Integer.toString(waitBetweenSpawns));

        if (!waitForAllDead.equals("")) {
            popObject.addAttribute("WaitForAllDead", waitForAllDead);
        }

        if (!startWaveWarningSound.equals("")) {
            popObject.addAttribute("StartWaveWarningSound", startWaveWarningSound);
        }

        popObject.addAttribute("TotalCurrency", Integer.toString(totalCurrency));

        PopObject firstSpawnOutput = new PopObject("FirstSpawnOutput");
        firstSpawnOutput.addAttribute("Target", "boss_spawn_relay");
        firstSpawnOutput.addAttribute("Action", "Trigger");

        popObject.addObject(firstSpawnOutput);
        popObject.addObject(tank.getPopObject());

        return popObject;
    }

    /**
     * Create a spawnWave containing tanks
     */
    public void generateRandomTanks() {
        hasTank = true;

        tank = new Tank();
        TankSetting tankSetting = tank.generateRandom();
        totalCount = tankSetting.getAmount();
        waitBetweenSpawns = tankSetting.generateSpawnDelay();
    }

    /**
     * Generates a random bot to spawn for this wave
     * @param waveNumber - the wave number
     * @param canGenerateGiants - whether the bot can be a giant
     * @param includeSpies - whether we should include spies - this is done to prevent the bomb from potentially never spawning
     */
    public void generateRandomBots(int waveNumber, boolean canGenerateGiants, boolean includeSpies) {
        hasTank = false;

        RandomBot tfBot = TFBot.generateRandom(waveNumber, canGenerateGiants, includeSpies);
        addToSquad(tfBot);

        hasGiant = tfBot.getIsGiant();
        totalCount = PopRandomizer.generateNumberInRange(tfBot.getSpawnRange());
        if (tfBot.getIsGiant()) {
            waitBetweenSpawns = PopRandomizer.generateNumberInRange(30, 45);
            maxActive = totalCount;
            spawnCount = PopRandomizer.generateNumberInRange(1, 2);
        } else {
            waitBetweenSpawns = PopRandomizer.generateNumberInRange(10, 25);
            computeMaxActive();
            computeSpawnCount();
        }

        adjustCounts(tfBot);
        fixSpawnCount();

        spawnLocations = tfBot.getIsGiant() ?
            MVMRandomizer.currentMap.getRandomGiantBotLocations() :
            MVMRandomizer.currentMap.getRandomNormalBotLocations();

        MVMRandomizer.currentMap.setBotTags(tfBot, spawnLocations);
        MVMRandomizer.currentMap.setBotTags(tfBot);
        MVMRandomizer.currentMap.adjustBotAttributes(tfBot);
        MVMRandomizer.currentMap.changeSpawnLocationFromTags(tfBot.tags, spawnLocations);
    }

    /**
     * Generate supports for the wave
     * Currently sets max active to some value within the spawn range
     * SpawnCount uses the default value, which is currently 2
     * Does nothing if there are no supports possible to generate
     */
    public void generateSupports() {
        RandomBot supportBot = TFBot.generateRandomSupport();
        if (supportBot == null) {
            OutputConsole.addMessageOnce("WARNING: No supports were possible to generate - skipping. This will be an issue if the map needs gate bots.");
            return;
        }

        support = new PopBoolean(true);
        maxActive = PopRandomizer.generateNumberInRange(supportBot.getSpawnRange());
        fixSpawnCount();

        waitBetweenSpawns = PopRandomizer.generateNumberInRange(20, 40);
        addToSquad(supportBot);

        totalCurrency = 0;

        spawnLocations = MVMRandomizer.currentMap.getRandomNormalBotLocations();
        MVMRandomizer.currentMap.setBotTags(supportBot, this);
        MVMRandomizer.currentMap.setBotTags(supportBot);
        MVMRandomizer.currentMap.adjustBotAttributes(supportBot);

        MVMRandomizer.currentMap.changeSpawnLocationFromTags(supportBot.tags, spawnLocations);
    }

    /**
     * Adjusts the spawn and total counts to be more reasonable
     * @param tfBot
     */
    private void adjustCounts(RandomBot tfBot) {
        if (!tfBot.getIsGiant() && spawnCount < 3) {
            spawnCount = 3;
        }

        fixSpawnCount();
    }

    /**
     * Adjusts the spawn count if it is too high
     */
    private void fixSpawnCount() {
        if (spawnCount > maxActive) {
            spawnCount = maxActive;
        }
    }

    /**
     * Computes how many bots are active based on the total count
     */
    private void computeMaxActive() {
        computeMaxActive(totalCount);
    }

    /**
     * Computes how many bots are active based on the base value
     */
    private void computeMaxActive(int baseValue) {
        int halfOfTotalCount = baseValue / 2;
        int oneThirdOfTotalCount = baseValue / 3;

        if (oneThirdOfTotalCount == 0 || halfOfTotalCount == 0) {
            maxActive = 1;
        } else {
            maxActive = PopRandomizer.generateNumberInRange(oneThirdOfTotalCount, halfOfTotalCount);
        }
    }

    /**
     * Computes how many bots will spawn at a time
     */
    private void computeSpawnCount() {
        spawnCount = PopRandomizer.generateNumberInRange(3, 7);
    }
}
