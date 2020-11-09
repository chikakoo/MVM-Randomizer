package Pop.GUI;

import Pop.Enums.TFClasses;
import Pop.GUI.TableModels.BotSettingsItemModel;
import Pop.GUI.TableModels.ClassDistributionModel;
import Pop.MVMRandomizer;
import Pop.Settings.ClassPercentage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Panel for configuring bot generation
 */
public class BotPanel extends JPanel {
    /**
     * GUI Components
     */
    private JRadioButton normalButton;
    private JRadioButton giantButton;

    private JRadioButton standardButton;
    private JRadioButton supportButton;

    private JComboBox<String> tfClassComboBox;

    private JTable botSettingsTable;
    private BotSettingsItemModel botSettingsModel;

    JMenuItem setEasySpawnRangeMenuItem = new JMenuItem("Set easy spawn range");
    JMenuItem setNormalSpawnRangeMenuItem = new JMenuItem("Set normal spawn range");
    JMenuItem setHardSpawnRangeMenuItem = new JMenuItem("Set hard spawn range");
    JMenuItem setImpossibleSpawnRangeMenuItem = new JMenuItem("Set impossible spawn range");

    private JTable standardBotDistributionsTable;
    private JTable giantBotDistrubtionsTable;
    private JTable supportBotDistrubtionsTable;

    private JScrollPane nonSupportDistrubtionsScrollPane;

    private ClassDistributionModel standardBotDistributionsModel;
    private ClassDistributionModel giantBotDistributionsModel;
    private ClassDistributionModel supportBotDistrubtionsModel;

    private IntegerFieldPanel percentRandomPanel = new IntegerFieldPanel("% chance of random bots (vs. templated):", new Dimension(30, 20));

    /**
     * Getters for the settings
     */
    public int getPercentRandom() { return percentRandomPanel.getValue(); }

    public ClassPercentage getStandardBotDistributions() {
        int weightColumn = 1;

        return new ClassPercentage(
            (int)standardBotDistributionsTable.getValueAt(0, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(1, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(2, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(3, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(4, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(5, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(6, weightColumn),
            (int)standardBotDistributionsTable.getValueAt(7, weightColumn),
            0
        );
    }

    public ClassPercentage getGiantBotDistributions() {
        int weightColumn = 1;

        return new ClassPercentage(
            (int)giantBotDistrubtionsTable.getValueAt(0, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(1, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(2, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(3, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(4, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(5, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(6, weightColumn),
            (int)giantBotDistrubtionsTable.getValueAt(7, weightColumn),
                0
        );
    }

    public ClassPercentage getSupportBotDistributions() {
        int weightColumn = 1;

        return new ClassPercentage(
            (int)supportBotDistrubtionsTable.getValueAt(0, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(1, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(2, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(3, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(4, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(5, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(6, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(7, weightColumn),
            (int)supportBotDistrubtionsTable.getValueAt(8, weightColumn)
        );
    }

    /**
     * Constructor
     */
    public BotPanel() {
        this.setLayout(new BorderLayout());

        JPanel botSettingsPanel = setUpBotSettingsPanel();
        JPanel classDistributionsPanel = setUpDistributionPanel();

        centerCellText();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(botSettingsPanel);
        bottomPanel.add(classDistributionsPanel);

        this.add(percentRandomPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);

        updateBotSettingsTable();
        applySettings();
    }

    /**
     * Applies all the mvm randomizer fileSettings
     * Note that the bot settings table is already populated using the settings, so no need to do anything with that here
     */
    public void applySettings() {
        updateBotSettingsTable();
        percentRandomPanel.setValue(MVMRandomizer.botSettings.getPercentRandom());
        standardBotDistributionsModel.initializeForStandardBots();
        giantBotDistributionsModel.initializeForGiantBots();
        supportBotDistrubtionsModel.initializeForSupportBots();
    }

    /**
     * Updates the table model to reflect the current filters
     */
    public void updateBotSettingsTable() {
        botSettingsModel.initialize(
            giantButton.isSelected(),
            supportButton.isSelected(),
            TFClasses.getByStringName((String)tfClassComboBox.getSelectedItem()));
    }

    /**
     * Update the table model to reflect the current filters
     * @param - whether the giants button is selected
     */
    private void updateBotSettingsTableForBotSize(boolean giantsSelected) {
        botSettingsModel.initialize(
            giantsSelected,
            supportButton.isSelected(),
            TFClasses.getByStringName((String)tfClassComboBox.getSelectedItem()));
    }

    /**
     * Update the table model to reflect the current filters
     * @param - whether the support button is selected
     */
    private void updateBotSettingsTableForSpawnType(boolean supportSelected) {
        botSettingsModel.initialize(
            giantButton.isSelected(),
            supportSelected,
            TFClasses.getByStringName((String)tfClassComboBox.getSelectedItem()));
    }

    /**
     * Creates and returns the panel for configuring bots
     * @return
     */
    private JPanel setUpBotSettingsPanel() {
        JPanel botSettingsPanel = new JPanel();
        botSettingsPanel.setLayout(new BorderLayout());

        botSettingsModel = new BotSettingsItemModel();
        botSettingsTable = new JTable(botSettingsModel);
        botSettingsTable.getSelectionModel().addListSelectionListener(new RowSelectionListener());
        botSettingsTable.setAutoCreateRowSorter(true);
        JScrollPane botSettingsScrollPane = new JScrollPane(botSettingsTable);

        JPanel topPanel = new JPanel();
        topPanel.add(setUpBotSizePanel());
        topPanel.add(setUpSpawnTypePanel());
        topPanel.add(setUpTFClassPanel());

        botSettingsPanel.add(topPanel, BorderLayout.NORTH);
        botSettingsPanel.add(botSettingsScrollPane, BorderLayout.CENTER);

        setUpBotSettingsContextMenu();

        return botSettingsPanel;
    }

    /**
     * Listener for when rows in the table are selected
     */
    private class RowSelectionListener implements ListSelectionListener {
        /**
         * Disables/enables menu options as appropriate
         * @param e
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            boolean shouldEnableItems = botSettingsTable.getSelectedRow() >= 0;
            enableOrDisableMenuItems(shouldEnableItems);
        }
    }

    /**
     * Creates and returns the panel for choosing the bot size filter
     * @return
     */
    private JPanel setUpBotSizePanel() {
        JPanel botSizePanel = new JPanel();
        botSizePanel.setBorder(new TitledBorder("Bot Size"));

        normalButton = new JRadioButton("Normal");
        giantButton = new JRadioButton("Giant");

        ButtonGroup botSizeButtonGroup = new ButtonGroup();
        botSizeButtonGroup.add(normalButton);
        botSizeButtonGroup.add(giantButton);

        botSizePanel.add(normalButton);
        botSizePanel.add(giantButton);

        normalButton.setSelected(true);
        normalButton.addItemListener(new BotSizeChangeListener());

        return botSizePanel;
    }

    /**
     * Listener for the radio buttons - this is meant to be put on the normal button
     */
    private class BotSizeChangeListener implements ItemListener {
        /**
         * Update the bot settings table - if this fired, that means the selected item changed
         * @param e
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            boolean isGiantSeleted = e.getStateChange() == ItemEvent.DESELECTED;
            updateBotSettingsTableForBotSize(isGiantSeleted);
            changeNonSupportDistrubtionsScrollPane(isGiantSeleted);
        }
    }

    /**
     * Creates and returns the panel for choosing the spawn type filter
     * @return
     */
    private JPanel setUpSpawnTypePanel() {
        JPanel spawnTypePanel = new JPanel();
        spawnTypePanel.setBorder(new TitledBorder("Spawn Type"));

        standardButton = new JRadioButton("Standard");
        supportButton = new JRadioButton("Support/Mission");

        ButtonGroup botSizeButtonGroup = new ButtonGroup();
        botSizeButtonGroup.add(standardButton);
        botSizeButtonGroup.add(supportButton);

        spawnTypePanel.add(standardButton);
        spawnTypePanel.add(supportButton);

        standardButton.setSelected(true);
        standardButton.addItemListener(new SpawnTypeChangeListener());

        return spawnTypePanel;
    }

    /**
     * Listener for the radio buttons - this is meant to be put on the standard button
     */
    private class SpawnTypeChangeListener implements ItemListener {
        /**
         * Update the bot settings table - if this fired, that means the selected item changed
         * @param e
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            updateBotSettingsTableForSpawnType(e.getStateChange() == ItemEvent.DESELECTED);
        }
    }

    /**
     * Creates and returns the panel for choosing the tfClass filter
     * @return
     */
    private JPanel setUpTFClassPanel() {
        JPanel tfClassPanel = new JPanel();
        tfClassPanel.setBorder(new TitledBorder("Class"));

        tfClassComboBox = new JComboBox<>(TFClasses.getSortedStringValues());
        tfClassComboBox.setBackground(Color.WHITE);
        tfClassComboBox.addActionListener(new TFClassComboBoxListener());
        tfClassPanel.add(tfClassComboBox);

        return tfClassPanel;
    }

    /**
     * The action listener for the tfClasses combo box
     */
    private class TFClassComboBoxListener implements ActionListener {
        /**
         * Updates the bot settings
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            updateBotSettingsTable();
        }
    }

    /**
     * Sets up the context menu for the bt settings table
     */
    private void setUpBotSettingsContextMenu() {
        JPopupMenu contextMenu = new JPopupMenu();
        contextMenu.add(setEasySpawnRangeMenuItem);
        contextMenu.add(setNormalSpawnRangeMenuItem);
        contextMenu.add(setHardSpawnRangeMenuItem);
        contextMenu.add(setImpossibleSpawnRangeMenuItem);

        enableOrDisableMenuItems(false);

        setEasySpawnRangeMenuItem.addActionListener(new SetEasySpawnRangeListener());
        setNormalSpawnRangeMenuItem.addActionListener(new SetNormalSpawnRangeListener());
        setHardSpawnRangeMenuItem.addActionListener(new SetHardSpawnRangeListener());
        setImpossibleSpawnRangeMenuItem.addActionListener(new SetImpossibleSpawnRangeListener());

        botSettingsTable.setComponentPopupMenu(contextMenu);
    }

    /**
     * Enables or disables all the menu items
     * @param shouldEnableItems - true to enable, false to disable
     */
    private void enableOrDisableMenuItems(boolean shouldEnableItems) {
        setEasySpawnRangeMenuItem.setEnabled(shouldEnableItems);
        setNormalSpawnRangeMenuItem.setEnabled(shouldEnableItems);
        setHardSpawnRangeMenuItem.setEnabled(shouldEnableItems);
        setImpossibleSpawnRangeMenuItem.setEnabled(shouldEnableItems);
    }

    /**
     * Below are listeners for all the set spawn range menu items
     */
    private class SetEasySpawnRangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = botSettingsTable.getSelectedRow();
            botSettingsModel.setEasySpawnRange(selectedRow);
            botSettingsTable.changeSelection(selectedRow, 0, false, false);
        }
    }

    private class SetNormalSpawnRangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = botSettingsTable.getSelectedRow();
            botSettingsModel.setNormalSpawnRange(selectedRow);
            botSettingsTable.changeSelection(selectedRow, 0, false, false);
        }
    }

    private class SetHardSpawnRangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = botSettingsTable.getSelectedRow();
            botSettingsModel.setHardSpawnRange(selectedRow);
            botSettingsTable.changeSelection(selectedRow, 0, false, false);
        }
    }

    private class SetImpossibleSpawnRangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = botSettingsTable.getSelectedRow();
            botSettingsModel.setImpossibleSpawnRange(selectedRow);
            botSettingsTable.changeSelection(selectedRow, 0, false, false);
        }
    }

    /**
     * Sets up the panel containing the class distrubtion tables
     * @return The panel
     */
    private JPanel setUpDistributionPanel() {
        JPanel classDistributionsPanel = new JPanel();
        classDistributionsPanel.setLayout(new BoxLayout(classDistributionsPanel, BoxLayout.X_AXIS));

        standardBotDistributionsModel = new ClassDistributionModel();
        standardBotDistributionsTable = new JTable(standardBotDistributionsModel);

        giantBotDistributionsModel = new ClassDistributionModel();
        giantBotDistrubtionsTable = new JTable(giantBotDistributionsModel);

        nonSupportDistrubtionsScrollPane = new JScrollPane();
        changeNonSupportDistrubtionsScrollPane(false);

        supportBotDistrubtionsModel = new ClassDistributionModel(true);
        supportBotDistrubtionsTable = new JTable(supportBotDistrubtionsModel)
        {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component component = super.prepareRenderer(renderer, row, column);
                JComponent jComponent = (JComponent)component;
                Border border = new MatteBorder(0, 0, 1, 0, Color.RED);

                // Add a border to the area dividing the mission bots and standard bots
                if (row == 5) {
                    jComponent.setBorder(border);
                }

                return component;
            }
        };
        JScrollPane supportBotDistrubtionsScrollPane = new JScrollPane(supportBotDistrubtionsTable);
        supportBotDistrubtionsScrollPane.setBorder(new TitledBorder("Support/Mission Bot Spawning Ratios"));

        classDistributionsPanel.add(nonSupportDistrubtionsScrollPane);
        classDistributionsPanel.add(supportBotDistrubtionsScrollPane);

        return classDistributionsPanel;
    }

    /**
     * Changes the standard/giant scroll pane so that you can change the distributions for standard or giant bots
     * @param isGiant - whether we should display for giant
     */
    private void changeNonSupportDistrubtionsScrollPane(boolean isGiant) {
        if (isGiant) {
            nonSupportDistrubtionsScrollPane.setViewportView(giantBotDistrubtionsTable);
            nonSupportDistrubtionsScrollPane.setBorder(new TitledBorder("Giant Bot Spawning Ratios"));
        } else {
            nonSupportDistrubtionsScrollPane.setViewportView(standardBotDistributionsTable);
            nonSupportDistrubtionsScrollPane.setBorder(new TitledBorder("Normal Bot Spawning Ratios"));
        }
    }

    /**
     * Centers the text displayed in cells
     */
    public void centerCellText() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        botSettingsTable.setDefaultRenderer(Integer.class, centerRenderer);
        standardBotDistributionsTable.setDefaultRenderer(Integer.class, centerRenderer);
        giantBotDistrubtionsTable.setDefaultRenderer(Integer.class, centerRenderer);
        supportBotDistrubtionsTable.setDefaultRenderer(Integer.class, centerRenderer);
    }
}
