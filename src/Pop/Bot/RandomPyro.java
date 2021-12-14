package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.Phlogistinator;
import Pop.Bot.Weapons.*;
import Pop.Enums.ProjectileTypes;
import Pop.Enums.TFClasses;

import java.util.*;

/**
 * Represents a randomly generated pyro
 */
public class RandomPyro extends RandomBot {
    /**
     * Constructor
     */
    public RandomPyro() {
        tfClass = TFClasses.PYRO;
        baseHealth = 175;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_FLAMETHROWER", "Flamethrower"),
            //new Weapon("Festive Flamethrower 2011", "Festive Flamethrower"), // In skins
            //new Weapon( "The Rainblower"), // In skins
            //new Weapon( "The Nostromo Napalmer"), // In skins
            new Weapon("The Backburner"),
            //new Weapon("Festive Backburner 2014", "Festive Backburner"), // In skins
            new Weapon("The Degreaser"),
            new Weapon("The Dragon's Fury"),
            new Phlogistinator("The Phlogistinator")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new AllClassShotgun("Pyro's Shotgun", "TF_WEAPON_SHOTGUN_PYRO"),
            new HitscanWeapon("The Flare Gun", ProjectileTypes.FLARE),
            //new HitscanWeapon( "Festive Flare Gun", ProjectileTypes.FLARE), // In skins
            new HitscanWeapon("The Detonator", ProjectileTypes.FLARE),
            new HitscanWeapon("The Manmelter", ProjectileTypes.FLARE),
            new HitscanWeapon( "The Scorch Shot", ProjectileTypes.FLARE),
            new Weapon("The Thermal Thruster"),
            new JarItem("The Gas Passer")
            //"Festive Shotgun 2014",
            //"The Reserve Shooter",
            //"Panic Attack Shotgun",
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_FIREAXE", "Fire Axe"),
            new Weapon("The Lollichop"),
            new Weapon("The Axtinguisher"),
            new Weapon( "The Festive Axtinguisher"),
            new Weapon( "The Postal Pummeler"),
            new Weapon("The Homewrecker"),
            new Weapon("The Maul"),
            new Weapon("The Powerjack"),
            new Weapon("The Back Scratcher"),
            new Weapon("Sharpened Volcano Fragment", "Volcano Fragment"),
            new Weapon("The Third Degree"),
            new Weapon("The Neon Annihilator")
//            "Gold Frying Pan",
//            "Saxxy",
//            "Prinny Machete",
//            "Frying Pan",
//            "The Conscientious Objector",
//            "The Freedom Staff",
//            "The Bat Outta Hell",
//            "The Memory Maker",
//            "The Ham Shank",
//            "The Crossing Guard",
//            "Necro Smasher",
            //"The Hot Hand") // glitchy looking
        ));

        classOnlyCosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("Pyro's Beanie", "Beanie"),
            new Cosmetic("Brigade Helm"),
            new Cosmetic("Respectless Rubber Glove", "Rubber Glove"),
            new Cosmetic("Pyro Brain Sucker", "Brain Sucker"),
            new Cosmetic("Pyro Helm", "Helmed"),
            new Cosmetic("Pyro Monocle", "Monocled"),
            new Cosmetic("The Attendant"),
            new Cosmetic("Handyman's Handle"),
            new Cosmetic("Napper's Respite"),
            new Cosmetic("Old Guadalajara"),
            new Cosmetic("KF Pyro Mask", "Masked"),
            new Cosmetic("Prancer's Pride"),
            new Cosmetic("Madame Dixie"),
            new Cosmetic("Pyromancer's Mask", "Pyromancer"),
            new Cosmetic("Sight for Sore Eyes"),
            new Cosmetic("Traffic Cone"),
            new Cosmetic("Connoisseur's Cap"),
            new Cosmetic("Hottie's Hoodie"),
            new Cosmetic("Stately Steel Toe"),
            new Cosmetic("The Birdcage"),
            new Cosmetic("The Flamboyant Flamenco"),
            new Cosmetic("The Little Buddy"),
            new Cosmetic("Apparition's Aspect"),
            new Cosmetic("Blazing Bull"),
            new Cosmetic("The Last Breath"),
            new Cosmetic("The Bubble Pipe"),
            new Cosmetic("The Head Warmer"),
            new Cosmetic("The Waxy Wayfinder"),
            new Cosmetic("The Triclops"),
            new Cosmetic("The HazMat Headcase"),
            new Cosmetic("Area 451"),
            new Cosmetic("The Plutonidome"),
            new Cosmetic("The Wraith Wrap"),
            new Cosmetic("The DethKapp"),
            new Cosmetic("Nose Candy"),
            new Cosmetic("The Winter Wonderland Wrap"),
            new Cosmetic("The Person in the Iron Mask", "Iron Mask"),
            new Cosmetic("The Necronomicrown"),
            new Cosmetic("The Bolted Birdcage"),
            new Cosmetic("The Electric Escorter"),
            new Cosmetic("The Filamental"),
            new Cosmetic("Firewall Helmet"),
            new Cosmetic("The Googol Glass Eyes"),
            new Cosmetic("The Metal Slug"),
            new Cosmetic("Plumber's Pipe"),
            new Cosmetic("Pyro's Boron Beanie"),
            new Cosmetic("Respectless Robo-Glove"),
            new Cosmetic("The Rusty Reaper"),
            new Cosmetic("The Breather Bag"),
            new Cosmetic("The Mair Mask"),
            new Cosmetic("The Centurion"),
            new Cosmetic("The Burning Bandana"),
            new Cosmetic("The Hive Minder"),
            new Cosmetic("The Pampered Pyro", "Pampered"),
            new Cosmetic("The Air Raider"),
            new Cosmetic("The Bone Dome"),
            new Cosmetic("Pop-eyes"),
            new Cosmetic("The Special Eyes"),
            new Cosmetic("The Beast From Below"),
            new Cosmetic("Bozo's Bouffant"),
            new Cosmetic("Burny's Boney Bonnet"),
            new Cosmetic("The Corpsemopolitan"),
            new Cosmetic("The Crispy Golden Locks"),
            new Cosmetic("The Glob"),
            new Cosmetic("The Gothic Guise"),
            new Cosmetic("Hard-Headed Hardware"),
            new Cosmetic("The Hollowhead"),
            new Cosmetic("The Macabre Mask"),
            new Cosmetic("The Mucous Membrain"),
            new Cosmetic("PY-40 Incinibot"),
            new Cosmetic("The Raven's Visage"),
            new Cosmetic("The Rugged Respirator"),
            new Cosmetic("The Spectralnaut"),
            new Cosmetic("Up Pyroscopes"),
            new Cosmetic("The Vicious Visage"),
            new Cosmetic("The Snaggletoothed Stetson"),
            new Cosmetic("The Blizzard Breather"),
            new Cosmetic("The Toy Tailor"),
            new Cosmetic("The Cute Suit"),
            new Cosmetic("Sole Mate"),
            new Cosmetic("The Combustible Kabuto"),
            new Cosmetic("Employee of the Mmmph"),
            new Cosmetic("The Smoking Skid Lid"),
            new Cosmetic("The Mishap Mercenary"),
            new Cosmetic("Creature's Grin"),
            new Cosmetic("Lollichop Licker"),
            new Cosmetic("Mr. Juice"),
            new Cosmetic("Vampyro"),
            new Cosmetic("The Nabler"),
            new Cosmetic("EOTL_Skier", "Skier"),
            new Cosmetic("dec2014 Black Knights Bascinet", "Black Knight's Bascinet"),
            new Cosmetic("dec2014 2014_pyromancer_hood", "Pyromander Hood"),
            new Cosmetic("A Head Full of Hot Air", "Hot Air"),
            new Cosmetic("Phobos Filter"),
            new Cosmetic("Arthropod's Aspect"),
            new Cosmetic("The Face of Mercy"),
            new Cosmetic("Neptune's Nightmare"),
            new Cosmetic("Fear Monger"),
            new Cosmetic("Promo The Firefly"),
            new Cosmetic("Combustible Cutie"),
            new Cosmetic("The Cranial Carcharodon"),
            new Cosmetic("Pestering Jester"),
            new Cosmetic("Pyro the Flamedeer", "Flamedeer"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("Airtight Arsonist"),
            new Cosmetic("D-eye-monds"),
            new Cosmetic("Feathered Fiend"),
            new Cosmetic("Burning Beanie"),
            new Cosmetic("The Cat's Pajamas"),
            new Cosmetic("The Burning Question"),
            new Cosmetic("The Arachno-Arsonist"),
            new Cosmetic("Mr. Quackers"),
            new Cosmetic("Pyro in Chinatown", "Chinatown"),
            new Cosmetic("Pocket Pardner"),
            new Cosmetic("The Fiery Phoenix"),
            new Cosmetic("Melted Mop"),
            new Cosmetic("Candy Cranium"),
            new Cosmetic("Head of the Dead"),
            new Cosmetic("Pyr'o Lantern"),
            new Cosmetic("Pyro Shark", "Shark"),
            new Cosmetic("Skullbrero"),
            new Cosmetic("The Trick Stabber"),
            new Cosmetic("Discovision"),
            new Cosmetic("Winter Wrap Up"),
            new Cosmetic("Fire Fighter"),
            new Cosmetic("Flamehawk"),
            new Cosmetic("The Boom Boxers"),
            new Cosmetic("The Fire Tooth"),
            new Cosmetic("The Seared Sorcerer"),
            new Cosmetic("The Treehugger"),
            new Cosmetic("The Round-A-Bout"),
            new Cosmetic("Brim of Fire"),
            new Cosmetic("Hook Line and Cinder", "Fish Tank"),
            new Cosmetic("Reel Fly Hat", "Reel Fly"),
            new Cosmetic("The Miami Rooster"),
            new Cosmetic("Smiling Somen"),
            new Cosmetic("Wandering Wraith"),
            new Cosmetic("Elf Ignition")
        ));
    }

    /**
     * Adjust the weapon attribute so pyros will spawn with full charge if they have the phlogistinator
     */
    @Override
    protected void adjustWeaponAttributesForCustomBots() {
        if (primaryWeapon instanceof Phlogistinator) {
            attributes.add("SpawnWithFullCharge");
        }
    }
}
