package Pop.Bot.Weapons.Skins;

/**
 * Weapon skin class - this is for weapon skins that existed before war paints
 */
public class WeaponSkin {
    /**
     * The name of the weapon - all the skins have alternate weapon names
     */
    private String weaponName;
    public String getWeaponName() { return this.weaponName; }

    /**
     * The display name for the weapon should the weapon name be used for the bot's name
     */
    private String weaponDisplayName;
    public String getWeaponDisplayName() { return this.weaponDisplayName; }

    public WeaponSkin(String weaponName, String weaponDisplayName) {
        this.weaponName = weaponName;
        this.weaponDisplayName = weaponDisplayName;
    }
}
