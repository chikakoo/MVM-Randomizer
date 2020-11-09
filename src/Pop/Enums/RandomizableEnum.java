package Pop.Enums;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * An interface for PopEnums
 */
public interface RandomizableEnum {
    /**
     * Generate a random value for this enum
     * @param <T> - should be the type of the enum
     * @return the random value generated
     */
   static <T extends RandomizableEnum> T GenerateRandomValue() throws NotImplementedException {
        throw new NotImplementedException();
   }
}
