package Pop.Bot.Weapons;

/**
 * The scout's Flying Guillotine
 */
public class Guillotine extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public Guillotine(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the item
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public Guillotine(String itemName, String displayName) {
        super(itemName, displayName);
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
