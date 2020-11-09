package Pop.Bot.Weapons;

/**
 * This class is needed because their item attribute name is not the same as their item name
 */
public class AllClassShotgun extends HitscanWeapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param itemAttributeItemName - The name to use in the item attribute block
     */
    public AllClassShotgun(String itemName, String itemAttributeItemName) {
        super(itemName);
        this.displayName = "Shotgun";
        this.itemAttributeItemName = itemAttributeItemName;
        itemAttributes.setItemName(itemAttributeItemName);
    }

    /**
     * Constructor
     * @param itemName - The name of the weapon
     * @param itemAttributeItemName - The name to use in the item attribute block
     * @param displayName - The name to use for bots
     */
    public AllClassShotgun(String itemName, String itemAttributeItemName, String displayName) {
        super(itemName);
        this.displayName = displayName;
        this.itemAttributeItemName = itemAttributeItemName;
        itemAttributes.setItemName(itemAttributeItemName);
    }
}
