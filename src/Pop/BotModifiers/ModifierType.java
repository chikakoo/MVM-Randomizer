package Pop.BotModifiers;

/**
 * Bot modifier types
 */
public enum ModifierType {
    /**
     * This modifier is a direct property on TFBot
     */
    PROPERTY,

    /**
     * This modifier is for an Attribute on the TFBot
     */
    ATTRIBUTE,

    /**
     * This modifier is for the CharacterAttributes object on the TFBot
     */
    CHARACTER,

    /**
     * This modifier is for the ItemAttributes object on the TFBot
     */
    ITEM
}
