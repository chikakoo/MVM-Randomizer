package Pop.Bot.Weapons;

/**
 * The rocket jumper. Note that this isn't being considered any particular kind of weapon so that it will
 * always be a rocket jumper/
 */
public class RocketJumper extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public RocketJumper(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public RocketJumper(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets it up so that bots with this weapon will try to pick up the bomb
     */
    private void setExtraProperties() {
        itemAttributes.add("cannot pick up intelligence", "0");
    }
}
