package Pop.Bot.Cosmetics;

/**
 * A representation of a TF2 cosmetic
 */
public class Cosmetic {
    /**
     * The name of the item as recognized by TF2
     */
    private String itemName;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * The name of the item to be used in bot names
     */
    private String displayName;
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Constructor
     * @param itemName - The item name. Sets the display name to this value, minus any of the word "The".
     */
    public Cosmetic(String itemName) {
        this.itemName = itemName;
        this.displayName = itemName.replace("The ", "");
    }

    /**
     * Constructor
     * @param itemName - The item name
     * @param displayName - The display name
     */
    public Cosmetic(String itemName, String displayName) {
        this.itemName = itemName;
        this.displayName = displayName;
    }
}
