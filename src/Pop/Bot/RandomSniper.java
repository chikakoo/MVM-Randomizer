package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.ProjectileTypes;
import Pop.Enums.SkillLevels;
import Pop.Enums.TFClasses;

import java.util.*;

/**
 * Represents a randomly generated sniper
 */
public class RandomSniper extends RandomBot {
    /**
     * Constructor
     */
    public RandomSniper() {
        tfClass = TFClasses.SNIPER;
        baseHealth = 125;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_SNIPERRIFLE", "Sniper Rifle"),
            new HitscanWeapon("Festive Sniper Rifle 2011", "Festive Sniper Rifle"),
            new HitscanWeapon("The AWPer Hand"),
            new HitscanWeapon("The Sydney Sleeper"),
            new HitscanWeapon( "The Bazaar Bargain"),
            //new HitscanWeapon("Shooting Star"), // This is a machina
            new HitscanWeapon("The Hitman's Heatmaker"),
            new HuntsmanWeapon("The Huntsman"),
            new HuntsmanWeapon("Festive Huntsman", ProjectileTypes.FESTIVE_ARROW),
            new HuntsmanWeapon("The Fortified Compound")
            //"The Machina", // Support snipers can't use these
            //"The Classic" // They don't know how to use this
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_SMG", "SMG"),
            new HitscanWeapon("Festive SMG 2014", "Festive SMG"),
            new HitscanWeapon("The Cleaner's Carbine", "Carbine"),
            new JarItem("Jarate"),
            new JarItem("Festive Jarate"),
            new JarItem("The Self-Aware Beauty Mark", "Beauty Mark"),
            new PassiveItem("The Razorback"),
            new PassiveItem("Darwin's Danger Shield"),
            new PassiveItem("The Cozy Camper")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_CLUB", "Kukri"),
            new Weapon("The Tribalman's Shiv", "Shiv"),
            new Weapon("The Bushwacka"),
            new Weapon("The Shahanshah")
//            "Saxxy",
//            "Gold Frying Pan",
//            "Prinny Machete",
//            "Frying Pan",
//            "The Conscientious Objector",
//            "The Freedom Staff",
//            "The Bat Outta Hell",
//            "The Memory Maker",
//            "The Ham Shank",
//            "The Crossing Guard",
//            "Necro Smasher",
        ));

        classOnlyCosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("Trophy Belt"),
            new Cosmetic("Master's Yellow Belt", "Yellow Belt"),
            new Cosmetic("Professional's Panama"),
            new Cosmetic("Sniper Pith Helmet", "Pith Helmet"),
            new Cosmetic("Sniper Fishing Hat", "Fishing Hat"),
            new Cosmetic("Ol' Snaggletooth"),
            new Cosmetic("Larrikin Robin"),
            new Cosmetic("Crocleather Slouch"),
            new Cosmetic("Villain's Veil"),
            new Cosmetic("Desert Marauder"),
            new Cosmetic("The Anger"),
            new Cosmetic("Sniper's Snipin' Glass", "Snipin' Glass"),
            new Cosmetic("The Hat With No Name"),
            new Cosmetic("The Swagman's Swatter"),
            new Cosmetic("Your Worst Nightmare"),
            new Cosmetic("Holy Hunter"),
            new Cosmetic("The All-Father"),
            new Cosmetic("The Bushman's Boonie"),
            new Cosmetic("The Fruit Shoot"),
            new Cosmetic("The Flamingo Kid"),
            new Cosmetic("The Doublecross-Comm"),
            new Cosmetic("The HazMat Headcase"),
            new Cosmetic("Liquidator's Lid"),
            new Cosmetic("The Lone Star"),
            new Cosmetic("The Bolted Bushman"),
            new Cosmetic("The Stovepipe Sniper Shako", "Shako"),
            new Cosmetic("The Cold Killer"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Sydney Straw Boat"),
            new Cosmetic("The Bloodhound"),
            new Cosmetic("Letch's LED"),
            new Cosmetic("Shooter's Tin Topi"),
            new Cosmetic("Soldered Sensei"),
            new Cosmetic("Wet Works"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("Brim-Full Of Bullets"),
            new Cosmetic("The Hallowed Headcase"),
            new Cosmetic("The Snaggletoothed Stetson"),
            new Cosmetic("Randolph the Blood-Nosed Caribou", "Blood-Nosed Caribou"),
            new Cosmetic("The Smissmas Caribou"),
            new Cosmetic("The Five-Month Shadow"),
            new Cosmetic("The Toy Soldier"),
            new Cosmetic("The Deep Cover Operator"),
            new Cosmetic("The Dread Hiding Hood"),
            new Cosmetic("The Scoper's Smoke"),
            new Cosmetic("Conspiratorial Cut"),
            new Cosmetic("Marsupial Man"),
            new Cosmetic("Marsupial Muzzle"),
            new Cosmetic("dec2014 hunter_beard", "Hunter Beard"),
            new Cosmetic("dec2014 hunter_ushanka", "Hunter Ushanka"),
            new Cosmetic("Corona Australis"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("Archer's Sterling"),
            new Cosmetic("Hawk Eyed Hunter"),
            new Cosmetic("The Classy Capper"),
            new Cosmetic("The Most Dangerous Mane", "Dangerous Mane"),
            new Cosmetic("The Handsome Hitman"),
            new Cosmetic("Puffy Polar Cap")
        ));
    }

    /**
     * If the bot is not using a bow, make them always fire their weapon
     * Set them to easy so it's not super ridiculous
     *
     * Mission bots are unaffected by always fire weapon
     */
    @Override
    protected void adjustWeaponAttributesForTemplatedBots() {
        templateOverrideSkillLevel = true;
        skillLevel = SkillLevels.EASY;
        if (isMissionBot) { return; }

        String templateName = template.getTemplateName();
        if (!templateName.equals("T_TFBot_Sniper") &&
            !templateName.equals("T_TFBot_Sniper_Razorback") &&
            !templateName.equals("T_TFBot_Sniper_Sydney_Sleeper")) {
            return;
        }

        attributes.add("AlwaysFireWeapon");
    }

    /**
     * If the bot is not using a bow, make them always fire their weapon
     * Mission bots know how to do this, so don't assign this attribute for them
     * Additionally - this is only important if the bot's main weapon is their primary weapon
     */
    @Override
    protected void adjustWeaponAttributesForCustomBots() {
        if (isMissionBot) { return; }

        boolean hasHuntsman = primaryWeapon instanceof HuntsmanWeapon;
        boolean isMainWeaponPrimary = getMainWeapon().equals(primaryWeapon);
        if (!hasHuntsman && isMainWeaponPrimary) {
            attributes.add("AlwaysFireWeapon");
        }
    }
}
