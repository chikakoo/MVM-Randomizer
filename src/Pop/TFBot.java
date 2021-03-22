package Pop;

import Pop.Bot.*;
import Pop.Enums.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a TF2 bot
 */
public class TFBot extends PopObjectRepresentation {
    /**
     * The class of the bot
     */
    protected TFClasses tfClass = TFClasses.SCOUT;
    public TFClasses getTFClass() { return tfClass; }
    public void setTFClass(TFClasses tfClass) {
        this.tfClass = tfClass;
        this.botName = tfClass.getDisplayString();
    }

    /**
     * The health of the bot
     */
    protected int health = 0;
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    /**
     * The skill level of the bot
     */
    protected SkillLevels skillLevel = SkillLevels.EASY;
    public void setSkillLevel(SkillLevels skillLevel) { this.skillLevel = skillLevel; }

    /**
     * Whether this bot is a mission bot
     * Note that this isn't actually used to set any mission data - that's all in the Mission class; this is used when
     * determining certain bot attributes (see RandomSniper for an example)
     */
    protected boolean isMissionBot = false;

    /**
     * Whether this bot is a support bot
     * Note that this isn't currently used for anything other than setting the class icons appropriately
     * The actual attribute that determines whether a bot is support is on the WaveSpawn object
     */
    protected boolean isSupportBot = false;

    /**
     * Whether we should override the template skill level
     */
    protected boolean templateOverrideSkillLevel = false;

    /**
     * The name of the icon of this bot
     */
    protected String classIcon;

    /**
     * Get the class icon string for use in a pop file
     * - Returns the empty string if there's no icon set
     * - Returns it in all lowercase if it's not a mission or a support bot
     * - Returns it in all caps if it's a mission or support bot
     * - In either case, switches the case of the first character if the bot always crits (to separate the crit bots)
     * @return - The class icon string
     */
    private String getClassIconForPopFile() {
        if (classIcon.trim().equals("")) {
            return "";
        }

        String classIconForPopFile = classIcon.toLowerCase();

        if (isMissionBot || isSupportBot) {
            classIconForPopFile = classIcon.toUpperCase();
        }

        if (hasAttribute("AlwaysCrit")) {
            Character firstChar = classIconForPopFile.charAt(0);
            if (Character.isUpperCase(firstChar)) {
                classIconForPopFile = classIconForPopFile.substring(0, 1).toLowerCase() + classIconForPopFile.substring(1);
            } else {
                classIconForPopFile = classIconForPopFile.substring(0, 1).toUpperCase() + classIconForPopFile.substring(1);
            }
        }

        return classIconForPopFile;
    }

    /**
     * The bot's scale
     */
    protected double scale = 1.0;
    public double getScale() { return scale; }
    public void setScale(double scale) { this.scale = scale; }

    /**
     * Any weapon restrictions on the bot
     */
    protected WeaponRestrictions weaponRestrictions = WeaponRestrictions.NONE;

    /**
     * Attributes to include on the bot
     */
    protected ArrayList<String> attributes = new ArrayList<>();
    public void addAttribute(String attributeToAdd)
    {
        attributes.add(attributeToAdd);
    }
    public boolean hasAttribute(String attribute) {
        return attributes.contains(attribute);
    }

    /**
     * Behavior modifiers to include on the bot
     */
    protected ArrayList<String> behaviorModifiers = new ArrayList<>();
    public void addBehaviorModifier(String modifierToAdd)
    {
        behaviorModifiers.add(modifierToAdd);
    }

    protected ArrayList<ModifierAttribute> characterAttributes = new ArrayList<>();
    public void addCharacterAttribute(String attribute, String value)
    {
        for (ModifierAttribute modifierAttribute : characterAttributes)
        {
            if (modifierAttribute.getAttribute().equals("\"" + attribute + "\"")) {
                modifierAttribute.setValue(value);
                return;
            }
        }

        characterAttributes.add(new ModifierAttribute(attribute, value));
    }

    protected ArrayList<ItemAttributes> itemAttributeSets = new ArrayList<>();

    /**
     * Add an an entry to the item attribute set - this will overwrite any existing entries
     * @param itemName The item name
     * @param attribute The attribute to add
     * @param value The value of the attribute
     */
    public void addToItemAttributeSet(String itemName, String attribute, String value) {
        ItemAttributes itemAttributeSet = getAndAddItemAttributeSetForItem(itemName);
        ModifierAttribute foundAttribute = itemAttributeSet.getAttribute(attribute);
        if (foundAttribute != null) {
            foundAttribute.setValue(value);
        } else {
            itemAttributeSet.add(attribute, value);
        }
    }

    /**
     * Gets the item attribute set for the given item - add it if it doesn't exist
     * @param itemName The item
     * @return The item attribute set
     */
    private ItemAttributes getAndAddItemAttributeSetForItem(String itemName) {
        ItemAttributes itemAttributeSetForThisItem = null;
        for (ItemAttributes itemAttributeSet : itemAttributeSets) {
            if (itemAttributeSet.getItemName().equals("\"" + itemName + "\"")) {
                itemAttributeSetForThisItem = itemAttributeSet;
            }
        }

        if (itemAttributeSetForThisItem == null) {
            itemAttributeSetForThisItem = new ItemAttributes(itemName);
            itemAttributeSets.add(itemAttributeSetForThisItem);
        }
        return itemAttributeSetForThisItem;
    }

    /**
     * Items to include on the bot
     */
    protected ArrayList<String> items = new ArrayList<>();

    /**
     * The name of the bot - will default to the class name
     */
    protected String botName = tfClass.getDisplayString();

    /**
     * The bot template - if this is not set to NONE, nothing else is written to the pop file
     */
    protected BotTemplate template;
    public BotTemplate getBotTemplate() { return template; }
    public void setBotTemplate(BotTemplate template) { this.template = template; }

    /**
     * Whether the bot will run toward gates and ignore the bomb - used with Mannhattan
     */
    public boolean isGateBot;

    /**
     * Any tags to add to the bot
     */
    public ArrayList<String> tags = new ArrayList<>();

    /**
     * Whether the bot is considered a giant
     */
    protected boolean isGiant;
    public boolean getIsGiant() { return isGiant; }

    /**
     * Constructor
     */
    public TFBot() { this.name = "TFBot"; }

    /**
     * Constructor
     * @param template - the template to assign the bot
     */
    public TFBot(BotTemplate template) {
        this.name = "TFBot";
        this.template = template;
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        PopObject popObject = new PopObject(name);
        handleHighlanderMode();

        if (isGateBot) {
            MVMRandomizer.currentMap.addGateBotAttributes(this);
        }

        if (MVMRandomizer.currentMap.usesGateBots()) {
            MVMRandomizer.currentMap.adjustGateBotMapAttributes(this);
        }

        if (template == null) {
            if (health > 0) {
                popObject.addAttribute("Health", Integer.toString(health));
            }

            popObject.addAttribute("Class", tfClass.getDisplayString());
            popObject.addAttribute("Name", "\"" + botName + "\"");
            popObject.addAttribute("Skill", skillLevel.toString());
        } else {
            popObject.addAttribute("Template", template.getTemplateName());

            if (templateOverrideSkillLevel) {
                popObject.addAttribute("Skill", skillLevel.toString());
            }
        }

        if (classIcon != null && !classIcon.equals("")) {
            popObject.addAttribute("ClassIcon", getClassIconForPopFile());
        }

        if (scale != 1) {
            popObject.addAttribute("Scale", Double.toString(scale));
        }

        if (!weaponRestrictions.equals(WeaponRestrictions.NONE)) {
            popObject.addAttribute("WeaponRestrictions", weaponRestrictions.toString());
        }

        for (String attribute : attributes) {
            popObject.addAttribute("Attributes", attribute);
        }

        for (String modifier : behaviorModifiers) {
            popObject.addAttribute("BehaviorModifiers", modifier);
        }

        for (String item : items) {
            popObject.addAttribute("Item", "\"" + item + "\"");
        }

        for (String tag : tags) {
            popObject.addAttribute("Tag", tag);
        }

        for (ItemAttributes item : itemAttributeSets) {
            popObject.addObject(item.getPopObject());
        }

        if (characterAttributes.size() > 0) {
            PopObject characterAttributesPopObject = new PopObject("CharacterAttributes");
            for (ModifierAttribute characterAttribute : characterAttributes) {
                characterAttributesPopObject.addAttribute(
                        characterAttribute.getAttribute(),
                        characterAttribute.getValue());
            }
            popObject.addObject(characterAttributesPopObject);
        }

        return popObject;
    }

    /**
     * Sets up the bot in the case that highlander mode is turned on
     */
    private void handleHighlanderMode() {
        if (!MVMRandomizer.botSettings.isHighlanderMode()) {
            return;
        }

        if (template != null && template.getTemplateName().equals("T_TFBot_SentryBuster")) {
            return;
        }

        if (isUsingHuntsman()) {
            weaponRestrictions = WeaponRestrictions.PRIMARY_ONLY;
        } else {
            weaponRestrictions = WeaponRestrictions.MELEE_ONLY;
        }

        if (this instanceof RandomBot) {
            // Rename the bot in case they are named after a different weapon
            ((RandomBot)this).setRandomBotName();
        }
    }

    /**
     * Returns whether the bot is using any of the bow weapons
     * @return
     */
    private boolean isUsingHuntsman() {
        ArrayList<String> huntsmanBots = new ArrayList<>(Arrays.asList(
            "T_TFBot_Sniper_Candy_Cane",
            "T_TFBot_Sniper_Lionel",
            "T_TFBot_Sniper_Michelle"
        ));

        if (template != null &&
            (
                huntsmanBots.contains(template.getTemplateName()) ||
                template.getTemplateName().toLowerCase().contains("huntsman")
            )
        ) {
            return true;
        }

        if (!tfClass.equals(TFClasses.SNIPER)) {
            return false;
        }

        ArrayList<String> bowList = new ArrayList<>(Arrays.asList(
            "The Huntsman",
            "Festive Huntsman",
            "The Fortified Compound"
        ));

        for (String item : items) {
            if (bowList.contains(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a random representation of this object
     * @param waveNumber - the wave number
     * @param canGenerateGiants - whether to attempt to generate giant bots
     * @param includeSpies - whether this bot could be spy
     * @return the generated bot
     */
    public static RandomBot generateRandom(int waveNumber, boolean canGenerateGiants, boolean includeSpies) {
        boolean generateGiant = canGenerateGiants && MVMRandomizer.waveSettings.shouldGenerateGiantBot(waveNumber);
        return RandomBot.generateBot(generateGiant, includeSpies);
    }

    /**
     * Generates a random representation of this object
     * @return the generated bot
     */
    public static RandomBot generateRandomSupport() {
        RandomBot randomBot = RandomBot.getBotFromEnum(MVMRandomizer.botSettings.getSupportBotClass());
        if (randomBot == null) {
            return null;
        }

        randomBot.generateSupportBot();
        return randomBot;
    }
}
