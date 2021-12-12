package Pop.Bot.Weapons.Skins;

import Pop.Bot.Weapons.Weapon;
import Pop.PopRandomizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Contains the list of all the alternate weapon skins and some helper functions
 */
public class WeaponSkins {
    /**
     * All the pistols
     */
    private static ArrayList<WeaponSkin> AlternatePistols = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_PISTOL", "Pistol"),
        new WeaponSkin("TTG Max Pistol", "Lugermorph"),
        new WeaponSkin("The C.A.P.P.E.R.", "C.A.P.P.E.R"),
        new WeaponSkin("concealedkiller_pistol_redrockroscoe", "Red Rock Pistol"),
        new WeaponSkin("craftsmann_pistol_homemadeheater", "Heater Pistol"),
        new WeaponSkin("teufort_pistol_hickoryholepuncher", "Hickory Pistol"),
        new WeaponSkin("teufort_pistol_localhero", "Local Hero Pistol"),
        new WeaponSkin("powerhouse_pistol_blackdahlia", "Black Dahlia Pistol"),
        new WeaponSkin("powerhouse_pistol_sandstonespecial", "Standstone Pistol"),
        new WeaponSkin("harvest_pistol_macabreweb", "Macabre Web Pistol"),
        new WeaponSkin("harvest_pistol_nutcracker", "Nutcracker Pistol"),
        new WeaponSkin("gentlemanne_pistol_dressedtokill", "Dressed Pistol"),
        new WeaponSkin("pyroland_pistol_bluemew", "Blue Mew Pistol"),
        new WeaponSkin("pyroland_pistol_shottohell", "Hell Pistol"),
        new WeaponSkin("pyroland_pistol_braincandy", "Brain Candy Pistol"),
        new WeaponSkin("warbird_pistol_blitzkrieg", "Blitzkrieg Pistol")
    ));

    /**
     * All the Rocket Launchers
     */
    private static ArrayList<WeaponSkin> AlternateRocketLaunchers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_ROCKETLAUNCHER", "Rocket Launcher"),
        new WeaponSkin("Festive Rocket Launcher 2011", "Festive Rocket Launcher"),
        new WeaponSkin("The Original", "Original"),
        new WeaponSkin("concealedkiller_rocketlauncher_sandcannon", "Sand Cannon Rocket"),
        new WeaponSkin("concealedkiller_rocketlauncher_woodlandwarrior", "Woodland Rocket"),
        new WeaponSkin("craftsmann_rocketlauncher_americanpastoral", "American Rocket"),
        new WeaponSkin("teufort_rocketlauncher_smalltownbringdown", "Small Town Rocket"),
        new WeaponSkin("powerhouse_rocketlauncher_shellshocker", "Shell Shocker Rocket"),
        new WeaponSkin("powerhouse_rocketlauncher_aquamarine", "Aquamarine Rocket"),
        new WeaponSkin("harvest_rocketlauncher_autumn", "Autumn Rocket"),
        new WeaponSkin("gentlemanne_rocketlauncher_coffinnail", "Coffin Nail Rocket"),
        new WeaponSkin("gentlemanne_rocketlauncher_highrollers", "High Roller Rocket"),
        new WeaponSkin("pyroland_rocketlauncher_bluemew", "Blue Mew Rocket"),
        new WeaponSkin("pyroland_rocketlauncher_braincandy", "Brain Candy Rocket"),
        new WeaponSkin("warbird_rocketlauncher_warhawk", "Warhawk Rocket")
    ));

    /**
     * All the sticky launchers
     */
    private static ArrayList<WeaponSkin> AlternateStickyLaunchers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER", "Sticky Launcher"),
        new WeaponSkin("Festive Stickybomb Launcher 2011", "Festive Sticky"),
        new WeaponSkin("concealedkiller_stickybomblauncher_suddenflurry", "Flurry Sticky"),
        new WeaponSkin("concealedkiller_stickybomblauncher_carpetbomber", "Carpet Sticky"),
        new WeaponSkin("craftsmann_stickybomblauncher_blastedbombardier", "Bombardier Sticky"),
        new WeaponSkin("teufort_stickybomblauncher_rooftopwrangler", "Rooftop Sticky"),
        new WeaponSkin( "powerhouse_stickybomblauncher_liquidasset", "Liquid Sticky"),
        new WeaponSkin( "powerhouse_stickybomblauncher_pinkelephant", "Elephant Sticky"),
        new WeaponSkin( "harvest_stickybomblauncher_pumpkinpatch", "Pumpkin Sticky"),
        new WeaponSkin( "harvest_stickybomblauncher_macabreweb", "Macabre Web Sticky"),
        new WeaponSkin( "harvest_stickybomblauncher_autumn", "Autumn Sticky"),
        new WeaponSkin("gentlemanne_stickybomblauncher_coffinnail", "Coffin Nail Sticky"),
        new WeaponSkin("gentlemanne_stickybomblauncher_dressedtokill", "Dressed Sticky"),
        new WeaponSkin("pyroland_stickybomblauncher_sweetdreams", "Sweet Sticky"),
        new WeaponSkin( "warbird_stickybomblauncher_blitzkrieg", "Blitzkrieg Sticky")
    ));

    /**
     * All the revolvers
     */
    private static ArrayList<WeaponSkin> AlternateRevolvers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_REVOLVER", "Revolver"),
        new WeaponSkin("Festive Revolver 2014", "Festive Revolver"),
        new WeaponSkin("TTG Sam Revolver", "Sam Revolver"),
        new WeaponSkin("concealedkiller_revolver_psychedelicslugger", "Psychedelic Revolver"),
        new WeaponSkin("craftsmann_revolver_oldcountry", "Old Country Revolver"),
        new WeaponSkin("teufort_revolver_mayor", "Mayor Revolver"),
        new WeaponSkin("powerhouse_revolver_deadreckoner", "Dead Revolver"),
        new WeaponSkin("harvest_revolver_boneyard", "Boneyard Revolver"),
        new WeaponSkin("harvest_revolver_macabreweb", "Macabre Web Revolver"),
        new WeaponSkin("harvest_revolver_wildwood", "Wildwood Revolver"),
        new WeaponSkin("gentlemanne_revolver_topshelf", "Top Shelf Revolver"),
        new WeaponSkin("gentlemanne_revolver_coffinnail", "Coffin Nail Revolver"),
        new WeaponSkin("pyroland_revolver_flowerpower", "Flower Revolver"),
        new WeaponSkin("warbird_revolver_blitzkrieg", "Blitzkrieg Revolver")
    ));

    /**
     * All the sniper rifles
     */
    private static ArrayList<WeaponSkin> AlternateSniperRifles = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_SNIPERRIFLE", "Sniper Rifle"),
        new WeaponSkin("Festive Sniper Rifle 2011", "Festive Sniper Rifle"),
        new WeaponSkin("The AWPer Hand", "AWPer Hand"),
        new WeaponSkin("concealedkiller_sniperrifle_purplerange", "Purple Rifle"),
        new WeaponSkin("concealedkiller_sniperrifle_nightowl", "Night Owl Rifle"),
        new WeaponSkin("craftsmann_sniperrifle_lumberfromdownunder", "Lumber Rifle"),
        new WeaponSkin("craftsmann_sniperrifle_shotinthedark", "Dark Rifle"),
        new WeaponSkin("teufort_sniperrifle_bogtrotter", "Bog Rifle"),
        new WeaponSkin("powerhouse_sniperrifle_thunderbolt", "Thunderbolt Rifle"),
        new WeaponSkin("harvest_sniperrifle_boneyard", "Boneyard Rifle"),
        new WeaponSkin("harvest_sniperrifle_pumpkinpatch", "Pumpkin Rifle"),
        new WeaponSkin("harvest_sniperrifle_wildwood", "Wildwood Rifle"),
        new WeaponSkin("gentlemanne_sniperrifle_coffinnail", "Coffin Nail Rifle"),
        new WeaponSkin("gentlemanne_sniperrifle_dressedtokill", "Dressed Rifle"),
        new WeaponSkin("pyroland_sniperrifle_rainbow", "Rainbow Rifle"),
        new WeaponSkin("pyroland_sniperrifle_balloonicorn", "Balloonicorn Rifle"),
        new WeaponSkin("warbird_sniperrifle_airwolf", "Airwolf Rifle")
    ));

    /**
     * All the scatterguns
     */
    private static ArrayList<WeaponSkin> AlternateScatterguns = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_SCATTERGUN", "Scattergun"),
        new WeaponSkin("Festive Scattergun 2011", "Festive Scattergun"),
        new WeaponSkin("concealedkiller_scattergun_nightterror", "Night Scattergun"),
        new WeaponSkin("craftsmann_scattergun_tartantorpedo", "Torpedo Scattergun"),
        new WeaponSkin("craftsmann_scattergun_countrycrusher", "Country Scattergun"),
        new WeaponSkin("craftsmann_scattergun_backcountryblaster", "Blaster Scattergun"),
        new WeaponSkin("teufort_scattergun_sprucedeuce", "Deuce Scattergun"),
        new WeaponSkin("powerhouse_scattergun_currentevent", "Event Scattergun"),
        new WeaponSkin("harvest_scattergun_macabreweb", "Macabre Web Scattergun"),
        new WeaponSkin("harvest_scattergun_nutcracker", "Nutcracker Scattergun"),
        new WeaponSkin("gentlemanne_scattergun_coffinnail", "Coffin Nail Scattergun"),
        new WeaponSkin("pyroland_scattergun_bluemew", "Blue Mew Scattergun"),
        new WeaponSkin("pyroland_scattergun_shottohell", "Hell Scattergun"),
        new WeaponSkin("pyroland_scattergun_flowerpower", "Flower Scattergun"),
        new WeaponSkin("warbird_scattergun_killerbee", "Bee Scattergun"),
        new WeaponSkin("warbird_scattergun_corsair", "Corsair Scattergun")
    ));

    /**
     * All the flamethrowers
     */
    private static ArrayList<WeaponSkin> AlternateFlamethrowers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_FLAMETHROWER", "Flamethrower"),
        new WeaponSkin("Festive Flamethrower 2011", "Festive Flamethrower"),
        new WeaponSkin("The Rainblower", "Rainblower"),
        new WeaponSkin("The Nostromo Napalmer", "Nostromo Napalmer"),
        new WeaponSkin("concealedkiller_flamethrower_forestfire", "Forest Flamethwoer"),
        new WeaponSkin("craftsmann_flamethrower_barnburner", "Barn Flamethrower"),
        new WeaponSkin("teufort_flamethrower_bovineblazemaker", "Bovine Flamethrower"),
        new WeaponSkin("teufort_flamethrower_earthskyandfire", "Element Flamethrower"),
        new WeaponSkin("powerhouse_flamethrower_flashfryer", "Flash Flamethrower"),
        new WeaponSkin("powerhouse_flamethrower_turbinetorcher", "Turbine Flamethrower"),
        new WeaponSkin("harvest_flamethrower_pumpkinpatch", "Pumpkin Flamethrower"),
        new WeaponSkin("harvest_flamethrower_autumn", "Autumn Flamethrower"),
        new WeaponSkin("harvest_flamethrower_nutcracker", "Nutcracker Flamethrower"),
        new WeaponSkin("gentlemanne_flamethrower_coffinnail", "Coffin Flamethrower"),
        new WeaponSkin("pyroland_flamethrower_rainbow", "Rainbow Flamethrower"),
        new WeaponSkin("pyroland_flamethrower_balloonicorn", "Balloonicorn Flamethrower"),
        new WeaponSkin("warbird_flamethrower_warhawk", "Warhawk Flamethrower")
    ));

    /**
     * All the mediguns
     */
    private static ArrayList<WeaponSkin> AlternateMediguns = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_MEDIGUN", "Medigun"),
        new WeaponSkin("Festive Medigun 2011", "Festive Medigun"),
        new WeaponSkin("concealedkiller_medigun_wrappedreviver", "Wrapped Medigun"),
        new WeaponSkin("concealedkiller_medigun_maskedmender", "Masked Medigun"),
        new WeaponSkin("craftsmann_medigun_reclaimedreanimator", "Reclaimed Medigun"),
        new WeaponSkin("teufort_medigun_civilservant", "Cibil Medigun"),
        new WeaponSkin("powerhouse_medigun_sparkoflife", "Life Medigun"),
        new WeaponSkin("harvest_medigun_wildwood", "Wildwood Medigun"),
        new WeaponSkin("gentlemanne_medigun_highrollers", "Highrollers Medigun"),
        new WeaponSkin("gentlemanne_medigun_coffinnail", "Coffin Nail Medigun"),
        new WeaponSkin("gentlemanne_medigun_dressedtokill", "Dressed Medigun"),
        new WeaponSkin("pyroland_medigun_flowerpower", "Flower Medigun"),
        new WeaponSkin("warbird_medigun_corsair", "Corsair Medigun"),
        new WeaponSkin("warbird_medigun_blitzkrieg", "Blitzkrieg Medigun")
    ));

    /**
     * All the grenade launchers
     */
    private static ArrayList<WeaponSkin> AlternateGrenadeLaunchers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_GRENADELAUNCHER", "Grenade Launcher"),
        new WeaponSkin("Festive Grenade Launcher", "Festive Launcher"),
        new WeaponSkin("harvest_grenadelauncher_macabreweb", "Macabre Web Grenade"),
        new WeaponSkin("harvest_grenadelauncher_autumn", "Autumn Grenade"),
        new WeaponSkin("gentlemanne_grenadelauncher_topshelf", "Top Shelf Grenade"),
        new WeaponSkin("gentlemanne_grenadelauncher_coffinnail", "Coffin Nail Grenade"),
        new WeaponSkin("pyroland_grenadelauncher_rainbow", "Rainbow Grenade"),
        new WeaponSkin("pyroland_grenadelauncher_sweetdreams", "Sweet Grenade"),
        new WeaponSkin("warbird_grenadelauncher_warhawk", "Warhawk Grenade"),
        new WeaponSkin("warbird_grenadelauncher_butcherbird", "Butcher Grenade")
    ));

    /**
     * All the wrenches
     */
    private static ArrayList<WeaponSkin> AlternateWrench = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_WRENCH", "Wrench"),
        new WeaponSkin("Festive Wrench 2011", "Festive Wrench"),
        new WeaponSkin("harvest_wrench_boneyard", "Bonehard Wrench"),
        new WeaponSkin("harvest_wrench_autumn", "Autumn Wrench"),
        new WeaponSkin("harvest_wrench_nutcracker", "Nutcracker Wrench"),
        new WeaponSkin("gentlemanne_wrench_topshelf", "Top Shelf Wrench"),
        new WeaponSkin("gentlemanne_wrench_dressedtokill", "Dressed Wrench"),
        new WeaponSkin("pyroland_wrench_torquedtohell", "Torqued Wrench"),
        new WeaponSkin("warbird_wrench_airwolf", "Airwolf Wrench")
    ));

    /**
     * All the SMGs
     */
    private static ArrayList<WeaponSkin> AlternateSMGs = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_SMG", "SMG"),
        new WeaponSkin("Festive SMG 2014", "Festive SMG"),
        new WeaponSkin("concealedkiller_smg_woodsywidowmaker", "Woodsy SMG"),
        new WeaponSkin("craftsmann_smg_plaidpotshotter", "Potshotter SMG"),
        new WeaponSkin("teufort_smg_treadplatetormenter", "Plate SMG"),
        new WeaponSkin("teufort_smg_teamsprayer", "Sprayer SMG"),
        new WeaponSkin("powerhouse_smg_lowprofile", "Low Profile SMG"),
        new WeaponSkin("harvest_smg_wildwood", "Wildwood SMG"),
        new WeaponSkin("gentlemanne_smg_highrollers", "High Rollers SMG"),
        new WeaponSkin("pyroland_smg_bluemew", "Blue Mew SMG"),
        new WeaponSkin("warbird_smg_blitzkrieg", "Blitzkrieg SMG")
    ));

    /**
     * All the knives
     */
    private static ArrayList<WeaponSkin> AlternateKnives = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_KNIFE", "Knife"),
        new WeaponSkin("Festive Knife 2011", "Festive Knife"),
        new WeaponSkin("The Sharp Dresser", "Sharp Dresser"),
        new WeaponSkin("The Black Rose", "Black Rose"),
        new WeaponSkin("harvest_knife_boneyard", "Boneyard Knife"),
        new WeaponSkin("gentlemanne_knife_topshelf", "Topshelf Knife"),
        new WeaponSkin("gentlemanne_knife_dressedtokill", "Dressed Knife"),
        new WeaponSkin("pyroland_knife_bluemew", "Blue Mew Knife"),
        new WeaponSkin("pyroland_knife_stabbedtohell", "Stabbed Knife"),
        new WeaponSkin("pyroland_knife_braincandy", "Brain Candy Knife"),
        new WeaponSkin("warbird_knife_airwolf", "Airwolf Knife"),
        new WeaponSkin("warbird_knife_blitzkrieg", "Blitzkrieg Knife")
    ));

    /**
     * All the miniguns
     */
    private static ArrayList<WeaponSkin> AlternateMiniguns = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Upgradeable TF_WEAPON_MINIGUN", "Minigun"),
        new WeaponSkin("Festive Minigun 2011", "Festive Minigun"),
        new WeaponSkin("Iron Curtain", "Iron Curtain"),
        new WeaponSkin("concealedkiller_minigun_kingofthejungle", "Jungle Minigun"),
        new WeaponSkin("craftsmann_minigun_ironwood", "Ironwood Minigun"),
        new WeaponSkin("craftsmann_minigun_antiqueannihilator", "Antique Minigun"),
        new WeaponSkin("teufort_minigun_warroom", "Warroom Minigun"),
        new WeaponSkin("teufort_minigun_citizenpain", "Citizen Minigun"),
        new WeaponSkin("powerhouse_minigun_brickhouse", "Brick House Minigun"),
        new WeaponSkin("harvest_minigun_pumpkinpatch", "Pumpin Minigun"),
        new WeaponSkin("harvest_minigun_macabreweb", "Macabre Web Minigun"),
        new WeaponSkin("harvest_minigun_nutcracker", "Nutcracker Minigun"),
        new WeaponSkin("gentlemanne_minigun_topshelf", "Top Shelf Minigun"),
        new WeaponSkin("gentlemanne_minigun_coffinnail", "Coffin Nail Minigun"),
        new WeaponSkin("gentlemanne_minigun_dressedtokill", "Dressed Minigun"),
        new WeaponSkin("pyroland_minigun_mistercuddles", "Cuddles Minigun"),
        new WeaponSkin("pyroland_minigun_braincandy", "Brain Candy Minigun"),
        new WeaponSkin("warbird_minigun_butcherbird", "Butcher Minigun")
    ));

    /**
     * All the shotguns
     * Note currently used - if this does get used, need to deal with all the different class names for it
     */
    private static ArrayList<WeaponSkin> AlternateShotguns = new ArrayList<>(Arrays.asList(
        new WeaponSkin("concealedkiller_shotgun_backwoodsboomstick", "Boomstick Shotgun"),
        new WeaponSkin("craftsmann_shotgun_rusticruiner", "Rustic Shotgun"),
        new WeaponSkin("teufort_shotgun_civicduty", "Civic Shotgun"),
        new WeaponSkin("powerhouse_shotgun_lightningrod", "Lightning Shotgun"),
        new WeaponSkin("harvest_shotgun_autumn", "Autumn Shotgun"),
        new WeaponSkin("gentlemanne_shotgun_coffinnail", "Coffin Nail Shotgun"),
        new WeaponSkin("gentlemanne_shotgun_dressedtokill", "Dressed Shotgun"),
        new WeaponSkin("pyroland_shotgun_flowerpower", "Flower Shotgun"),
        new WeaponSkin("warbird_shotgun_redbear", "Red Bear Shotgun")
    ));

    /**
     * All the chargin' targes
     */
    private static ArrayList<WeaponSkin> AlternateCharginTarges = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Chargin' Targe", "Chargin' Targe"),
        new WeaponSkin("Festive Targe 2014", "Festive Targe")
    ));

    /**
     * All the frontier justices
     */
    private static ArrayList<WeaponSkin> AlternateFrontierJustices = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Frontier Justice", "Frontier Justice"),
        new WeaponSkin("Festive Frontier Justice", "Festive Frontier Justice")
    ));

    /**
     * All the wranglers
     */
    private static ArrayList<WeaponSkin> AlternateWranglers = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Wrangler", "Wrangler"),
        new WeaponSkin("Festive Wrangler", "Festive Wrangler"),
        new WeaponSkin("The Giger Counter", "Giger Counter")
    ));

    /**
     * All the crossbows
     */
    private static ArrayList<WeaponSkin> AlternateCrossbows = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Crusader's Crossbow", "Crossbow"),
        new WeaponSkin("Festive Crusader's Crossbow", "Festive Crossbow")
    ));

    /**
     * All the backburners
     */
    private static ArrayList<WeaponSkin> AlternateBackburners = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Backburner", "Backburner"),
        new WeaponSkin("Festive Backburner 2014", "Festive Backburner")
    ));

    /**
     * All the flare guns
     */
    private static ArrayList<WeaponSkin> AlternateFlareGuns = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Flare Gun", "Flare Gun"),
        new WeaponSkin("Festive Flare Gun", "Festive Flare Gun")
    ));

    /**
     * All the force-a-natures
     */
    private static ArrayList<WeaponSkin> AlternateForceANatures = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Force-a-Nature", "Force-a-Nature"),
        new WeaponSkin("Festive Force-a-Nature", "Festive Force-a-Nature")
    ));

    /**
     * All the bonks
     */
    private static ArrayList<WeaponSkin> AlternateBonks = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Bonk! Atomic Punch", "Bonk"),
        new WeaponSkin("Festive Bonk 2014", "Festive Bonk")
    ));

    /**
     * All the mad milks
     */
    private static ArrayList<WeaponSkin> AlternateMadMilks = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Mad Milk", "Mad Milk"),
        new WeaponSkin("Mutated Milk", "Mutated Milk")
    ));

    /**
     * All the huntsmans
     */
    private static ArrayList<WeaponSkin> AlternateHuntsmans = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Huntsman", "Huntsman"),
        new WeaponSkin("The Fortified Compound", "Fortified Compound")
    ));

    /**
     * All the jarates
     */
    private static ArrayList<WeaponSkin> AlternateJarates = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Jarate", "Jarate"),
        new WeaponSkin("Festive Jarate", "Festive Jarate"),
        new WeaponSkin("The Self-Aware Beauty Mark", "Beauty Mark")
    ));

    /**
     * All the black boxes
     */
    private static ArrayList<WeaponSkin> AlternateBlackBoxes = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Black Box", "Black Box"),
        new WeaponSkin("Festive Black Box","Festive Black Box")
    ));

    /**
     * All the buff banners
     */
    private static ArrayList<WeaponSkin> AlternateBuffBanners = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Buff Banner", "Buff Banner"),
        new WeaponSkin("Festive Buff Banner", "Festive Buff Banner")
    ));

    /**
     * All the ambassadors
     */
    private static ArrayList<WeaponSkin> AlternateAmbassadors = new ArrayList<>(Arrays.asList(
        new WeaponSkin("The Ambassador", "Ambassador"),
        new WeaponSkin("Festive Ambassador", "Festive Ambassador")
    ));

    /**
     * All the eternal rewards
     */
    private static ArrayList<WeaponSkin> AlternateEternalRewards = new ArrayList<>(Arrays.asList(
        new WeaponSkin("Your Eternal Reward", "Your Eternal Reward"),
        new WeaponSkin("The Wanga Prick", "Wanga Prick")
    ));

    /**
     * Gets a random skin from the list
     * @param skins - The skins to choose from
     * @return - The random skin
     */
    private static WeaponSkin GetRandomSkin(ArrayList<WeaponSkin> skins) {
        return PopRandomizer.randomElement(skins);
    }

    /**
     * Gets a random skin from the given weapon name
     * @return - A random skin if the weapon name maps to one - otherwise, returns null
     */
    public static WeaponSkin GetRandomSkinFromWeaponName(String weaponName) {
        WeaponSkin skin = null;
        switch(weaponName) {
            case "Upgradeable TF_WEAPON_PISTOL":
                skin = GetRandomSkin(AlternatePistols);
                break;
            case "Upgradeable TF_WEAPON_ROCKETLAUNCHER":
                skin = GetRandomSkin(AlternateRocketLaunchers);
                break;
            case "Upgradeable TF_WEAPON_PIPEBOMBLAUNCHER":
                skin = GetRandomSkin(AlternateStickyLaunchers);
                break;
            case "Upgradeable TF_WEAPON_REVOLVER":
                skin = GetRandomSkin(AlternateRevolvers);
                break;
            case "Upgradeable TF_WEAPON_SNIPERRIFLE":
                skin = GetRandomSkin(AlternateSniperRifles);
                break;
            case "Upgradeable TF_WEAPON_SCATTERGUN":
                skin = GetRandomSkin(AlternateScatterguns);
                break;
            case "Upgradeable TF_WEAPON_FLAMETHROWER":
                skin = GetRandomSkin(AlternateFlamethrowers);
                break;
            case "Upgradeable TF_WEAPON_MEDIGUN":
                skin = GetRandomSkin(AlternateMediguns);
                break;
            case "Upgradeable TF_WEAPON_GRENADELAUNCHER":
                skin = GetRandomSkin(AlternateGrenadeLaunchers);
                break;
            case "Upgradeable TF_WEAPON_WRENCH":
                skin = GetRandomSkin(AlternateWrench);
                break;
            case "Upgradeable TF_WEAPON_SMG":
                skin = GetRandomSkin(AlternateSMGs);
                break;
            case "Upgradeable TF_WEAPON_KNIFE":
                skin = GetRandomSkin(AlternateKnives);
                break;
            case "Upgradeable TF_WEAPON_MINIGUN":
                skin = GetRandomSkin(AlternateMiniguns);
                break;
            //Shotguns don't actually work, unfortunately - similar issue to the Saxxy class items
//            case "Pyro's Shotgun":
//            case "Heavy's Shotgun":
//            case "Soldier's Shotgun":
//            case "Engineer's Shotgun":
//                skin = GetRandomSkin(AlternateShotguns);
//                break;

            case "The Chargin' Targe":
                skin = GetRandomSkin(AlternateCharginTarges);
                break;
            case "The Frontier Justice":
                skin = GetRandomSkin(AlternateFrontierJustices);
                break;
            case "The Wrangler":
                skin = GetRandomSkin(AlternateWranglers);
                break;
            case "The Crusader's Crossbow":
                skin = GetRandomSkin(AlternateCrossbows);
                break;
            case "The Backburner":
                skin = GetRandomSkin(AlternateBackburners);
                break;
            case "The Flare Gun":
                skin = GetRandomSkin(AlternateFlareGuns);
                break;
            case "The Force-a-Nature":
                skin = GetRandomSkin(AlternateForceANatures);
                break;
            case "Bonk! Atomic Punch":
                skin = GetRandomSkin(AlternateBonks);
                break;
            case "Mad Milk":
                skin = GetRandomSkin(AlternateMadMilks);
                break;
            case "The Huntsman":
                skin = GetRandomSkin(AlternateHuntsmans);
                break;
            case "Jarate":
                skin = GetRandomSkin(AlternateJarates);
                break;
            case "The Black Box":
                skin = GetRandomSkin(AlternateBlackBoxes);
                break;
            case "The Buff Banner":
                skin = GetRandomSkin(AlternateBuffBanners);
                break;
            case "The Ambassador":
                skin = GetRandomSkin(AlternateAmbassadors);
                break;
            case "Your Eternal Reward":
                skin = GetRandomSkin(AlternateEternalRewards);
                break;
        }

        return skin;
    }
}
