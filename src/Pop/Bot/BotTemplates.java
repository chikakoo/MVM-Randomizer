package Pop.Bot;

import Pop.Enums.TFClasses;
import Pop.GUI.OutputConsole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Represents all the templates for all bots
 */
public class BotTemplates {
    private static HashMap<TFClasses, ArrayList<BotTemplate>> standardTemplates = new HashMap<>();
    private static HashMap<TFClasses, ArrayList<BotTemplate>> giantTemplates = new HashMap<>();

    private static ArrayList<String> templateFileNames = new ArrayList<>();
    public static ArrayList<String> getTemplateFileNames() { return templateFileNames; };

    public static HashSet<String> templateClassesAndNames = new HashSet<>();

    /**
     * Gets a template
     * @param tfClass - the class to get
     * @param isGiant - whether the class is a giant
     * @return The matching template, or null if not found
     */
    public static ArrayList<BotTemplate> getTemplateList(TFClasses tfClass, boolean isGiant) {
        if (isGiant) {
            return giantTemplates.getOrDefault(tfClass, null);
        } else {
            return standardTemplates.getOrDefault(tfClass, null);
        }
    }

    /**
     * Adds a template given the required information
     * @param templateName - the name of the template
     * @param tfClass - the class of the template
     * @param name - the name of the bot
     * @param classIcon - the class icon on the template
     */
    private static void addTemplate(String templateName, TFClasses tfClass, String name, String customProjectileWeapon, String classIcon) {
        boolean isGiant = templateName.toLowerCase().startsWith("t_tfbot_giant");
        BotTemplate template = new BotTemplate(templateName, tfClass, name, isGiant, customProjectileWeapon, classIcon);

        ArrayList<BotTemplate> classTemplateList;
        if (isGiant) {
            classTemplateList = getTemplateList(tfClass, true);
            if (classTemplateList == null) {
                classTemplateList = new ArrayList<>();
                giantTemplates.put(tfClass, classTemplateList);
            }
            classTemplateList.add(template);

        } else {
            classTemplateList = getTemplateList(tfClass, false);
            if (classTemplateList == null) {
                classTemplateList = new ArrayList<>();
                standardTemplates.put(tfClass, classTemplateList);
            }
            classTemplateList.add(template);
        }

        if (!templateLoaded(tfClass, name)) {
            templateClassesAndNames.add(tfClass.getDisplayString() + " | " + templateName);
        }
    }

    /**
     * Returns whether the template was loaded
     * @param tfClass - the class of the template
     * @param templateName - the name of the template
     * @return True if the template was loaded, false otherwise
     */
    public static boolean templateLoaded(TFClasses tfClass, String templateName) {
        String templateClassAndName = tfClass.getDisplayString() + " | " + templateName;
        return templateClassesAndNames.contains(templateClassAndName);
    }

    /**
     * Parse all the files in the ./Pop Files directory
     * @return An empty string if successful; an error message if not
     */
    public static String populateTemplates() {
        templateClassesAndNames.clear();
        File popFolder = new File(".\\Pop Files");
        File[] filesInDirectory = popFolder.listFiles();

        if (filesInDirectory == null || filesInDirectory.length == 0) {
            return "ERROR: No pop files found in " + popFolder.getAbsolutePath();
        }

        boolean isFirstBotInFile;
        try {
            for (File currentFile : filesInDirectory) {
                Scanner scanner = new Scanner(currentFile);
                String currentTemplateName = "";
                TFClasses currentTFClass = null;
                String currentName = "";
                String currentCustomProjectileWeapon = null;
                String currentClassIcon = "";
                isFirstBotInFile = true;

                if (currentFile.getName().endsWith(".pop")) {
                    templateFileNames.add(currentFile.getName());

                    while (scanner.hasNext()) {
                        String currentLine = scanner.nextLine().replace("\t", " ").trim();
                        String lineToCompare = currentLine.toLowerCase();

                        if (lineToCompare.contains("t_tfbot")) {
                            // Add the icon of the previous bot
                            if (!isFirstBotInFile && !tryAddTemplate(currentTemplateName, currentTFClass, currentName, currentCustomProjectileWeapon, currentClassIcon)) {
                                OutputConsole.addMessage("ERROR: could not add template of name: " + currentTemplateName + " in "  + currentFile.getName());
                            }
                            isFirstBotInFile = false;
                            currentTemplateName = "";
                            currentTFClass = null;
                            currentName = "";
                            currentCustomProjectileWeapon = null;
                            currentClassIcon = "";

                            if (!currentTemplateName.equals("")) {
                                return "ERROR: Found a template (" + currentTemplateName +") without a name or class in " + currentFile.getName();
                            }
                            currentTemplateName = currentLine.split("\\s+")[0];
                        } else if (lineToCompare.startsWith("class ")) {
                            if (currentTemplateName.equals("")) {
                                return "ERROR: Found a class without a template in " + currentFile.getName();
                            }
                            currentTFClass = TFClasses.getByStringName(currentLine.split("\\s+")[1]);
                        } else if (lineToCompare.startsWith("name ")) {
                            if (currentTemplateName.equals("")) {
                                return "ERROR: Found a name (" + currentLine + ")  without a template in " + currentFile.getName();
                            }
                            currentName = currentLine.substring(4).trim().replace("\"", "");
                        } else if (lineToCompare.startsWith("//customprojectileweapon ")) {
                            currentCustomProjectileWeapon = currentLine
                                .replaceAll("(?i)//CustomProjectileWeapon ", "")
                                .replace("\"", "")
                                .trim();
                        } else if (lineToCompare.startsWith("classicon ")) {
                            if (currentTemplateName.equals("")) {
                                return "ERROR: Found a class icon (" + lineToCompare + ")  without a template in " + currentFile.getName();
                            }
                            currentClassIcon = lineToCompare.split("\\s+")[1];
                        }
                    }
                    // Add the last bot in the file
                    if (!tryAddTemplate(currentTemplateName, currentTFClass, currentName, currentCustomProjectileWeapon, currentClassIcon)) {
                        OutputConsole.addMessage("ERROR: could not add template of name: " + currentTemplateName + " in "  + currentFile.getName());
                    }

                    scanner.close();
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Tries to add the template
     * @param templateName - the name of the template
     * @param tfClass - the bot's class
     * @param name - the bot's name
     * @param classIcon - the bot's class icon
     * @return
     */
    private static boolean tryAddTemplate(String templateName, TFClasses tfClass, String name, String customProjectileWeapon, String classIcon) {
        boolean haveAllNeededInfo = !templateName.equals("") && tfClass != null && !name.equals("");
        if (haveAllNeededInfo) {
            addTemplate(templateName, tfClass, name, customProjectileWeapon, classIcon);
            return true;
        }
        return false;
    }
}
