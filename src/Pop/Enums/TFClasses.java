package Pop.Enums;

import java.util.Arrays;

/**
 * All possible TFBot class values
 */
public enum TFClasses implements JsonSerializableEnum {
    SCOUT("Scout"),
    SNIPER("Sniper"),
    SOLDIER("Soldier"),
    DEMOMAN("Demoman"),
    MEDIC("Medic"),
    HEAVY("Heavy"),
    PYRO("Pyro"),
    SPY("Spy"),
    ENGINEER("Engineer");

    /**
     * The attribute for the class value
     */
    private final String tfClass;

    /**
     * Constructor
     * @param tfClass - the value to set the enum to
     */
    TFClasses(String tfClass) {
        this.tfClass = tfClass;
    }

    /**
     * Gets a sorted array of the values of this enum
     * @return the list
     */
    public static String[] getSortedStringValues() {
        TFClasses[] values = TFClasses.values();
        String[] stringValues = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            stringValues[i] = values[i].getDisplayString();
        }
        Arrays.sort(stringValues);
        return stringValues;
    }

    /**
     * Gets an enum value based on its toString value
     * @param stringName - the string value
     * @return The enum value
     */
    public static TFClasses getByStringName(String stringName) {
        stringName = stringName.toLowerCase();
        for (TFClasses currentTFClass : TFClasses.values()) {
            String currentClassString = currentTFClass.getDisplayString().toLowerCase();
            if (currentClassString.equals(stringName)) {
                return currentTFClass;
            } else if (currentClassString.equals("heavy") && stringName.equals("heavyweapons")) {
                return currentTFClass;
            }
        }

        return TFClasses.SCOUT;
    }

    /**
     * Gets the string to display
     * @return The string to display
     */
    @Override
    public String getDisplayString() { return tfClass; }

    /**
     * Gets the string to use for the default class icons
     * @return - The string
     */
    public String getStringForClassIcon() {
        if (this.equals(TFClasses.DEMOMAN)) {
            return "demo";
        }
        return this.toString().toLowerCase();
    }
}
