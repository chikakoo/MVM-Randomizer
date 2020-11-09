package Pop.Enums;

import Pop.PopRandomizer;

/**
 * All possible bot skill levels
 */
public enum SkillLevels implements RandomizableEnum {
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    EXPERT("Expert");

    /**
     * The attribute for the skill level
    */
    private final String skillLevel;

    /**
     * Constructor
     * @param skillLevel - the value to set the enum to
     */
    SkillLevels(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Generates a random value for this enum
     * @return the generated value
     */
    public static SkillLevels GenerateRandomValue() {
        int index = PopRandomizer.generateRandomValue(values().length);
        return values()[index];
    }

    /**
     * The toString method
     * @return the value the enum should display
     */
    public String toString() {
        return skillLevel;
    }
}
