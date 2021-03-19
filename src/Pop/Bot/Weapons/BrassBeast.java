package Pop.Bot.Weapons;

/**
 * This class is to identify the brass beast because movement bonuses are put on it manually
 */
public class BrassBeast extends Weapon {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public BrassBeast(String itemName) {
        super(itemName);
    }

    /**
     * Sets the item attributes of this weapon
     */
    public void addMovementSpeedBonus() {
        itemAttributes.add("aiming movespeed decreased", "0.8");
    }
}
