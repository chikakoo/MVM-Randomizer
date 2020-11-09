package Pop.Bot.Weapons;

/**
 * Items that you consume and have to switch back to your main
 */
public class ConsumableItem extends PassiveItem {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public ConsumableItem(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public ConsumableItem(String itemName, int weight) {
        super(itemName, weight);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the item
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public ConsumableItem(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the item
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public ConsumableItem(String itemName, String displayName, int weight) {
        super(itemName, displayName, weight);
        setExtraProperties();
    }

    /**
     * Sets the extra properties so that bots will switch to another weapon after use
     */
    private void setExtraProperties() {
        itemAttributes.add("force weapon switch", "1");
        itemAttributes.add("single wep deploy time increased", "0.01");
    }
}
