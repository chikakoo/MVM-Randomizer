package Pop.Bot.Weapons;

/**
 * Used to let Pyro spawn with full charge and so he will actually use his charge
 */
public class Phlogistinator extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public Phlogistinator(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public Phlogistinator(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets it up so that pyros will taunt when they try to airblast
     */
    private void setExtraProperties() {
        itemAttributes.add("airblast disabled", "0");
    }
}
