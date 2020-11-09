package Pop;

import Pop.Enums.RandomizableEnum;

/**
 * A weighted item - used with randomization to make some items more likely to be
 * chosen than others
 */
public class WeightedItem<T> {
    /**
     * The weighted item
     */
    private T item;
    public T getItem() { return item; }

    /**
     * The weight, relative to other weighted items
     */
    private int weight;
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    /**
     * The maximum times this item can be chosen
     */
    private int maxSelections;

    /**
     * The number of times this item was chosen
     */
    private int numberOfTimesChosen = 0;

    /**
     * Whether this item has no limit to the number of times it can be chosen
     */
    private boolean noChooseLimit;

    /**
     * Constructor
     * @param item - the weighted item
     * @param weight - the weight
     * @param maxSelections - the number of times this item was chosen
     */
    public WeightedItem(T item, int weight, int maxSelections) {
        this.item = item;
        this.weight = weight;
        this.maxSelections = maxSelections;
        this.noChooseLimit = false;
    }

    /**
     * Constructor
     * @param item - the weighted item
     * @param weight - the weight
     */
    public WeightedItem(T item, int weight) {
        this.item = item;
        this.weight = weight;
        this.noChooseLimit = true;
    }

    /**
     * Constructor
     * @param item - the weighted item
     */
    public WeightedItem(T item) {
        this.item = item;
        this.weight = 100;
        this.noChooseLimit = true;
    }

    /**
     * Chooses the item - increments numberOfTimesChosen if applicable
     */
    public void chooseItem() {
        if (!noChooseLimit) {
            numberOfTimesChosen++;
        }
    }

    /**
     * Returns whether the item can be chosen
     * @return whether the item can be chosen
     */
    public boolean canBeChosen() {
        if (noChooseLimit) {
            return true;
        }
        return numberOfTimesChosen < maxSelections;
    }
}
