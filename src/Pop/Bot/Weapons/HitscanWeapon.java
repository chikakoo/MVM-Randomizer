package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;

public class HitscanWeapon extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     */
    public HitscanWeapon(String itemName) {
        super(itemName, ProjectileTypes.BULLET);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    public HitscanWeapon(String itemName, ProjectileTypes defaultProjectileType) {
        super(itemName, defaultProjectileType);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public HitscanWeapon(String itemName, String displayName) {
        super(itemName, displayName, ProjectileTypes.BULLET);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    public HitscanWeapon(String itemName, String displayName, ProjectileTypes defaultProjectileType) {
        super(itemName, displayName, defaultProjectileType);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Gets a random hitscan projectile type
     * @return null
     */
    @Override
    protected ProjectileTypes getRandomProjectileType() {
        return ProjectileTypes.getRandomHitscanWeaponProjectile(this.defaultProjectileType);
    }
}
