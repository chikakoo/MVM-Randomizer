package Pop;

import Pop.Enums.PopObjectTypes;

import java.util.ArrayList;

/**
 * Represents an object in a popfile
 */
public class PopObject extends PopObjectMember {
    /**
     * The attributes and their values
     */
    private ArrayList<PopObjectMember> members;

    /**
     * Gets the object's attributes
     * @return the object's attributes
     */
    public ArrayList<PopObjectMember> getMembers() {
        return members;
    }

    /**
     * Constructor
     * @param name - the name of the object
     */
    public PopObject(String name) {
        this.name = name;
        members = new ArrayList();
        popObjectType = PopObjectTypes.OBJECT;
    }

    /**
     * Adds an attribute to the member list
     * @param name - the name of the attribute
     * @param value - the value of the attribute
     */
    public void addAttribute(String name, String value) {
        members.add(new PopObjectAttribute(name, value));
    }

    /**
     * Adds an object to the member list - if null, does nothing
     * @param popObject - the object to add
     */
    public void addObject(PopObject popObject) {
        if (popObject != null) {
            members.add(popObject);
        }
    }

    /**
     * Adds a PopObject from a given PopObjectRepresentation
     * @param popObjectRepresentation - the popObjectRepresentation
     */
    public void addObjectRepresentation(PopObjectRepresentation popObjectRepresentation) {
        if (popObjectRepresentation != null) {
            members.add(popObjectRepresentation.getPopObject());
        }
    }

    /**
     * Adds a list of object representations to the member list
     * @param popObjectRepresentations - the list of the PopObjectRepsentations
     */
    public void addObjectRepresentations(ArrayList<PopObjectRepresentation> popObjectRepresentations) {
        for (PopObjectRepresentation popObjectRepresentation : popObjectRepresentations) {
            members.add(popObjectRepresentation.getPopObject());
        }
    }
}
