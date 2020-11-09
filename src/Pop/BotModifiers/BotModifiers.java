package Pop.BotModifiers;

import Pop.Bot.RandomBot;
import Pop.PopRandomizer;
import Pop.Range;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a list of all the bot modifiers that can be randomly applied
 */
public class BotModifiers {
    /**
     * All modifiers that make bots stronger
     */
    public static ArrayList<BotModifier> strengtheningModifiers = new ArrayList<>(
        Arrays.asList(
            new BotModifier("Health", ModifierType.PROPERTY, ConversionType.PERCENTAGE, new Range(20, 30)),
            new BotModifier("damage bonus", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(10, 30)),
            new BotModifier("bleeding duration", ModifierType.ITEM, ConversionType.NONE, new Range(2, 5)),
            new BotModifier("set damagetype ignite", ModifierType.ITEM, ConversionType.NONE, new Range(1, 1)),
            new BotModifier("afterburn immunity", ModifierType.ITEM, ConversionType.NONE, new Range(1, 1)),
            new BotModifier("slow enemy on hit", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(20, 50)),
            new BotModifier("critboost on kill", ModifierType.ITEM, ConversionType.NONE, new Range(2, 8)),
            new BotModifier("move speed bonus", ModifierType.CHARACTER, ConversionType.PERCENTAGE, new Range(10, 30)),
            new BotModifier("Scale", ModifierType.PROPERTY, ConversionType.PERCENTAGE, new Range(-10, -30)),
            new BotModifier("head scale", ModifierType.CHARACTER, ConversionType.PERCENTAGE, new Range(-10, -30)),
            new BotModifier("health regen", ModifierType.ITEM, ConversionType.NONE, new Range(1, 3)),
            new BotModifier("damage causes airblast", ModifierType.ITEM, ConversionType.NONE, new Range(1, 1)),
            new BotModifier("minicrit vs burning player", ModifierType.ITEM, ConversionType.NONE, new Range(1, 1)),
            new BotModifier("minicritboost on kill", ModifierType.ITEM, ConversionType.NONE, new Range(5, 10)),
            new BotModifier("speed_boost_on_kill", ModifierType.ITEM, ConversionType.NONE, new Range(3, 3)),
            new BotModifier("speed_boost_on_hit", ModifierType.ITEM, ConversionType.NONE, new Range(3, 3)),
            new BotModifier("health on radius damage", ModifierType.ITEM, ConversionType.NONE, new Range(10, 25)),
            new BotModifier("fire rate bonus", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(-10, -25)),
            new BotModifier("AlwaysCrit", ModifierType.ATTRIBUTE, ConversionType.NONE, new Range(1, 1))
        )
    );

    /**
     * All modifiers that make bots weaker
     */
    public static ArrayList<BotModifier> weakeningModifiers = new ArrayList<>(
        Arrays.asList(
            new BotModifier("Health", ModifierType.PROPERTY, ConversionType.PERCENTAGE, new Range(10, 20)),
            new BotModifier("damage bonus", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(10, 20)),
            new BotModifier("move speed bonus", ModifierType.CHARACTER, ConversionType.PERCENTAGE, new Range(10, 30)),
            new BotModifier("Scale", ModifierType.PROPERTY, ConversionType.PERCENTAGE, new Range(-10, -30)),
            new BotModifier("head scale", ModifierType.CHARACTER, ConversionType.PERCENTAGE, new Range(-10, -30)),
            new BotModifier("dmg penalty vs nonburning", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(10, 30)),
            new BotModifier("damage force increase", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(20, 50)),
            new BotModifier("fire rate penalty", ModifierType.ITEM, ConversionType.PERCENTAGE, new Range(10, 25))
        )
    );

    /**
     * Applies a random set of strengthening modifiers to the bot
     * @param bot - the bot
     * @param numberOfModifiers - the number of modifiers to apply to the bot
     */
    public static void applyStrengtheningModifiers(RandomBot bot, int numberOfModifiers) {
        ArrayList<String> modifiersApplied = new ArrayList<>();

        for (int i = 0; i < numberOfModifiers; i++) {
            BotModifier modifier = PopRandomizer.randomElement(strengtheningModifiers);

            if (!modifiersApplied.contains(modifier.getName())) {
                String modifierValue = modifier.generateStrongerRangeValue();
                applyModifier(bot, modifier, modifierValue);
                modifiersApplied.add(modifier.getName());
            } else {
                i--;
            }
        }
    }

    /**
     * Applies a random set of strengthening modifiers to the bot
     * @param bot - the bot
     * @param numberOfModifiers - the number of modifiers to apply to the bot
     */
    public static void applyWeakeningModifiers(RandomBot bot, int numberOfModifiers) {
        ArrayList<String> modifiersApplied = new ArrayList<>();
        for (int i = 0; i < numberOfModifiers; i++) {
            BotModifier modifier = PopRandomizer.randomElement(weakeningModifiers);

            if (!modifiersApplied.contains(modifier.getName())) {
                String modifierValue = modifier.generateWeakerRangeValue();
                applyModifier(bot, modifier, modifierValue);
                modifiersApplied.add(modifier.getName());
            } else {
                i--;
            }
        }
    }

    /**
     * Applies a modifier to a bot
     * @param bot - the bot
     * @param modifier - the modifier
     * @param modifierValue - the value of the modifier
     */
    private static void applyModifier(RandomBot bot, BotModifier modifier, String modifierValue) {
        String modifierName = modifier.getName();
        switch(modifier.type) {
            case PROPERTY:
                applyModifierToProperty(bot, modifierName, modifierValue);
                break;
            case ATTRIBUTE:
                bot.addAttribute(modifierName);
                break;
            case ITEM:
                String mainWeaponName = bot.getMainWeaponName();
                bot.addToItemAttributeSet(mainWeaponName, modifierName, modifierValue);
                break;
            case CHARACTER:
                // Giant bot speeds shouldn't be set the same as standard, for balance purposes
                if (modifierName.equals("move speed bonus") && bot.getIsGiant())
                {
                    double modifierNumber = Double.parseDouble(modifierValue);
                    double amountToAdjust = (modifierNumber - 1) / 2;
                    modifierValue = (0.6 + amountToAdjust) + "";
                }

                bot.addCharacterAttribute(modifierName, modifierValue);
                break;
            default:
                System.out.println("WARNING: attempted to apply a modifier to an unknown modifier type...");
        }
    }

    /**
     * Applies a modifier to the given property
     * @param bot - the bot
     * @param property - the property to apply the modifier to
     * @param modifierValue - the value of the modifier
     */
    private static void applyModifierToProperty(RandomBot bot, String property, String modifierValue) {
        if (property.equals("Scale")) {
            bot.setScale(Double.parseDouble(modifierValue));
        } else if (property.equals("Health")) {
            int baseHealthValue = bot.getHealth();
            if (baseHealthValue == 0) {
                baseHealthValue = bot.getBaseHealth();
            }

            double newHealthValue = Double.parseDouble(modifierValue) * baseHealthValue;
            bot.setHealth((int)newHealthValue);
        } else {
            System.out.println("WARNING: Tried to apply non-existent property of " + property);
        }
    }
}
