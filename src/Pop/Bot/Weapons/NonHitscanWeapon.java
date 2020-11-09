package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;

public class NonHitscanWeapon extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     */
    public NonHitscanWeapon(String itemName) {
        super(itemName);
        this.weaponProjectileType = WeaponProjectileTypes.NON_HITSCAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public NonHitscanWeapon(String itemName, String displayName) {
        super(itemName, displayName);
        this.weaponProjectileType = WeaponProjectileTypes.NON_HITSCAN;
    }

    /**
     * Gets a random non-hitscan projectile type
     * @return null
     */
    @Override
    protected ProjectileTypes getRandomProjectileType() {
        return ProjectileTypes.getRandomNonHitscanWeaponProjectile();
    }
}