package Pop.Bot.Weapons;

/**
 * The Loch-N-Load is the same as a grenade launcher, but we can't use custom
 * projectile types or the game will crash inexplicably
 */
public class LochNLoad extends GrenadeLauncher {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public LochNLoad(String itemName) {
        super(itemName);
        this.weaponProjectileType = null;
    }
}
