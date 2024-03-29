package Pop.Enums;

import Pop.PopRandomizer;

/**
 * A list of maps
 */
public enum Maps implements JsonSerializableEnum {
    DEFAULT("Random"),
    COALTOWN("Coaltown"),
    DECOY("Decoy"),
    MANNWORKS("Mannworks"),
    MANNHATTAN("Mannhattan"),
    ROTTENBURG("Rottenburg"),
    BIGROCK("Bigrock"),

    // Community
    TEIEN("Teien"),
    INTERSECTION("Intersection"),
    SANDSTONE("Sandstone"),
    MAELSTROM("Maelstrom"),
    //DERP("Derp"), // Unfinished
    MUSEUM("Museum"),
    VENTUS("Ventus"),
    PLATEAU("Plateau"),
    QUETZALCOATL("Quetzalcoatl"),
    OVERGREEN("Overgreen"),
    DAMM("Damm"),
    WATERFRONT("Waterfront"),
    DOCKYARD("Dockyard"),
    TEUFORT("2Fort"),
    ATOMGRAD("Atomgrad"),
    SPACEPOST("Spacepost"),
    SNOWFLAKE("Snowflake"),
    AFFINITY("Affinity"),
    MANNDARIN("Manndarin"),
    OILRIG("Oilrig"),
    SADDLE("Saddle"),
    HILLSIDE("Hillside"),
    MANNCOHQ("Mann Co. HQ"),
    BANDCORNER("Band Corner"),
    MARIO_KART("Mario Kart"),
    BRUGGE("Brugge"),
    SHIVER_PEAK("Shiver Peak"),
    CONDEMNED("Condemned"),
    COAST_ROCK("Coast Rock"),
    CASINO_CITY("Casino City"),
    SKULLCOVE("Skull Cove"),
    SEQUOIA("Sequoia"),
    OXIDIZE("Oxidize"),
    GUARDIAN_CASTER("Guardian Caster"),
    TRAINYARD("Trainyard"),
    POTASSIUM("Potassium"),
    HIDEOUT("Hideout"),
    SHARP("Sharp"),
    SANCTUM_FORTRESS("Sanctum Fortress");

    /**
     * The value of the enum
     */
    private final String map;

    /**
     * Constructor
     * @param map - the value to set the enum to
     */
    Maps(String map) {
        this.map = map;
    }

    /**
     * Gets whether the map is part of the standard TF2 maps
     * @return
     */
    public static boolean isStandardMap(Maps map) {
        return
            map.equals(Maps.BIGROCK) ||
            map.equals(Maps.COALTOWN) ||
            map.equals(Maps.DECOY) ||
            map.equals(Maps.MANNHATTAN) ||
            map.equals(Maps.MANNWORKS) ||
            map.equals(Maps.ROTTENBURG);
    }

    /**
     * Gets the string to display
     * @return The string to display
     */
    @Override
    public String getDisplayString() { return map; }
}
