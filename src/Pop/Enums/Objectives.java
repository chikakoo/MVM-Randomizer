package Pop.Enums;

import Pop.PopRandomizer;

/**
 * A list of possible mission objectives
 */
public enum Objectives implements RandomizableEnum {
    NONE(""),

    /**
     * Sentry busters
     */
    DESTROY_SENTRIES("DestroySentries"),

    /**
     * Snipers
     */
    SNIPER("Sniper"),

    /**
     * Spies
     */
    SPY("Spy"),

    /**
     * Engineers
     */
    ENGINEER("Engineer");

    /**
     * The attribute for objective value
     */
    private final String objective;

    /**
     * Constructor
     * @param objective - the value to set the enum to
     */
    Objectives(String objective) {
        this.objective = objective;
    }

    /**
     * Generates a random value for this enum
     * @return the generated value
     */
    public static Objectives GenerateRandomValue() {
        int index;
        Objectives objective = Objectives.DESTROY_SENTRIES;

        while (objective.equals(Objectives.DESTROY_SENTRIES)) {
            index = PopRandomizer.generateRandomValue(values().length);
            objective = values()[index];
        }

        return objective;
    }

    /**
     * The toString method
     * @return the value the enum should display
     */
    public String toString() {
        return objective;
    }
}
