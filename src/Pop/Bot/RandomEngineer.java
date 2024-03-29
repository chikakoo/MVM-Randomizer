package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.Weapon;
import Pop.Enums.TFClasses;
import Pop.PopRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a randomly generated engineer
 */
public class RandomEngineer extends RandomBot {
    /**
     * Constructor
     */
    public RandomEngineer() {
        tfClass = TFClasses.ENGINEER;
        baseHealth = 300; // MVM engies have more health than the normal 125

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Engineer's Shotgun", "Shotgun"),
            new Weapon("The Frontier Justice"),
            //new Weapon("Festive Frontier Justice"), // In skins
            new Weapon("The Widowmaker"),
            new Weapon("The Pomson 6000", "Pomson"),
            new Weapon("The Rescue Ranger")
            //"Festive Shotgun 2014",
            //"Panic Attack Shotgun")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_PISTOL", "Pistol"),
            //new Weapon("TTG Max Pistol", "Max Pistol"), // In skins
            //new Weapon("The C.A.P.P.E.R."), // In skins
            new Weapon( "The Wrangler"),
            //new Weapon("Festive Wrangler"), // In skins
            //new Weapon("The Giger Counter"), // In skins
            new Weapon("The Short Circuit")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon( "Upgradeable TF_WEAPON_WRENCH", "Wrench"),
            //new Weapon("Festive Wrench 2011", "Festive Wrench"), // In skins
            new Weapon( "The Gunslinger"),
            new Weapon( "The Southern Hospitality"),
            new Weapon(  "The Jag"),
            new Weapon( "The Eureka Effect")
            //"Golden Wrench",
            //"Saxxy",
            //"Gold Frying Pan",
            //"Prinny Machete",
            //"Necro Smasher",
        ));

        classOnlyCosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("Mining Light"),
            new Cosmetic("Engineer's Cap", "Cap"),
            new Cosmetic("Texas Ten Gallon"),
            new Cosmetic("Engineer Welding Mask", "Welding Mask"),
            new Cosmetic("Engineer Earmuffs", "Earmuffs"),
            new Cosmetic("Buckaroos Hat"),
            new Cosmetic("Industrial Festivizer", "Festivised"),
            new Cosmetic("Big Country"),
            new Cosmetic("Googly Gazer"),
            new Cosmetic("Professor's Peculiarity"),
            new Cosmetic("Polish War Babushka"),
            new Cosmetic("Ol' Geezer"),
            new Cosmetic("Western Wear"),
            new Cosmetic("Clockwerk's Helm"),
            new Cosmetic("The Hat With No Name"),
            new Cosmetic("The Pencil Pusher"),
            new Cosmetic("The Virtual Reality Headset"),
            new Cosmetic("Buzz Killer"),
            new Cosmetic("The Brainiac Goggles"),
            new Cosmetic("The Brainiac Hairpiece"),
            new Cosmetic("The Tin-1000"),
            new Cosmetic("The Crafty Hair"),
            new Cosmetic("The Master Mind"),
            new Cosmetic("The Barnstormer"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Grizzled Growth"),
            new Cosmetic("The Last Straw"),
            new Cosmetic("Vox Diabolus"),
            new Cosmetic("The Wilson Weave"),
            new Cosmetic("The Data Mining Light"),
            new Cosmetic("The Plug-In Prospector"),
            new Cosmetic("Texas Tin-Gallon"),
            new Cosmetic("The Timeless Topper"),
            new Cosmetic("The Pardner's Pompadour"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("The Cuban Bristle Crisis"),
            new Cosmetic("The Gold Digger"),
            new Cosmetic("The Special Eyes"),
            new Cosmetic("The Viking Braider"),
            new Cosmetic("The Grease Monkey"),
            new Cosmetic("The Snaggletoothed Stetson"),
            new Cosmetic("Face Full of Festive"),
            new Cosmetic("The Scotch Saver"),
            new Cosmetic("The Trencher's Topper"),
            new Cosmetic("The Cute Suit"),
            new Cosmetic("The Danger"),
            new Cosmetic("The Level Three Chin"),
            new Cosmetic("The Peacenik's Ponytail"),
            new Cosmetic("Beep Man"),
            new Cosmetic("Garden Bristles"),
            new Cosmetic("Tiny Texan"),
            new Cosmetic("dec2014 engineer_detectiveglasses", "Detective Glasses"),
            new Cosmetic("Sheriff's Stetson"),
            new Cosmetic("El Patron"),
            new Cosmetic("Dead'er Alive"),
            new Cosmetic("Smokey Sombrero"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("The Corpus Christi Cranium"),
            new Cosmetic("The Wide-Brimmed Bandito"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("Flash of Inspiration"),
            new Cosmetic("Head Mounted Double Observatory", "Double Observatory"),
            new Cosmetic("Plumber's Cap"),
            new Cosmetic("Trucker's Topper"),
            new Cosmetic("Antarctic Eyewear"),
            new Cosmetic("The Cold Case"),
            new Cosmetic("A Shell of a Mann", "Shelled"),
            new Cosmetic("Dell in the Shell", "Turtle"),
            new Cosmetic("Aim Assistant"),
            new Cosmetic("Defragmenting Hard Hat 17%", "17%"),
            new Cosmetic("Mini-Engy", "Mini"),
            new Cosmetic("The Puggyback"),
            new Cosmetic("Brain Interface"),
            new Cosmetic("Texas Toast"),
            new Cosmetic("Eingineer"),
            new Cosmetic("El Mostacho"),
            new Cosmetic("The Trick Stabber"),
            new Cosmetic("Provisions Cap"),
            new Cosmetic("Telefragger Toque", "Telefragger"),
            new Cosmetic("Winter Wrap Up"),
            new Cosmetic("Head Of Defense", "Defensive Head"),
            new Cosmetic("Sophisticated Smoker"),
            new Cosmetic("The Boom Boxers"),
            new Cosmetic("The Ghoul Box"),
            new Cosmetic("Goblineer"),
            new Cosmetic("The Pug Mug"),
            new Cosmetic("Wavefinder"),
            new Cosmetic("Blitzen Bowl"),
            new Cosmetic("The Sightliner"),
            new Cosmetic("Computron 5000"),
            new Cosmetic("The Hook, Line, and Thinker", "Hooked"),
            new Cosmetic("Train Of Thought"),
            new Cosmetic("The Lawnmaker"),
            new Cosmetic("Cabinet Mann"),
            new Cosmetic("Dustbowl Devil"),
            new Cosmetic("More Gun Marshal", "More Gun"),
            new Cosmetic("The Pony Express")
        ));
    }

    /**
     * Bot engineers have more HP than the player class normally does
     */
    @Override
    protected void adjustAttributesForCustomBots() {
        health = PopRandomizer.generateNumberInRange(250, 550);
    }
}
