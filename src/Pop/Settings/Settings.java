package Pop.Settings;

import Pop.Bot.BotTemplate;
import Pop.GUI.MVMRandomizerGUI;
import Pop.GUI.OutputConsole;
import Pop.MVMRandomizer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * The settings for the application
 */
public class Settings {
    /**
     * Settings handling pop files
     */
    private FileSettings fileSettings = new FileSettings();
    public FileSettings getFileSettings() { return fileSettings; }
    public void setFileSettings(FileSettings fileSettings) {
        this.fileSettings = fileSettings;
    }

    /**
     * Settings about the wave schedule
     */
    private WaveScheduleSettings waveScheduleSettings = new WaveScheduleSettings();
    public WaveScheduleSettings getWaveScheduleSettings() { return waveScheduleSettings; }
    public void setWaveScheduleSettings(WaveScheduleSettings waveScheduleSettings) {
        this.waveScheduleSettings = waveScheduleSettings;
    }

    /**
     * Settings about waves
     */
    private WaveSettings waveSettings = new WaveSettings();
    public WaveSettings getWaveSettings() { return waveSettings; }
    public void setWaveSettings(WaveSettings waveSettings) { this.waveSettings = waveSettings; }

    /**
     * Settings about bots
     */
    private BotSettings botSettings = new BotSettings();
    public BotSettings getBotSettings() { return botSettings; }
    public void setBotSettings(BotSettings botSettings) { this.botSettings = botSettings; }

    /**
     * Settings about random bots
     */
    private RandomBotSettings randomBotSettings = new RandomBotSettings();
    public RandomBotSettings getRandomBotSettings() { return randomBotSettings; }
    public void setRandomBotSettings(RandomBotSettings randomBotSettings) {
        this.randomBotSettings = randomBotSettings;
    }

    /**
     * Settings about tanks
     */
    private TankSettings tankSettings = new TankSettings();
    public TankSettings getTankSettings() { return tankSettings; }
    public void setTankSettings(TankSettings tankSettings) { this.tankSettings = tankSettings; }

    /**
     * Settings about maps
     */
    private MapSettings mapSettings = new MapSettings();
    public MapSettings getMapSettings() { return mapSettings; }
    public void setMapSettings(MapSettings mapSettings) { this.mapSettings = mapSettings; }

    /**
     * Loads all the settings from the default XML file
     */
    public static void loadDefaultSettings() {
        loadSettings(".\\Saved Settings\\default.json");
    }

    /**
     * Loads all the settings from the selected settings file
     * @parent the parent component that's calling this function
     */
    public static void loadSettings(JComponent parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".\\Saved Settings\\"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Settings files", "json");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(parent);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            loadSettings(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    /**
     * Loads all the settings from the saved settings file
     */
    private static void loadSettings(String settingsFilePath) {
        try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader(settingsFilePath);
            JsonReader jsonReader = new JsonReader(fileReader);
            Settings allSettings = gson.fromJson(jsonReader, Settings.class);
            copySettings(allSettings, MVMRandomizer.settings);

            MVMRandomizer.botSettings.initialize();

            fileReader.close();
            jsonReader.close();

            OutputConsole.addMessage("Loaded settings file: " + settingsFilePath);

            //Refresh the GUI with the new settings
            MVMRandomizerGUI.applyAllSettings();

        } catch (FileNotFoundException e) {
            OutputConsole.addMessage("Could not load settings at: " + settingsFilePath);
        } catch (IOException e) {
            OutputConsole.addMessage("Could not load settings at: " + settingsFilePath);
        }
    }

    /**
     * Copies the settings over from the given Settings object
     * @param copyFrom - the object to copy settings from
     * @param copyTo - the object to copy settings to
     */
    public static void copySettings(Settings copyFrom, Settings copyTo) {
        copyTo.fileSettings.copySettings(copyFrom.fileSettings);
        copyTo.waveScheduleSettings.copySettings(copyFrom.waveScheduleSettings);
        copyTo.waveSettings.copySettings(copyFrom.waveSettings);
        copyTo.botSettings.copySettings(copyFrom.botSettings);
        copyTo.randomBotSettings.copySettings(copyFrom.randomBotSettings);
        copyTo.tankSettings.copySettings(copyFrom.tankSettings);
        copyTo.mapSettings.copySettings(copyFrom.mapSettings);
    }

    /**
     * Saves all the current settings to the chosen path
     * @parent the parent component that's calling this function
     */
    public static void saveSettings(JComponent parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".\\Saved Settings"));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Settings files (*.json)", "json");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showSaveDialog(parent);

        try {
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                MVMRandomizerGUI.updateSettings();
                File fileToSave = fileChooser.getSelectedFile();

                if (!fileToSave.getAbsolutePath().endsWith(".json")) {
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".json");
                }

                FileWriter writer = new FileWriter(fileToSave);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(MVMRandomizer.settings, writer);
                writer.close();

                OutputConsole.addMessage("Saved settings file: " + fileToSave.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
