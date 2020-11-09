package Pop.Bot.Weapons;

/**
 * Beggar's bazooka - makes it so that bots won't hurt themselves with it
 */
public class BeggarsBazooka extends HitscanWeapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public BeggarsBazooka(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public BeggarsBazooka(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * SEts the properties so that the bots won't hurt themselves
     */
    private void setExtraProperties() {
        itemAttributes.add("auto fires full clip", "1");
        itemAttributes.add("auto fires when full", "1");
    }
}
