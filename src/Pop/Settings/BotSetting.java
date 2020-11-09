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
     * This also affects giants
     */
    private Range standardSpawnRange;
    public Range getStandardSpawnRange() {
        return standardSpawnRange;
    }
    public void setStandardSpawnRange(Range standardSpawnRange) {
        this.standardSpawnRange = standardSpawnRange;
    }

    /**
     * The range of the amount of bots that can be spawned for this bot for support spawning
     */
    private Range supportSpawnRange;
    public Range getSupportSpawnRange() {
        return supportSpawnRange;
    }
    public void setSupportSpawnRange(Range supportSpawnRange) {
        this.supportSpawnRange = supportSpawnRange;
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
            boolean isStandard,
            boolean isSupport) {
        this.template = template;
        this.standardWeight = standardWeight;
        this.supportWeight = supportWeight;
        this.standardSpawnRange = standardSpawnRange;
        this.supportSpawnRange = supportSpawnRange;
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
            true, !isGiantBot
        );

        if (tfClass.equals(TFClasses.ENGINEER)) {
            newBotSetting.setIsStandard(false); // Engies are NEVER spawned normally - they're glitchy that way
        }

        return newBotSetting;
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
        isStandard = botSetting.getIsStandard();
        isSupport = botSetting.getIsSupport();
    }
}
