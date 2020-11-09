package Pop.BotModifiers;


import Pop.PopRandomizer;
import Pop.Range;

/**
 * Created by Lionel on 2/10/2018.
 */
public class BotModifier {


    /**
     * The name of the modifier
     */
    protected String name;
    public String getName() { return name; }

    /**
     * What this modifier modifies
     */
    protected ModifierType type;

    /**
     * How the modifier's value should be converted
     */
    protected ConversionType conversionType;

    /**
     * The range of values this modifier can generate
     */
    protected Range range;

    /**
     * Constructor
     * @param name - The name of the modifier
     * @param type - The type of modifier
     * @param conversionType - conversionType
     * @param range - The range of values that could be used to make the bot stronger or weaker
     */
    public BotModifier(String name, ModifierType type, ConversionType conversionType, Range range) {
        this.name = name;
        this.type = type;
        this.conversionType = conversionType;
        this.range = range;
    }

    /**
     * Generates a value within the strongerRange values
     * @return The generated value
     */
    public String generateStrongerRangeValue() {
        double value = PopRandomizer.generateNumberInRange(range);
        if (conversionType.equals(ConversionType.PERCENTAGE)) {
            value = (value / 100.0) + 1; // So, 10 becomes 1.1, a 10% increase
            return Double.toString((double)Math.round(value * 100d) / 100d);
        } else {
            return Integer.toString((int)value);
        }
    }

    /**
     * Generates a value within the weakerRange values
     * @return The generated value
     */
    public String generateWeakerRangeValue() {
        double value = PopRandomizer.generateNumberInRange(range);
        if (conversionType.equals(ConversionType.PERCENTAGE)) {
            value = Math.abs((value / 100.0) - 1); // So, 10 becomes 0.9, a 10% decrease
            return Double.toString((double)Math.round(value * 100d) / 100d);
        } else {
            return Integer.toString((int)value);
        }
    }
}
