package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.TFClasses;
import Pop.PopRandomizer;
import Pop.RandomizerPresets;

import java.util.*;

/**
 * Represents a randomly generated spy
 */
public class RandomSpy extends RandomBot {
    /**
     * Constructor
     */
    public RandomSpy() {
        tfClass = TFClasses.SPY;
        baseHealth = 125;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("Upgradeable TF_WEAPON_REVOLVER", "Revolver"),
            new HitscanWeapon("Festive Revolver 2014", "Festive Revolver"),
            new HitscanWeapon("TTG Sam Revolver", "Sam Revolver"),
            new HitscanWeapon("The Ambassador"),
            new HitscanWeapon("Festive Ambassador"),
            new HitscanWeapon("L'Etranger"),
            new HitscanWeapon("The Enforcer"),
            new HitscanWeapon("The Diamondback")
        ));

        secondaryWeaponList = new ArrayList<>(
            // Spies cannot have sappers or it crashes!
//                Arrays.asList(
//            "Upgradeable TF_WEAPON_BUILDER_SPY",
//            "The Red-Tape Recorder",
//            "The Ap-Sap",
//            "Festive Sapper",
//            "The Snack Attack")
        );

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_KNIFE", "Knife"),
            new Weapon("Festive Knife 2011", "Festive Knife"),
            new Weapon("The Sharp Dresser"),
            new Weapon("The Black Rose"),
            new Weapon("Your Eternal Reward"),
            new Weapon("The Wanga Prick"),
            new Weapon("Conniver's Kunai"),
            new Weapon("The Big Earner"),
            new Weapon("The Spy-cicle")
//            "Gold Frying Pan",
//            "Prinny Machete",
//            "Saxxy")
        ));

        classOnlyCosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("Fancy Fedora"),
            new Cosmetic("Backbiter's Billycock"),
            new Cosmetic("Camera Beard"),
            new Cosmetic("Spy Noble Hair", "Nobled Haired"),
            new Cosmetic("Spy Beret", "Beret"),
            new Cosmetic("The Familiar Fez"),
            new Cosmetic("Detective Noir"),
            new Cosmetic("Le Party Phantom"),
            new Cosmetic("Spy Oni Mask"),
            new Cosmetic("Charmer's Chapeau"),
            new Cosmetic("Private Eye"),
            new Cosmetic("Janissary Hat"),
            new Cosmetic("Cosa Nostra Cap"),
            new Cosmetic("Belltower Spec Ops"),
            new Cosmetic("The Counterfeit Billycock"),
            new Cosmetic("L'Inspecteur"),
            new Cosmetic("The Spectre's Spectacles"),
            new Cosmetic("Griffin's Gog"),
            new Cosmetic("Under Cover"),
            new Cosmetic("The Doublecross-Comm"),
            new Cosmetic("The Ninja Cowl"),
            new Cosmetic("The Stealth Steeler"),
            new Cosmetic("Hat of Cards"),
            new Cosmetic("The Scarecrow"),
            new Cosmetic("The Dapper Disguise"),
            new Cosmetic("The Bloodhound"),
            new Cosmetic("Base Metal Billycock", "Metal Billycock"),
            new Cosmetic("Bootleg Base Metal Billycock", "Bootleg Billycock"),
            new Cosmetic("The Megapixel Beard"),
            new Cosmetic("The Pom-Pommed Provocateur"),
            new Cosmetic("The Belgian Detective"),
            new Cosmetic("The Harmburg"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("L'homme Burglerre"),
            new Cosmetic("The Candyman's Cap"),
            new Cosmetic("The Hyperbaric Bowler"),
            new Cosmetic("Ethereal Hood"),
            new Cosmetic("The Napoleon Complex"),
            new Cosmetic("The Deep Cover Operator"),
            new Cosmetic("The Aviator Assassin"),
            new Cosmetic("Facepeeler"),
            new Cosmetic("Nightmare Hunter"),
            new Cosmetic("Rogue's Rabbit"),
            new Cosmetic("Shadowman's Shade"),
            new Cosmetic("The Graylien"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("A Hat to Kill For"),
            new Cosmetic("The Dead Head"),
            new Cosmetic("Big Topper"),
            new Cosmetic("Brain-Warming Wear"),
            new Cosmetic("Reader's Choice"),
            new Cosmetic("The Upgrade"),
            new Cosmetic("Aristotle"),
            new Cosmetic("Murderer's Motif"),
            new Cosmetic("Harry"),
            new Cosmetic("Shutterbug"),
            new Cosmetic("Avian Amante"),
            new Cosmetic("Voodoo Vizier"),
            new Cosmetic("Bird's Eye Viewer"),
            new Cosmetic("Crabe de Chapeau"),
            new Cosmetic("Particulate Protector"),
            new Cosmetic("Crustaceous Cowl"),
            new Cosmetic("Computron 5000"),
            new Cosmetic("Gruesome Gourd"),
            new Cosmetic("Festive Cover-Up")
        ));
    }

    /**
     * Generates random weapons and weapon restrictions for the bot
     */
    @Override
    protected void generateRandomWeapons() {
        weaponRestrictions = RandomizerPresets.getWeaponRestrictionForRandomSpy();
        primaryWeapon = PopRandomizer.randomElement(primaryWeaponList);
        meleeWeapon = PopRandomizer.randomElement(meleeWeaponList);

        addWeapon(primaryWeapon);
        addWeapon(meleeWeapon);

        adjustWeaponAttributesForCustomBots();
        fixClassNameDueToRandomProjectileType();
    }

    /**
     * Gets the main weapon the spy will use - they default to melee and never have a secondary
     */
    @Override
    protected Weapon getMainWeapon() {
        switch(weaponRestrictions) {
            case PRIMARY_ONLY:
                return primaryWeapon;
            default:
                return meleeWeapon;
        }
    }
}
