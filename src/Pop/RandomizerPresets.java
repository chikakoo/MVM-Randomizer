package Pop;

import Pop.Enums.*;
import java.util.ArrayList;

/**
 * Preset configurations for the weighted randomizer
 */
public class RandomizerPresets {
    /**
     * Gets a random skill level
     * @return the skill level
     */
    public static SkillLevels getRandomSkillLevel() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();
        weightedItems.add(new WeightedItem<>(SkillLevels.EASY, 80));
        weightedItems.add(new WeightedItem<>(SkillLevels.NORMAL, 12));
        weightedItems.add(new WeightedItem<>(SkillLevels.HARD, 6));
        weightedItems.add(new WeightedItem<>(SkillLevels.EXPERT, 2));

        WeightedItemCollection<SkillLevels> weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<SkillLevels> weightedRandomizer = new WeightedRandomizer(weightedItemCollection);

        return (SkillLevels)weightedRandomizer.getWeightedItem();
    }

    /**
     * Gets a random weapon restriction
     * @return the weapon restriction
     */
    public static WeaponRestrictions getWeaponRestrictionForRandomBot() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.NONE, 25));
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.PRIMARY_ONLY, 30));
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.SECONDARY_ONLY, 30));
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.MELEE_ONLY, 15));

        WeightedItemCollection<WeaponRestrictions> weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<WeaponRestrictions> weightedRandomizer = new WeightedRandomizer(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }

    /**
     * Gets a random weapon restriction
     * @return the weapon restriction
     */
    public static WeaponRestrictions getWeaponRestrictionForRandomSpy() {
        ArrayList<WeightedItem> weightedItems = new ArrayList<>();
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.PRIMARY_ONLY, 20));
        weightedItems.add(new WeightedItem<>(WeaponRestrictions.MELEE_ONLY, 90));

        WeightedItemCollection<WeaponRestrictions> weightedItemCollection = new WeightedItemCollection(weightedItems);
        WeightedRandomizer<WeaponRestrictions> weightedRandomizer = new WeightedRandomizer(weightedItemCollection);

        return weightedRandomizer.getWeightedItem();
    }
}
