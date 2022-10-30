package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.TFClasses;
import Pop.ModifierAttribute;
import Pop.PopRandomizer;

import java.util.*;

/**
 * Represents a randomly generated heavy
 */
public class RandomHeavy extends RandomBot {
    /**
     * Constructor
     */
    public RandomHeavy() {
        tfClass = TFClasses.HEAVY;
        baseHealth = 300;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_MINIGUN", "Minigun"),
            //new HitscanWeapon("Festive Minigun 2011", "Festive Minigun"), // In skins
            //new HitscanWeapon("Iron Curtain"), // In skins
            new HitscanWeapon("Natascha"),
            new HitscanWeapon("Tomislav"),
            new HitscanWeapon("The Huo Long Heatmaker", "Huo Long Heater"),
            new BrassBeast("The Brass Beast")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new AllClassShotgun("Heavy's Shotgun", "TF_WEAPON_SHOTGUN_HWG"),
            new AllClassShotgun("The Family Business", "TF_WEAPON_SHOTGUN_HWG", "Family Business"),
            new LunchBoxItem("The Buffalo Steak Sandvich", 20)

            // These seem to make the heavy eat forever - results in him getting stuck in spawn until you attack him
            // new LunchBoxItem("The Sandvich"),
            // new LunchBoxItem("Festive Sandvich"),
            // new LunchBoxItem("The Robo-Sandvich"),
            // new LunchBoxItem("The Dalokohs Bar"),
            // new LunchBoxItem("Fishcake"),

            //"Festive Shotgun 2014",
            //"Panic Attack Shotgun")
            //"The Second Banana")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_FISTS", "Fists"),
            new Weapon("Apoco-Fists", "Apoco-Fist"),
            new Weapon("The Killing Gloves of Boxing", "Boxing"),
            new Weapon("Gloves of Running Urgently MvM", "Running Urgently"),
            //new Weapon("The Bread Bite"), // Same as the Gloves of Running Urgently
            new Weapon("Warrior's Spirit"),
            new Weapon("Fists of Steel"),
            new Weapon("The Eviction Notice"),
            new Weapon("The Holiday Punch")
            //"Gloves of Running Urgently", // Too easy, drains their health
            //"Festive Gloves of Running Urgently", // Too easy, drains their health
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
            new Cosmetic("Football Helmet"),
            new Cosmetic("Officer's Ushanka"),
            new Cosmetic("Tough Guy's Toque"),
            new Cosmetic("Heavy Hair"),
            new Cosmetic("Heavy Do-rag"),
            new Cosmetic("Hard Counter"),
            new Cosmetic("Pugilist's Protector"),
            new Cosmetic("Cadaver's Cranium"),
            new Cosmetic("Poker Visor"),
            new Cosmetic("Big Chief"),
            new Cosmetic("Coupe D'isaster"),
            new Cosmetic("Magnificent Mongolian"),
            new Cosmetic("Heavy Topknot"),
            new Cosmetic("Large Luchadore"),
            new Cosmetic("The Team Captain"),
            new Cosmetic("Capone's Capper"),
            new Cosmetic("Big Steel Jaw of Summer Fun", "Steel Jaw"),
            new Cosmetic("Copper's Hard Top"),
            new Cosmetic("Security Shades"),
            new Cosmetic("Pilotka"),
            new Cosmetic("Dragonborn Helmet"),
            new Cosmetic("Storm Spirit's Jolly Hat", "Jolly Hat"),
            new Cosmetic("The Gym Rat"),
            new Cosmetic("The One-Man Army"),
            new Cosmetic("The Outdoorsman"),
            new Cosmetic("Can Opener"),
            new Cosmetic("Cold War Luchador"),
            new Cosmetic("War Head"),
            new Cosmetic("The All-Father"),
            new Cosmetic("The U-clank-a"),
            new Cosmetic("The Crafty Hair"),
            new Cosmetic("The Soviet Gentleman"),
            new Cosmetic("The Heavy Artillery Officer's Cap", "Officer's Cap"),
            new Cosmetic("The K-9 Mane"),
            new Cosmetic("The Grand Duchess Tiara"),
            new Cosmetic("Brock's Locks"),
            new Cosmetic("The Carl"),
            new Cosmetic("Heavy's Hockey Hair"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Pounding Father"),
            new Cosmetic("The Wilson Weave"),
            new Cosmetic("The Bunsen Brave"),
            new Cosmetic("The Gridiron Guardian"),
            new Cosmetic("The Tungsten Toque"),
            //new Cosmetic("The Bear Necessities"), // Glitchy
            new Cosmetic("The Gabe Glasses"),
            new Cosmetic("The Katyusha"),
            new Cosmetic("The Tsarboosh"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("The Cuban Bristle Crisis"),
            new Cosmetic("The Viking Braider"),
            new Cosmetic("The Chicken Kiev"),
            new Cosmetic("The Horned Honcho"),
            new Cosmetic("The Monstrous Mandible"),
            new Cosmetic("The Dictator"),
            new Cosmetic("Minnesota Slick"),
            new Cosmetic("Bullet Buzz"),
            new Cosmetic("The Eliminators Safeguard"),
            new Cosmetic("The Leftover Trap"),
            new Cosmetic("The Sammy Cap"),
            new Cosmetic("The Trash Man"),
            new Cosmetic("The War Goggles"),
            new Cosmetic("Polar Bear"),
            new Cosmetic("Wild West Whiskers"),
            new Cosmetic("The Sinner's Shade"),
            new Cosmetic("The War Eagle"),
            new Cosmetic("The Nuke"),
            new Cosmetic("Yeti_Head", "Yeti Head"),
            new Cosmetic("Fat Man's Field Cap"),
            new Cosmetic("Commando Elite"),
            new Cosmetic("The Aztec Aggressor"),
            new Cosmetic("Warhood"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("Pestering Jester"),
            new Cosmetic("Mo'Horn"),
            new Cosmetic("Mad Mask"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("Sucker Slug"),
            new Cosmetic("El Duderino"),
            new Cosmetic("White Russian"),
            new Cosmetic("dec2014 heavy_parka", "Parka"),
            new Cosmetic("dec2014 The Big Papa", "Big Papa"),
            new Cosmetic("EOTL_Flat_cap", "Flat Cap"),
            new Cosmetic("Minsk Beef"),
            new Cosmetic("Bull Locks"),
            new Cosmetic("The Unshaved Bear"),
            new Cosmetic("Yuri's Revenge"),
            new Cosmetic("Der Maschinensoldaten-Helm", "Maschinensoldaten"),
            new Cosmetic("Starboard Crusader"),
            new Cosmetic("Mann-O-War"),
            new Cosmetic("Cool Capuchon"),
            new Cosmetic("Mediterranean Mercenary"),
            new Cosmetic("Convict Cap"),
            new Cosmetic("Momma Kiev"),
            new Cosmetic("Sophisticated Smoker"),
            new Cosmetic("The Boom Boxers"),
            new Cosmetic("Mannvich"),
            new Cosmetic("Particulate Protector"),
            new Cosmetic("SandMann's Brush", "SandMann"),
            new Cosmetic("Snack Stack"),
            new Cosmetic("Two Punch Mann", "Two Punch"),
            new Cosmetic("Computron 5000"),
            new Cosmetic("Mooshanka"),
            new Cosmetic("Squatter's Right"),
            new Cosmetic("Horror Shawl"),
            new Cosmetic("Misha's Maw"),
            new Cosmetic("Road Rage")
        ));
    }

    /**
     * Adjust weapon attributes
     */
    @Override
    protected void adjustWeaponAttributesForCustomBots() {
        fixBrassBeast();
    }

    /**
     * Adjusts the movespeed penalty on the brass beast so that the standard bots don't just stand there
     */
    private void fixBrassBeast() {
        if (!isGiant && primaryWeapon instanceof BrassBeast) {
            ((BrassBeast)primaryWeapon).addMovementSpeedBonus();
        }
    }

    /**
     * Adjusts the movement speed of giant heavies so they aren't as fast as the other giants
     */
    @Override
    protected void adjustAttributesForCustomBots() {
        if (!isGiant) { return; }

        int moveSpeedIndex = characterAttributes.indexOf("move speed bonus");
        double baseSpeed = 0.6;
        ModifierAttribute speedAttribute = new ModifierAttribute("move speed bonus");

        if (moveSpeedIndex != -1) {
            speedAttribute = characterAttributes.get(moveSpeedIndex);
            baseSpeed = Double.parseDouble(characterAttributes.get(moveSpeedIndex).getValue());
        } else {
            characterAttributes.add(speedAttribute);
        }

        double newSpeed = baseSpeed - (PopRandomizer.generateNumberInRange(10, 30) / 100.0);
        speedAttribute.setValue(String.format("%.2g", newSpeed));
    }
}
