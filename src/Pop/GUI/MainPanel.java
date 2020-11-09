package Pop.GUI;

import Pop.Enums.Maps;
import Pop.MVMRandomizer;
import Pop.Range;
import Pop.Settings.BotSettings;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * The main panel of the application - this is where the user will
 * generate the file
 */
public class MainPanel extends JPanel {
    /**
     * GUI Components
     */
    private static JTextField popDirectoryTextBox;
    private static JTextField missionNameTextField;
    private static JPanel mainContents = new JPanel();
    private static CheckboxPanel deleteFilesCheckbox;
    private static JComboBox mapComboBox;
    private static RangePanel wavesPanel = new RangePanel("Waves", new Dimension(40, 20));

    /**
     * Getters for all the settings
     */
    public static String getPopPath() { return popDirectoryTextBox.getText(); }
    public static String getMissionName() { return missionNameTextField.getText(); }
    public static boolean getDeleteFiles() { return deleteFilesCheckbox.isChecked(); }
    public static Maps getSelectedMap() { return (Maps)mapComboBox.getSelectedItem(); }
    public static Range getNumberOfWaves() { return wavesPanel.getRange(); }

    /**
     * Constructor
     */
    public MainPanel() {
        this.setMinimumSize(new Dimension(0, 0));
        this.setPreferredSize(new Dimension(1024, 768));

        setUpDirectoryDisplay();
        mainContents.add(Box.createRigidArea(new Dimension(0, 4)));
        setUpPopFileGenerationPanel();
        setUpWavesPanel();
        setUpGenerateButtons();

        mainContents.setLayout(new BoxLayout(mainContents, BoxLayout.Y_AXIS));
        this.add(mainContents, BorderLayout.CENTER);
        this.add(new OutputConsole(), BorderLayout.SOUTH);

        applySettings();
    }

    /**
     * Applies all the mvm randomizer fileSettings
     */
    public void applySettings() {
        String savedPopPath = MVMRandomizer.fileSettings.getPopPath();
        String popFilePath = savedPopPath == null ? "" : savedPopPath;
        popDirectoryTextBox.setText(popFilePath);
        missionNameTextField.setText(MVMRandomizer.fileSettings.getMissionName());
        deleteFilesCheckbox.setIsChecked(MVMRandomizer.fileSettings.getDeletingMissions());
        wavesPanel.setRange(MVMRandomizer.waveScheduleSettings.getNumberOfWaves());

        setUpMapChoices();
    }

    /**
     * Sets up the map combo box - includes available choices and the current selected map
     */
    public void setUpMapChoices() {
        mapComboBox.setModel(new DefaultComboBoxModel<>(MVMRandomizer.mapSettings.getPossibleMaps().toArray()));
        mapComboBox.setRenderer(new EnumComboBoxRenderer());
        mapComboBox.setSelectedItem(MVMRandomizer.mapSettings.getSelectedMap());
    }

    /**
     * Sets up displaying the text boxes and buttons for choosing the pop file directory
     */
    private void setUpDirectoryDisplay() {
        JPanel directoryPanel = new JPanel();
        directoryPanel.setLayout(new BoxLayout(directoryPanel, BoxLayout.X_AXIS));

        popDirectoryTextBox = new JTextField();
        popDirectoryTextBox.setBackground(Color.WHITE);
        popDirectoryTextBox.setEditable(false);
        popDirectoryTextBox.setPreferredSize(new Dimension(800, 10));

        JButton popDirectoryBrowse = new JButton("...");
        popDirectoryBrowse.setPreferredSize(new Dimension(25, 25));
        popDirectoryBrowse.addActionListener(new BrowseButtonListener());

        JButton popDirectoryOpen = new JButton();
        popDirectoryOpen.setIcon(UIManager.getIcon("FileView.directoryIcon"));
        popDirectoryOpen.setPreferredSize(new Dimension(25, 25));
        popDirectoryOpen.addActionListener(new OpenButtonListener());

        directoryPanel.add(popDirectoryTextBox);
        directoryPanel.add(popDirectoryBrowse);
        directoryPanel.add(popDirectoryOpen);

        mainContents.add(directoryPanel);
    }

    /**
     * The action listener for the browser button
     */
    private class BrowseButtonListener implements ActionListener {
        /**
         * Executed when the browser button is clicked - shows the display dialog
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            String savedPopPath = MVMRandomizer.fileSettings.getPopPath();
            File currentDirectory = new File(savedPopPath == null ? "" : savedPopPath);
            if (currentDirectory.isDirectory()) {
                fileChooser.setCurrentDirectory(currentDirectory);
            } else {
                OutputConsole.addMessage(
                    "The current setting is not a valid directory: " + currentDirectory.getAbsolutePath());
            }

            int returnValue = fileChooser.showOpenDialog(MainPanel.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File directory = fileChooser.getSelectedFile();

                String directoryPath = directory.getAbsolutePath();
                MVMRandomizer.fileSettings.setPopPath(directoryPath);
                popDirectoryTextBox.setText(directoryPath);
                OutputConsole.addMessage("Updated pop directory to: " + directoryPath);
            }
        }
    }

    /**
     * The action listener for the open button
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Opens windows explorer to the current directory
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Desktop.getDesktop().open(new File(popDirectoryTextBox.getText()));
            } catch(IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Set up the controls for generating a wave
     */
    private void setUpPopFileGenerationPanel() {
        JPanel generationPanel = new JPanel();
        generationPanel.setLayout(new BoxLayout(generationPanel, BoxLayout.X_AXIS));

        JLabel fileNameStartLabel = new JLabel("mvm_");
        setUpMapComboBox();
        JLabel underscoreLabel = new JLabel("_");
        setUpMissionNameTextField();
        JLabel fileNameEndLabel = new JLabel(".pop");

        generationPanel.add(fileNameStartLabel);
        generationPanel.add(Box.createRigidArea(new Dimension(4, 0)));
        generationPanel.add(mapComboBox);
        generationPanel.add(Box.createRigidArea(new Dimension(4, 0)));
        generationPanel.add(underscoreLabel);
        generationPanel.add(Box.createRigidArea(new Dimension(4, 0)));
        generationPanel.add(missionNameTextField);
        generationPanel.add(Box.createRigidArea(new Dimension(4, 0)));
        generationPanel.add(fileNameEndLabel);
        generationPanel.add(Box.createRigidArea(new Dimension(30, 0)));

        setUpDeleteFilesCheckbox(generationPanel);
        mainContents.add(generationPanel);
    }

    /**
     * Sets up the combo box containing the map choices
     */
    private void setUpMapComboBox() {
        mapComboBox = new JComboBox();
        mapComboBox.setPreferredSize(new Dimension (200, 25));
        mapComboBox.setMaximumSize(mapComboBox.getPreferredSize());
        mapComboBox.setBackground(Color.WHITE);
        mapComboBox.addActionListener(new MapComboBoxListener());
    }

    /**
     * The action listener for the map combo box
     */
    private class MapComboBoxListener implements ActionListener {
        /**
         * Sets the map settings to the selected index
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            MVMRandomizer.mapSettings.setSelectedMap((Maps)mapComboBox.getSelectedItem());
        }
    }

    /**
     * ets up the checkbox to delete files
     * @param generationPanel - The parent panel
     */
    private void setUpDeleteFilesCheckbox(JPanel generationPanel) {
        deleteFilesCheckbox = new CheckboxPanel("Delete files of same mission name?");
        deleteFilesCheckbox.addActionListener(new DeleteFilesCheckboxListener());
        generationPanel.add(deleteFilesCheckbox);
    }

    /**
     * Sets up the textbox containing the mission's name
     */
    private void setUpMissionNameTextField() {
        missionNameTextField = new JTextField(10);
        missionNameTextField.setMaximumSize(new Dimension(30, 25));

        missionNameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateMissionNameSetting();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateMissionNameSetting();
            }

            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
    }

    /**
     * Updates the mission name setting with whatever is in the textbox
     */
    private void updateMissionNameSetting() {
        MVMRandomizer.fileSettings.setMissionName(missionNameTextField.getText());
    }

    /**
     * The action listener for the delete files checkbox
     */
    private class DeleteFilesCheckboxListener implements ActionListener {
        /**
         * Change the delete files setting - it should go into effect immediately
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            MVMRandomizer.fileSettings.setDeletingMissions(deleteFilesCheckbox.isChecked());
        }
    }

    /**
     * Sets up the waves panel
     */
    private void setUpWavesPanel() {
        JPanel wavesPanelContainer = new JPanel();
        wavesPanelContainer.setLayout(new GridBagLayout());
        wavesPanelContainer.add(wavesPanel);

        mainContents.add(wavesPanelContainer);
    }

    /**
     * Sets up the generate buttons
     */
    private void setUpGenerateButtons() {
        JPanel generateButtonsPanel = new JPanel();
        generateButtonsPanel.setLayout(new BoxLayout(generateButtonsPanel, BoxLayout.X_AXIS));
        generateButtonsPanel.add(setUpGenerateButton());
        generateButtonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        generateButtonsPanel.add(setUpGenerateHighlanderButton());

        mainContents.add(generateButtonsPanel);
    }

    /**
     * Sets up the generate button
     * @return - the generateButton
     */
    private JButton setUpGenerateButton() {
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(new GenerateButtonListener());
        return generateButton;
    }

    /**
     * The action listener for the generate button
     */
    private class GenerateButtonListener implements ActionListener {
        /**
         * Opens windows explorer to the current directory
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            beforePopFileGeneration();
            MVMRandomizerGUI.updateSettings();
            MVMRandomizer.generate();
        }
    }

    /**
     * Sets up the generate highlander button
     * @return - the generateHighlanderButton
     */
    private JButton setUpGenerateHighlanderButton() {
        JButton generateHighlanderButton = new JButton("Generate Highlander");
        generateHighlanderButton.setToolTipText("Highlander mode makes every bot only use melee. Snipers can also use bows.");
        generateHighlanderButton.addActionListener(new GenerateHighlanderButtonListener());
        return generateHighlanderButton;
    }

    /**
     * The action listener for the generate button
     */
    private class GenerateHighlanderButtonListener implements ActionListener {
        /**
         * Opens windows explorer to the current directory
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            beforePopFileGeneration();

            MVMRandomizer.botSettings.setHighlanderMode(true);
            MVMRandomizerGUI.updateSettings();
            MVMRandomizer.generate();
            MVMRandomizer.botSettings.setHighlanderMode(false);
        }
    }

    /**
     * Things to do before generating the pop file
     * Currently just clears the output console's tracked messages
     */
    private void beforePopFileGeneration() {
        OutputConsole.clearTrackedMessages();
    }
}
