package Pop;

import Pop.Enums.PopObjectTypes;

/**
 * An attribute in a PopObject
 */
public class PopObjectAttribute extends PopObjectMember {
    /**
     * The value of the attribute
     */
    private String value;

    /**
     * Gets the value
     * @return the attribute's value
     */
    public String getValue() {
        return value;
    }

    /**
     * Constructor
     * @param name - the name of the attribute
     * @param value - the value of the attribute
     */
    public PopObjectAttribute(String name, String value) {
        this.name = name;
        this.value = value;
        popObjectType = PopObjectTypes.ATTRIBUTE;
    }
}
