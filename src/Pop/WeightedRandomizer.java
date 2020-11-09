package Pop;

import Pop.Enums.*;
import java.util.*;

/**
 * Chooses a random value based on weighted values
 */
public class WeightedRandomizer<T> {
    /**
     * The random class
     */
    private Random random = new Random();

    /**
     * The weighted items
     */
    private WeightedItemCollection<T> weightedItemCollection = new WeightedItemCollection();

    /**
     * The "buckets" that the weighted items fall into
     */
    private ArrayList<Integer> buckets = new ArrayList();

    /**
     * Constructor
     * @param weightedItemCollection - the weighted items
     */
    public WeightedRandomizer(WeightedItemCollection weightedItemCollection) {
        this.weightedItemCollection = weightedItemCollection;

        CalculateBuckets();
    }

    /**
     * Calculate the "buckets" - there are the ranges of values that a particular
     * index will be chosen
     */
    private void CalculateBuckets() {
        int nextBucket = 0;
        for (WeightedItem item : weightedItemCollection.getWeightedItems()) {
            nextBucket += item.getWeight();
            buckets.add(nextBucket);
        }
    }

    /**
     * Randomly get a weighted item - if the total weight is 0, return back null since nothing can be chosen
     * @return the retrieved item
     */
    public T getWeightedItem() {
        int currentBucketIndex = 0;
        int totalWeight = weightedItemCollection.getTotalWeight();

        if (totalWeight == 0) {
            return null;
        }

        int randomNumber = random.nextInt(totalWeight);
        for (currentBucketIndex = 0;
             randomNumber >= buckets.get(currentBucketIndex);
             currentBucketIndex++)
        { }

        return weightedItemCollection.chooseItem(currentBucketIndex);
    }
}