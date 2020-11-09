package Pop.Settings;

/**
 * Settings for randomly generated bots
 */
public class RandomBotSettings {
    /**
     * The odds that the random bots will have additional attributes
     */
    private int percentAttributes;
    public int getPercentAttributes() {
        return percentAttributes;
    }
    public void setPercentAttributes(int percentAttributes) {
        this.percentAttributes = percentAttributes;
    }

    /**
     * The max number of additional attributes that each random bots can have
     */
    private int maxAttributes;
    public int getMaxAttributes() {
        return maxAttributes;
    }
    public void setMaxAttributes(int maxAttributes) {
        this.maxAttributes = maxAttributes;
    }

    /**
     * The odds that the random bots will spawn with a cosmetic
     */
    private int percentCosmetic;
    public int getPercentCosmetic() {
        return percentCosmetic;
    }
    public void setPercentCosmetic(int percentCosmetic) {
        this.percentCosmetic = percentCosmetic;
    }

    /**
     * The odds that the cosmetic will be painted
     */
    private int percentPaint;
    public int getPercentPaint() {
        return percentPaint;
    }
    public void setPercentPaint(int percentPaint) {
        this.percentPaint = percentPaint;
    }

    /**
     * The odds that the cosmetic will have an unusual effect
     */
    private int percentUnusualEffect;
    public int getPercentUnusualEffect() { return percentUnusualEffect; }
    public void setPercentUnusualEffect(int percentUnusualEffect) {
        this.percentUnusualEffect = percentUnusualEffect;
    }

    /**
     * The odds that a demoman's grenade or sticky launcher will have a random projectile model
     */
    private int percentRandomProjectileModel = 50;
    public int getPercentRandomProjectileModel() { return percentRandomProjectileModel; }
    public void setPercentRandomProjectileModel(int percentRandomProjectileModel) {
        this.percentRandomProjectileModel = percentRandomProjectileModel;
    }

    /**
     * Percent chance that any weapon will get a new projectile type
     * This also replaces the class icon
     */
    private int percentRandomProjectileType = 25;
    public int getPercentRandomProjectileType() {
        return percentRandomProjectileType;
    }
    public void setPercentRandomProjectileType(int percentRandomProjectileType) {
        this.percentRandomProjectileType = percentRandomProjectileType;
    }

    //TODO: settings for weapon restrictions

    /**
     * Copies the settings over from the given RandomBotSettings
     * @param randomBotSetting - the object to copy settings from
     */
    public void copySettings(RandomBotSettings randomBotSetting) {
        percentAttributes = randomBotSetting.getPercentAttributes();
        maxAttributes = randomBotSetting.getMaxAttributes();
        percentCosmetic = randomBotSetting.getPercentCosmetic();
        percentPaint = randomBotSetting.getPercentPaint();
        percentUnusualEffect = randomBotSetting.getPercentUnusualEffect();
        percentRandomProjectileModel = randomBotSetting.getPercentRandomProjectileModel();
        percentRandomProjectileType = randomBotSetting.getPercentRandomProjectileType();
    }
}
