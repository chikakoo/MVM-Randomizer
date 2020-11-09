package Pop.Bot.Weapons;

public class StickyLauncher extends StickyLauncherBase {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public StickyLauncher(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public StickyLauncher(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets it up so that the max pipebombs is 1 so that they will actually explode
     */
    private void setExtraProperties() {
        itemAttributes.add("max pipebombs decreased", "-7");
    }
}
