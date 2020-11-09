package Pop.Bot.Weapons;

/**
 * Drinks that the scout uses
 */
public class DrinkItem extends ConsumableItem {
    /**
     * Constructor
     * @param itemName - The name of the item
     */
    public DrinkItem(String itemName) {
        super(itemName);
    }

    /**
     * Constructor
     * @param itemName - The name of the item
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public DrinkItem(String itemName, String displayName) {
        super(itemName, displayName);
    }

    /**
     * Constructor
     * @param itemName - The name of the item
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public DrinkItem(String itemName, String displayName, int weight) {
        super(itemName, displayName, weight);
    }
}
