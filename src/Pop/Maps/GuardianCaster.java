package Pop.Maps;

import Pop.*;
import Pop.Bot.BotTemplate;
import Pop.Enums.SpawnLocations;
import Pop.Enums.TFClasses;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;
import java.util.Arrays;

public class GuardianCaster extends Map {
    /**
     * Whether the specified hazards are currently active
     */
    private boolean usingSmokeHazard = false;
    private boolean usingToxicHazard = false;

    /**
     * The last nav tag assigned to the bot
     * Used with squads with medics so they match
     */
    private String currentBotNavTag;

    /**
     * Constructor
     */
    public GuardianCaster() {
        super();
        name = "Guardian Caster";
        popfileName = "gd_caster";
        canSpawnEngineers = true;

        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_GATE);

        sniperBotSpawnLocations.clear();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_GATE);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_TOP);

        spyBotSpawnLocations.clear();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_GATE);

        engineerBotSpawnLocations.clear();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_GATE);
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_TOP);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_TOP);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_TOP);

        tankRoutes.add(TankRoutes.GUARDIAN_CASTER);
    }

    /**
     * Creates the object for InitWaveOutput - this will choose the pathmodels
     * @return the created object
     */
    public PopObject createInitWaveOutputObject() {
        PopObject initWaveOutput = new PopObject("InitWaveOutput");
        initWaveOutput.addAttribute("Target", "wave_pathmodels_both");
        initWaveOutput.addAttribute("Action", "Trigger");

        return initWaveOutput;
    }

    /**
     * Gets a random location for a normal bot
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        return getNormalOrGiantBotLocations(normalBotSpawnLocations);
    }

    /**
     * Gets a random location for a giant bot
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomGiantBotLocations() {
        return getNormalOrGiantBotLocations(giantBotSpawnLocations);
    }

    /**
     * Gets the set of spawn locations for a normal or giant bot
     * Will always include spawnbot_gate
     * @param spawnChoices - the normal or giant spawn location list
     * @return the list of locations
     */
    private ArrayList<SpawnLocations> getNormalOrGiantBotLocations(ArrayList<SpawnLocations> spawnChoices) {
        SpawnLocations location = PopRandomizer.randomElement(spawnChoices);

        ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();
        spawnLocations.add(location);
        spawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_GATE);

        return spawnLocations;
    }

    /**
     * Sets tags for mission bots
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setMissionBotTags(TFBot tfBot) {
        BotTemplate template = tfBot.getBotTemplate();
        if (template != null && template.getTemplateName().equals("T_TFBot_SentryBuster")) {
            tfBot.tags.add("bot_sentrybuster");
        }
    }

    /**
     * This map sets up attributes so that all bots are like gate bots
     * Sets tags for bots so they can navigate correctly
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setBotTags(TFBot tfBot) {
        BotTemplate template = tfBot.getBotTemplate();
        if (template != null && template.getTemplateName().equals("T_TFBot_SentryBuster")) {
            return;
        }

        setGateBotInfo(tfBot);

        ArrayList<String> tags = new ArrayList<>(
                Arrays.asList("nav_prefer_top_right", "nav_prefer_top_left", "nav_prefer_left", "nav_prefer_right"));
        String tag = PopRandomizer.randomElement(tags);
        currentBotNavTag = tag;
        tfBot.tags.add(tag);
    }

    /**
     * Sets the gatebot info on the bot
     * @param tfBot - the bot
     */
    private void setGateBotInfo(TFBot tfBot) {
        if (tfBot.getIsGiant()) {
            tfBot.tags.add("bot_giant");
        }

        if (!tfBot.getTFClass().equals(TFClasses.MEDIC)) {
            tfBot.tags.add("bot_gatebot");
        }

        tfBot.addBehaviorModifier("Push");
        tfBot.addAttribute("IgnoreFlag");
    }

    /**
     * Performs any necessary setup for a given wave number
     * Sets the smoke hazard to false
     * @param waveNumber - the wave number
     */
    @Override
    public void setUpForWave(int waveNumber) {
        usingSmokeHazard = false;
        usingToxicHazard = false;
    }

    /**
     * Sets up the money wave
     * Includes zeroing out all the wave spawn money and adding it to the current bot
     * Will also hide the bot icon so that it won't show up
     * @param wave - the wave
     */
    @Override
    public void afterWaveAdded(Wave wave) {
        WaveSpawn moneySpawn = new WaveSpawn();
        moneySpawn.setLimitedSupport(true);
        moneySpawn.setTotalCount(1);
        moneySpawn.setMaxActive(1);
        moneySpawn.setSpawnCount(1);

        ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();
        spawnLocations.add(SpawnLocations.SPAWN_BOT_GUARDIAN_CASTER_MONEY);
        moneySpawn.setSpawnLocations(spawnLocations);

        String lastWaveSpawn = "";
        int totalCurrency = 0;
        for (WaveSpawn waveSpawn : wave.getWaveSpawns()) {
            String waveSpawnName = waveSpawn.getWaveSpawnName();
            if (waveSpawnName != null && !waveSpawnName.equals("")) {
                lastWaveSpawn = waveSpawnName;
            }
            totalCurrency += waveSpawn.getTotalCurrency();
            waveSpawn.setTotalCurrency(0);
        }
        moneySpawn.setWaitForAllSpawned(lastWaveSpawn);
        moneySpawn.setTotalCurrency(Math.max(totalCurrency, 0));

        if (isHazardActive()) {
            PopObject tfBot = new PopObject("TFBot");
            tfBot.addAttribute("Class", "Scout");
            tfBot.addAttribute("ClassIcon", getHazardClassIconName());
            moneySpawn.setSquadOverride(tfBot);
        } else {
            PopObject outerChoice = new PopObject("RandomChoice");
            PopObject innerChoice = new PopObject("RandomChoice");
            PopObject tfBot = new PopObject("TFBot");
            tfBot.addAttribute("Class", "Scout");

            outerChoice.addObject(innerChoice);
            innerChoice.addObject(tfBot);
            moneySpawn.setSquadOverride(outerChoice);
        }

        wave.getWaveSpawns().add(moneySpawn);
    }

    /**
     * Performs any necessary setup for a given wave spawn number
     * Clears the event if it's the last wave spawn
     * Has a 33% chance of starting a new event if NOT the last wave spawn
     * Handles setting up squads for medic wave spawns
     * @param waveSpawnNumber - the wave spawn
     * @param isLastWaveSpawn - whether this is the final wave spawn
     */
    public void setUpForWaveSpawn(WaveSpawn waveSpawn, int waveSpawnNumber, boolean isLastWaveSpawn) {
        boolean isHazardActive = isHazardActive();

        if (isLastWaveSpawn && isHazardActive) {
            endActiveHazard(waveSpawn);
        } else if (!isHazardActive && !isLastWaveSpawn && PopRandomizer.generateBooleanFromPercentage(33)) {
            startRandomHazard(waveSpawn);
        }

        ArrayList<TFBot> tfBotsInWaveSpawn = waveSpawn.getSquad().getTFBots();
        if (tfBotsInWaveSpawn.size() == 1 && tfBotsInWaveSpawn.get(0).getTFClass().equals(TFClasses.MEDIC)) {
            TFBot medicSquadBot = TFBot.generateRandomForMedicSquad();
            setGateBotInfo(medicSquadBot);
            medicSquadBot.tags.add(currentBotNavTag);
            tfBotsInWaveSpawn.add(0, medicSquadBot);
            fixMedicWaveSpawnCounts(waveSpawn);
        }
    }

    /**
     * Fix the medic wave spawn counts so they line up
     * @param waveSpawn - the wave spawn to correct
     */
    private void fixMedicWaveSpawnCounts(WaveSpawn waveSpawn) {
        int spawnCount = waveSpawn.getSpawnCount();
        if (spawnCount % 2 != 0) { // We need an even number, since there's 2 bots per squad
            spawnCount++;
        }

        int totalCount = waveSpawn.getTotalCount();
        int spawnMultiplier = (int)Math.ceil((double)totalCount / spawnCount);

        totalCount = spawnCount * spawnMultiplier;

        // We don't want to reduce the number of giants, so we'll just add bots for the giants to heal instead
        if (waveSpawn.getHasGiant()) {
            totalCount *= 2;
            spawnCount *= 2;
        }

        waveSpawn.setTotalCount(totalCount);
        waveSpawn.setMaxActive(spawnCount);
        waveSpawn.setSpawnCount(spawnCount);
    }

    /**
     * Returns whether a hazard is active
     * @return
     */
    private boolean isHazardActive() {
        return usingSmokeHazard ||  usingToxicHazard;
    }

    /**
     * Starts a random hazard - smoke or toxic
     * @param waveSpawn - the wave spawn
     */
    private void startRandomHazard(WaveSpawn waveSpawn) {
        String hazardName;
        if (PopRandomizer.generateBoolean()) {
            hazardName = "toxic";
            usingToxicHazard = true;
        } else {
            hazardName = "smoke";
            usingSmokeHazard = true;
        }

        PopObject startWaveOutputObject = new PopObject("StartWaveOutput");
        startWaveOutputObject.addAttribute("Target", "wave_event_" + hazardName);
        startWaveOutputObject.addAttribute("Action", "Trigger");

        waveSpawn.setStartWaveOutput(startWaveOutputObject);
    }

    /**
     * Ends the current hazard
     * @param waveSpawn - the wave spawn
     */
    private void endActiveHazard(WaveSpawn waveSpawn) {
        PopObject startWaveOutputObject = new PopObject("StartWaveOutput");
        startWaveOutputObject.addAttribute("Target", getHazardFinishAttributeName());
        startWaveOutputObject.addAttribute("Action", "Trigger");

        waveSpawn.setStartWaveOutput(startWaveOutputObject);
    }

    /**
     * Gets the attribute name based on the hazard name
     * @return
     */
    private String getHazardFinishAttributeName() {
        return "wave_event_" + getHazardName() + "_finish";
    }

    /**
     * Gets the attribute name based on the hazard name
     * @return
     */
    private String getHazardClassIconName() {
        return "caster_" + getHazardName();
    }

    /**
     * Gets the current hazard name
     * @return
     */
    private String getHazardName() {
        String hazardName = "";
        if (usingSmokeHazard) {
            hazardName = "smoke";
        } else if (usingToxicHazard) {
            hazardName = "toxic";
        }
        return hazardName;
    }

    /**
     * Sets bot scale to be 1.7 if it's greater than that
     * @param tfBot - the bot to adjust the attributes of
     */
    public void adjustBotAttributes(TFBot tfBot) {
        if (tfBot.getScale() > 1.7 || (tfBot.getIsGiant() && tfBot.getBotTemplate() != null)) {
            tfBot.setScale(1.7);
        }
    }
}
