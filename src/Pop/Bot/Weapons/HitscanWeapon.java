package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;

public class HitscanWeapon extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     */
    public HitscanWeapon(String itemName) {
        super(itemName);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public HitscanWeapon(String itemName, String displayName) {
        super(itemName, displayName);
        this.weaponProjectileType = WeaponProjectileTypes.HITSCAN;
    }

    /**
     * Gets a random hitscan projectile type
     * @return null
     */
    @Override
    protected ProjectileTypes getRandomProjectileType() {
        return ProjectileTypes.getRandomHitscanWeaponProjectile();
    }
}
