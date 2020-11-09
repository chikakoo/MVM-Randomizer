package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;

public class HuntsmanWeapon extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     */
    public HuntsmanWeapon(String itemName) {
        super(itemName);
        this.weaponProjectileType = WeaponProjectileTypes.HUNTSMAN;
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public HuntsmanWeapon(String itemName, String displayName) {
        super(itemName, displayName);
        this.weaponProjectileType = WeaponProjectileTypes.HUNTSMAN;
    }

    /**
     * Gets a random huntsman projectile type
     * @return null
     */
    @Override
    protected ProjectileTypes getRandomProjectileType() {
        return ProjectileTypes.getRandomHuntsmanProjectile();
    }
}