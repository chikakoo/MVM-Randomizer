package Pop.Enums;

/**
 * Used with randomization - just an enum of numbers
 * Add more as needed
 */
public enum NumericValues implements RandomizableEnum {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    /**
     * The value of the enum
     */
    private final int value;

    /**
     * Constructor
     * @param value - the value of the enum
     */
    NumericValues(int value) {
        this.value = value;
    }

    /**
     * Gets the numeric value
     * @return the numeric value
     */
    public int getNumericValue() {
        return value;
    }
}
