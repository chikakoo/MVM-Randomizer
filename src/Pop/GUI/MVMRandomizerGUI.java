package Pop.GUI;

import Pop.Bot.BotTemplates;
import Pop.MVMRandomizer;
import Pop.Range;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * The GUI for MVMRandomizer
 */
public class MVMRandomizerGUI extends JFrame {
    private static JTabbedPane tabbedPane;
    public static MainPanel mainPanel;
    public static WavePanel wavePanel;
    public static BotPanel botPanel;
    public static RandomBotPanel randomBotPanel;
    public static TankPanel tankPanel;
    public static MapPanel mapPanel;

    public static void main(String[] args) {
        String error = BotTemplates.populateTemplates();
        if (!error.equals("")) {
            OutputConsole.addMessage(error);
        }

        JMenuBar menuBar = new MenuBar();
        mainPanel = new MainPanel();
        wavePanel = new WavePanel();
        botPanel = new BotPanel();
        randomBotPanel = new RandomBotPanel();
        tankPanel = new TankPanel();
        mapPanel = new MapPanel();

        setLookAndFeel("Nimbus");
        MVMRandomizer.initialize();

        tabbedPane = new JTabbedPane();
        tabbedPane.addChangeListener(new TabChangedListener());
        tabbedPane.add(mainPanel, "Generate");
        tabbedPane.add(wavePanel, "Wave");
        tabbedPane.add(botPanel, "Bot");
        tabbedPane.add(randomBotPanel, "Random Bot");
        tabbedPane.add(tankPanel, "Tank");
        tabbedPane.add(mapPanel, "Map");

        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setJMenuBar(menuBar);
        frame.add(tabbedPane);
        frame.setSize(1024, 768);
        frame.setMaximumSize(new Dimension(1024, 768));
        frame.setPreferredSize(new Dimension(1024, 768));
        frame.setTitle("MVM Randomizer");
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Sets the look and feel of the application
     * @param lookAndFeelName The look and feel name
     */
    private static void setLookAndFeel(String lookAndFeelName) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(lookAndFeelName)) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            OutputConsole.addMessage("INFO: The " + lookAndFeelName + " look and feel is unavailable. Using the default.");
        }
    }

    /**
     * Applies all the saved settings so that the data in the matches that of the settings
     */
    public static void applyAllSettings() {
        MVMRandomizerGUI.mainPanel.applySettings();
        MVMRandomizerGUI.tankPanel.applySettings();
        MVMRandomizerGUI.botPanel.applySettings();
        MVMRandomizerGUI.randomBotPanel.applySettings();
        MVMRandomizerGUI.wavePanel.applySettings();
        MVMRandomizerGUI.mapPanel.applySettings();
    }

    /**
     * Updates the settings with the current state of the GUI
     */
    public static void updateSettings() {
        MVMRandomizer.fileSettings.setPopPath(MainPanel.getPopPath());
        MVMRandomizer.fileSettings.setMissionName(MainPanel.getMissionName());
        MVMRandomizer.fileSettings.setDeletingMissions(MainPanel.getDeleteFiles());
        MVMRandomizer.waveScheduleSettings.setNumberOfWaves(MainPanel.getNumberOfWaves());

        updateWavePanelTable(); // Ensures that there are the correct number of waves if they were recently changed
        MVMRandomizer.waveSettings.setWaves(wavePanel.getWaveSettings());

        // Note that the map settings table will update them as they're being edited - no need to do anything here
        MVMRandomizer.mapSettings.setSelectedMap(MainPanel.getSelectedMap());

        // Note that the bot settings table will update them as it's being edited - no need to do anything here
        MVMRandomizer.botSettings.setPercentRandom(botPanel.getPercentRandom());
        MVMRandomizer.botSettings.setStandardBotDistributions(botPanel.getStandardBotDistributions());
        MVMRandomizer.botSettings.setGiantBotDistributions(botPanel.getGiantBotDistributions());
        MVMRandomizer.botSettings.setSupportBotDistributions(botPanel.getSupportBotDistributions());

        MVMRandomizer.randomBotSettings.setPercentAttributes(randomBotPanel.getPercentAttributes());
        MVMRandomizer.randomBotSettings.setMaxAttributes(randomBotPanel.getMaxNumberOfAttributes());
        MVMRandomizer.randomBotSettings.setPercentCosmetic(randomBotPanel.getPercentCosmetic());
        MVMRandomizer.randomBotSettings.setPercentPaint(randomBotPanel.getPercentPainted());
        MVMRandomizer.randomBotSettings.setPercentUnusualEffect(randomBotPanel.getPercentUnusualEffect());
        MVMRandomizer.randomBotSettings.setPercentRandomProjectileModel(randomBotPanel.getPercentRandomProjectileEffect());
        MVMRandomizer.randomBotSettings.setPercentRandomProjectileType(randomBotPanel.getPercentRandomProjectileType());

        MVMRandomizer.tankSettings.setWaveSpawnReduction(tankPanel.getWaveSpawnReduction());
        MVMRandomizer.tankSettings.setTanks(tankPanel.getTankSettings());
    }

    /**
     * Detects when a new tab is selected
     */
    private static class TabChangedListener implements ChangeListener {
        /**
         * Resizes the wave panel table to be the max number of wave spawns when that tab is selected
         * @param e
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            int selectedIndex = tabbedPane.getSelectedIndex();

            if (selectedIndex == 0) { // The main panel
                mainPanel.setUpMapChoices();
            } else if (selectedIndex == 1) { // The wave panel
                updateWavePanelTable();
            }
        }
    }

    /**
     * Updates the wave panel table so that the correct number of waves are displayed
     */
    private static void updateWavePanelTable() {
        Range waveSpawnRange = MainPanel.getNumberOfWaves();
        int maxWaveSpawns = Math.max(waveSpawnRange.getUpperBound(), waveSpawnRange.getLowerBound());

        wavePanel.resizeTable(maxWaveSpawns);
    }
}
