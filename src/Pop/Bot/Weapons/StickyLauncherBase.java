package Pop.Bot.Weapons;

public abstract class StickyLauncherBase extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public StickyLauncherBase(String itemName) {
        super(itemName);
        setExtraProperties();
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public StickyLauncherBase(String itemName, String displayName) {
        super(itemName, displayName);
        setExtraProperties();
    }

    /**
     * Sets it up so that these weapons have a custom projectile model
     * Also adds the fire rate and clip size bonus so that they will actually be dangerous
     */
    private void setExtraProperties() {
        this.canHaveCustomProjectileModel = true;
        itemAttributes.add("fire rate bonus", "1");
        itemAttributes.add("clip size bonus", "10");
    }
}
