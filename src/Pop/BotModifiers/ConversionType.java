package Pop.BotModifiers;

/**
 * How a BotModifier's value should be converted
 */
public enum ConversionType {
    /**
     * Don't change the value at all
     */
    NONE,

    /**
     * This value is a percentage - apply it appropriately
     */
    PERCENTAGE
}
