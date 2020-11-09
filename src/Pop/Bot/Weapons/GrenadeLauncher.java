package Pop.Bot.Weapons;

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
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public GrenadeLauncher(String itemName, String displayName) {
        super(itemName, displayName);
        this.canHaveCustomProjectileModel = true;
    }
}
