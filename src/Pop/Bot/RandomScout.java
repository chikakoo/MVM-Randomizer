package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.TFClasses;

import java.util.*;

/**
 * Represents a randomly generated scout
 */
public class RandomScout extends RandomBot {
    /**
     * Constructor
     */
    public RandomScout() {
        tfClass = TFClasses.SCOUT;
        baseHealth = 125;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_SCATTERGUN", "Scattergun"),
            new HitscanWeapon("Festive Scattergun 2011", "Festive Scattergun"),
            new HitscanWeapon("The Force-a-Nature"),
            new HitscanWeapon("Festive Force-a-Nature"),
            new HitscanWeapon("The Shortstop"),
            new HitscanWeapon("The Soda Popper"),
            new HitscanWeapon("Baby Face's Blaster"),
            new HitscanWeapon( "The Back Scatter")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_PISTOL", "Pistol"),
            new HitscanWeapon("TTG Max Pistol", "Lugermorph"),
            new HitscanWeapon("The C.A.P.P.E.R."),
            new HitscanWeapon("The Winger"),
            new HitscanWeapon("Pretty Boy's Pocket Pistol", "Pocket Pistol"),
            new Guillotine("The Flying Guillotine", "Guillotine"),
            new DrinkItem("Bonk! Atomic Punch", "Bonk", 10),
            new DrinkItem("Festive Bonk 2014", "Festive Bonk", 10),
            new DrinkItem("Crit-a-Cola"),
            new DrinkItem("Mad Milk"),
            new DrinkItem("Mutated Milk")
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_BAT", "Bat"),
            new Weapon("Festive Bat 2011", "Festive Bat"),
            new Weapon("The Holy Mackerel"),
            new Weapon("Festive Holy Mackerel"),
            new Weapon("Unarmed Combat"),
            new Weapon("Batsaber"),
            new Weapon("The Sandman"),
            new Weapon("The Candy Cane"),
            new Weapon("The Boston Basher"),
            new Weapon("Three-Rune Blade"),
            new Weapon("Sun-on-a-Stick"),
            new Weapon("The Fan O'War"),
            new Weapon("The Wrap Assassin")
//            "Saxxy",
//            "The Atomizer",
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
            new Cosmetic("Batter's Helmet"),
            new Cosmetic("Bonk Helm"),
            new Cosmetic("Ye Olde Baker Boy"),
            new Cosmetic("Troublemaker's Tossle Cap", "Tossle Cap"),
            new Cosmetic("Scout Whoopee Cap"),
            new Cosmetic("Bombing Run"),
            new Cosmetic("The Milkman"),
            new Cosmetic("Flipped Trilby"),
            new Cosmetic("MNC Mascot Hat"),
            new Cosmetic("Hero's Tail"),
            new Cosmetic("Scout MtG Hat"),
            new Cosmetic("Bonk Boy"),
            new Cosmetic("The El Jefe"),
            new Cosmetic("The Backwards Ballcap"),
            new Cosmetic("The Hermes"),
            new Cosmetic("The Stereoscopic Shades"),
            new Cosmetic("Wrap Battler"),
            new Cosmetic("The Big Elfin Deal"),
            new Cosmetic("The Front Runner"),
            new Cosmetic("The Cross-Comm Express"),
            new Cosmetic("The Fed-Fightin' Fedora"),
            new Cosmetic("The Void Monk Hair"),
            new Cosmetic("The Robot Running Man"),
            new Cosmetic("The Crafty Hair"),
            new Cosmetic("The Hanger-On Hood"),
            new Cosmetic("The Wilson Weave"),
            new Cosmetic("The Bolt Boy"),
            new Cosmetic("Bonk Leadwear"),
            new Cosmetic("Ye Oiled Baker Boy"),
            new Cosmetic("The Bacteria Blocker"),
            new Cosmetic("The Beastly Bonnet"),
            new Cosmetic("Greased Lightning"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("The Face Plante"),
            new Cosmetic("The Halloweiner"),
            new Cosmetic("The Horrific Head of Hare", "Head of Hare"),
            new Cosmetic("The Hound's Hood"),
            new Cosmetic("Runner's Warm-Up"),
            new Cosmetic("The Scout Shako"),
            new Cosmetic("The Frickin' Sweet Ninja Hood", "Ninja Hood"),
            new Cosmetic("The Pomade Prince"),
            new Cosmetic("The Alien Cranium"),
            new Cosmetic("Thirst Blood"),
            new Cosmetic("Head Hunter"),
            new Cosmetic("Nugget Noggin"),
            new Cosmetic("dec2014 Marauders Mask", "Marauder's Mask"),
            new Cosmetic("Fortunate Son"),
            new Cosmetic("Cadet Visor"),
            new Cosmetic("B'aaarrgh-n-Bicorne"),
            new Cosmetic("Death Racer's Helmet"),
            new Cosmetic("Sidekick's Side Slick", "Side Slick"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("The Airdog"),
            new Cosmetic("Herald's Helm"),
            new Cosmetic("Pestering Jester"),
            new Cosmetic("The Wing Mann"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("The Lightning Lid"),
            new Cosmetic("Trucker's Topper")
        ));
    }
}
