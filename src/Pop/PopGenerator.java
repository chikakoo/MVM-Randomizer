package Pop;

import Pop.Bot.BotTemplate;
import Pop.Bot.BotTemplates;
import Pop.GUI.OutputConsole;

import java.io.*;

/**
 * Contains functions for generating the pop file
 */
public class PopGenerator {
    /**
     * The pop file writer
     */
    private PopFileWriter popFile;

    /**
     * Constructor - takes the name of the pop file
     * @param fullPath - the full path of the pop file
     * @throws IOException
     */
    public PopGenerator(String fullPath) throws IOException {
        popFile = new PopFileWriter(fullPath);
    }

    /**
     * Generates the pop file
     * @throws IOException
     */
    public void generatePopFile() throws IOException {
        generateFileHeader();
        addIncludedFiles();
        generateWaves();

        popFile.close();
    }

    /**
     * Creates the header at the top of the file
     * @throws IOException
     */
    private void generateFileHeader() throws IOException {
        final String HEADER_TEXT =
                "This file was generated randomly using the MVM Randomizer\n" +
                "// Intended to be used with " + MVMRandomizer.currentMap.getName() +
                " (mvm_" + MVMRandomizer.currentMap.getPopfileName() + "_" + MVMRandomizer.fileSettings.getMissionName() + ".pop)";
        popFile.AddCommentInBorders(HEADER_TEXT);
}

    /**
     * Adds the included pop files (templates, etc.) to this pop file
     * @throws IOException
     */
    private void addIncludedFiles() throws IOException {
        for (String fileName : BotTemplates.getTemplateFileNames()) {
            popFile.writePopObjectAttribute("#base", fileName);
        }
        popFile.writeLine();
    }

    /**
     * Generates the waves in the pop file
     * @throws IOException
     */
    private void generateWaves() throws IOException {
        WaveSchedule waveSchedule = new WaveSchedule();
        waveSchedule.generateRandom();

        popFile.writePopObjectRepsentation(waveSchedule);
    }

    /**
     * Deletes all the pop files where the mission name is equal to the given name
     * @param directory - the directory to delete the files in
     * @param missionName - the mission names to delete
     * @throws IOException
     */
    public void cleanUpFiles(String directory, String missionName) {
        if (MVMRandomizer.fileSettings.getDeletingMissions()) {
            File folder = new File(directory);
            File[] filesInDirectory = folder.listFiles();

            for (File currentFile : filesInDirectory) {
                if (currentFile.getName().endsWith(missionName + ".pop")) {
                    if (currentFile.delete()) {
                        OutputConsole.addMessage("Deleted file: " + currentFile.getName());
                    }
                }
            }
        }
    }
}
