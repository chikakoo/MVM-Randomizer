package Pop.Enums;

/**
 * Locations where bots can spawn
 */
public enum SpawnLocations {
    // The normal locations
    SPAWN_BOT("spawnbot"),
    SPAWN_BOT_ROTTENBURG_SENTRY_BUSTER("spawnbot_mission_sentry_buster"),
    SPAWN_BOT_SNIPER("spawnbot_mission_sniper"),
    SPAWN_BOT_SPY("spawnbot_mission_spy"),

    // Coaltown - this one spawns from the right and left sides of the map
    SPAWN_BOT_COALTOWN_GIANT("spawnbot_giant"),

    // Decoy - this is the top part of the map
    SPAWN_BOT_DECOY_INVASION("spawnbot_invasion"),

    // Manhattan - always include main1 (or main1_slow_ and main2 (excludes snipers)
    SPAWN_BOT_MANNHATTAN_MAIN_0("spawnbot_main0"),
    SPAWN_BOT_MANNHATTAN_UPPER_0("spawnbot_upper0"),
    SPAWN_BOT_MANNHATTAN_MAIN_1("spawnbot_main1"),
    SPAWN_BOT_MANNHATTAN_MAIN_1_SLOW("spawnbot_main1_slow"),
    SPAWN_BOT_MANNHATTAN_MAIN_2("spawnbot_main2"),
    SPAWN_BOT_MISSION_MANNHATTAN_SNIPER_0("spawnbot_mission_sniper0"),
    SPAWN_BOT_MISSION_MANNHATTAN_SNIPER_1("spawnbot_mission_sniper1"),

    // Rottenburg - the upper right area of the main spawn
    SPAWN_BOT_ROTTENBURG_FLANKERS("flankers"),

    // Teien
    SPAWN_BOT_TEIEN_LEFT("spawnbot_left"),
    SPAWN_BOT_TEIEN_LOWER("spawnbot_lower"),

    // Maelstrom
    //SPAWN_BOT_MAELSTROM_GIANT("spawnbot_giant"), // In the map file, but causes bots to get stuck/not spawn

    // Museum
    SPAWN_BOT_MUSEUM_RIGHT("spawnbot_right"),
    SPAWN_BOT_MUSEUM_LEFT("spawnbot_left"),
    SPAWN_BOT_MUSEUM_TOP("spawnbot_top"),
    SPAWN_BOT_MUSEUM_GIANT("spawnbot_giant"),
    SPAWN_BOT_MUSEUM_ENGINEER_RIGHT("spawnbot_right_eng"),
    SPAWN_BOT_MUSEUM_ENGINEER_LEFT("spawnbot_left_eng"),

    // Plateau
    SPAWN_BOT_PLATEAU_ENGINEER("spawnbot_mission_engineer"),

    // Intersection
    SPAWN_BOT_INTERSECTION_SENTRY_BUSTER("spawnbot_lower"),
    SPAWN_BOT_INTERSECTION_RIGHT("spawnbot_right"),
    SPAWN_BOT_INTERSECTION_LEFT("spawnbot_left"),

    // Quetzalcoatl
    SPAWN_BOT_QUETZALCOATL_FLANK("spawnbot_flank"),

    // Manndarin
    SPAWN_BOT_MANNDARIN_INVASION("spawnbot_invasion"),

    // Affinity
    SPAWN_BOT_AFFINITY_SENTRY_BUSTER("botSpawn_buster"),
    SPAWN_BOT_AFFINITY_MAIN("botSpawn_main"),
    SPAWN_BOT_AFFINITY_FLANK("botSpawn_flank"),
    SPAWN_BOT_AFFINITY_UPPER("botSpawn_upper"),

    // Oilrig
    SPAWN_BOT_OILRIG_BOSS("spawnbot_boss"),

    // Saddle
    SPAWN_BOT_SADDLE_SENTRY_BUSTER("spawnbot_mission_sentrybuster"),
    SPAWN_BOT_SADDLE_1("spawnbot1"),
    SPAWN_BOT_SADDLE_2("spawnbot2"),

    // Spacepost
    SPAWN_BOT_SPACEPOST_UPPER("spawnbot_upper"),
    SPAWN_BOT_SPACEPOST_BOSS("spawnbot_boss"),

    // Teufort
    SPAWN_BOT_TEUFORT_GIANT("spawnbot_special"),

    // Waterfront
    SPAWN_BOT_WATERFRONT_FLANK("spawnbot_flank"),
    SPAWN_BOT_WATERFRONT_FLANK2("spawnbot_flank2"),
    SPAWN_BOT_WATERFRONT_RANDOM("spawnbot_flank_rand"),

    // Dockyard
    SPAWN_BOT_DOCKYARD_MAIN_0("spawnbot_main_0"),
    SPAWN_BOT_DOCKYARD_MAIN_1("spawnbot_main_1"),
    SPAWN_BOT_DOCKYARD_FlANK_0("spawnbot_flank_0"),
    SPAWN_BOT_DOCKYARD_FLANK_1("spawnbot_flank_1"),
    SPAWN_BOT_DOCKYARD_LEFT_1("spawnbot_left_0"),
    SPAWN_BOT_DOCKYARD_RIGHT_1("spawnbot_right_0"),
    SPAWN_BOT_DOCKYARD_SCATTERED_0("spawnbot_scattered_0"),
    SPAWN_BOT_DOCKYARD_SCATTERED_1("spawnbot_scattered_1"),

    // Damm
    SPAWN_BOT_DAMM_MAIN0("spawnbot_main0"),
    SPAWN_BOT_DAMM_MAIN1("spawnbot_main1"),
    SPAWN_BOT_DAMM_MAIN2("spawnbot_main2"),
    SPAWN_BOT_DAMM_MAIN0_SQAUD("spawnbot_main0_squad"),
    SPAWN_BOT_DAMM_MAIN1_SLOW("spawnbot_main1_slow"),
    SPAWN_BOT_DAMM_UPPER0("spawnbot_upper0"),
    SPAWN_BOT_DAMM_UPPER1("spawnbot_upper1"),
    SPAWN_BOT_DAMM_SNIPER1("spawnbot_mission_sniper1"),

    // Atomgrad
    SPAWN_BOT_ATOMGRAD_FINAL("spawnbot_final"),

    // Band Corner
    SPAWN_BOT_BAND_CORNER_RIGHT("spawnbot_right"),
    SPAWN_BOT_BAND_CORNER_LEFT("spawnbot_left"),

    // Mario Kart
    SPAWN_BOT_MARIO_KART_UPPER("spawnbot_upper"),

    // Brugge
    SPAWN_BOT_BRUGGE_SIDE("spawnbot_side"),
    SPAWN_BOT_BRUGGE_FLANK("spawnbot_flank"),
    SPAWN_BOT_BRUGGE_INVASION("spawnbot_invasion"),
    SPAWN_BOT_BRUGGE_CHIEF("spawnbot_chief"),

    //Shiver Peak
    SPAWN_BOT_SHIVER_PEAK_FLANK("spawnbot_flank"),

    // Condemned
    SPAWN_BOT_CONDEMNED_SENTRY_BUSTER_FRONT("spawnbot_mission_sentrybuster_front"),
    SPAWN_BOT_CONDEMNED_SENTRY_BUSTER_BACK("spawnbot_mission_sentrybuster_back"),
    SPAWN_BOT_CONDEMNED_SPY_FRONT("spawnbot_mission_spy_front"),
    SPAWN_BOT_CONDEMNED_SPY_BACK("spawnbot_mission_spy_back"),
    SPAWN_BOT_CONDEMNED_FRONT("spawnbot_front"),
    SPAWN_BOT_CONDEMNED_FRONT_RIGHT("spawnbot_front_right"),
    SPAWN_BOT_CONDEMNED_FRONT_LEFT("spawnbot_front_left"),
    SPAWN_BOT_CONDEMNED_BACK("spawnbot_back"),
    SPAWN_BOT_CONDEMNED_BACK_RIGHT("spawnbot_back_right"),
    SPAWN_BOT_CONDEMNED_BACK_LEFT("spawnbot_back_left"),

    // Coast Rock
    SPAWN_BOT_COAST_ROCK_PARACHUTE("spawnbot_parachute"),
    SPAWN_BOT_COAST_ROCK_TUNNEL("spawnbot_tunnel"),

    // Casino City
    SPAWN_BOT_CASINO_CITY_CENTER("spawnbot_center"),
    SPAWN_BOT_CASINO_CITY_LEFT("spawnbot_left"),
    SPAWN_BOT_CASINO_CITY_RIGHT("spawnbot_right"),
    SPAWN_BOT_CASINO_CITY_CHIPS("spawnbot_chips"),

    // Skullcove
    SPAWN_BOT_SKULLCOVE_ENGINEER("spawnbot_mission_engy"),
    SPAWN_BOT_SKULLCOVE_LEFT("spawnbot_left"),
    SPAWN_BOT_SKULLCOVE_RIGHT("spawnbot_right"),
    SPAWN_BOT_SKULLCOVE_ALL("spawnbot_all"),

    // Oxidize
    SPAWN_BOT_OXIDIZE_SENTRY_BUSTER("spawnbot_mission_sentry_buster"),
    SPAWN_BOT_OXIDIZE_FLANKERS("flankers"),
    SPAWN_BOT_OXIDIZE_CHIEF("spawnbot_chief"),

    // Guardian Caster
    SPAWN_BOT_GUARDIAN_CASTER_GATE("spawnbot_gate"),
    SPAWN_BOT_GUARDIAN_CASTER_TOP("spawnbot_top"),
    SPAWN_BOT_GUARDIAN_CASTER_MONEY("spawnbot_money"),

    // Potassium
    SPAWN_BOT_POTASSIUM_LEFT("spawnbot_left"),

    // Sharp
    SPAWN_BOT_SHARP_SECONDARY("spawnbot_secondary"),
    SPAWN_BOT_SHARP_INVASION("spawnbot_invasion"),
    SPAWN_BOT_SHARP_LEFT("spawnbot_left"),
    SPAWN_BOT_SHARP_MIDDLE("spawnbot_middle"),
    SPAWN_BOT_SHARP_RIGHT("spawnbot_right"),

    // Trainyard
    SPAWN_BOT_TRAINYARD_SENTRY_BUSTER("spawnbot_mission_sentrybuster"),
    SPAWN_BOT_TRAINYARD_GATEBOT("gatebot"),
    SPAWN_BOT_TRAINYARD_GATEBOT_LEFT("gatebot_left"),
    SPAWN_BOT_TRAINYARD_GATEBOT_MIDDLE("gatebot_middle"),
    SPAWN_BOT_TRAINYARD_GATEBOT_RIGHT("gatebot_right"),
    SPAWN_BOT_TRAINYARD_LEFT("spawnbot_left"),
    SPAWN_BOT_TRAINYARD_MIDDLE("spawnbot_middle"),
    SPAWN_BOT_TRAINYARD_RIGHT("spawnbot_right"),
    SPAWN_BOT_TRAINYARD_BOSS("spawnbot_boss"), // Also gatebot_boss, but probabaly won't want that

    // Sanctum Fortress
    SPAWN_BOT_SANCTUM_FORTRESS_SENTRY_BUSTER("spawnbot_sentrybuster"),
    SPAWN_BOT_SANCTUM_FORTRESS_SPECIAL_BOMB("spawnbot_specialbomb");

    /**
     * The attribute for spawn location value
     */
    private final String spawnLocation;

    /**
     * Constructor
     * @param spawnLocation - the value to set the enum to
     */
    SpawnLocations(String spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    /**
     * The toString method
     * @return the value the enum should display
     */
    public String toString() {
        return spawnLocation;
    }
}
