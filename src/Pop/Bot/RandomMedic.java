package Pop.Bot;
import Pop.Bot.Cosmetics.Cosmetic;
import Pop.Bot.Weapons.*;
import Pop.Enums.TFClasses;

import java.util.*;

/**
 * Represents a randomly generated medic
 */
public class RandomMedic extends RandomBot {
    /**
     * Constructor
     */
    public RandomMedic() {
        tfClass = TFClasses.MEDIC;
        baseHealth = 150;

        primaryWeaponList = new ArrayList<>(Arrays.asList(
            new HitscanWeapon("TF_WEAPON_SYRINGEGUN_MEDIC", "Syringe Gun"),
            new HitscanWeapon( "The Blutsauger"),
            new HitscanWeapon("The Overdose"),
            new NonHitscanWeapon("The Crusader's Crossbow", "Crossbow"),
            new NonHitscanWeapon( "Festive Crusader's Crossbow", "Festive Crossbow")
        ));

        secondaryWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_MEDIGUN", "Medigun"),
            new Weapon("Festive Medigun 2011", "Festive Medigun"),
            new Weapon("The Kritzkrieg"),
            new Weapon("The Quick-Fix")
            //"The Vaccinator") // Graphical glitch
        ));

        meleeWeaponList = new ArrayList<>(Arrays.asList(
            new Weapon("Upgradeable TF_WEAPON_BONESAW", "Bonesaw"),
            new Weapon("Festive Bonesaw 2014", "Festive Bonesaw"),
            new Weapon("The Ubersaw"),
            new Weapon("Festive Ubersaw"),
            new Weapon("The Vita-Saw"),
            new Weapon("The Amputator"),
            new Weapon("The Solemn Vow")
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
            new Cosmetic("Prussian Pickelhaube"),
            new Cosmetic("Otolaryngologist's Mirror", "Otolaryngologist"),
            new Cosmetic("Vintage Tyrolean"),
            new Cosmetic("Medic Mask", "Masked"),
            new Cosmetic("Medic Gatsby", "Gatspy"),
            new Cosmetic("Medic Goggles", "Goggles"),
            new Cosmetic("Berliner's Bucket Helm", "Bucket Helm"),
            new Cosmetic("Blighted Beak"),
            new Cosmetic("German Gonzila"),
            new Cosmetic("Medic Geisha Hair", "Geisha Hair"),
            new Cosmetic("Grimm Hatte"),
            new Cosmetic("Medic's Mountain Cap", "Mountain Cap"),
            new Cosmetic("Private Eye"),
            new Cosmetic("Doctor's Sack"),
            new Cosmetic("The Team Captain"),
            new Cosmetic("Medic MtG Hat"),
            new Cosmetic("The Surgeon's Stahlhelm"),
            new Cosmetic("Dr. Gogglestache"),
            new Cosmetic("Einstein"),
            new Cosmetic("The All-Father"),
            new Cosmetic("The Nine-Pipe Problem"),
            new Cosmetic("The Gentleman's Ushanka"),
            new Cosmetic("The Crafty Hair"),
            new Cosmetic("Medi-Mask"),
            new Cosmetic("The Combat Medic's Crusher Cap", "Crusher Cap"),
            new Cosmetic("The Mutton Mann"),
            new Cosmetic("The Wilson Weave"),
            new Cosmetic("The Byte'd Beak"),
            new Cosmetic("Halogen Head Lamp"),
            new Cosmetic("Platinum Pickelhaube"),
            new Cosmetic("Practitioner's Processing Mask", "Processing Mask"),
            new Cosmetic("The Steam Pipe"),
            new Cosmetic("Titanium Tyrolean"),
            new Cosmetic("The Virus Doctor"),
            new Cosmetic("The Weather Master"),
            new Cosmetic("The Powdered Practitioner"),
            new Cosmetic("Baron von Havenaplane"),
            new Cosmetic("Das Gutenkutteharen", "Gutenkutteharen"),
            //new Cosmetic("Das Hazmattenhatten", "Hazmattenhatten"), // Glitchy looking
            new Cosmetic("Das Maddendoktor", "Maddendoktor"),
            new Cosmetic("Das Naggenvatcher", "Naggenvatcher"),
            new Cosmetic("Das Ubersternmann", "Ubersternmann"),
            new Cosmetic("The Macho Mann"),
            new Cosmetic("A Brush with Death"),
            new Cosmetic("The Slick Cut"),
            new Cosmetic("The Alternative Medicine Mann", "Medicine Mann"),
            new Cosmetic("Das Blutliebhaber", "Blutliebhaber"),
            new Cosmetic("Medimedes"),
            new Cosmetic("The Second Opinion"),
            new Cosmetic("The Shaman's Skull"),
            new Cosmetic("Teutonkahmun"),
            new Cosmetic("The Trepanabotomizer"),
            new Cosmetic("The Nunhood"),
            new Cosmetic("The Ruffled Ruprecht"),
            new Cosmetic("The Fashionable Megalomaniac"),
            new Cosmetic("Heer's Helmet"),
            new Cosmetic("The Teutonic Toque"),
            new Cosmetic("Hundekopf"),
            new Cosmetic("Ze Ubermensch", "Ubermensch"),
            new Cosmetic("Transylvanian Toupe"),
            new Cosmetic("dec2014 Surgeon's Shako", "Surgeon's Shako"),
            new Cosmetic("dec2014 medic_unknown_mann", "Unknown Mann"),
            new Cosmetic("The Physician's Protector"),
            new Cosmetic("Teufort Knight"),
            new Cosmetic("Berlin Brain Bowl"),
            new Cosmetic("The Gauzed Gaze"),
            new Cosmetic("Colossal Cranium"),
            new Cosmetic("Field Practice"),
            new Cosmetic("Battle Boonie"),
            new Cosmetic("Coldfront Commander")
            //"The Mann of Reason", // Glitchy looking
        ));
    }
}
