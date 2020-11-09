package Pop;

/**
 * A simple class with an upper and lower range value
 */
public class Range {
    /**
     * The lower bound of the range
     */
    private int lowerBound;
    public int getLowerBound() { return lowerBound; }
    public void setLowerBound(int lowerBound) { this.lowerBound = lowerBound; }

    /**
     * The upper bound of the range
     */
    private int upperBound;
    public int getUpperBound() { return upperBound; }
    public void setUpperBound(int upperBound) { this.upperBound = upperBound; }

    /**
     * Constructor
     *
     * @param lowerBound - the lower bound
     * @param upperBound - the upper bound
     */
    public Range(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Constructor
     * @param value - sets both lower and upper to these values
     */
    public Range(int value) {
        this.lowerBound = value;
        this.upperBound = value;
    }

    /**
     * Default constructor
     */
    public Range() { }

    /**
     * Copy constructor
     */
    public Range(Range rangeToCopyFrom) {
        if (rangeToCopyFrom != null) {
            this.lowerBound = rangeToCopyFrom.getLowerBound();
            this.upperBound = rangeToCopyFrom.getUpperBound();
        }
    }

    /**
     * Gets the larger of the two ranges based on the upperBound
     * @param range1 - the first range
     * @param range2 - the second range
     */
    public static Range getLowerRange(Range range1, Range range2) {
        return range1.getUpperBound() > range2.getUpperBound() ?
            range2 :
            range1;
    }
}
