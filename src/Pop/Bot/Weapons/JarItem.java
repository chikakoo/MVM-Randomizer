package Pop.Bot.Weapons;

/**
 * Covers the flying guillotine and the jar items
 */
public class JarItem extends ConsumableItem {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public JarItem(String itemName) {
        super(itemName);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public JarItem(String itemName, String displayName) {
        super(itemName, displayName);
    }
}
