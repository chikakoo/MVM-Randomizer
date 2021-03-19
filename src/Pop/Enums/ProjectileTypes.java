package Pop.Enums;

import Pop.Bot.Weapons.RocketLauncherWeapon;
import Pop.GUI.OutputConsole;
import Pop.PopRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A list of projectile types
 */
public enum ProjectileTypes {
    NONE (0),
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
    public static ProjectileTypes getRandomHitscanWeaponProjectile(ProjectileTypes typeToExclude) {
        ArrayList<ProjectileTypes> hitscanProjectiles = new ArrayList<>(Arrays.asList(
            BULLET,
            ROCKET,
            SYRINGE,
            FLARE,
            BISON
        ));

        if (hitscanProjectiles.contains(typeToExclude)) {
            hitscanProjectiles.remove(typeToExclude);
        }

        return PopRandomizer.randomElement(hitscanProjectiles);
    }

    /**
     * Gets a random projectile type that works with non-hitscan weapons
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomNonHitscanWeaponProjectile(ProjectileTypes typeToExclude) {
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

        if (nonHitscanProjectiles.contains(typeToExclude)) {
            nonHitscanProjectiles.remove(typeToExclude);
        }

        return PopRandomizer.randomElement(nonHitscanProjectiles);
    }

    /**
     * Gets a random projectile type that works with huntsman weapons
     * Excludes huntsman projectiles
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomHuntsmanProjectile(ProjectileTypes typeToExclude) {
        ArrayList<ProjectileTypes> huntsmanProjectiles = new ArrayList<>(Arrays.asList(
                BULLET,
                FLARE,
                COW_MANGLER,
                BISON,
                CANNONBALL,
                RESCUE_RANGER,
                ARROW,
                FESTIVE_ARROW
        ));

        if (huntsmanProjectiles.contains(typeToExclude)) {
            huntsmanProjectiles.remove(typeToExclude);
        }

        return PopRandomizer.randomElement(huntsmanProjectiles);
    }

    /**
     * Gets a random projectile type that works with rocket launcher weapons
     * Excludes rockets, as that's the only type that will call this for now
     * @return The retrieved value
     */
    public static ProjectileTypes getRandomRocketLauncherProjectile() {
        ArrayList<ProjectileTypes> rocketLauncherProjectiles = new ArrayList<>(Arrays.asList(
                //ROCKET,
                SYRINGE,
                FLARE,
                BISON
        ));

        return PopRandomizer.randomElement(rocketLauncherProjectiles);
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
