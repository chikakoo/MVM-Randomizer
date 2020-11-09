package Pop.Bot.Weapons;

/**
 * Adds attributes so that heavy won't just constantly eat his items and take forever to leave spawn
 */
public class LunchBoxItem extends ConsumableItem {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param weight - The odds that this weapon will be chosen, relative to the others
     */
    public LunchBoxItem(String itemName, int weight) {
        super(itemName, weight);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public LunchBoxItem(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets the extra properties so that bots with a lunchbox item won't continuously eat them
     */
    private void setExtraProperties() {
        itemAttributes.add("max health additive bonus", "1");
        itemAttributes.add("force weapon switch", "1");
        itemAttributes.add("single wep deploy time increased", "0.01");
    }
}
