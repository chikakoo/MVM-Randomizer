package Pop;

import Pop.Bot.RandomBot;
import Pop.Enums.*;
import Pop.GUI.OutputConsole;

import java.util.ArrayList;

/**
 * Represents missions for the MVM bots
 */
public class Mission extends PopObjectRepresentation {
    /**
     * The objective of the mission
     */
    private Objectives objective = Objectives.NONE;
    public Objectives getObjective() { return this.objective; }
    public void setObjective(Objectives objective) { this.objective = objective; }

    /**
     * Amount of time before the mission is active once a wave starts
     */
    private int initialCooldown = 10;

    /**
     * The spawn location of the bot
     */
    private ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();

    /**
     * The wave this mission becomes active on
     */
    private int beginAtWave = 1;
    public void setBeginAtWave(int beginAtWave) { this.beginAtWave = beginAtWave; }

    /**
     * The amount of time for this mission to be active
     */
    private int runForThisManyWaves = 10;
    public void setRunForThisManyWaves(int runForThisManyWaves) { this.runForThisManyWaves = runForThisManyWaves; }

    /**
     * The time before a new set of bots can spawn
     */
    private int cooldownTime = 35;

    /**
     * The number of bots to spawn each time
     */
    private int desiredCount = 1;

    /**
     * The bot to spawn for this mission
     */
    private RandomBot tfBot;

    /**
     * Constructor
     */
    public Mission()
    {
        this.name = "Mission";
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        setBotsBasedOnObjective();

        PopObject popObject = new PopObject(name);
        popObject.addAttribute("Objective", objective.toString());
        popObject.addAttribute("InitialCooldown", Integer.toString(initialCooldown));

        if (spawnLocations != null) {
            for (SpawnLocations spawnLocation : spawnLocations) {
                popObject.addAttribute("Where", spawnLocation.toString());
            }
        }

        popObject.addAttribute("BeginAtWave", Integer.toString(beginAtWave));
        popObject.addAttribute("RunForThisManyWaves", Integer.toString(runForThisManyWaves));
        popObject.addAttribute("CooldownTime", Integer.toString(cooldownTime));
        popObject.addAttribute("DesiredCount", Integer.toString(desiredCount));

        MVMRandomizer.currentMap.setMissionBotTags(tfBot);
        popObject.addObjectRepresentation(tfBot);

        return popObject;
    }

    /**
     * Generates a random representation of this object
     * @return the objective of the mission
     */
    public Objectives generateRandom() {
        Objectives objective = MVMRandomizer.botSettings.getMissionObjective();
        if (objective != null) {
            setObjective(objective);
            setRandomMissionValues();

            return objective;
        }
        return null;
    }

    /**
     * Generates a random representation of this object
     * @param previousMission - the mission that was already generated - so we don't have duplicated missions
     */
    public void generateRandom(Objectives previousMission) {
        Objectives objective = MVMRandomizer.botSettings.getMissionObjective(previousMission);
        if (objective != null) {
            setObjective(objective);
            setRandomMissionValues();
        }
    }

    /**
     * Sets the initial cooldown and cooldown time
     */
    private void setRandomMissionValues() {
        initialCooldown = PopRandomizer.generateNumberInRange(10, 60);
        cooldownTime = PopRandomizer.generateNumberInRange(20, 60);

        if (MVMRandomizer.botSettings.isWave666Mode()) {
            initialCooldown *= PopRandomizer.generateNumberInRange(2, 10);
            cooldownTime *= 2;
        }
    }

    /**
     * Sets the tfBot and spawnLocation of the bots based on the objective
     */
    private void setBotsBasedOnObjective() {
        switch(objective) {
            case DESTROY_SENTRIES:
                tfBot = RandomBot.getSentryBusterBot();
                spawnLocations = MVMRandomizer.currentMap.getSentryBusterSpawnLocations();
                return;
            case SPY:
                tfBot = RandomBot.getBotFromEnum(TFClasses.SPY);
                tfBot.isMissionBot = true;
                tfBot.generateSupportBot();
                spawnLocations = MVMRandomizer.currentMap.getRandomSpyBotLocations();
                break;
            case SNIPER:
                tfBot = RandomBot.getBotFromEnum(TFClasses.SNIPER);
                tfBot.isMissionBot = true;
                tfBot.generateSupportBot();
                spawnLocations = MVMRandomizer.currentMap.getRandomSniperBotLocations();
                break;
            case ENGINEER:
                tfBot = RandomBot.getBotFromEnum(TFClasses.ENGINEER);
                tfBot.isMissionBot = true;
                tfBot.generateSupportBot();
                spawnLocations = MVMRandomizer.currentMap.getRandomEngineerBotLocations();
                break;
            default:
                OutputConsole.addMessage("Unexpected mission objective: " + objective.name() + ". Aborting mission creation.");
                return;
        }

        desiredCount = tfBot.getMissionSpawnCount();
    }

    /**
     * This is the default mission for sentry busters
     * @param numberOfWaves - the total number of waves
     * @return the sentry buster mission
     */
    public static Mission createSentryBusterMission(int numberOfWaves) {
        Mission mission = new Mission();
        mission.setObjective(Objectives.DESTROY_SENTRIES);
        mission.setRunForThisManyWaves(numberOfWaves);
        return mission;
    }
}
