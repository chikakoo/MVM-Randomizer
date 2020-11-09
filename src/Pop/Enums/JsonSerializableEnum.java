package Pop.Enums;

/**
 * Places on enums that are to be serialized - these CANNOT have their own toString methods
 */
public interface JsonSerializableEnum {
    /**
     * Gets the string to display
     * @return The string to display
     */
    String getDisplayString();
}
