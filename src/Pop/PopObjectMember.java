package Pop;

import Pop.Enums.PopObjectTypes;

/**
 * A member of a PopObject - could be an attribute or another PopObject
 */
public abstract class PopObjectMember {
    /**
     * The name of the object
     */
    protected String name;

    /**
     * Whether the member is an attribute or an object
     */
    protected PopObjectTypes popObjectType;

    /**
     * Gets the name
     * @return the object's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns whether this member is an attribute
     * @return - true if it's an attribute; false otherwise
     */
    public boolean isAttribute() {
        return popObjectType == PopObjectTypes.ATTRIBUTE;
    }

    /**
     * Returns whether this member is an object
     * @return - true if it's an object; false otherwise
     */
    public boolean isObject() {
        return popObjectType == PopObjectTypes.OBJECT;
    }
}
