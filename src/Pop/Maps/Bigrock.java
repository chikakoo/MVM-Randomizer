package Pop.Maps;

        import Pop.Enums.TankRoutes;

/**
 * Bigrock
 */
public class Bigrock extends Map {
    /**
     * Constructor
     */
    public Bigrock() {
        super();
        name = "Bigrock";
        popfileName = "bigrock";

        tankRoutes.add(TankRoutes.BIGROCK);
    }
}
