package Pop.Bot.Weapons;

import Pop.PopRandomizer;
import Pop.WeightedItem;
import Pop.WeightedItemCollection;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaponModels {
    public static ArrayList<WeaponModel> WeaponModel = new ArrayList<>(Arrays.asList(
            // c models
            new WeaponModel("models/weapons/c_models/c_8mm_camera/c_8mm_camera.mdl", "Memory Maker"),
            new WeaponModel("models/weapons/c_models/c_ambassador/c_ambassador.mdl", "Ambassador"),
            new WeaponModel("models/weapons/c_models/c_ambassador/c_ambassador_xmas.mdl", "Festive Ambassador"),
            new WeaponModel("models/weapons/c_models/c_axtinguisher/c_axtinguisher_pyro.mdl", "Axtinguisher"),
            new WeaponModel("models/weapons/c_models/c_banana/c_banana.mdl", "Second Banana"),
            new WeaponModel("models/weapons/c_models/c_bat.mdl", "Bat"),
            new WeaponModel("models/weapons/c_models/c_bat/c_bat_xmas.mdl", "Festive Bat"),
            new WeaponModel("models/weapons/c_models/c_bonesaw/c_bonesaw.mdl", "Bonesaw"),
            new WeaponModel("models/weapons/c_models/c_bonesaw/c_bonesaw_xmas.mdl", "Festive Bonesaw"),
            new WeaponModel("models/weapons/c_models/c_bottle/c_bottle.mdl", "Bottle"),
            new WeaponModel("models/weapons/c_models/c_bow/c_bow.mdl", "Huntsman"),
            new WeaponModel("models/weapons/c_models/c_bow/c_bow_xmas.mdl", "Festive Huntsman"),
            new WeaponModel("models/weapons/c_models/c_boxing_gloves/c_boxing_gloves.mdl", "Gloves"),
            new WeaponModel("models/weapons/c_models/c_boxing_gloves/c_boxing_gloves_xmas.mdl", "Festive Gloves"),
            new WeaponModel("models/weapons/c_models/c_bugle/c_bugle.mdl", "Buff Bugle"),
            new WeaponModel("models/weapons/c_models/c_builder/c_builder.mdl", "Builder"),
            new WeaponModel("models/weapons/c_models/c_carnival_mallet/c_carnival_mallet.mdl", "Necro Smasher"),
            new WeaponModel("models/weapons/c_models/c_claymore/c_claymore.mdl", "Eyelander"),
            new WeaponModel("models/weapons/c_models/c_claymore/c_claymore_xmas.mdl", "Festive Eyelander"),
            new WeaponModel("models/weapons/c_models/c_csgo_awp/c_csgo_awp.mdl", "AWP"),
            new WeaponModel("models/weapons/c_models/c_demo_arms.mdl", "Demo Arms"),
            new WeaponModel("models/weapons/c_models/c_directhit/c_directhit.mdl", "Direct Hit"),
            new WeaponModel("models/weapons/c_models/c_double_barrel.mdl", "Force-A-Nature"),
            new WeaponModel("models/weapons/c_models/c_energy_drink/c_energy_drink.mdl", "Bonk"),
            new WeaponModel("models/weapons/c_models/c_engineer_arms.mdl", "Engineer Arms"),
            new WeaponModel("models/weapons/c_models/c_engineer_gunslinger.mdl", "Gunslinger"),
            new WeaponModel("models/weapons/c_models/c_fireaxe_pyro/c_fireaxe_pyro.mdl", "Fireaxe"),
            new WeaponModel("models/weapons/c_models/c_fireaxe_pyro/c_fireaxe_pyro_xmas.mdl", "Festive Fireaxe"),
            new WeaponModel("models/weapons/c_models/c_flameball/c_flameball.mdl", "Dragon's Fury"),
            new WeaponModel("models/weapons/c_models/c_flamethrower/c_backburner.mdl", "Backburner"),
            new WeaponModel("models/weapons/c_models/c_flamethrower/c_backburner_xmas.mdl", "Festive Backburner"),
            new WeaponModel("models/weapons/c_models/c_flamethrower/c_flamethrower.mdl", "Flamethrower"),
            new WeaponModel("models/weapons/c_models/c_flamethrower/c_flamethrower_xmas.mdl", "Festive Flamethrower"),
            new WeaponModel("models/weapons/c_models/c_flaregun_pyro/c_flaregun_pyro.mdl","Flare Gun"),
            new WeaponModel("models/weapons/c_models/c_frontierjustice/c_frontierjustice.mdl", "Frontier Justice"),
            new WeaponModel("models/weapons/c_models/c_frontierjustice/c_frontierjustice_xmas.mdl", "Festive Frontier Justice"),
            new WeaponModel("models/weapons/c_models/c_frying_pan/c_frying_pan.mdl", "Frying Pan"),
            new WeaponModel("models/weapons/c_models/c_gascan/c_gascan.mdl", "Gas Passer"),
            new WeaponModel("models/weapons/c_models/c_grapple_proj/c_grapple_proj.mdl", "Grapple Projectile"),
            new WeaponModel("models/weapons/c_models/c_grappling_hook/c_grappling_hook.mdl", "Grappling Hook"),
            new WeaponModel("models/weapons/c_models/c_grenadelauncher/c_grenadelauncher.mdl", "Grenade Launcher"),
            new WeaponModel("models/weapons/c_models/c_grenadelauncher/c_grenadelauncher_xmas.mdl", "Festive Launcher"),
            new WeaponModel("models/weapons/c_models/c_headtaker/c_headtaker.mdl", "Headtaker"),
            new WeaponModel("models/weapons/c_models/c_heavy_arms.mdl", "Heavy Arms"),
            new WeaponModel("models/weapons/c_models/c_hippocrates_bust/c_hippocrates_bust.mdl", "Solemn Vow"),
            new WeaponModel("models/weapons/c_models/c_knife/c_knife.mdl", "Knife"),
            new WeaponModel("models/weapons/c_models/c_knife/c_knife_xmas.mdl", "Festive Knife"),
            new WeaponModel("models/weapons/c_models/c_leechgun/c_leechgun.mdl", "Blutsauger"),
            new WeaponModel("models/weapons/c_models/c_lollichop/c_lollichop.mdl", "Lollichop"),
            new WeaponModel("models/weapons/c_models/c_machete/c_machete.mdl", "Kukri"),
            new WeaponModel("models/weapons/c_models/c_medic_arms.mdl", "Medic Arms"),
            new WeaponModel("models/weapons/c_models/c_medigun/c_medigun.mdl", "Medigun"),
            new WeaponModel("models/weapons/c_models/c_medigun/c_medigun_xmas.mdl", "Festive Medigun"),
            new WeaponModel("models/weapons/c_models/c_minigun/c_minigun.mdl", "Minigun"),
            new WeaponModel("models/weapons/c_models/c_minigun/c_minigun_natascha.mdl", "Natascha"),
            new WeaponModel("models/weapons/c_models/c_minigun/c_minigun_xmas.mdl", "Festive Minigun"),
            new WeaponModel("models/weapons/c_models/c_overhealer/c_overhealer.mdl", "Kritzkrieg"),
            new WeaponModel("models/weapons/c_models/c_p2rec/c_p2rec.mdl", "Ap-Sap"),
            new WeaponModel("models/weapons/c_models/c_pda_engineer/c_pda_engineer.mdl", "PDA"),
            new WeaponModel("models/weapons/c_models/c_pickaxe/c_pickaxe.mdl", "Equalizer"),
            new WeaponModel("models/weapons/c_models/c_pickaxe/c_pickaxe_s2.mdl", "Escape Plan"),
            new WeaponModel("models/weapons/c_models/c_pistol/c_pistol.mdl", "Pistol"),
            new WeaponModel("models/weapons/c_models/c_proto_backpack/c_proto_backpack.mdl", "Quick-Fix Backpack"),
            new WeaponModel("models/weapons/c_models/c_proto_medigun/c_proto_medigun.mdl", "Quick-Fix"),
            new WeaponModel("models/weapons/c_models/c_pyro_arms.mdl", "Pyro Arms"),
            new WeaponModel("models/weapons/c_models/c_rainblower/c_rainblower.mdl", "Rainblower"),
            new WeaponModel("models/weapons/c_models/c_revolver/c_revolver.mdl", "Revolver"),
            new WeaponModel("models/weapons/c_models/c_revolver/c_revolver_xmas.mdl", "Festive Revolver"),
            new WeaponModel("models/weapons/c_models/c_rocketjumper/c_rocketjumper.mdl", "Rocket Jumper"),
            new WeaponModel("models/weapons/c_models/c_rocketlauncher/c_rocketlauncher.mdl", "Rocket Launcher"),
            new WeaponModel("models/weapons/c_models/c_rocketlauncher/c_rocketlauncher_xmas.mdl", "Festive Rocket Launcher"),
            new WeaponModel("models/weapons/c_models/c_rocketpack/c_rocketpack.mdl", "Thermal Thruster"),
            new WeaponModel("models/weapons/c_models/c_sandwich/c_robo_sandwich.mdl", "Robo-Sandvich"),
            new WeaponModel("models/weapons/c_models/c_sandwich/c_sandwich.mdl", "Sandvich"),
            new WeaponModel("models/weapons/c_models/c_sandwich/c_sandwich_xmas.mdl", "Festive Sandvich"),
            new WeaponModel("models/weapons/c_models/c_sapper/c_sapper.mdl", "Sapper"),
            new WeaponModel("models/weapons/c_models/c_sapper/c_sapper_xmas.mdl", "Festive Sapper"),
            new WeaponModel("models/weapons/c_models/c_saxxy/c_saxxy.mdl", "Saxxy", true),
            new WeaponModel("models/weapons/c_models/c_scattergun.mdl", "Scattergun"),
            new WeaponModel("models/weapons/c_models/c_scattergun/c_scattergun_xmas.mdl", "Festive Scattergun"),
            new WeaponModel("models/weapons/c_models/c_scottish_resistance/c_scottish_resistance.mdl", "Scottish Resistance"),
            new WeaponModel("models/weapons/c_models/c_scout_arms.mdl", "Scout Arms"),
            new WeaponModel("models/weapons/c_models/c_shotgun/c_shotgun.mdl", "Shotgun"),
            new WeaponModel("models/weapons/c_models/c_shotgun/c_shotgun_xmas.mdl", "Festive Shotgun"),
            new WeaponModel("models/weapons/c_models/c_shovel/c_shovel.mdl", "Shovel"),
            new WeaponModel("models/weapons/c_models/c_slapping_glove/c_slapping_glove.mdl", "Hot Hand"),
            new WeaponModel("models/weapons/c_models/c_smg/c_smg.mdl", "SMG"),
            new WeaponModel("models/weapons/c_models/c_smg/c_smg_xmas.mdl", "Festive SMG"),
            new WeaponModel("models/weapons/c_models/c_sniper_arms.mdl", "Sniper Arms"),
            new WeaponModel("models/weapons/c_models/c_sniperrifle/c_sniperrifle.mdl", "Sniper Rifle"),
            new WeaponModel("models/weapons/c_models/c_sniperrifle/c_sniperrifle_xmas.mdl", "Festive Sniper"),
            new WeaponModel("models/weapons/c_models/c_soldier_arms.mdl", "Soldier Arms"),
            new WeaponModel("models/weapons/c_models/c_spy_arms.mdl", "Spy Arms"),
            new WeaponModel("models/weapons/c_models/c_sticky_jumper/c_sticky_jumper.mdl", "Sticky Jumper"),
            new WeaponModel("models/weapons/c_models/c_stickybomb_launcher/c_stickybomb_launcher.mdl", "Sticky Launcher"),
            new WeaponModel("models/weapons/c_models/c_stickybomb_launcher/c_stickybomb_launcher_xmas.mdl", "Festive Sticky"),
            new WeaponModel("models/weapons/c_models/c_syringegun/c_syringegun.mdl", "Syringe Gun"),
            new WeaponModel("models/weapons/c_models/c_targe/c_targe.mdl", "Chargin' Targe"),
            new WeaponModel("models/weapons/c_models/c_targe/c_targe_xmas.mdl", "Festive Targe"),
            new WeaponModel("models/weapons/c_models/c_tfc_sniperrifle/c_tfc_sniperrifle.mdl", "Classic"),
            new WeaponModel("models/weapons/c_models/c_toolbox/c_toolbox.mdl", "Toolbox"),
            new WeaponModel("models/weapons/c_models/c_ubersaw/c_ubersaw.mdl", "Ubersaw"),
            new WeaponModel("models/weapons/c_models/c_ubersaw/c_ubersaw_xmas.mdl", "Festive Ubersaw"),
            new WeaponModel("models/weapons/c_models/c_wooden_bat/c_wooden_bat.mdl", "Sandman"),
            new WeaponModel("models/weapons/c_models/c_wrangler.mdl", "Wrangler"),
            new WeaponModel("models/weapons/c_models/c_wrangler_xmas.mdl", "Festive Wrangler"),
            new WeaponModel("models/weapons/c_models/c_wrench/c_wrench.mdl", "Wrench"),
            new WeaponModel("models/weapons/c_models/c_wrench/c_wrench_xmas.mdl", "Festive Wrench"),
            new WeaponModel("models/weapons/c_models/c_xms_double_barrel.mdl", "Festive Farce-A-Nature"),
            new WeaponModel("models/weapons/c_models/c_xms_energy_drink/c_xms_energy_drink.mdl", "Festive Bonk"),
            new WeaponModel("models/weapons/c_models/c_xms_festive_ornament.mdl", "Ornamental"),
            new WeaponModel("models/weapons/c_models/c_xms_flaregun/c_xms_flaregun.mdl", "Festive Flare Gun"),
            new WeaponModel("models/weapons/c_models/c_xms_urinejar.mdl", "Festive Jarate"),
            new WeaponModel("models/weapons/c_models/urinejar.mdl", "Jarate"),

            // workshop c models
            new WeaponModel("models/workshop/weapons/c_models/c_acr_hookblade/c_acr_hookblade.mdl", "Sharp Dresser"),
            new WeaponModel("models/workshop/weapons/c_models/c_amputator/c_amputator.mdl", "Amputator"),
            new WeaponModel("models/workshop/weapons/c_models/c_atom_launcher/c_atom_launcher.mdl", "Air Strike"),
            new WeaponModel("models/workshop/weapons/c_models/c_ava_roseknife/c_ava_roseknife.mdl", "Black Rose"),
            new WeaponModel("models/workshop/weapons/c_models/c_back_scratcher/c_back_scratcher.mdl", "Back Scratcher"),
            new WeaponModel("models/workshop/weapons/c_models/c_battalion_bugle/c_battalion_bugle.mdl", "Battalion Bugle"),
            new WeaponModel("models/workshop/weapons/c_models/c_battleaxe/c_battleaxe.mdl", "Skullcutter"),
            new WeaponModel("models/workshop/weapons/c_models/c_bazaar_sniper/c_bazaar_sniper.mdl", "Bazaar Bargain"),
            new WeaponModel("models/workshop/weapons/c_models/c_bear_claw/c_bear_claw.mdl", "Warrior's Spirit"),
            new WeaponModel("models/workshop/weapons/c_models/c_blackbox/c_blackbox.mdl", "Black Box"),
            new WeaponModel("models/workshop/weapons/c_models/c_blackbox/c_blackbox_xmas.mdl", "Festive Black Box"),
            new WeaponModel("models/workshop/weapons/c_models/c_bonk_bat/c_bonk_bat.mdl", "Atomizer"),
            new WeaponModel("models/workshop/weapons/c_models/c_boston_basher/c_boston_basher.mdl", "Boston Basher"),
            new WeaponModel("models/workshop/weapons/c_models/c_buffalo_steak/c_buffalo_steak.mdl", "Buffalo Steak"),
            new WeaponModel("models/workshop/weapons/c_models/c_buffalo_steak/plate_buffalo_steak.mdl", "Steak Plate"),
            new WeaponModel("models/workshop/weapons/c_models/c_caber/c_caber.mdl", "Caber"),
            new WeaponModel("models/workshop/weapons/c_models/c_caber/c_caber_exploded.mdl", "Damaged Caber"),
            new WeaponModel("models/workshop/weapons/c_models/c_candy_cane/c_candy_cane.mdl", "Candy Cane"),
            new WeaponModel("models/workshop/weapons/c_models/c_chocolate/c_chocolate.mdl", "Dalokohs Bar"),
            new WeaponModel("models/workshop/weapons/c_models/c_chocolate/plate_chocolate.mdl", "Dalokohs Bar Plate"),
            new WeaponModel("models/workshop/weapons/c_models/c_claidheamohmor/c_claidheamohmor.mdl", "Claidheamh Mòr"),
            new WeaponModel("models/workshop/weapons/c_models/c_croc_knife/c_croc_knife.mdl", "Bushwacka"),
            new WeaponModel("models/workshop/weapons/c_models/c_crossing_guard/c_crossing_guard.mdl", "Crossing Guard"),
            new WeaponModel("models/workshop/weapons/c_models/c_crusaders_crossbow/c_crusaders_crossbow.mdl", "Crusader's Crossbow"),
            new WeaponModel("models/workshop/weapons/c_models/c_crusaders_crossbow/c_crusaders_crossbow_xmas.mdl", "Festive Crossbow"),
            new WeaponModel("models/workshop/weapons/c_models/c_degreaser/c_degreaser.mdl", "Degreaster"),
            new WeaponModel("models/workshop/weapons/c_models/c_demo_cannon/c_demo_cannon.mdl", "Loose Cannon"),
            new WeaponModel("models/workshop/weapons/c_models/c_demo_sultan_sword/c_demo_sultan_sword.mdl", "Persian Persuader"),
            new WeaponModel("models/workshop/weapons/c_models/c_detonator/c_detonator.mdl", "Detonator"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_cowmangler/c_drg_cowmangler.mdl", "Cow Mangler"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_manmelter/c_drg_manmelter.mdl", "Manmelter"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_phlogistinator/c_drg_phlogistinator.mdl", "Phlogistinator"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_pomson/c_drg_pomson.mdl", "Pomson"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_righteousbison/c_drg_righteousbison.mdl", "Bison"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_thirddegree/c_drg_thirddegree.mdl", "Third Degree"),
            new WeaponModel("models/workshop/weapons/c_models/c_drg_wrenchmotron/c_drg_wrenchmotron.mdl", "Eureka Effect"),
            new WeaponModel("models/workshop/weapons/c_models/c_dumpster_device/c_dumpster_device.mdl", "Beggar's Bazooka"),
            new WeaponModel("models/workshop/weapons/c_models/c_eternal_reward/c_eternal_reward.mdl", "Eternal Reward"),
            new WeaponModel("models/workshop/weapons/c_models/c_eviction_notice/c_eviction_notice.mdl", "Eviction Notice"),
            new WeaponModel("models/workshop/weapons/c_models/c_fishcake/c_fishcake.mdl", "Fishcake"),
            new WeaponModel("models/workshop/weapons/c_models/c_fishcake/plate_fishcake.mdl", "Fishcake Plate"),
            new WeaponModel("models/workshop/weapons/c_models/c_fists_of_steel/c_fists_of_steel.mdl", "Fists of Steel"),
            new WeaponModel("models/workshop/weapons/c_models/c_gatling_gun/c_gatling_gun.mdl", "Brass Beast"),
            new WeaponModel("models/workshop/weapons/c_models/c_golfclub/c_golfclub.mdl", "Nessie's Nine Iron"),
            new WeaponModel("models/workshop/weapons/c_models/c_ham/c_ham.mdl", "Ham Shank"),
            new WeaponModel("models/workshop/weapons/c_models/c_holymackerel/c_holymackerel.mdl", "Holy Mackerel"),
            new WeaponModel("models/workshop/weapons/c_models/c_holymackerel/c_holymackerel_xmas.mdl", "Festive Hackerel"),
            new WeaponModel("models/workshop/weapons/c_models/c_invasion_bat/c_invasion_bat.mdl", "Batsaber"),
            new WeaponModel("models/workshop/weapons/c_models/c_invasion_pistol/c_invasion_pistol.mdl", "C.A.P.P.E.R"),
            new WeaponModel("models/workshop/weapons/c_models/c_invasion_sniperrifle/c_invasion_sniperrifle.mdl", "Shooting Star"),
            new WeaponModel("models/workshop/weapons/c_models/c_invasion_wrangler/c_invasion_wrangler.mdl", "Giger Counter"),
            new WeaponModel("models/workshop/weapons/c_models/c_iron_curtain/c_iron_curtain.mdl", "Iron Curtain"),
            new WeaponModel("models/workshop/weapons/c_models/c_jag/c_jag.mdl", "Jag"),
            new WeaponModel("models/workshop/weapons/c_models/c_kingmaker_sticky/c_kingmaker_sticky.mdl", "Quickiebonb Launcher"),
            new WeaponModel("models/workshop/weapons/c_models/c_kingmaker_sticky/w_kingmaker_stickybomb.mdl", "Quickiebomb"),
            new WeaponModel("models/workshop/weapons/c_models/c_letranger/c_letranger.mdl", "L'Etranger"),
            new WeaponModel("models/workshop/weapons/c_models/c_liberty_launcher/c_liberty_launcher.mdl", "Liberty Launcher"),
            new WeaponModel("models/workshop/weapons/c_models/c_lochnload/c_lochnload.mdl", "Loch-n-Load"),
            new WeaponModel("models/workshop/weapons/c_models/c_madmilk/c_madmilk.mdl", "Mad Milk"),
            new WeaponModel("models/workshop/weapons/c_models/c_mailbox/c_mailbox.mdl", "Postal Pummeler"),
            new WeaponModel("models/workshop/weapons/c_models/c_market_gardener/c_market_gardener.mdl", "Market Gardener"),
            new WeaponModel("models/workshop/weapons/c_models/c_medigun_defense/c_medigun_defense.mdl", "Vaccinator"),
            new WeaponModel("models/workshop/weapons/c_models/c_medigun_defense/c_medigun_defensepack.mdl", "Vaccinator Pack"),
            new WeaponModel("models/workshop/weapons/c_models/c_paintrain/c_paintrain.mdl", "Pain Train"),
            new WeaponModel("models/workshop/weapons/c_models/c_paratooper_pack/c_paratrooper_pack.mdl", "B.A.S.E. Jumper"),
            new WeaponModel("models/workshop/weapons/c_models/c_paratooper_pack/c_paratrooper_pack_open.mdl", "Open B.A.S.E."),
            new WeaponModel("models/workshop/weapons/c_models/c_paratooper_pack/c_paratrooper_parachute.mdl", "B.A.S.E. Parachute"),
            new WeaponModel("models/workshop/weapons/c_models/c_pep_pistol/c_pep_pistol.mdl", "Pocket Pistol"),
            new WeaponModel("models/workshop/weapons/c_models/c_pep_scattergun/c_pep_scattergun.mdl", "Baby Face's Blaster"),
            new WeaponModel("models/workshop/weapons/c_models/c_persian_shield/c_persian_shield.mdl", "Splendid Screen"),
            new WeaponModel("models/workshop/weapons/c_models/c_persian_shield/c_persian_shield_all.mdl", "Splendid Screen"),
            new WeaponModel("models/workshop/weapons/c_models/c_persian_shield/c_persian_shield_arrow.mdl", "Splendid Screen"),
            new WeaponModel("models/workshop/weapons/c_models/c_persian_shield/c_persian_shield_spike.mdl", "Splendid Screen"),
            new WeaponModel("models/workshop/weapons/c_models/c_picket/c_picket.mdl", "Conscientious Objector"),
            new WeaponModel("models/workshop/weapons/c_models/c_powerjack/c_powerjack.mdl", "Powerjack"),
            new WeaponModel("models/workshop/weapons/c_models/c_pro_rifle/c_pro_rifle.mdl", "Hitman's Heatmaker"),
            new WeaponModel("models/workshop/weapons/c_models/c_pro_smg/c_pro_smg.mdl", "Cleaner's Carbine"),
            new WeaponModel("models/workshop/weapons/c_models/c_quadball/c_quadball.mdl", "Iron Bomber"),
            new WeaponModel("models/workshop/weapons/c_models/c_quadball/w_quadball_grenade.mdl", "Iron Bomber Grenade"),
            new WeaponModel("models/workshop/weapons/c_models/c_reserve_shooter/c_reserve_shooter.mdl", "Reserve Shooter"),
            new WeaponModel("models/workshop/weapons/c_models/c_rfa_hammer/c_rfa_hammer.mdl", "Maul"),
            new WeaponModel("models/workshop/weapons/c_models/c_riding_crop/c_riding_crop.mdl", "Disciplinary Action"),
            new WeaponModel("models/workshop/weapons/c_models/c_rift_fire_axe/c_rift_fire_axe.mdl", "Volcano Fragment"),
            new WeaponModel("models/workshop/weapons/c_models/c_rift_fire_mace/c_rift_fire_mace.mdl", "Sun-on-a-Stick"),
            new WeaponModel("models/workshop/weapons/c_models/c_russian_riot/c_russian_riot.mdl", "Family Business"),
            new WeaponModel("models/workshop/weapons/c_models/c_scatterdrum/c_scatterdrum.mdl", "Back Scatter"),
            new WeaponModel("models/workshop/weapons/c_models/c_scimitar/c_scimitar.mdl", "Shahanshah"),
            new WeaponModel("models/workshop/weapons/c_models/c_scorch_shot/c_scorch_shot.mdl", "Scorch Shot"),
            new WeaponModel("models/workshop/weapons/c_models/c_scotland_shard/c_scotland_shard.mdl", "Scottish Handshake"),
            new WeaponModel("models/workshop/weapons/c_models/c_scout_sword/c_scout_sword.mdl", "Three-Rune Blade"),
            new WeaponModel("models/workshop/weapons/c_models/c_shortstop/c_shortstop.mdl", "Shortstop"),
            new WeaponModel("models/workshop/weapons/c_models/c_skullbat/c_skullbat.mdl", "Bat Outta Hell"),
            new WeaponModel("models/workshop/weapons/c_models/c_sledgehammer/c_sledgehammer.mdl", "Homewrecker"),
            new WeaponModel("models/workshop/weapons/c_models/c_snub_nose/c_snub_nose.mdl", "Enforcer"),
            new WeaponModel("models/workshop/weapons/c_models/c_soda_popper/c_soda_popper.mdl", "Soda Popper"),
            new WeaponModel("models/workshop/weapons/c_models/c_spikewrench/c_spikewrench.mdl", "Southern Hospitality"),
            new WeaponModel("models/workshop/weapons/c_models/c_sr3_punch/c_sr3_punch.mdl",  "Apoco-Fists"),
            new WeaponModel("models/workshop/weapons/c_models/c_switchblade/c_switchblade.mdl", "Big Earner"),
            new WeaponModel("models/workshop/weapons/c_models/c_sydney_sleeper/c_sydney_sleeper.mdl", "Sydney Sleeper"),
            new WeaponModel("models/workshop/weapons/c_models/c_tele_shotgun/c_tele_shotgun.mdl", "Rescue Ranger"),
            new WeaponModel("models/workshop/weapons/c_models/c_tomislav/c_tomislav.mdl", "Tomislav"),
            new WeaponModel("models/workshop/weapons/c_models/c_trenchgun/c_trenchgun.mdl", "Panic Attack"),
            new WeaponModel("models/workshop/weapons/c_models/c_ttg_max_gun/c_ttg_max_gun.mdl", "Lugermorph"),
            new WeaponModel("models/workshop/weapons/c_models/c_ttg_sam_gun/c_ttg_sam_gun.mdl", "Big Kill"),
            new WeaponModel("models/workshop/weapons/c_models/c_uberneedle/c_uberneedle.mdl", "Vita-Saw"),
            new WeaponModel("models/workshop/weapons/c_models/c_unarmed_combat/c_unarmed_combat.mdl", "Unarmed Combat"),
            new WeaponModel("models/workshop/weapons/c_models/c_voodoo_pin/c_voodoo_pin.mdl", "Wanga Prick"),
            new WeaponModel("models/workshop/weapons/c_models/c_wheel_shield/c_wheel_shield.mdl", "Tide Turner"),
            new WeaponModel("models/workshop/weapons/c_models/c_winger_pistol/c_winger_pistol.mdl", "Winger"),
            new WeaponModel("models/workshop/weapons/c_models/c_wood_machete/c_wood_machete.mdl", "Tribalman's Shiv"),
            new WeaponModel("models/workshop/weapons/c_models/c_xms_cold_shoulder/c_xms_cold_shoulder.mdl", "Spy-cicle"),
            new WeaponModel("models/workshop/weapons/c_models/c_xms_giftwrap/c_xms_giftwrap.mdl", "Wrap Assassin"),
            new WeaponModel("models/workshop/weapons/c_models/c_xms_gloves/c_xms_gloves.mdl", "Holiday Punch"),

            // sappers
            new WeaponModel("models/buildables/p2rec_placed.mdl", "Placed Ap-Sap"),
            new WeaponModel("models/buildables/p2rec_placement.mdl", "Placing Ap-Sap"),
            new WeaponModel("models/buildables/sapper_placed.mdl", "Placed Sapper"),
            new WeaponModel("models/buildables/sapper_placement.mdl", "Placing Sapper"),
            new WeaponModel("models/buildables/sapper_xmas_placed.mdl", "Placed Festive Sapper"),
            new WeaponModel("models/buildables/sapper_xmas_placement.mdl", "Placing Festive Sapper"),
            new WeaponModel("models/buildables/sd_sapper_placed.mdl", "Placed Tape Recorder"),
            new WeaponModel("models/buildables/sd_sapper_placement.mdl", "Placing Tape Recorder"),

            // canteens
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_ammo.mdl", "Ammo Canteen"),
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_build.mdl", "Building Canteen"),
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_generic.mdl", "Canteen"),
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_krit.mdl", "Crit Canteen"),
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_tele.mdl", "Tele Canteen"),
            new WeaponModel("models/player/items/mvm_loot/all_class/mvm_flask_uber.mdl", "Uber Canteen")
    ));

    public static ArrayList<WeaponModel> cosmeticModels = new ArrayList<>(Arrays.asList(
            // botkiller fobs
            new WeaponModel("models/player/items/mvm_loot/demo/fob_e_stickybomb.mdl", "Sticky Fob"),
            new WeaponModel("models/player/items/mvm_loot/demo/fob_h_stickybomb.mdl", "Sticky Fob"),
            new WeaponModel("models/player/items/mvm_loot/demo/fob_h_stickybomb_diamond.mdl", "Sticky Fob"),
            new WeaponModel("models/player/items/mvm_loot/engineer/fob_e_wrench.mdl", "Wrench Fob"),
            new WeaponModel("models/player/items/mvm_loot/engineer/fob_h_wrench.mdl", "Wrench Fob"),
            new WeaponModel("models/player/items/mvm_loot/engineer/fob_h_wrench_diamond.mdl", "Wrench Fob"),
            new WeaponModel("models/player/items/mvm_loot/heavy/fob_e_minigun.mdl", "Minigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/heavy/fob_h_minigun.mdl", "Minigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/heavy/fob_h_minigun_diamond.mdl", "Minigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/medic/fob_e_medigun.mdl", "Medigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/medic/fob_h_medigun.mdl", "Medigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/medic/fob_h_medigun_diamond.mdl", "Medigun Fob"),
            new WeaponModel("models/player/items/mvm_loot/pyro/fob_e_flamethrower.mdl", "Flamethrower Fob"),
            new WeaponModel("models/player/items/mvm_loot/pyro/fob_h_flamethrower.mdl", "Flamethrower Fob"),
            new WeaponModel("models/player/items/mvm_loot/pyro/fob_h_flamethrower_diamond.mdl", "Flamethrower Fob"),
            new WeaponModel("models/player/items/mvm_loot/scout/fob_e_scattergun.mdl", "Scattergun Fob"),
            new WeaponModel("models/player/items/mvm_loot/scout/fob_h_scattergun.mdl", "Scattergun Fob"),
            new WeaponModel("models/player/items/mvm_loot/scout/fob_h_scattergun_diamond.mdl", "Scattergun Fob"),
            new WeaponModel("models/player/items/mvm_loot/sniper/fob_e_sniperrifle.mdl", "Sniper Rifle Fob"),
            new WeaponModel("models/player/items/mvm_loot/sniper/fob_h_sniperrifle.mdl", "Sniper Rifle Fob"),
            new WeaponModel("models/player/items/mvm_loot/sniper/fob_h_sniperrifle_diamond.mdl", "Sniper Rifle Fob"),
            new WeaponModel("models/player/items/mvm_loot/soldier/fob_e_rocketlauncher.mdl", "Rocket Launcher Fob"),
            new WeaponModel("models/player/items/mvm_loot/soldier/fob_h_rocketlauncher.mdl", "Rocket Launcher Fob"),
            new WeaponModel("models/player/items/mvm_loot/soldier/fob_h_rocketlauncher_diamond.mdl", "Rocket Launcher Fob"),

            // items
            new WeaponModel("models/workshop/player/items/demo/bagpipes/bagpipes.mdl", "Bagpipes"),
            new WeaponModel("models/workshop/player/items/demo/demo_booties/demo_booties.mdl", "Wee Booties"),
            new WeaponModel("models/workshop/player/items/demo/pegleg/pegleg.mdl", "Bootlegger"),
            new WeaponModel("models/workshop/player/items/engineer/bucking_bronco/bucking_bronco.mdl", "Bucking Bronco"),
            new WeaponModel("models/workshop/player/items/pyro/ghost_aspect/ghost_aspect.mdl", "Ghost Aspect"),
            new WeaponModel("models/workshop/player/items/pyro/spring_rider/spring_rider.mdl", "Balloonibouncer"),
            new WeaponModel("models/workshop/player/items/sniper/killer_solo/killer_solo.mdl", "Killer Solo"),
            new WeaponModel("models/workshop/player/items/soldier/fumblers_fanfare/fumblers_fanfare.mdl", "Fubar Fanfare"),
            new WeaponModel("models/workshop/player/items/soldier/mantreads/mantreads.mdl", "Mantreads"),

            // misc
            new WeaponModel("models/player/items/all_class/hwn_spellbook_complete.mdl", "Complete Spellbook"),
            new WeaponModel("models/player/items/all_class/hwn_spellbook_diary.mdl", "Spellbook Diary"),
            new WeaponModel("models/player/items/crafting/community_cosmetic_case.mdl", "Community Case"),
            new WeaponModel("models/player/items/crafting/cosmetic_case.mdl", "Cosmetic Case"),
            new WeaponModel("models/player/items/crafting/cosmetic_case_ribbon.mdl", "Ribboned Case"),
            new WeaponModel("models/player/items/crafting/halloween_case.mdl", "Halloween Case"),
            new WeaponModel("models/player/items/crafting/halloween2015_case.mdl", "H'ween 2015 Case"),
            new WeaponModel("models/player/items/crafting/weapons_case.mdl", "Weapons Case"),
            new WeaponModel("models/player/items/cyoa_pda/cyoa_pda.mdl", "PDA"),
            new WeaponModel("models/player/items/demo/crown.mdl", "Crown"),
            new WeaponModel("models/player/items/engineer/guitar.mdl", "Guitar"),
            new WeaponModel("models/workshop/player/items/all_class/secondrate_sorcery/secondrate_sorcery_demo.mdl", "Second Rate"),
            new WeaponModel("models/workshop/player/items/all_class/zoomin_broom/zoomin_broom_demo.mdl", "Zoomin Broom")
    ));

    public static ArrayList<WeaponModel> buildingModels = new ArrayList<>(Arrays.asList(
            new WeaponModel("models/buildables/dispenser.mdl", "L1 Dispenser"),
            new WeaponModel("models/buildables/dispenser_lvl2.mdl", "L2 Dispenser"),
            new WeaponModel("models/buildables/dispenser_lvl3.mdl", "L3 Dispenser"),
            new WeaponModel("models/buildables/sentry1.mdl", "L1 Sentry"),
            new WeaponModel("models/buildables/sentry1_heavy.mdl", "L1 Heavy Sentry"),
            new WeaponModel("models/buildables/sentry2.mdl", "L2 Sentry"),
            new WeaponModel("models/buildables/sentry2_heavy.mdl", "L2 Heavy Sentry"),
            new WeaponModel("models/buildables/sentry3.mdl", "L3 Sentry"),
            new WeaponModel("models/buildables/sentry3_heavy.mdl", "L3 Heavy Sentry"),
            new WeaponModel("models/buildables/sentry3_rockets.mdl", "L3 Rocket Sentry"),
            new WeaponModel("models/buildables/teleporter.mdl", "Teleporter"),
            new WeaponModel("models/buildables/teleporter_blueprint_enter.mdl", "Teleporter Blueprints"),
            new WeaponModel("models/buildables/teleporter_blueprint_exit.mdl", "Teleporter Blueprints")
    ));

    public static ArrayList<WeaponModel> breadModels = new ArrayList<>(Arrays.asList(
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_baguette.mdl", "Baguette"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_burnt.mdl", "Burnt Bread"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_cinnamon.mdl", "Cinnamon"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_cornbread.mdl", "Cornbread"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_crumpet.mdl", "Crumpet"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_plainloaf.mdl", "Loaf"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_pretzel.mdl", "Pretzel"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_ration.mdl", "Canned Bread"),
            new WeaponModel("models/weapons/c_models/c_bread/c_bread_russianblack.mdl", "Russian Black"),
            new WeaponModel("models/weapons/w_models/w_breadmonster/w_breadmonster.mdl", "Breadmonster"),
            new WeaponModel("models/weapons/c_models/c_breadmonster/c_breadmonster.mdl", "Beauty Mark"),
            new WeaponModel("models/weapons/c_models/c_breadmonster/c_breadmonster_milk.mdl", "Mutated Milk")
    ));

    public static ArrayList<WeaponModel> pickupsAndFunGibModels = new ArrayList<>(Arrays.asList(
            new WeaponModel("models/items/ammopack_large.mdl", "Large Ammo"),
            new WeaponModel("models/items/ammopack_large_bday.mdl", "Large Gift Ammo"),
            new WeaponModel("models/items/ammopack_medium.mdl", "Med Ammo"),
            new WeaponModel("models/items/ammopack_medium_bday.mdl", "Med Gift Ammo"),
            new WeaponModel("models/items/ammopack_small.mdl", "Small Ammo"),
            new WeaponModel("models/items/banana/plate_banana.mdl", "Banana Plate"),
            new WeaponModel("models/items/currencypack_large.mdl", "Big Money"),
            new WeaponModel("models/items/currencypack_medium.mdl", "Some Money"),
            new WeaponModel("models/items/currencypack_small.mdl", "Money"),
            new WeaponModel("models/items/festivizer.mdl", "Festivizer"),
            new WeaponModel("models/items/gift_festive.mdl", "Festive Gift"),

            // This crashes on sandstone...
            //new WeaponModel("models/items/medkit_large.mdl", "Large Medkit"),

            new WeaponModel("models/items/medkit_large_bday.mdl", "Large Gift Medkit"),
            new WeaponModel("models/items/medkit_medium.mdl", "Med Medkit"),
            new WeaponModel("models/items/medkit_medium_bday.mdl", "Med Gift Medkit"),
            new WeaponModel("models/items/medkit_small.mdl", "Small Medkit"),
            new WeaponModel("models/items/paintkit_tool.mdl", "Paintkit"),
            new WeaponModel("models/items/plate.mdl", "Plate"),
            new WeaponModel("models/items/plate_robo_sandwich.mdl", "Robo Sandvich Plate"),
            new WeaponModel("models/items/plate_sandwich_xmas.mdl", "Festive Sandvich Plate"),
            new WeaponModel("models/passtime/ball/passtime_ball.mdl", "Passtime Ball"),
            new WeaponModel("models/player/gibs/gibs_boot.mdl", "Old Boot"),
            new WeaponModel("models/player/gibs/gibs_tire.mdl", "Unicycle"),
            new WeaponModel("models/workshop/cases/invasion_case/invasion_case.mdl", "Invasion Case"),
            new WeaponModel("models/workshop/cases/invasion_case/invasion_case_rare.mdl", "Rare Invasion Case"),
            new WeaponModel("models/weapons/w_models/w_toolbox.mdl", "Toolbox")
    ));

    public static ArrayList<WeaponModel> projectileModels = new ArrayList<>(Arrays.asList(
            new WeaponModel("models/weapons/w_models/w_arrow.mdl", "Arrow"),
            new WeaponModel("models/weapons/w_models/w_arrow_xmas.mdl", "Festive Arrow"),
            //new WeaponModel("models/weapons/w_models/w_baseball.mdl", "Baseball"), // Crashed?
            new WeaponModel("models/weapons/w_models/w_cannonball.mdl", "Cannonball"),
            new WeaponModel("models/weapons/w_models/w_cigarette_case.mdl", "Cigarette Case"),
            new WeaponModel("models/weapons/w_models/w_flaregun_shell.mdl", "Flare"),
            new WeaponModel("models/weapons/w_models/w_grenade_grenadelauncher.mdl", "Grenade"),
            new WeaponModel("models/weapons/w_models/w_repair_claw.mdl", "Rescue Bolt"),
            new WeaponModel("models/weapons/w_models/w_rocket.mdl", "Rocket"),
            new WeaponModel("models/weapons/w_models/w_rocket_airstrike/w_rocket_airstrike.mdl", "Airstrike Rocket"),
            new WeaponModel("models/weapons/w_models/w_stickybomb.mdl", "Sticky"),
            new WeaponModel("models/weapons/w_models/w_stickybomb_d.mdl", "Scottish Sticky"),
            new WeaponModel("models/weapons/w_models/w_stickybomb2.mdl", "Jumpy Sticky")
    ));

    /**
     * Gets a random model using the defined lists, which have their own weights
     * @return The random model chosen
     */
    public static WeaponModel getRandomModel() {
        ArrayList<WeightedItem<ArrayList<WeaponModel>>> weightedItems = new ArrayList<>(Arrays.asList(
            new WeightedItem<>(WeaponModel, 100),
            new WeightedItem<>(cosmeticModels, 100),
            new WeightedItem<>(breadModels, 200),
            new WeightedItem<>(pickupsAndFunGibModels, 200),
            new WeightedItem<>(projectileModels, 150),
            new WeightedItem<>(buildingModels, 80)
        ));

        WeightedItemCollection<ArrayList<WeaponModel>> collection = new WeightedItemCollection<>(weightedItems);
        return PopRandomizer.randomElement(collection.getRandomItem());
    }
}
