package Pop.Bot.Weapons;

/**
 * Any item that isn't actually weilded
 */
public class PassiveItem extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public PassiveItem(String itemName) {
        super(itemName);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public PassiveItem(String itemName, int weight) {
        super(itemName, weight);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public PassiveItem(String itemName, String displayName) {
        super(itemName, displayName);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public PassiveItem(String itemName, String displayName, int weight) {
        super(itemName, displayName, weight);
    }
}
