package Pop.Bot.Weapons;

/**
 * Soldier's horns
 */
public class HornItem extends PassiveItem {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public HornItem(String itemName) {
        super(itemName);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public HornItem(String itemName, String displayName) {
        super(itemName, displayName);
    }
}
