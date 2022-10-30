package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.TFClasses;
import Pop.Enums.WeaponRestrictions;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.*;

/**
 * Represents a randomly generated demoman
 */
public class RandomDemoman extends RandomBot {
    /**
     * Constructor
     */
    public RandomDemoman() {
        tfClass = TFClasses.DEMOMAN;
        baseHealth = 175;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new GrenadeLauncher("Upgradeable TF_WEAPON_GRENADELAUNCHER", "Grenade Launcher"),
            //new GrenadeLauncher("Festive Grenade Launcher", "Festive Launcher"), // In skins
            new GrenadeLauncher("The Loch-n-Load"),
            new GrenadeLauncher("The Iron Bomber"),
            new LooseCannon( "The Loose Cannon"),
            new PassiveItem("Ali Baba's Wee Booties", "Wee Booties"),
            new PassiveItem("The Bootlegger"),
            new PassiveItem("The B.A.S.E. Jumper")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new StickyLauncher("Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER", "Sticky Launcher"),
            //new StickyLauncher("Festive Stickybomb Launcher 2011", "Festive Sticky"), // In skins
            new QuickieLauncher("The Quickiebomb Launcher", "Quickiebomb"),
            new StickyJumper("Stickybomb Jumper", "Sticky Jumper"),
            new ScottishResistance("The Scottish Resistance"),
            new PassiveItem("The Chargin' Targe"),
            //new PassiveItem("Festive Targe 2014", "Festive Targe"), // In skins
            new PassiveItem("The Splendid Screen"),
            new PassiveItem("The Tide Turner")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_BOTTLE", "Bottle"),
            new Weapon("The Scottish Handshake", "Scottish Handshake"),
            new Weapon("The Eyelander"),
            new Weapon("Festive Eyelander"),
            new Weapon("The Horseless Headless Horsemann's Headtaker", "Headtaker"),
            new Weapon("Nessie's Nine Iron", "Nine Iron"),
            new Weapon("The Scotsman's Skullcutter", "Skullcutter"),
            new Weapon("The Pain Train"),
            new Weapon("The Ullapool Caber", "Caber"),
            new Weapon("The Claidheamohmor"),
            new Weapon("The Half-Zatoichi")
            //"Gold Frying Pan",
            //"Saxxy",
            //"Prinny Machete",
            //"Frying Pan",
            //"The Conscientious Objector",
            //"The Freedom Staff",
            //"The Bat Outta Hell",
            //"The Memory Maker",
            //"The Ham Shank",
            //"The Crossing Guard",
            //"Necro Smasher",
        ));

        classOnlyCosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("Demoman's Fro"),
            new Cosmetic("Glengarry Bonnet"),
            new Cosmetic("Scotsman's Stove Pipe", "Stove Pipe"),
            new Cosmetic("Demoman Hallmark", "Hallmark"),
            new Cosmetic("Tippler's Tricorne"),
            new Cosmetic("Carouser's Capotain"),
            new Cosmetic("Rimmed Raincatcher"),
            new Cosmetic("Sober Stuntman"),
            new Cosmetic("TTG Glasses"),
            new Cosmetic("Prince Tavish's Crown", "Tavish's Crown"),
            new Cosmetic("Scotch Bonnet"),
            new Cosmetic("Demo Kabuto", "Kabuto"),
            new Cosmetic("Reggaelator"),
            new Cosmetic("Private Eye"),
            new Cosmetic("Conjurer's Cowl"),
            new Cosmetic("Sultan's Ceremonial"),
            new Cosmetic("Tam O'Shanter"),
            new Cosmetic("Mask of the Shaman"),
            new Cosmetic("The Buccaneer's Bicorne"),
            new Cosmetic("The Hat With No Name"),
            new Cosmetic("The Tavish DeGroot Experience", "Tavish DeGroot"),
            new Cosmetic("Hair of the Dog"),
            new Cosmetic("Scottish Snarl"),
            new Cosmetic("The All-Father"),
            new Cosmetic("The Bolgan"),
            new Cosmetic("The Snapped Pupil"),
            new Cosmetic("The Grenadier Helm"),
            new Cosmetic("The Bearded Bombardier"),
            new Cosmetic("The K-9 Mane"),
            new Cosmetic("The Menpo"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Wilson Weave"),
            new Cosmetic("Blind Justice"),
            new Cosmetic("The Bolted Bicorne"),
            new Cosmetic("The Broadband Bonnet"),
            new Cosmetic("The Cyborg Stunt Helmet"),
            new Cosmetic("The FR-0"),
            new Cosmetic("The HDMI Patch"),
            new Cosmetic("The Pure Tin Capotain"),
            new Cosmetic("The Strontium Stove Pipe"),
            new Cosmetic("The Tartan Shade"),
            new Cosmetic("The Black Watch"),
            new Cosmetic("The Glasgow Great Helm"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("The Stormin' Norman"),
            new Cosmetic("The Tartan Spartan"),
            new Cosmetic("Pirate Bandana"),
            new Cosmetic("Cap'n Calamari"),
            new Cosmetic("Ethereal Hood"),
            new Cosmetic("The Headtaker's Hood"),
            new Cosmetic("The Mann-Bird of Aberdeen", "Mann-Bird"),
            new Cosmetic("The Parasight"),
            new Cosmetic("The Squid's Lid"),
            new Cosmetic("The Transylvania Top"),
            new Cosmetic("Tartan Tyrolean"),
            new Cosmetic("Stylish DeGroot"),
            new Cosmetic("The Allbrero"),
            new Cosmetic("The Frontier Djustice"),
            new Cosmetic("The Razor Cut"),
            new Cosmetic("Seeing Double"),
            new Cosmetic("Eyeborg"),
            new Cosmetic("Forgotten King's Restless Head", "Restless Head"),
            new Cosmetic("Explosive Mind"),
            new Cosmetic("EOTL_summerhat", "Summer Hat"),
            new Cosmetic("dec2014 Comforter", "Comforter"),
            new Cosmetic("dec2014 Viking Helmet", "Viking Helmet"),
            new Cosmetic("Bruce's Bonnet"),
            new Cosmetic("Outta' Sight"),
            new Cosmetic("The Hood of Sorrows"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("The Dayjogger"),
            new Cosmetic("Spirit of the Bombing Past", "Bombing past"),
            new Cosmetic("Bomb Beanie"),
            new Cosmetic("The Bomber Knight"),
            new Cosmetic("Elf Esteem"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("Blast Defense"),
            new Cosmetic("The War Eagle"),
            new Cosmetic("Hungover Hero"),
            new Cosmetic("Melody Of Misery"),
            new Cosmetic("Antarctic Eyewear"),
            new Cosmetic("The Frag Proof Fragger", "Frag Proof"),
            new Cosmetic("Backbreaker's Skullcracker", "Skullcracker"),
            new Cosmetic("Bobby Bonnet", "Officer"),
            new Cosmetic("Spiky Viking"),
            new Cosmetic("Hazard Headgear"),
            new Cosmetic("Sophisticated Smoker"),
            new Cosmetic("The Boom Boxers"),
            new Cosmetic("Helm Helm"),
            new Cosmetic("Particulate Protector"),
            new Cosmetic("Death Stare"),
            new Cosmetic("Trickster's Treats"),
            new Cosmetic("Head Banger"),
            new Cosmetic("Alcoholic Automaton"),
            new Cosmetic("Bombard Brigadier"),
            new Cosmetic("Nightbane Brim")
        ));
    }

    /**
     * Forces demoman to always fire his weapon if he only uses his sticky launcher
     */
    @Override
    protected void adjustWeaponAttributesForCustomBots() {
        if (weaponRestrictions.equals(WeaponRestrictions.SECONDARY_ONLY) && secondaryWeapon instanceof StickyLauncherBase) {
            attributes.add("AlwaysFireWeapon");
        }
    }
}