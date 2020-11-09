package Pop.Enums;

import Pop.PopRandomizer;

/**
 * The possible weapon restriction values
 */
public enum WeaponRestrictions implements RandomizableEnum {
    /**
     * No value
     */
    NONE(""),

    /**
     * Bots are restricted to their melee weapons
     */
    MELEE_ONLY("MeleeOnly"),

    /**
     * Bots are restricted to their primary weapons
     */
    PRIMARY_ONLY("PrimaryOnly"),

    /**
     * Bots are restricted to their secondary weapons
     */
    SECONDARY_ONLY("SecondaryOnly");

    /**
     * The attribute for weapon restriction value
     */
    private final String weaponRestriction;

    /**
     * Constructor
     *
     * @param weaponRestriction - the value to set the enum to
     */
    WeaponRestrictions(String weaponRestriction) {
        this.weaponRestriction = weaponRestriction;
    }

    /**
     * Generates a random value for this enum
     * @return the generated value
     */
    public static WeaponRestrictions GenerateRandomValue() {
        int index = PopRandomizer.generateRandomValue(values().length);
        return values()[index];
    }

    /**
     * The toString method
     *
     * @return the value the enum should display
     */
    public String toString() {
        return weaponRestriction;
    }
}
