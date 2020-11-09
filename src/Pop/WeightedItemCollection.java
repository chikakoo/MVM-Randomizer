package Pop;

import Pop.Enums.RandomizableEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of weighted items
 */
public class WeightedItemCollection<T> {
    /**
     * The weighted items
     */
    private ArrayList<WeightedItem<T>> weightedItems = new ArrayList();
    public ArrayList<WeightedItem<T>> getWeightedItems() { return weightedItems; }

    /**
     * Default constructor
     */
    public WeightedItemCollection() { }

    /**
     * Constructor
     * @param weightedItems - the weighted items
     */
    public WeightedItemCollection(ArrayList<WeightedItem<T>> weightedItems) {
        this.weightedItems = weightedItems;
    }

    /**
     * Adds an item to the collection
     * @param item - the item to add
     * @param weight - the weight of the item to add
     */
    public void add(T item, int weight) {
        weightedItems.add(new WeightedItem<T>(item, weight));
    }

    /**
     * Adds an item to the collection
     * @param item - the item to add
     * @param weight - the weight of the item to add
     * @param maxNumber - the maximum number of this item to be chosen
     */
    public void add(T item, int weight, int maxNumber) {
        weightedItems.add(new WeightedItem<T>(item, weight, maxNumber));
    }

    /**
     * Adds all the items in the given list, with the given weight
     * @param itemsToAdd - the list of items to add
     * @param weight - the weights to assign all the items
     */
    public void addAll(List<T> itemsToAdd, int weight) {
        for (T item : itemsToAdd) {
            add(item, weight);
        }
    }

    /**
     * Clears all values out of the collection
     */
    public void clear() {
        weightedItems.clear();
    }

    /**
     * Gets the total weight of the items
     * @return the total weight of the items
     */
    public int getTotalWeight() {
        int totalWeight = 0;
        for (WeightedItem item : weightedItems) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    /**
     * Chooses the item at the given index - this will remove the item if no more are available
     * @param index - the item index to remove
     * @Return the item that was removed
     */
    public T chooseItem(int index) {
        WeightedItem<T> item = weightedItems.get(index);
        item.chooseItem();

        if (!item.canBeChosen()) {
            weightedItems.remove(index);
        }

        return item.getItem();
    }

    /**
     * Change the weight of the given item
     * @param item - the item to change the weight of
     * @param weight - the weight to change the item to
     */
    public void changeWeight(T item, int weight) {
        for(WeightedItem<T> currentItem : weightedItems) {
            if (currentItem.getItem().equals(item)) {
                currentItem.setWeight(weight);
                return;
            }
        }
    }

    /**
     * Removes the given item
     * @param item - the item to remove
     */
    public void removeItem(T item) {
        for(int i = 0; i < weightedItems.size(); i++) {
            if (weightedItems.get(i).getItem().equals(item)) {
                weightedItems.remove(i);
                return;
            }
        }
    }

    /**
     * Gets a random item from the collection
     * @return the random item
     */
    public T getRandomItem() {
        WeightedRandomizer<T> randomizer = new WeightedRandomizer(this);
        return randomizer.getWeightedItem();
    }
}
