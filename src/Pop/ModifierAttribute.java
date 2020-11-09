package Pop;


/**
 * Represents an attribute on a character or item
 */
public class ModifierAttribute {
    /**
     * The name of the attribute
     */
    private String attribute = "";
    public String getAttribute() { return "\"" + attribute + "\""; }

    /**
     * The name of the value
     */
    private String value = "";
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public void setValue(int value) { this.value = value + ""; }
    public void setValue(double value) { this.value = value + ""; }

    /**
     * Constructor
     * @param attribute - the name of the attribute
     * @param value - the name of the value
     */
    public ModifierAttribute(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Constructor
     * @param attribute - the name of the attribute
     */
    public ModifierAttribute(String attribute) {
        this.attribute = attribute;
    }
}
