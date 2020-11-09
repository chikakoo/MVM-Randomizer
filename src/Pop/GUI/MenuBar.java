package Pop.GUI;

import Pop.MVMRandomizer;
import Pop.Settings.Settings;
import javax.swing.*;
import java.awt.event.*;

/**
 * The menubar of the GUI display
 */
public class MenuBar extends JMenuBar {
    /**
     * Constructor
     */
    public MenuBar() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem saveSettings = new JMenuItem("Save Settings", KeyEvent.VK_S);
        saveSettings.addActionListener(new SaveSettingsListener());

        JMenuItem loadSettings = new JMenuItem("Load Settings", KeyEvent.VK_L);
        loadSettings.addActionListener(new LoadSettingsListener());

        JMenuItem loadDefaults = new JMenuItem ("Load Defaults", KeyEvent.VK_D);
        loadDefaults.addActionListener(new LoadDefaultsListener());

        file.add(saveSettings);
        file.add(loadSettings);
        file.add(loadDefaults);
        this.add(file);
    }

    /**
     * Listener for the save settings option
     */
    private class SaveSettingsListener implements ActionListener {
        /**
         * Saves the current settings
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Settings.saveSettings(MenuBar.this);
        }
    }

    /**
     * Listener for the load settings option
     */
    private class LoadSettingsListener implements ActionListener {
        /**
         * Saves the selected settings
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Settings.loadSettings(MenuBar.this);
        }
    }

    /**
     * Listener for the load defaults option
     */
    private class LoadDefaultsListener implements ActionListener {
        /**
         * Saves the selected settings
         * @param e - (Unused) the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Settings.loadDefaultSettings();
            MVMRandomizerGUI.applyAllSettings();
            MVMRandomizerGUI.updateSettings();
        }
    }
}
