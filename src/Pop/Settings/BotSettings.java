package Pop.Settings;

import Pop.Bot.BotTemplate;
import Pop.Bot.BotTemplates;
import Pop.Enums.Objectives;
import Pop.Enums.TFClasses;
import Pop.GUI.OutputConsole;
import Pop.MVMRandomizer;
import Pop.WeightedItem;
import Pop.WeightedItemCollection;
import Pop.WeightedRandomizer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Settings for bots as a whole
 */
public class BotSettings {
    /**
     * Settings for normal bots
     */
    private HashMap<TFClasses, ArrayList<BotSetting>> normalBots = new HashMap<>();
    public  HashMap<TFClasses, ArrayList<BotSetting>> getNormalBots() { return normalBots; }
    public void setNormalBots( HashMap<TFClasses, ArrayList<BotSetting>> normalBots) { this.normalBots = normalBots; }

    /**
     * Settings for giant bots
     */
    private HashMap<TFClasses, ArrayList<BotSetting>> giantBots = new HashMap<>();
    public  HashMap<TFClasses, ArrayList<BotSetting>> getGiantBots() { return giantBots; }
    public void setGiantBots(HashMap<TFClasses, ArrayList<BotSetting>> giantBots) { this.giantBots = giantBots; }

    /**
     * The odds that any generated bot will be random (as opposed to templated)
     */
    private int percentRandom;
    public int getPercentRandom() {
        return percentRandom;
    }
    public void setPercentRandom(int percentRandom) {
        this.percentRandom = percentRandom;
    }

    /**
     * Odds of each bot spawning for a standard WaveSpawn
     */
    private ClassPercentage standardBotDistributions;
    public ClassPercentage getStandardBotDistributions() {
        return standardBotDistributions;
    }
    public void setStandardBotDistributions(ClassPercentage standardBotDistributions) {
        this.standardBotDistributions = standardBotDistributions;
    }

    /**
     * Odds of each giant bot spawning for a standard WaveSpawn
     */
    private ClassPercentage giantBotDistributions;
    public ClassPercentage getGiantBotDistributions() {
        return giantBotDistributions;
    }
    public void setGiantBotDistributions(ClassPercentage giantBotDistributions) {
        this.giantBotDistributions = giantBotDistributions;
    }

    /**
     * Odds of each bot spawning for support (includes missions)
     */
    private ClassPercentage supportBotDistributions;
    public ClassPercentage getSupportBotDistributions() {
        return supportBotDistributions;
    }
    public void setSupportBotDistributions(ClassPercentage supportBotDistributions) {
        this.supportBotDistributions = supportBotDistributions;
    }

    /**
     * Highlander mode is where all bots are melee only, with the exception of snipers, who can also use the huntsman
     */
    private boolean highlanderMode;
    public boolean isHighlanderMode() {
        return highlanderMode;
    }
    public void setHighlanderMode(boolean highlanderMode) {
        this.highlanderMode = highlanderMode;
    }

    /**
     * Wave 666 mode is where all waves are combined into one single long wave, with delays between where waves would
     * normally end
     */
    private boolean wave666Mode;
    public boolean isWave666Mode() {
        return wave666Mode;
    }
    public void setWave666Mode(boolean wave666Mode) {
        this.wave666Mode = wave666Mode;
    }

    /**
     * Constructor
     */
    public BotSettings() {
        standardBotDistributions = new ClassPercentage();
        giantBotDistributions = new ClassPercentage();
        supportBotDistributions = new ClassPercentage();
        initialize();
    }

    /**
     * Initializes the settings with default values
     * This essentially fills in any gaps with default data
     */
    public void initialize() {
        for (TFClasses tfClass : TFClasses.values()) {
            initializeForClass(tfClass, false);
            initializeForClass(tfClass, true);
        }
    }

    /**
     * Fills in the templates in the list that don't exist for the given class
     * @param tfClass - the class
     * @param isGiantBot - whether this is a giant bot
     */
    private void initializeForClass(TFClasses tfClass, boolean isGiantBot) {
        for (BotTemplate template : BotTemplates.getTemplateList(tfClass, isGiantBot)) {
            BotSetting existingBotSetting = getBotSetting(tfClass, template, isGiantBot);
            if (existingBotSetting == null) {
                BotSetting newBotSetting = BotSetting.getDefaultBotSetting(tfClass, template, isGiantBot);
                addBotSetting(tfClass, isGiantBot, newBotSetting);
            } else {
                // Class icons and projectile weapons are NOT saved - so we must set it from the template we've retrieved
                existingBotSetting.getTemplate().setClassIcon(template.getClassIcon());
                existingBotSetting.getTemplate().setCustomProjectileWeapon(template.getCustomProjectileWeapon());

                // If the spawn number does not exist, we should set it to the defaults (for legacy settings files)
                if (existingBotSetting.getStandardSpawnNumber() == null ||
                    existingBotSetting.getStandardSpawnNumber().sum() == 0)
                {
                    existingBotSetting.setDefaultSpawnNumbersIfNeeded(isGiantBot);
                }
            }
        }
    }

    /**
     * Copies the settings over from the given BotSettings
     * @param botSettings - the object to copy settings from
     */
    public void copySettings(BotSettings botSettings) {
        normalBots = deepCopyBotSettingHashMap(botSettings.getNormalBots());
        giantBots = deepCopyBotSettingHashMap(botSettings.getGiantBots());

        percentRandom = botSettings.getPercentRandom();
        standardBotDistributions = new ClassPercentage(botSettings.getStandardBotDistributions());
        giantBotDistributions = new ClassPercentage(botSettings.getGiantBotDistributions());
        supportBotDistributions = new ClassPercentage(botSettings.getSupportBotDistributions());
    }

    /**
     * Deep copy function for the maps from a TFClass to a list of BotSetting objects
     * @param map - the map to copy
     * @return The copy of the map
     */
    private HashMap<TFClasses, ArrayList<BotSetting>> deepCopyBotSettingHashMap(
            HashMap<TFClasses, ArrayList<BotSetting>> map) {

        HashMap<TFClasses, ArrayList<BotSetting>> newMap = new HashMap<>();
        for (TFClasses currentTFClass : map.keySet()) {
            ArrayList<BotSetting> currentBotSettings = map.get(currentTFClass);
            ArrayList<BotSetting> newBotSettings = new ArrayList<>();

            for (BotSetting currentBotSetting : currentBotSettings) {
                String templateName = currentBotSetting.getTemplate().getTemplateName();
                if (!BotTemplates.templateLoaded(currentTFClass, templateName))
                {
                    OutputConsole.addMessage("WARNING: Bot template \"" + templateName + "\" of class \"" + currentTFClass.getDisplayString() + "\" does not exist in any of your pop files. Skipping...");
                    continue;
                }

                BotSetting newBotSetting = new BotSetting();
                newBotSetting.copySettings(currentBotSetting);
                newBotSettings.add(newBotSetting);
            }

            newMap.put(currentTFClass, newBotSettings);
        }

        return newMap;
    }

    /**
     * Gets the BotSetting associated with the class and template - null if not found
     * @param tfClass - the key of the HashMap
     * @param template - the template
     * @param getGiantBotSettings - true if we should get the list for giants
     * @return The list of settings
     */
    public BotSetting getBotSetting(TFClasses tfClass, BotTemplate template, boolean getGiantBotSettings) {
        ArrayList<BotSetting> botSettings = getBotSettings(tfClass, getGiantBotSettings);

        if (botSettings != null) {
            for (BotSetting botSetting : botSettings) {
                if (botSetting.getTemplate().equals(template)) {
                    return botSetting;
                }
            }
        }

        return null;
    }

    /**
     * Gets the list of bot settings belonging to the given class and size
     * @param tfClass - the class
     * @param getGiantBotSettings - true to get giants, false otherwise
     * @return The list
     */
    public ArrayList<BotSetting> getBotSettings(TFClasses tfClass, boolean getGiantBotSettings) {
        if (getGiantBotSettings && giantBots.containsKey(tfClass)) {
            return giantBots.get(tfClass);
        } else if (normalBots.containsKey(tfClass)) {
            return normalBots.get(tfClass);
        }

        return null;
    }

    /**
     * Adds a given bot setting - creates any HashMaps if they don't exist yet
     * @param tfClass - the tfClass
     * @param isGiantBot - whether this is for a giant bot
     * @param botSettingToAdd - the bot setting itself
     */
    public void addBotSetting(
            TFClasses tfClass,
            boolean isGiantBot,
            BotSetting botSettingToAdd) {

        if (isGiantBot && !giantBots.containsKey(tfClass)) {
            giantBots.put(tfClass, new ArrayList<>());
        } else if (!normalBots.containsKey(tfClass)) {
            normalBots.put(tfClass, new ArrayList<>());
        }

        ArrayList<BotSetting> botSettingsList = getBotSettings(tfClass, isGiantBot);
        botSettingsList.add(botSettingToAdd);
    }

    /**
     * Gets a random normal bot - takes weights into consideration
     * @param tfClass - the class the bot should be part of
     * @return - the retrieved BotSetting
     */
    public BotSetting getRandomBotSetting(TFClasses tfClass) {
        ArrayList<BotSetting> botSettings = getBotSettings(tfClass, false);
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();

        for (BotSetting botSetting : botSettings) {
            if (botSetting.getIsStandard()) {
                weightedItems.add(new WeightedItem<>(botSetting, botSetting.getStandardWeight()));
            }
        }
        WeightedItemCollection weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<BotSetting> weightedRandomizer = new WeightedRandomizer<>(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }

    /**
     * Gets a random giant bot - takes weights into consideration
     * @param tfClass - the class the bot should be part of
     * @return - the retrieved BotSetting
     */
    public BotSetting getRandomGiantBotSetting(TFClasses tfClass) {
        ArrayList<BotSetting> botSettings = getBotSettings(tfClass, true);
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();

        for (BotSetting botSetting : botSettings) {
            if (botSetting.getIsStandard()) {
                weightedItems.add(new WeightedItem<>(botSetting, botSetting.getStandardWeight()));
            }
        }
        WeightedItemCollection weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<BotSetting> weightedRandomizer = new WeightedRandomizer<>(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }

    /**
     * Gets a random support bot - takes weights into consideration
     * This includes giant bots marked as supports (they're just added to the mix)
     * @param tfClass - the class the bot should be part of
     * @return - the retrieved BotSetting
     */
    public BotSetting getRandomSupportBotSetting(TFClasses tfClass) {
        ArrayList<BotSetting> standardBotSettings = getBotSettings(tfClass, false);
        ArrayList<BotSetting> giantBotSettings = getBotSettings(tfClass, true);
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();

        for (BotSetting botSetting : standardBotSettings) {
            if (botSetting.getIsSupport()) {
                weightedItems.add(new WeightedItem<>(botSetting, botSetting.getSupportWeight()));
            }
        }

        for (BotSetting botSetting : giantBotSettings) {
            if (botSetting.getIsSupport()) {
                weightedItems.add(new WeightedItem<>(botSetting, botSetting.getSupportWeight()));
            }
        }

        WeightedItemCollection weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<BotSetting> weightedRandomizer = new WeightedRandomizer<>(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }

    /**
     * Gets a random standard bot class - takes weights into consideration
     * @param includeSpy - whether to include spy
     * @return - the retrieved class
     */
    public TFClasses getStandardBotClass(boolean includeSpy) {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>(Arrays.asList(
            new WeightedItem<>(TFClasses.DEMOMAN, standardBotDistributions.getDemomanPercentage()),
            new WeightedItem<>(TFClasses.HEAVY, standardBotDistributions.getHeavyPercentage()),
            new WeightedItem<>(TFClasses.MEDIC, standardBotDistributions.getMedicPercentage()),
            new WeightedItem<>(TFClasses.PYRO, standardBotDistributions.getPyroPercentage()),
            new WeightedItem<>(TFClasses.SCOUT, standardBotDistributions.getScoutPercentage()),
            new WeightedItem<>(TFClasses.SOLDIER, standardBotDistributions.getSoldierPercentage()),
            new WeightedItem<>(TFClasses.SNIPER, standardBotDistributions.getSniperPercentage())
        ));

        if (includeSpy) {
            weightedItems.add(new WeightedItem<>(TFClasses.SPY, standardBotDistributions.getSpyPercentage()));
        }

        WeightedItemCollection<TFClasses> weightedItemCollection = new WeightedItemCollection(weightedItems);
        return weightedItemCollection.getRandomItem();
    }

    /**
     * Gets a random bot class intended to be used with a medic squad
     * This will exlcude Engineer, Medic, and Spy
     * @return - the retrieved class
     */
    public TFClasses getBotClassForMedicSquad() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>(Arrays.asList(
                new WeightedItem<>(TFClasses.DEMOMAN, standardBotDistributions.getDemomanPercentage()),
                new WeightedItem<>(TFClasses.HEAVY, standardBotDistributions.getHeavyPercentage()),
                new WeightedItem<>(TFClasses.PYRO, standardBotDistributions.getPyroPercentage()),
                new WeightedItem<>(TFClasses.SCOUT, standardBotDistributions.getScoutPercentage()),
                new WeightedItem<>(TFClasses.SOLDIER, standardBotDistributions.getSoldierPercentage()),
                new WeightedItem<>(TFClasses.SNIPER, standardBotDistributions.getSniperPercentage())
        ));

        WeightedItemCollection<TFClasses> weightedItemCollection = new WeightedItemCollection(weightedItems);
        return weightedItemCollection.getRandomItem();
    }

    /**
     * Gets a random giant bot class - takes weights into consideration
     * @param includeSpy - whether to include spy
     * @return - the retrieved class
     */
    public TFClasses getGiantBotClass(boolean includeSpy) {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>(Arrays.asList(
            new WeightedItem<>(TFClasses.DEMOMAN, giantBotDistributions.getDemomanPercentage()),
            new WeightedItem<>(TFClasses.HEAVY, giantBotDistributions.getHeavyPercentage()),
            new WeightedItem<>(TFClasses.MEDIC, giantBotDistributions.getMedicPercentage()),
            new WeightedItem<>(TFClasses.PYRO, giantBotDistributions.getPyroPercentage()),
            new WeightedItem<>(TFClasses.SCOUT, giantBotDistributions.getScoutPercentage()),
            new WeightedItem<>(TFClasses.SOLDIER, giantBotDistributions.getSoldierPercentage()),
            new WeightedItem<>(TFClasses.SNIPER, giantBotDistributions.getSniperPercentage())
        ));

        if (includeSpy) {
            weightedItems.add(new WeightedItem<>(TFClasses.SPY, giantBotDistributions.getSpyPercentage()));
        }

        WeightedItemCollection<TFClasses> weightedItemCollection = new WeightedItemCollection(weightedItems);
        return weightedItemCollection.getRandomItem();
    }

    /**
     * Gets a random support bot class - takes weights into consideration
     * @return - the retrieved class
     */
    public TFClasses getSupportBotClass() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>(Arrays.asList(
            new WeightedItem<>(TFClasses.DEMOMAN, supportBotDistributions.getDemomanPercentage()),
            new WeightedItem<>(TFClasses.HEAVY, supportBotDistributions.getHeavyPercentage()),
            new WeightedItem<>(TFClasses.MEDIC, supportBotDistributions.getMedicPercentage()),
            new WeightedItem<>(TFClasses.PYRO, supportBotDistributions.getPyroPercentage()),
            new WeightedItem<>(TFClasses.SCOUT, supportBotDistributions.getScoutPercentage()),
            new WeightedItem<>(TFClasses.SOLDIER, supportBotDistributions.getSoldierPercentage())
        ));
        WeightedItemCollection<TFClasses> weightedItemCollection = new WeightedItemCollection(weightedItems);

        int sniperPercentage = supportBotDistributions.getSniperPercentage();
        if (weightedItemCollection.getTotalWeight() == 0 && sniperPercentage > 0) {
            weightedItemCollection.add(TFClasses.SNIPER, supportBotDistributions.getSniperPercentage());
            OutputConsole.addMessageOnce("WARNING: No support bots available - using sniper instead");
        }

        return weightedItemCollection.getRandomItem();
    }

    /**
     * Gets a random mission bot class - takes weights into consideration
     * Will not attempt to add an engineer if the map does not support it
     * @return - the retrieved class
     */
    public Objectives getMissionObjective() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>(Arrays.asList(
            new WeightedItem<>(Objectives.SNIPER, supportBotDistributions.getSniperPercentage()),
            new WeightedItem<>(Objectives.SPY, supportBotDistributions.getSpyPercentage())
        ));

        if (MVMRandomizer.currentMap.getCanSpawnEngineers()) {
            weightedItems.add(
                new WeightedItem<>(Objectives.ENGINEER, supportBotDistributions.getEngineerPercentage()));
        }

        WeightedItemCollection<Objectives> weightedItemCollection = new WeightedItemCollection(weightedItems);
        return weightedItemCollection.getRandomItem();
    }

    /**
     * Gets a random mission bot class - takes weights into consideration. Does not include the given objective.
     * Will not attempt to add an engineer if the map does not support it
     * @return - the retrieved class
     */
    public Objectives getMissionObjective(Objectives objectiveToExclude) {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();

        if (!objectiveToExclude.equals(Objectives.SNIPER)) {
            weightedItems.add(new WeightedItem<>(Objectives.SNIPER, supportBotDistributions.getSniperPercentage()));
        }

        if (!objectiveToExclude.equals(Objectives.SPY)) {
            weightedItems.add(new WeightedItem<>(Objectives.SPY, supportBotDistributions.getSpyPercentage()));
        }

        if (!objectiveToExclude.equals(Objectives.SPY) && MVMRandomizer.currentMap.getCanSpawnEngineers()) {
            weightedItems.add(
                new WeightedItem<>(Objectives.ENGINEER, supportBotDistributions.getEngineerPercentage()));
        }

        WeightedItemCollection<Objectives> weightedItemCollection = new WeightedItemCollection(weightedItems);
        return weightedItemCollection.getRandomItem();
    }
}
