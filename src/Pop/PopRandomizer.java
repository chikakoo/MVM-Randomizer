package Pop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains randomizer functions for the pop file
 */
public class PopRandomizer {
    private static Random random = new Random();

    /**
     * Generates a random value between 0 (inclusive) and the max value (exclusive)
     * @param maxValue - the max value to generate
     * @return the generated value
     */
    public static int generateRandomValue(int maxValue) {
        return random.nextInt(maxValue);
    }

    /**
     * Generates a random value between minValue and maxValue (both inclusive)
     * @param minValue - the minimum value
     * @param maxValue - the maximum value
     * @return the generated number
     */
    public static int generateNumberInRange(int minValue, int maxValue) {
        if (minValue == maxValue) { return minValue; }

        if (maxValue < minValue) {
            int tempMaxValue = maxValue;
            maxValue = minValue;
            minValue = tempMaxValue;
        }

        int numberOfPossibleValues = maxValue - minValue + 1;
        return random.nextInt(numberOfPossibleValues) + minValue;
    }

    /**
     * Generates a random value between minValue and maxValue (both inclusive)
     * @param range - the range
     * @return the generated number
     */
    public static int generateNumberInRange(Range range) {
        int lowerBound = range.getLowerBound();
        int upperBound = range.getUpperBound();

        if (range.getLowerBound() < 0 && range.getUpperBound() < 0) {
            int generatedNumber = generateNumberInRange(lowerBound * -1, upperBound * -1);
            return generatedNumber * -1;
        }

        return generateNumberInRange(lowerBound, upperBound);
    }

    /**
     * Generate a boolean based on a percentage
     * @param percentChance - the percentage chance of true
     * @return true or false
     */
    public static boolean generateBooleanFromPercentage(double percentChance) {
        if (percentChance >= 100) { return true; }

        double randomDouble = random.nextDouble() * 100;
        return randomDouble < percentChance;
    }

    /**
     * Generate a boolean
     * @return true or false
     */
    public static boolean generateBoolean() {
        return random.nextBoolean();
    }

    /**
     * Returns a random item from the given list
     * @param list - the list to get the random item out of
     * @param <E> - the type of the list
     * @return the random item
     */
    public static <E> E randomElement(ArrayList<E> list) {
        int index = generateRandomValue(list.size());
        return list.get(index);
    }

    /**
     * Returns a random item from the given list and removes it from that list
     * @param list - the list to get the random item out of
     * @param <E> - the type of the list
     * @return the random item
     */
    public static <E> E getAndRemoveRandomElement(ArrayList<E> list) {
        int index = generateRandomValue(list.size());
        E item = list.get(index);
        list.remove(index);
        return item;
    }
}
