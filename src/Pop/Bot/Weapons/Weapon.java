package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;
import Pop.Enums.WeaponProjectileTypes;
import Pop.ItemAttributes;
import Pop.MVMRandomizer;
import Pop.PopRandomizer;
import Pop.WeightedItemCollection;

import java.util.ArrayList;

public class Weapon {
    /**
     * The name of the weapon - used when assigning the weapon to the bots:
     * Item "itemName"
     */
    protected String itemName;
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * The name to be used if the bot is named after this weapon
     */
    protected String displayName;
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * The name of the weapon when used to define the item attributes - normally just the item name:
     * ItemAttributes:
     * {
     *     ItemName "itemAttributeName"
     *     ...
     * }
     */
    protected String itemAttributeItemName;
    public String getItemAttributeItemName() {
        return itemAttributeItemName;
    }
    public void setItemAttributeItemName(String itemAttributeItemName) {
        this.itemAttributeItemName = itemAttributeItemName;
    }

    /**
     * Used when determining which projectile types can be used when overriding
     */
    protected WeaponProjectileTypes weaponProjectileType = WeaponProjectileTypes.NONE;
    public WeaponProjectileTypes getWeaponProjectileType() {
        return weaponProjectileType;
    }
    public void setWeaponProjectileType(WeaponProjectileTypes weaponProjectileType) {
        this.weaponProjectileType = weaponProjectileType;
    }

    /**
     * The default projectile type - this is used when trying to exclude the default type from
     * being chosen at random
     */
    protected ProjectileTypes defaultProjectileType = ProjectileTypes.NONE;

    /**
     *  Whether this weapon can have a custom projectile model
     */
    protected boolean canHaveCustomProjectileModel = false;

    /**
     * The weapon model belonging to this weapon
     */
    protected WeaponModel weaponModel = null;
    public WeaponModel getWeaponModel() { return weaponModel; }

    /**
     * The overridden projectile type of the weapon
     */
    protected ProjectileTypes overriddenProjectileType = null;
    public ProjectileTypes getOverriddenProjectileType() {
        return overriddenProjectileType;
    }
    public void setOverriddenProjectileType(ProjectileTypes overriddenProjectileType) {
        this.overriddenProjectileType = overriddenProjectileType;
    }

    /**
     * The item attributes for the weapon - used when generating special weapon properties in the pop files
     * The getter also tries to add a random projectile and model to the weapon
     */
    protected ItemAttributes itemAttributes;
    public ItemAttributes getItemAttributes() {
        return itemAttributes;
    }

    /**
     * The weight of the weapon - this is the odds that the weapon will be chosen out of all the others
     */
    protected int weight = 100;

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the displayName and itemAttributeItemName to this value.
     *                 It will replace the string "The " with the empty string.
     */
    public Weapon(String itemName) {
        String displayName = itemName.replace("The ", "");
        setWeaponProperties(itemName, displayName, 100);
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the displayName and itemAttributeItemName to this value.
     *                 It will replace the string "The " with the empty string.
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    public Weapon(String itemName, ProjectileTypes defaultProjectileType) {
        String displayName = itemName.replace("The ", "");
        setWeaponProperties(itemName, displayName, 100, defaultProjectileType);
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param displayName - The name to be used if the bot is named after this weapon
     */
    public Weapon(String itemName, String displayName) {
        setWeaponProperties(itemName, displayName, 100);
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    public Weapon(String itemName, String displayName, ProjectileTypes defaultProjectileType) {
        setWeaponProperties(itemName, displayName, 100, defaultProjectileType);
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the displayName and itemAttributeItemName to this value.
     *                 It will replace the string "The " with the empty string.
     * @param weight - The odds that this weapon will be chosen relative to the others
     */
    public Weapon(String itemName, int weight) {
        String displayName = itemName.replace("The ", "");
        setWeaponProperties(itemName, displayName, weight);
    }

    /**
     * Constructor
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen relative to the others
     */
    public Weapon(String itemName, String displayName, int weight) {
        setWeaponProperties(itemName, displayName, weight);
    }

    /**
     * Sets the weapon properties - a shared method by all the constructors
     * Includes setting the random projectile type
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen relative to the others
     */
    private void setWeaponProperties(String itemName, String displayName, int weight) {
        setWeaponProperties(itemName, displayName, weight, ProjectileTypes.NONE);
    }

    /**
     * Sets the weapon properties - a shared method by all the constructors
     * Includes setting the random projectile type
     * @param itemName - The name of the item - also sets the itemAttributeItemName to this value
     * @param displayName - The name to be used if the bot is named after this weapon
     * @param weight - The odds that this weapon will be chosen relative to the others
     * @param defaultProjectileType - The default projectile type of the weapon
     */
    private void setWeaponProperties(String itemName, String displayName, int weight, ProjectileTypes defaultProjectileType) {
        this.itemName = itemName;
        this.displayName = displayName;
        this.itemAttributeItemName = itemName;
        this.itemAttributes = new ItemAttributes(itemAttributeItemName);
        this.weight = weight;
        this.defaultProjectileType = defaultProjectileType;
        this.tryAddRandomProjectileType();
    }

    /**
     * Chance of adding random projectile type to this weapon
     */
    private void tryAddRandomProjectileType() {
        if (PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentRandomProjectileType())) {
            addRandomProjectileType();
        }
    }

    /**
     * Adds a random projectile type to the weapon
     */
    protected void addRandomProjectileType() {
        overriddenProjectileType = getRandomProjectileType();
        if (overriddenProjectileType != null) {
            itemAttributes.add("override projectile type", overriddenProjectileType.toString());

            if (overriddenProjectileType.equals(ProjectileTypes.BISON)) {
                itemAttributes.add("energy weapon penetration", "1");
            }

            else if (overriddenProjectileType.equals(ProjectileTypes.FLARE)) {
                itemAttributes.add("set damagetype ignite", "1");
            }
        }
    }

    /**
     * Gets a random projectile type - the base weapon has no projectile type, so it returns null
     * @return null
     */
    protected ProjectileTypes getRandomProjectileType() {
        return null;
    }

    /**
     * Returns whether the weapon has an overridden projectile type
     * @return True if so, false otherwise
     */
    public boolean hasOverriddenProjectileType() {
        return overriddenProjectileType != null;
    }

    /**
     * Adds a random projectile model to the given weapon
     */
    private static void tryAddRandomProjectileModel(Weapon weapon) {
        boolean hasCannonballProjectiles =
                weapon.overriddenProjectileType != null && weapon.overriddenProjectileType.equals(ProjectileTypes.CANNONBALL);
        boolean canHaveRandomModel = weapon.canHaveCustomProjectileModel || hasCannonballProjectiles;
        if (canHaveRandomModel &&
            PopRandomizer.generateBooleanFromPercentage(MVMRandomizer.randomBotSettings.getPercentRandomProjectileModel())) {
            weapon.weaponModel = WeaponModels.getRandomModel();
            weapon.itemAttributes.add("custom projectile model", "\"" + weapon.weaponModel + "\"");

            if (weapon.weaponModel.getTurnToGoldOnDeath()) {
                weapon.itemAttributes.add("turn to gold", "1");
            }
        }
    }

    /**
     * Gets a random weapon from the given list, using their weight values
     * @param list - The list of possible weapons
     * @return - A random weapon from the list
     */
    public static Weapon getRandomWeapon(ArrayList<Weapon> list) {
        WeightedItemCollection<Weapon> weightedWeaponList = new WeightedItemCollection<>();
        for (Weapon weapon : list) {
            weightedWeaponList.add(weapon, weapon.weight);
        }

        Weapon randomWeapon = weightedWeaponList.getRandomItem();
        tryAddRandomProjectileModel(randomWeapon);
        return randomWeapon;
    }
}
