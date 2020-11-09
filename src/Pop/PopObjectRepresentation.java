package Pop;

/**
 * A representation of a PopObject - contains a popObject attribute
 */
public abstract class PopObjectRepresentation {
    /**
     * The name of this representation
     */
    protected String name;

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public abstract PopObject getPopObject();
}
