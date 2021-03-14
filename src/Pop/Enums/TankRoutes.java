package Pop.Enums;

import Pop.PopRandomizer;

/**
 * Created by Lionel on 1/18/2018.
 */
public enum TankRoutes {
    DECOY("boss_path_a1"), // and boss-path_b1
    BIGROCK("boss_path-a1"),// and boss_path_1
    COALTOWN("boss_path_a1"),
    MANNWORKS_1("boss_path_1"),
    MANNWORKS_2("boss_path2_1"),
    ROTTENBURG_1("tank_path_a_10"),
    ROTTENBURG_2("tank_path_b_10"),
    TEIEN_1("boss_path_a1"),
    TEIEN_2("boss_path_a2"),
    SANDSTONE("boss_path_a1"),
    MAELSTORM_1("tank_path_a_1"),
    MAELSTORM_2("tank_path_b_1"),
    DERP_1("tank_path_a_1"),
    DERP_2("tank_path_b_1"),
    PLATEAU_1("tank_path_a_1"),
    PLATEAU_2("tank_path_b_1"),
    VENTUS_1("tank_path_a_1"),
    VENTUS_2("tank_path_b_1"),
    QUETZALCOATL_1("tank_path_b1"),
    QUETZALCOATL_2("tank_path_a_10"),
    MANDARIN("boss_path_1"),
    AFFINITY("boss_path_a1"),
    OILRIG_1("tank_path_a_1"),
    OILRIG_2("tank_path_b_1"),
    SADDLE("boss_path_a1"),
    SPACEPOST("tank_path_a_1"),
    OVERGREEN("boss_path_1_5"),
    WATERFRONT_1("tankpath_same"),
    WATERFRONT_2("tankpath_alt"),
    DOCKYARD("boss_path_start"),
    HILLSIDE("boss_path_a1"),
    MANNCOHQ("tank_path_a_1"),
    PARADIGM("tank_path_a_1"),
    ATOMGRAD("tank_path_b_1"),
    BRUGGE("tank_path_1"),
    COAST_ROCK_SAME("tankpath_same"),
    COAST_ROCK_ALT("tankpath_alt"),
    CASINO_CITY_1("tank_path_a_1"),
    CASINO_CITY_2("tank_path_b_1"),
    CASINO_CITY_SENTRY("tank_path_sentrytank");

    /**
     * The attribute for the class value
     */
    private final String tankRoute;

    /**
     * Constructor
     * @param tankRoute - the value to set the enum to
     */
    TankRoutes(String tankRoute) {
        this.tankRoute = tankRoute;
    }

    /**
     * The toString method
     * @return the value the enum should display
     */
    public String toString() {
        return tankRoute;
    }
}