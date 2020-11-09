package Pop.GUI;

import Pop.MVMRandomizer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for configuring random bot generation
 */
public class RandomBotPanel extends JPanel {
    /**
     * GUI Components
     */
    private IntegerFieldPanel percentAttributesPanel = new IntegerFieldPanel("% chance of attributes:", new Dimension(30, 20));
    private IntegerFieldPanel maxNumberOfAttributesPanel = new IntegerFieldPanel("Max number of attributes:", new Dimension(30, 20));
    private IntegerFieldPanel percentCosmeticPanel = new IntegerFieldPanel("% chance of cosmetic:", new Dimension(30, 20));
    private IntegerFieldPanel percentPaintedPanel = new IntegerFieldPanel("% chance of cosmetic being painted:", new Dimension(30, 20));
    private IntegerFieldPanel percentUnusualEffectPanel = new IntegerFieldPanel("% chance of cosmetic being unusual:", new Dimension(30, 20));
    private IntegerFieldPanel percentRandomProjectileModel = new IntegerFieldPanel("% chance of random demoman projectile models:", new Dimension(30, 20));
    private IntegerFieldPanel percentRandomProjectileType = new IntegerFieldPanel("% chance of random projectile type:", new Dimension(30, 20));

    /**
     * Getters for the settings
     */
    public int getPercentAttributes() { return percentAttributesPanel.getValue(); }
    public int getMaxNumberOfAttributes() { return maxNumberOfAttributesPanel.getValue(); }
    public int getPercentCosmetic() { return percentCosmeticPanel.getValue(); }
    public int getPercentPainted() { return percentPaintedPanel.getValue(); }
    public int getPercentUnusualEffect() { return percentUnusualEffectPanel.getValue(); }
    public int getPercentRandomProjectileEffect() { return percentRandomProjectileModel.getValue(); }
    public int getPercentRandomProjectileType() { return percentRandomProjectileType.getValue(); }

    /**
     * Constructor
     */
    public RandomBotPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        Panel randomSettingsPanel = new Panel();
        randomSettingsPanel.setLayout(new BoxLayout(randomSettingsPanel, BoxLayout.Y_AXIS));
        randomSettingsPanel.add(percentAttributesPanel);
        randomSettingsPanel.add(maxNumberOfAttributesPanel);
        randomSettingsPanel.add(percentCosmeticPanel);
        randomSettingsPanel.add(percentPaintedPanel);
        randomSettingsPanel.add(percentUnusualEffectPanel);
        randomSettingsPanel.add(percentRandomProjectileModel);
        randomSettingsPanel.add(percentRandomProjectileType);

        this.add(randomSettingsPanel);

        applySettings();
    }

    /**
     * Applies all the mvm randomizer fileSettings
     */
    public void applySettings() {
        percentAttributesPanel.setValue(MVMRandomizer.randomBotSettings.getPercentAttributes());
        maxNumberOfAttributesPanel.setValue(MVMRandomizer.randomBotSettings.getMaxAttributes());
        percentCosmeticPanel.setValue(MVMRandomizer.randomBotSettings.getPercentCosmetic());
        percentPaintedPanel.setValue(MVMRandomizer.randomBotSettings.getPercentPaint());
        percentUnusualEffectPanel.setValue(MVMRandomizer.randomBotSettings.getPercentUnusualEffect());
        percentRandomProjectileModel.setValue(MVMRandomizer.randomBotSettings.getPercentRandomProjectileModel());
        percentRandomProjectileType.setValue(MVMRandomizer.randomBotSettings.getPercentRandomProjectileType());
    }
}
