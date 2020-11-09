package Pop.Enums;

/**
 * An enum representing the values "Yes" and "No"
 */
public enum YesOrNo {
    /**
     * The "yes" value
     */
    YES("yes"),

    /**
     * The "no" value
     */
    NO("no");

    /**
     * The attribute for the yes or no value
     */
    private final String yesOrNo;

    /**
     * Constructor
     * @param yesOrNo - the value to set the enum to
     */
    YesOrNo(String yesOrNo) {
        this.yesOrNo = yesOrNo;
    }

    /**
     * The toString method
     * @return the value the enum should display
     */
    public String toString() {
        return yesOrNo;
    }
}
