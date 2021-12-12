package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.ProjectileTypes;
import Pop.Enums.TFClasses;
import Pop.Enums.WeaponRestrictions;

import java.util.*;

/**
 * Represents a randomly generated soldier
 */
public class RandomSoldier extends RandomBot {
    /**
     * Constructor
     */
    public RandomSoldier() {
        tfClass = TFClasses.SOLDIER;
        baseHealth = 200;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new RocketLauncherWeapon("Upgradeable TF_WEAPON_ROCKETLAUNCHER", "Rocket Launcher"),
            //new RocketLauncherWeapon("Festive Rocket Launcher 2011", "Festive Rocket Launcher"), // In skins
            //new RocketLauncherWeapon("The Original"), // In skins
            new RocketLauncherWeapon("The Direct Hit"),
            new RocketLauncherWeapon("The Black Box"),
            //new RocketLauncherWeapon("Festive Black Box"), // In skins
            new RocketLauncherWeapon("The Liberty Launcher"),
            new RocketLauncherWeapon( "The Air Strike"),
            new NonHitscanWeapon("The Cow Mangler 5000", "Cow Mangler", ProjectileTypes.COW_MANGLER),
            new BeggarsBazooka("The Beggar's Bazooka"),
            new RocketJumper("Rocket Jumper")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new AllClassShotgun("Soldier's Shotgun", "TF_WEAPON_SHOTGUN_SOLDIER"),
            new NonHitscanWeapon("The Righteous Bison", "Bison", ProjectileTypes.BISON),
            new HornItem("The Buff Banner"),
            //new HornItem("Festive Buff Banner"), // In skins
            new HornItem("The Battalion's Backup"),
            new HornItem("The Concheror"),
            new PassiveItem("The Mantreads"),
            new PassiveItem("The Gunboats"),
            new PassiveItem("The B.A.S.E. Jumper")
            //"Festive Shotgun 2014",
            //"The Reserve Shooter",
            //"Panic Attack Shotgun")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_SHOVEL", "Shovel"),
            new Weapon("The Equalizer"),
            new Weapon("The Pain Train"),
            new Weapon("The Half-Zatoichi"),
            new Weapon("The Disciplinary Action"),
            new Weapon("The Market Gardener"),
            new Weapon("The Escape Plan")
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
            new Cosmetic("Soldier's Stash", "Stashed"),
            new Cosmetic("Stainless Pot"),
            new Cosmetic("Tyrant's Helm"),
            new Cosmetic("Soldier Samurai Hat"),
            new Cosmetic("Soldier Drill Hat"),
            new Cosmetic("Worms Gear"),
            new Cosmetic("Chieftain's Challenge"),
            new Cosmetic("Stout Shako"),
            new Cosmetic("The Grenadier's Softcap"),
            new Cosmetic("Defiant Spartan"),
            new Cosmetic("Exquisite Rack"),
            new Cosmetic("Hero's Hachimaki"),
            new Cosmetic("Honcho's Headgear"),
            new Cosmetic("Bucket Hat"),
            new Cosmetic("Furious Fukaamigasa"),
            new Cosmetic("The Team Captain"),
            new Cosmetic("Armored Authority"),
            new Cosmetic("Jumper's Jeepcap"),
            new Cosmetic("Lord Cockswain's Novelty Mutton Chops and Pipe", "Chops and Pipe"),
            new Cosmetic("Lord Cockswain's Pith Helmet", "Pith Helmet"),
            new Cosmetic("Stahlhelm"),
            new Cosmetic("The Hat With No Name", "Unnamed Hat"),
            new Cosmetic("Idiot Box"),
            new Cosmetic("The Infernal Impaler"),
            new Cosmetic("The All-Father"),
            new Cosmetic("The Lucky Shot"),
            new Cosmetic("The Battle Bob"),
            new Cosmetic("The Conquistador"),
            new Cosmetic("The Cross-Comm Crash Helmet", "Crash Helmet"),
            new Cosmetic("The Helmet Without a Home", "Homeless Helmet"),
            new Cosmetic("The Soldier's Stogie"),
            new Cosmetic("The Tin Pot"),
            new Cosmetic("The Crafty Hair"),
            new Cosmetic("The War Pig"),
            new Cosmetic("The Menpo"),
            new Cosmetic("The Zipperface"),
            new Cosmetic("The Chief Constable"),
            new Cosmetic("Soldier's Slope Scopers"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Doe-Boy"),
            new Cosmetic("Full Metal Drill Hat"),
            new Cosmetic("Soldier's Sparkplug"),
            new Cosmetic("Steel Shako"),
            new Cosmetic("Tyrantium Helmet"),
            new Cosmetic("The Cloud Crasher"),
           // new Cosmetic("The Caribbean Conqueror"), // Glitchy looking
            new Cosmetic("The Rebel Rouser"),
            new Cosmetic("The Valley Forge"),
            new Cosmetic("The Whirly Warrior"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("The Cuban Bristle Crisis"),
            new Cosmetic("The Viking Braider"),
            new Cosmetic("The Cadaver's Capper"),
            new Cosmetic("The Faux Manchu"),
            new Cosmetic("The Freedom Feathers"),
            new Cosmetic("The Hardium Helm"),
            new Cosmetic("The Hidden Dragon"),
            new Cosmetic("The Larval Lid"),
            new Cosmetic("The Spellbinder's Bonnet"),
            new Cosmetic("The War on Smissmas Battle Hood", "Battle Hood"),
            new Cosmetic("Marshall's Mutton Chops", "Mutton Chops"),
            new Cosmetic("The Slo-Poke"),
            new Cosmetic("The Toy Soldier"),
            new Cosmetic("Ground Control"),
            new Cosmetic("The Big Daddy"),
            new Cosmetic("The First American"),
            new Cosmetic("The Gilded Guard"),
            new Cosmetic("The Spook Specs"),
            new Cosmetic("The Lone Survivor"),
            new Cosmetic("Battle Bird"),
            new Cosmetic("Hellhunter's Headpiece"),
            new Cosmetic("Supernatural Stalker"),
            new Cosmetic("EOTL_soldierhat", "Hatted"),
            new Cosmetic("EOTL_beard", "Bearded"),
            new Cosmetic("Screamin' Eagle"),
            new Cosmetic("dec2014 Skullcap", "Skullcap"),
            new Cosmetic("The Hellmet"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("Pestering Jester"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("The Nuke"),
            new Cosmetic("The Shellmet"),
            new Cosmetic("The War Eagle"),
            new Cosmetic("Brass Bucket"),
            //"The Crit Cloak", // Glitchy
            new Cosmetic("The Head Hedge"),
            new Cosmetic("Private Maggot Muncher", "Maggot Muncher"),
            new Cosmetic("Sky High Fly Guy", "Sky High"),
            new Cosmetic("The Tank Top"),
            new Cosmetic("Vampire Vanquisher"),
            new Cosmetic("Climbing Commander"),
            new Cosmetic("The Crack Pot"),
            new Cosmetic("The Dumb Bell"),
            new Cosmetic("Bobby Bonnet", "Officer"),
            new Cosmetic("Dancing Doe"),
            new Cosmetic("The Peacebreaker"),
            new Cosmetic("El Zapateador", "Zapateador"),
            new Cosmetic("Racc Mann"),
            new Cosmetic("Public Speaker"),
            new Cosmetic("Bazaar Bauble"),
            new Cosmetic("Breach and Bomb"),
            new Cosmetic("Hawk Warrior"),
            new Cosmetic("Sophisticated Smoker"),
            new Cosmetic("Calamitous Cauldron"),
            new Cosmetic("Semi-tame Trapper's Hat", "Semi-tame"),
            new Cosmetic("War Blunder"),
            new Cosmetic("Particulate Protector"),
            new Cosmetic("The Panisher"),
            new Cosmetic("Roaming Roman"),
            new Cosmetic("Thousand-Yard Stare"),
            new Cosmetic("Poopy Doe"),
            new Cosmetic("War Dog"),
            new Cosmetic("Elf Defence")
        ));
    }

    /**
     * Adjust the weapon attributes for soldier
     * - Changes the weapon restrictions if the soldier can't do damage
     * - Makes it so horn weapons cause the solider to spawn with a full charge
     */
    @Override
    protected void adjustWeaponAttributesForCustomBots() {
        if (weaponRestrictions.equals(WeaponRestrictions.SECONDARY_ONLY) && hasHorn()) {
            attributes.add("SpawnWithFullCharge");
        }
    }

    /**
     * Returns whether the bot has a horn
     * @return True if so, false otherwise
     */
    private boolean hasHorn() {
        return secondaryWeapon instanceof HornItem;
    }
}
