package Pop;

import java.io.*;

import Pop.Enums.Maps;
import Pop.GUI.OutputConsole;
import Pop.Maps.*;
import Pop.Settings.*;

public class MVMRandomizer {
    /**
     * The settings file
     */
    public static Settings settings = new Settings();
    public static FileSettings fileSettings = settings.getFileSettings();
    public static WaveScheduleSettings waveScheduleSettings = settings.getWaveScheduleSettings();
    public static WaveSettings waveSettings = settings.getWaveSettings();
    public static BotSettings botSettings = settings.getBotSettings();
    public static RandomBotSettings randomBotSettings = settings.getRandomBotSettings();
    public static TankSettings tankSettings = settings.getTankSettings();

    public static MapSettings mapSettings = settings.getMapSettings();

    /**
     * The map to randomize
     */
    public static Map currentMap;

    /**
     * Main
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        initialize();
        generate();
    }

    /**
     * Initializes the application - should be called by the GUI code too
     */
    public static void initialize() {
        Settings.loadDefaultSettings();
    }

    /**
     * Generate the pop file
     */
    public static void generate() {
        Maps currentSelection = mapSettings.getSelectedMap();
        currentMap = mapSettings.getOrRandomizeSelectedMap();

        try {
            PopGenerator popGenerator = new PopGenerator(getFilePath());
            popGenerator.cleanUpFiles(fileSettings.getPopPath(), fileSettings.getMissionName());
            popGenerator.generatePopFile();

            if (MVMRandomizer.botSettings.isHighlanderMode()) {
                OutputConsole.addMessage("Generated highlander file: " + getFileName());
            } else if (MVMRandomizer.botSettings.isWave666Mode()) {
                OutputConsole.addMessage("Generated wave 666 file: " + getFileName());
            } else {
                OutputConsole.addMessage("Generated file: " + getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            OutputConsole.addMessage("Could not generate file at: " + getFilePath());
        } finally {
            mapSettings.setSelectedMap(currentSelection); // Handles the case where Random is selected
        }
    }

    /**
     * Gets the full path of the pop file to be generated
     * @return The full path of the pop file to be generated
     */
    public static String getFilePath() {
        return String.format(
            "%s\\mvm_%s_%s.pop",
            fileSettings.getPopPath(),
            currentMap.getPopfileName(),
            fileSettings.getMissionName());
    }

    /**
     * Gets the file name of the pop file to be generated
     * @return The file name
     */
    public static String getFileName() {
        return String.format("mvm_%s_%s.pop", currentMap.getPopfileName(), fileSettings.getMissionName());
    }
}
