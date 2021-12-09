package Pop.Settings;

import Pop.Bot.BotTemplate;
import Pop.Bot.RandomBot;
import Pop.Enums.TFClasses;
import Pop.Range;

/**
 * Settings for each individual bot
 */
public class BotSetting {
    /**
     * The bot's template
     */
    private BotTemplate template;
    public BotTemplate getTemplate() {
        return template;
    }
    public void setTemplate(BotTemplate template) { this.template = template; }

    /**
     * The weight of the bot when being chosen for standard spawning
     * This also affects giants
     */
    private int standardWeight;
    public int getStandardWeight() {
        return standardWeight;
    }
    public void setStandardWeight(int standardWeight) {
        this.standardWeight = standardWeight;
    }

    /**
     * The weight of the bot when being chosen for support spawning
     */
    private int supportWeight;
    public int getSupportWeight() {
        return supportWeight;
    }
    public void setSupportWeight(int supportWeight) { this.supportWeight = supportWeight; }

    /**
     * The range of the amount of bots that can be spawned for this bot for standard spawning
     */
    private Range standardSpawnRange;
    public Range getStandardSpawnRange() {
        return standardSpawnRange;
    }
    public void setStandardSpawnRange(Range standardSpawnRange) {
        this.standardSpawnRange = standardSpawnRange;
    }

    /**
     * The range of the amount of bots that can spawn at once for standard spawning
     */
    private Range standardSpawnNumber;
    public Range getStandardSpawnNumber() {
        return standardSpawnNumber;
    }
    public void setStandardSpawnNumber(Range standardSpawnNumber) {
        this.standardSpawnNumber = standardSpawnNumber;
    }

    /**
     * The range of the amount of support bots that can be spawned
     * Relevant when limited support is on (see Guardian Caster for an example)
     */
    private Range supportSpawnRange;
    public Range getSupportSpawnRange() {
        return supportSpawnRange;
    }
    public void setSupportSpawnRange(Range supportSpawnRange) {
        this.supportSpawnRange = supportSpawnRange;
    }

    /**
     * The range of the amount of support bots that can spawn at once
     */
    private Range supportSpawnNumber;
    public Range getSupportSpawnNumber() {
        return supportSpawnNumber;
    }
    public void setSupportSpawnNumber(Range supportSpawnNumber) {
        this.supportSpawnNumber = supportSpawnNumber;
    }

    /**
     * Whether the bot should be chosen as a standard bot
     */
    private boolean isStandard;
    public boolean getIsStandard() {
        return isStandard;
    }
    public void setIsStandard(boolean standard) {
        isStandard = standard;
    }

    /**
     * Whether the bot should be chosen as a support bot
     * For engies, snipers, and spies, this equates to being a mission bot
     */
    private boolean isSupport;
    public boolean getIsSupport() {
        return isSupport;
    }
    public void setIsSupport(boolean support) {
        isSupport = support;
    }

    /**
     * Default Constructor
     */
    public BotSetting() { }

    /**
     * Full Constructor
     */
    public BotSetting(
            BotTemplate template,
            int standardWeight,
            int supportWeight,
            Range standardSpawnRange,
            Range supportSpawnRange,
            Range standardSpawnNumber,
            Range supportSpawnNumber,
            boolean isStandard,
            boolean isSupport) {
        this.template = template;
        this.standardWeight = standardWeight;
        this.supportWeight = supportWeight;
        this.standardSpawnRange = standardSpawnRange;
        this.supportSpawnRange = supportSpawnRange;
        this.standardSpawnNumber = standardSpawnNumber;
        this.supportSpawnNumber = supportSpawnNumber;
        this.isStandard = isStandard;
        this.isSupport = isSupport;
    }

    /**
     * Gets a bot given its class, template, and size
     * @param tfClass - the class
     * @param template - the template
     * @param isGiantBot - true if giant, false otherwise
     * @return
     */
    public static BotSetting getDefaultBotSetting(TFClasses tfClass, BotTemplate template, boolean isGiantBot) {
        Range spawnRange = isGiantBot ?
            RandomBot.NORMAL_GIANT_SPAWN_RANGE :
            RandomBot.NORMAL_SPAWN_RANGE;

        BotSetting newBotSetting = new BotSetting(
            template,
            100, 100,
            new Range(spawnRange), RandomBot.SUPPORT_SPAWN_RANGE,
            getDefaultStandardSpawnNumber(isGiantBot), getDefaultSupportSpawnNumber(isGiantBot),
            true, !isGiantBot
        );

        if (tfClass.equals(TFClasses.ENGINEER)) {
            newBotSetting.setIsStandard(false); // Engies are NEVER spawned normally - they're glitchy that way
        }

        return newBotSetting;
    }

    /**
     * Gets the default spawn number for non-support bots
     * @param isGiantBot - whether the bot is giant
     * @return - the default spawn number range
     */
    public static Range getDefaultStandardSpawnNumber(boolean isGiantBot) {
        return isGiantBot ? new Range(1, 2): new Range(3, 7);
    }

    /**
     * Gets the default spawn number for support bots
     * @param isGiantBot - whether the bot is giant
     * @return - the default spawn number range
     */
    public static Range getDefaultSupportSpawnNumber(boolean isGiantBot) {
        return isGiantBot ? new Range(1, 1): new Range(2, 2);
    }

    /**
     * Sets the default spawn numbers for standard and support if the values are null or have a range of 0
     * (which would break things!)
     * @param isGiantBot - whether the bot is giant
     * @return - the default spawn number range
     */
    public void setDefaultSpawnNumbersIfNeeded(boolean isGiantBot) {
        if (standardSpawnNumber == null || supportSpawnNumber.sum() == 0) {
            setStandardSpawnNumber(getDefaultStandardSpawnNumber(isGiantBot));
        }

        if (supportSpawnNumber == null || supportSpawnNumber.sum() == 0) {
            setSupportSpawnNumber(getDefaultSupportSpawnNumber(isGiantBot));
        }
    }

    /**
     * Copies the settings over from the given BotSetting
     * @param botSetting - the object to copy settings from
     */
    public void copySettings(BotSetting botSetting) {
        template = botSetting.getTemplate();
        standardWeight = botSetting.getStandardWeight();
        supportWeight = botSetting.getSupportWeight();
        standardSpawnRange = new Range(botSetting.getStandardSpawnRange());
        supportSpawnRange = new Range(botSetting.getSupportSpawnRange());
        standardSpawnNumber = new Range(botSetting.getStandardSpawnNumber());
        supportSpawnNumber = new Range(botSetting.getSupportSpawnNumber());
        isStandard = botSetting.getIsStandard();
        isSupport = botSetting.getIsSupport();
    }
}
