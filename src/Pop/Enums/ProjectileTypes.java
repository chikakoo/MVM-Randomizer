package Pop.Enums;

import Pop.GUI.OutputConsole;
import Pop.PopRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A list of projectile types
 */
public enum ProjectileTypes {
    BULLET(1),
    ROCKET(2),
    SYRINGE(5),
    FLARE(6),
    ARROW(8),
    CROSSBOW_SYRINGE(11),
    COW_MANGLER(12),
    BISON(13),
    CANNONBALL(17),
    RESCUE_RANGER(18),
    FESTIVE_ARROW(19),
    FESTIVE_CROSSBOW_SYRINGE(23);

    /**
     * The value of the enum
     */
    private final int value;
    public int getValue() { return value; }

    /**
     * Constructor
     * @param value - the value to set the enum to
     */
    ProjectileTypes(int value) {
        this.value = value;
    }

    /**
     * Gets a random projectile type that works with hitscan weapons
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomHitscanWeaponProjectile() {
        ArrayList<ProjectileTypes> hitscanProjectiles = new ArrayList<>(Arrays.asList(
            BULLET,
            ROCKET,
            SYRINGE,
            FLARE,
            BISON
        ));

        return PopRandomizer.randomElement(hitscanProjectiles);
    }

    /**
     * Gets a random projectile type that works with non-hitscan weapons
     * Excludes huntsman
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomNonHitscanWeaponProjectile() {
        ArrayList<ProjectileTypes> nonHitscanProjectiles = new ArrayList<>(Arrays.asList(
            BULLET,
            ROCKET,
            SYRINGE,
            FLARE,
            ARROW,
            CROSSBOW_SYRINGE,
            COW_MANGLER,
            BISON,
            CANNONBALL,
            RESCUE_RANGER,
            FESTIVE_ARROW,
            FESTIVE_CROSSBOW_SYRINGE
        ));

        return PopRandomizer.randomElement(nonHitscanProjectiles);
    }

    /**
     * Gets a random projectile type that works with huntsman weapons
     * Excludes huntsman
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomHuntsmanProjectile() {
        ArrayList<ProjectileTypes> huntsmanProjectiles = new ArrayList<>(Arrays.asList(
            BULLET,
            FLARE,
            ARROW,
            COW_MANGLER,
            BISON,
            CANNONBALL,
            RESCUE_RANGER,
            FESTIVE_ARROW
        ));

        return PopRandomizer.randomElement(huntsmanProjectiles);
    }

    /**
     * Returns the tf2 class name of this enum to be placed on the bot
     * @return
     */
    public String getDamageTypeString() {
        switch(this) {
            case BULLET:
            case SYRINGE:
            case ARROW:
            case CROSSBOW_SYRINGE:
            case BISON:
            case RESCUE_RANGER:
            case FESTIVE_ARROW:
            case FESTIVE_CROSSBOW_SYRINGE:
                return "bullet";
            case ROCKET:
            case COW_MANGLER:
            case CANNONBALL:
                return "blast";
            case FLARE:
                return "fire";
            default:
                OutputConsole.addMessage("WARNING: Tried to get damage type for non-existent class: \"" + this.toString() + "\". Defaulting to bullet...");
                return "class_projectile_bullet";
        }
    }

    /**
     * Returns the integer value as a string
     * @return The integer value of the projectile type
     */
    @Override
    public String toString() {
        return value + "";
    }
}
