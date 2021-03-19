package Pop.Bot.Weapons;

import Pop.Enums.ProjectileTypes;

public class LooseCannon extends GrenadeLauncher {
    /**
     * Constructor
     * @param itemName - The name of the weapon
     */
    public LooseCannon(String itemName) {
        super(itemName, ProjectileTypes.CANNONBALL);
        setExtraProperties();
    }

    /**
     * Sets the properties of the loose cannon so that bots won't hurt themselves with it
     */
    private void setExtraProperties() {
        if (itemAttributes.getAttribute("grenade launcher mortar mode") == null) {
            itemAttributes.add("grenade launcher mortar mode", "-1");
        }
        itemAttributes.add("auto fires full clip", "1");
        itemAttributes.add("auto fires when full", "1");
    }

    /**
     * If the random projectile is different than the base projectile, then set the mortar mode to 0 so we don't crash
     */
    @Override
    protected void addRandomProjectileType() {
        super.addRandomProjectileType();

        if (overriddenProjectileType != null && !overriddenProjectileType.equals(ProjectileTypes.CANNONBALL)) {
            itemAttributes.add("grenade launcher mortar mode", "0");
        }
    }
}
