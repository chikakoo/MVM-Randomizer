package Pop;

import java.util.ArrayList;

/**
 * A list of attributes to give an item
 */
public class ItemAttributes extends PopObjectRepresentation {
    /**
     * The name of the item to be modified
     */
    private String itemName;
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    /**
     * The list of attributes to include on the item
     */
    private ArrayList<ModifierAttribute> attributes = new ArrayList<>();
    public ItemAttributes(String itemName) {
        this.itemName = "\"" + itemName + "\"";
    }

    /**
     * Returns the representation of this popObject - null if there are no attributes
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        if (attributes.isEmpty()) {
            return null;
        }

        PopObject popObject = new PopObject("ItemAttributes");
        popObject.addAttribute("ItemName", itemName);

        for (ModifierAttribute attribute : attributes) {
            popObject.addAttribute(attribute.getAttribute(), attribute.getValue());
        }

        return popObject;
    }

    /**
     * Add an attribute to this ItemAttributes object - replaces it if it exists already
     * @param attribute - the attribute name
     * @param value - the attribute value
     */
    public void add(String attribute, String value) {
        ModifierAttribute existingAttribute = getAttribute(attribute);
        if (existingAttribute == null) {
            attributes.add(new ModifierAttribute(attribute, value));
        } else {
            existingAttribute.setValue(value);
        }
    }

    /**
     * Returns whether the object contains any values
     * @return true if the object contains values; false otherwise
     */
    public boolean isEmpty() {
        return attributes.size() == 0;
    }

    /**
     * Gets the modifier attribute for the given item name and attribute
     * @param attribute The attribute
     * @return The retrieved Modifier Attribute, or null if it doesn't exist
     */
    public ModifierAttribute getAttribute(String attribute) {
        for (ModifierAttribute modifierAttribute : attributes) {
            if (modifierAttribute.getAttribute().equals("\"" + attribute + "\"")) {
                return modifierAttribute;
            }
        }
        return null;
    }
}
