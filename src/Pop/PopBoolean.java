package Pop;

/**
 * This is a boolean type that has a toString mapped to "1" and "0"
 */
public class PopBoolean {
    /**
     * The value of the boolean
     */
    private boolean value = false;

    /**
     * Value getter
     * @return the value
     */
    public boolean getValue() { return value; }

    /**
     * Default constructor
     */
    public PopBoolean() { }

    /**
     * Constructor
     * @param value - the value of the boolean
     */
    public PopBoolean(boolean value) {
        this.value = value;
    }

    /**
     * Returns the string representation of the value
     * @return 1 if true, false otherwise
     */
    public String toString() {
        return value ? "1" : "0";
    }
}
