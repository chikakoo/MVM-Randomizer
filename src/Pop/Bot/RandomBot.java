package Pop.Bot;

import Pop.*;
import Pop.Bot.Cosmetics.AllClassCosmeticLists;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.PassiveItem;
import Pop.Bot.Weapons.Weapon;
import Pop.BotModifiers.BotModifiers;
import Pop.Enums.*;
import Pop.Settings.BotSetting;

import java.util.ArrayList;

/**
 * A class containing methods for generating random bots
 */
public abstract class RandomBot extends TFBot {
    /**
     * Difficulty ranges - this is how many bots to spawn based on a given difficulty
     */
    final public static Range EASY_SPAWN_RANGE = new Range(20, 35);
    final public static Range NORMAL_SPAWN_RANGE = new Range(12, 20);
    final public static Range HARD_SPAWN_RANGE = new Range(5, 10);
    final public static Range IMPOSSIBLE_SPAWN_RANGE = new Range(4, 8);

    final public static Range EASY_GIANT_SPAWN_RANGE = new Range(4, 6);
    final public static Range NORMAL_GIANT_SPAWN_RANGE = new Range(2, 3);
    final public static Range HARD_GIANT_SPAWN_RANGE = new Range(1, 2);
    final public static Range IMPOSSIBLE_GIANT_SPAWN_RANGE = new Range(1, 1);

    final public static Range SUPPORT_SPAWN_RANGE = new Range(2, 5);

    protected Range spawnRange;
    public Range getSpawnRange() {
        double rangeMultiplier = MVMRandomizer.mapSettings.getSpawnMultiplier();
        return new Range(
            Math.max((int)(spawnRange.getLowerBound() * rangeMultiplier), 1),
            Math.max((int)(spawnRange.getUpperBound() * rangeMultiplier), 1)
        );
    }
    public int getMissionSpawnCount() {
        return PopRandomizer.generateNumberInRange(spawnRange);
    }
    public void setSpawnRange(Range spawnRange) { this.spawnRange = spawnRange; }

    /**
     * All lists of weapons for the bot
     */
    protected ArrayList<Weapon> primaryWeaponList;
    protected ArrayList<Weapon> secondaryWeaponList;
    protected ArrayList<Weapon> meleeWeaponList;

    /**
     * Weapons that are equipped
     */
    protected Weapon primaryWeapon;
    protected Weapon secondaryWeapon;
    protected Weapon meleeWeapon;

    /**
     * Class-specific cosmetic list
     */
    protected ArrayList<Cosmetic> classOnlyCosmetics = new ArrayList<>();
    private Cosmetic cosmetic;

    /**
     * The base health of this bot
     */
    protected int baseHealth = 125;
    public int getBaseHealth() { return baseHealth; }


    /**
     * Default constructor
     */
    public RandomBot() { }

    /**
     * Constructor
     */
    public RandomBot(TFClasses tfClass) {
        this.tfClass = tfClass;
    }

    /**
     * Generates a bot
     * @param generateGiant - whether the bot should be a giant
     * @param includeSpies - whether this bot could be spy
     * @return the generated bot
     */
    public static RandomBot generateBot(boolean generateGiant, boolean includeSpies) {
        RandomBot bot;
        if (generateGiant) {
            bot = RandomBot.getBotFromEnum(MVMRandomizer.botSettings.getGiantBotClass(includeSpies));
            bot.generateGiantBot();
        } else {
            bot = RandomBot.getBotFromEnum(MVMRandomizer.botSettings.getStandardBotClass(includeSpies));
            bot.generateStandardBot();
        }

        return bot;
    }

    /**
     * Factory for random bots
     * @param tfClass - the class to generate
     * @return the generated bot
     */
    public static RandomBot getBotFromEnum(TFClasses tfClass) {
        if (tfClass == null) {
            return null;
        }

        switch(tfClass) {
            case DEMOMAN:
                return new RandomDemoman();
            case ENGINEER:
                return new RandomEngineer();
            case HEAVY:
                return new RandomHeavy();
            case MEDIC:
                return new RandomMedic();
            case PYRO:
                return new RandomPyro();
            case SCOUT:
                return new RandomScout();
            case SNIPER:
                return new RandomSniper();
            case SOLDIER:
                return new RandomSoldier();
            case SPY:
                return new RandomSpy();
            default:
                // should not happen
                return new RandomScout();
        }
    }

    /**
     * Gets a bot with the sentry buster template
     * @return the sentry buster
     */
    public static RandomBot getSentryBusterBot() {
        RandomBot randomBot = new RandomDemoman(); // which one doesn't actually matter
        randomBot.setBotTemplate(BotTemplate.getSentryBusterTemplate());
        return randomBot;
    }

    /**
     * Generates a random support bot - these cover mission bots (snipers, spies, engies)
     * @return the random bot
     */
    public void generateSupportBot() {
        isSupportBot = true;

        boolean generateCustomBot = PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.botSettings.getPercentRandom());
        if (generateCustomBot) {
            generateCustomBot();
            spawnRange = isGiant ? new Range(1, 1) : new Range(2, 5);
        } else {
            BotSetting botSetting = MVMRandomizer.botSettings.getRandomSupportBotSetting(tfClass);
            template = botSetting.getTemplate();
            classIcon = template.getClassIcon();
            spawnRange = botSetting.getSupportSpawnRange();
            adjustWeaponAttributesForTemplatedBots();
            addRandomProjectileModelForTemplatedBot();
        }

        if (!isMissionBot) {
            isGateBot = true;
        }
    }

    /**
     * Generates a random bot that isn't based on a template
     * @return the random bot
     */
    public void generateStandardBot() {
        boolean generateCustomStandardBot =
            PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.botSettings.getPercentRandom());
        if (generateCustomStandardBot) {
            generateCustomBot();
        } else {
            generateTemplatedBot();
        }

        //TODO: get rid of me... this is just for heavy/spy combo..... also put this on generateGiantBot
//        if (tfClass.equals(TFClasses.HEAVY)) {
//            health = 1;
//            spawnRange = new Range(1, 1);
//        }
    }

    /**
     * Generates a random bot that isn't based on a template
     * @return the random bot
     */
    private void generateCustomBot()
    {
        skillLevel = RandomizerPresets.getRandomSkillLevel();

        switch (skillLevel) {
            case EASY:
            case NORMAL:
                spawnRange = RandomBot.NORMAL_SPAWN_RANGE;
                break;
            case HARD:
            case EXPERT:
            default:
                spawnRange = RandomBot.HARD_SPAWN_RANGE;
        }

        classIcon = "random_" + tfClass.getDisplayString().toLowerCase();
        generateRandomWeapons();
        generateRandomCosmetic();
        setRandomBotName();

        int difficulty = generateRandomModifiers();
        adjustSpawnCountForStandardBot(difficulty);

        adjustAttributesForCustomBots();
    }

    /**
     * Generates a random giant bot that isn't based on a template
     * @return the random bot
     */
    private void generateCustomGiantBot() {
        isGiant = true;
        health = PopRandomizer.generateNumberInRange(2000, 4000);
        skillLevel = SkillLevels.EXPERT;

        if (health > 3000) {
            spawnRange = RandomBot.HARD_GIANT_SPAWN_RANGE;
        } else {
            spawnRange = RandomBot.NORMAL_GIANT_SPAWN_RANGE;
        }

        classIcon = "random_giant_" + tfClass.getDisplayString().toLowerCase();
        generateRandomWeapons();
        generateRandomCosmetic();
        setRandomBotName();

        attributes.add("MiniBoss");

        if (tfClass.equals(TFClasses.SCOUT)) {
            health -= 1000;

            boolean isFastScout = PopRandomizer.generateBoolean();
            if (isFastScout) {
                if (health > 2500) { health -= 1000; }
                double speedBonus = (double)PopRandomizer.generateNumberInRange(10, 20) / 10.0;
                characterAttributes.add(new ModifierAttribute("move speed bonus", Double.toString(speedBonus)));
            }
        } else {
            characterAttributes.add(new ModifierAttribute("move speed bonus", "0.6"));
        }

        characterAttributes.add(new ModifierAttribute("damage force reduction", "0.6"));
        characterAttributes.add(new ModifierAttribute("airblast vulnerability multiplier", "0.6"));
        characterAttributes.add(new ModifierAttribute("override footstep sound set", "6"));

        int difficulty = generateRandomModifiers();
        adjustSpawnCountForGiantBot(difficulty);

        adjustAttributesForCustomBots();
    }

    /**
     * Generates random weapons and weapon restrictions for the bot
     * Note that the Spy call overrides this method to eliminate crashes for sappers being added
     */
    protected void generateRandomWeapons() {
        weaponRestrictions = RandomizerPresets.getWeaponRestrictionForRandomBot();

        primaryWeapon = Weapon.getRandomWeapon(primaryWeaponList);
        secondaryWeapon = Weapon.getRandomWeapon(secondaryWeaponList);
        meleeWeapon = Weapon.getRandomWeapon(meleeWeaponList);

        addWeapon(primaryWeapon);
        addWeapon(secondaryWeapon);
        addWeapon(meleeWeapon);

        if (getMainWeaponBasedOnRestrictions() instanceof PassiveItem) {
            weaponRestrictions = WeaponRestrictions.NONE;
        }

        adjustWeaponAttributesForCustomBots();
        fixClassNameDueToRandomProjectileType();
    }

    /**
     * Adds the weapon to the bot
     * @param weapon The weapon to add
     */
    protected void addWeapon(Weapon weapon) {
        items.add(weapon.getItemName());
        itemAttributeSets.add(weapon.getItemAttributes());
    }

    /**
     * Generates a random hat for the bot - includes unusuals and paints
     */
    private void generateRandomCosmetic() {
        boolean shouldGenerateCosmetic =
            PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentCosmetic());
        if (!shouldGenerateCosmetic) { return; }

        cosmetic = getRandomCosmetic();
        items.add(cosmetic.getItemName());

        setCosmeticAttributes();
    }

    /**
     * Returns a random cosmetic for the class
     * Currently hard-coded 20% of it being all-class, and 80% of it being class-specific
     * @return
     */
    private Cosmetic getRandomCosmetic() {
        if (PopRandomizer.generateBooleanFromPercentage(20)) {
            return PopRandomizer.randomElement(AllClassCosmeticLists.cosmetics);
        }

        return PopRandomizer.randomElement(classOnlyCosmetics);
    }

    /**
     * Paints and sets unusual effects on the current cosmetic
     */
    private void setCosmeticAttributes() {
        if (cosmetic == null) { return; }

        ItemAttributes cosmeticAttributes = new ItemAttributes(cosmetic.getItemName());

        boolean isPainted = PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentPaint());
        if (isPainted) {
            int randomColor = PopRandomizer.generateRandomValue(0xFFFFFF);
            cosmeticAttributes.add("set item tint RGB", Integer.toString(randomColor));
        }

        boolean hasUnusualEffect = PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentUnusualEffect());
        if (hasUnusualEffect) {
            int unusualEffect = PopRandomizer.generateNumberInRange(1, 110); // The range of the unusual particle effects in TF2
            cosmeticAttributes.add("attach particle effect", Integer.toString(unusualEffect));
        }

        if (isPainted || hasUnusualEffect) {
            itemAttributeSets.add(cosmeticAttributes);
        }
    }

    /**
     * Generates random attributes for the bot
     * @return The base difficulty of the bot - this is used to set the spawn range values later
     */
    private int generateRandomModifiers() {
        int baseDifficulty = -1;

        boolean generateModifiers =
            PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentAttributes());
        if (generateModifiers) {
            switch(skillLevel) {
                case EASY:
                    baseDifficulty = 0;
                    break;
                case NORMAL:
                    baseDifficulty = 1;
                    break;
                case HARD:
                    baseDifficulty = 2;
                    break;
                case EXPERT:
                    baseDifficulty = 3;
                    break;
            }

            int maxAttributes = MVMRandomizer.randomBotSettings.getMaxAttributes();
            int numberOfModifiers = PopRandomizer.generateNumberInRange(1, maxAttributes);
            int numberOfStrengtheningModifiers = PopRandomizer.generateNumberInRange(0, numberOfModifiers);
            int numberOfWeakeningModifiers = numberOfModifiers - numberOfStrengtheningModifiers;

            // Adjust the difficulty based on the modifiers
            baseDifficulty += numberOfStrengtheningModifiers - numberOfWeakeningModifiers;

            BotModifiers.applyStrengtheningModifiers(this, numberOfStrengtheningModifiers);
            BotModifiers.applyWeakeningModifiers(this, numberOfWeakeningModifiers);
        }

        return baseDifficulty;
    }

    /**
     * Adjusts the spawn count for standard bots based on their difficulty
     * @param baseDifficulty The base difficulty
     */
    private void adjustSpawnCountForStandardBot(int baseDifficulty) {
        if (baseDifficulty == -1) {
            return;
        } else if (baseDifficulty == 0) {
            setSpawnRange(NORMAL_SPAWN_RANGE); // Easy range is too ridiculous
        } else if (baseDifficulty == 1) {
            setSpawnRange(NORMAL_SPAWN_RANGE);
        } else if (baseDifficulty == 2 || baseDifficulty == 3) {
            setSpawnRange(HARD_SPAWN_RANGE);
        } else if (baseDifficulty > 3) {
            setSpawnRange(IMPOSSIBLE_SPAWN_RANGE);
        }
    }

    /**
     * Adjusts the spawn count for giant bots based on their difficulty
     * @param baseDifficulty The base difficulty
     */
    private void adjustSpawnCountForGiantBot(int baseDifficulty) {
        boolean isHardOrExpert = skillLevel.equals(SkillLevels.HARD) || skillLevel.equals(SkillLevels.EXPERT);

        if (baseDifficulty == -1) {
            return;
        } else if (isHardOrExpert && baseDifficulty > 1) {
            setSpawnRange(IMPOSSIBLE_GIANT_SPAWN_RANGE);
        } else if (baseDifficulty == 1) {
            setSpawnRange(NORMAL_GIANT_SPAWN_RANGE);
        } else {
            setSpawnRange(EASY_GIANT_SPAWN_RANGE);
        }
    }

    /**
     * Sets a bot to a name based on their weapon or cosmetic
     * Set to a 50% chance to base the name off their main weapon or cosmetic
     * Prefixes "Giant" if the bot is a giant
     */
    public void setRandomBotName() {
        botName = isGiant ? "Giant " : "";

        if (cosmetic == null || PopRandomizer.generateBoolean()) {
            botName += getMainWeaponNameForBotName() + " " + tfClass.getDisplayString();
        } else {
            botName += cosmetic.getDisplayName() + " " + tfClass.getDisplayString();
        }
    }

    /**
     * Gets the main weapon that the class was assigned - but only for the bot name purposes
     * This eliminates the checks on whether the weapon is actually a weapon the bot will have out most of the time
     * @return The weapon
     */
    private String getMainWeaponNameForBotName() {
        return getMainWeaponBasedOnRestrictions().getDisplayName();
    }

    /**
     * Gets the main weapon that the class was assigned based ONLY on the weapon restrictions
     * @return The weapon
     */
    private Weapon getMainWeaponBasedOnRestrictions() {
        switch(weaponRestrictions) {
            case SECONDARY_ONLY:
                return secondaryWeapon;
            case MELEE_ONLY:
                return meleeWeapon;
            default:
                return primaryWeapon;
        }
    }

    /**
     * Gets the main weapon that the class will use
     * @return The weapon
     */
    protected Weapon getMainWeapon() {
        boolean isPrimaryAWeapon = !(primaryWeapon instanceof PassiveItem);
        boolean isSecondaryAWeapon = !(secondaryWeapon instanceof PassiveItem);

        switch(weaponRestrictions) {
            case SECONDARY_ONLY:
                if (isSecondaryAWeapon) {
                    return secondaryWeapon;
                } else if (isPrimaryAWeapon) {
                    return primaryWeapon;
                } else {
                    return meleeWeapon;
                }
            case MELEE_ONLY:
                return meleeWeapon;
            default:
                if (isPrimaryAWeapon) {
                    return primaryWeapon;
                } else if (isSecondaryAWeapon) {
                    return secondaryWeapon;
                } else {
                    return meleeWeapon;
                }
        }
    }

    /**
     * Gets the name of the weapon that the bot will be using the most
     * @return Gets the main weapon name of the bot
     */
    public String getMainWeaponName() {
        return getMainWeapon().getItemName();
    }

    /**
     * Generates a random bot that is based on a template
     * @return the random bot
     */
    private void generateTemplatedBot() {
        BotSetting botSetting = MVMRandomizer.botSettings.getRandomBotSetting(tfClass);
        template = botSetting.getTemplate();
        classIcon = template.getClassIcon();
        spawnRange = botSetting.getStandardSpawnRange();
        adjustWeaponAttributesForTemplatedBots();
        addRandomProjectileModelForTemplatedBot();
    }

    /**
     * Generates a random bot that isn't based on a template
     * @return the random bot
     */
    private void generateGiantBot() {
        isGiant = true;

        boolean generateCustomGiantBot =
            PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.botSettings.getPercentRandom());
        if (generateCustomGiantBot) {
            generateCustomGiantBot();
        } else {
            generateTemplatedGiantBot();
        }
    }

    /**
     * Generates a random giant bot that is based on a template
     * @return the random bot
     */
    private void generateTemplatedGiantBot() {
        BotSetting botSetting = MVMRandomizer.botSettings.getRandomGiantBotSetting(tfClass);
        template = botSetting.getTemplate();
        classIcon = template.getClassIcon();
        spawnRange = botSetting.getStandardSpawnRange();
        adjustWeaponAttributesForTemplatedBots();
        addRandomProjectileModelForTemplatedBot();
    }

    /**
     * Adjust any attributes on the templated bot's randomized weapons
     */
    protected void adjustWeaponAttributesForTemplatedBots() {
        return;
    }

    /**
     * Adjust any attributes on the custom bot's randomized weapons
     */
    protected void adjustWeaponAttributesForCustomBots() {
        return;
    }

    /**
     * Adjusts any attributes for the bot
     */
    protected void adjustAttributesForCustomBots() { return; }

    /**
     * Adjust the class name of the bot if their weapon's projectile type was changed
     * This is skipped if we're in highlander mode because the main weapon is always melee
     */
    protected void fixClassNameDueToRandomProjectileType() {
        if (MVMRandomizer.botSettings.isHighlanderMode()) {
            return;
        }

        Weapon mainWeapon = getMainWeapon();
        if (mainWeapon.hasOverriddenProjectileType()) {
            String giantString = isGiant ? "giant_" : "";
            classIcon = giantString + "projectile_" + mainWeapon.getOverriddenProjectileType().getDamageTypeString();
        }
    }

    /**
     * Adds a custom projectile for templated bots - the actual functions are defined in the appropriate child classes
     */
    protected void addRandomProjectileModelForTemplatedBot() { }

    /**
     * Used by template bots - adds a random projectile model for the bot's given item
     * @param weaponName - The weapon name
     */
    protected void addRandomProjectileModelForTemplatedBot(String weaponName) {
        String randomModel = WeaponModels.getRandomModel();
        addToItemAttributeSet(weaponName, "custom projectile model", "\"" + randomModel + "\"");

        if (WeaponModels.weaponsThatTurnToGold.contains(randomModel)) {
            addToItemAttributeSet(weaponName, "turn to gold", "1");
        }
    }
}