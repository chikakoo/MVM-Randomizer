package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;

public class RocketLauncherWeapon extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     */
    public RocketLauncherWeapon(String itemName) {
        super(itemName);
        this.weaponProjectileType = WeaponProjectileTypes.ROCKET_LAUNCHER;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public RocketLauncherWeapon(String itemName, String displayName) {
        super(itemName, displayName);
        this.weaponProjectileType = WeaponProjectileTypes.ROCKET_LAUNCHER;
    }

    /**
     * Gets a random rocket launcher projectile type
     * @return null
     */
    @Override
    protected ProjectileTypes getRandomProjectileType() {
        return ProjectileTypes.getRandomRocketLauncherProjectile();
    }
}