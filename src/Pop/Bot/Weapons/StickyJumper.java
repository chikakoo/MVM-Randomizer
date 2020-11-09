package Pop.Bot.Weapons;

public class StickyJumper extends StickyLauncherBase {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public StickyJumper(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public StickyJumper(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets it up so that the max pipe bombs is 1 so that they will actually explode
     * Also makes it so that these bots will actually pick up the bomb
     */
    private void setExtraProperties() {
        itemAttributes.add("max pipebombs decreased", "-7");
        itemAttributes.add("cannot pick up intelligence", "0");
    }
}
