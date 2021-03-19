package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;

public class GrenadeLauncher extends NonHitscanWeapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public GrenadeLauncher(String itemName) {
        super(itemName);
        this.canHaveCustomProjectileModel = true;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    public GrenadeLauncher(String itemName, ProjectileTypes defaultProjectileType) {
        super(itemName, defaultProjectileType);
        this.canHaveCustomProjectileModel = true;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public GrenadeLauncher(String itemName, String displayName) {
        super(itemName, displayName);
        this.canHaveCustomProjectileModel = true;
    }
}
