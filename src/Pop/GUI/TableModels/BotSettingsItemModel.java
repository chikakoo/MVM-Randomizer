package Pop.GUI.TableModels;

import Pop.Bot.BotTemplate;
import Pop.Bot.BotTemplates;
import Pop.Bot.RandomBot;
import Pop.Enums.TFClasses;
import Pop.GUI.OutputConsole;
import Pop.MVMRandomizer;
import Pop.Range;
import Pop.Settings.BotSetting;
import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 * The bot settings item model for JTables
 * Note that these use the real settings data, so modified data is automatically saved in the settings
 */
public class BotSettingsItemModel extends AbstractTableModel {
    private ArrayList<BotSetting> bots = new ArrayList<>();
    public ArrayList<BotSetting> getTanks() { return bots; }
    private boolean isForSupport;
    private boolean isForGiants;
    private TFClasses tfClass;

    private String[] columnNames = {
        "Bot Name", "Template Name",
        "Weight #", "Weight %",
        "Low Spawn Range", "High Spawn Range",
        "Is Standard/Support?" // Changed appropriately in the initialize functions
    };

    /**
     * Initializes the table model with the appropriate data grabbed off the enums
     * @param isForGiants - whether this table should use giant templates
     * @param isForSupport - whether this table should show columns for support bots (vs. standard)
     * @param tfClass - the class this table should show data for
     */
    public void initialize(boolean isForGiants, boolean isForSupport, TFClasses tfClass) {
        this.isForGiants = isForGiants;
        this.tfClass = tfClass;
        populateBotList();

        if (isForSupport) {
            initializeForSupport();
        } else {
            initializeForStandard();
        }

        fireTableStructureChanged(); // For the column name change
        fireTableDataChanged();
    }

    /**
     * Populates this model's list of bots to display based on a list of templates
    */
    public void populateBotList() {
        bots.clear();

        for (BotTemplate template : BotTemplates.getTemplateList(tfClass, isForGiants)) {
            BotSetting botSettingToAdd = MVMRandomizer.botSettings.getBotSetting(tfClass, template, isForGiants);
            if (botSettingToAdd != null) {
                addRow(botSettingToAdd);
            } else {
                OutputConsole.addMessage("ERROR: could not find template with the enum value " + template.getName());
            }
        }
    }

    /**
     * Initializes the model for use with standard bots
     */
    private void initializeForStandard() {
        isForSupport = false;
        columnNames[6] = "Is Standard?";
    }

    /**
     * Initializes the model for use with support bots
     */
    private void initializeForSupport() {
        isForSupport = true;
        columnNames[6] = "Is Support?";
    }

    /**
     * Adds a row to the table
     * @param botSetting - the tank setting to add
     */
    private void addRow(BotSetting botSetting) {
        bots.add(botSetting);
    }

    /**
     * Deletes all rows from the table
     */
    public void clear() {
        bots.clear();
        fireTableDataChanged();
    }

    /**
     * Sets the spawn range to easy values (defined in RandomBot)
     * @param rowIndex
     */
    public void setEasySpawnRange(int rowIndex) {
        if (indexInRange(rowIndex)) {
            BotSetting botSetting = bots.get(rowIndex);
            if (isForGiants) {
                setSpawnRange(botSetting, RandomBot.EASY_GIANT_SPAWN_RANGE);
            } else {
                setSpawnRange(botSetting, RandomBot.EASY_SPAWN_RANGE);
            }

            fireTableDataChanged();
        }
    }

    /**
     * Sets the spawn range to normal values (defined in RandomBot)
     * @param rowIndex
     */
    public void setNormalSpawnRange(int rowIndex) {
        if (indexInRange(rowIndex)) {
            BotSetting botSetting = bots.get(rowIndex);
            if (isForGiants) {
                setSpawnRange(botSetting, RandomBot.NORMAL_GIANT_SPAWN_RANGE);
            } else {
                setSpawnRange(botSetting, RandomBot.NORMAL_SPAWN_RANGE);
            }

            fireTableDataChanged();
        }
    }

    /**
     * Sets the spawn range to hard values (defined in RandomBot)
     * @param rowIndex
     */
    public void setHardSpawnRange(int rowIndex) {
        if (indexInRange(rowIndex)) {
            BotSetting botSetting = bots.get(rowIndex);
            if (isForGiants) {
                setSpawnRange(botSetting, RandomBot.HARD_GIANT_SPAWN_RANGE);
            } else {
                setSpawnRange(botSetting, RandomBot.HARD_SPAWN_RANGE);
            }

            fireTableDataChanged();
        }
    }

    /**
     * Sets the spawn range to impossible values (defined in RandomBot)
     * @param rowIndex
     */
    public void setImpossibleSpawnRange(int rowIndex) {
        if (indexInRange(rowIndex)) {
            BotSetting botSetting = bots.get(rowIndex);
            if (isForGiants) {
                setSpawnRange(botSetting, RandomBot.IMPOSSIBLE_GIANT_SPAWN_RANGE);
            } else {
                setSpawnRange(botSetting, RandomBot.IMPOSSIBLE_SPAWN_RANGE);
            }

            fireTableDataChanged();
        }
    }

    /**
     * Sets the spawn range of the bot setting to the given spawn range
     * @param botSetting - the bot setting
     * @param spawnRange - the spawn range to set
     */
    private void setSpawnRange(BotSetting botSetting, Range spawnRange) {
        if (isForSupport) {
            botSetting.setSupportSpawnRange(spawnRange);
        } else {
            botSetting.setStandardSpawnRange(spawnRange);
        }
    }

    /**
     * Returns whether the given index is a valid row index
     * @param rowIndex - the row index
     * @return True if the index is in range, false otherwise
     */
    private boolean indexInRange(int rowIndex) {
        return rowIndex >= 0 && rowIndex < bots.size();
    }

    /**
     * Gets the number of rows in the table
     * @return The number of rows in the table
     */
    @Override
    public int getRowCount() {
        return bots.size();
    }

    /**
     * Gets the number of columns in the table
     * @return The number of columns in the table
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Gets the column name given the column index
     * @param index - the name of the column
     * @return The column name
     */
    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }

    /**
     * Gets the value of the given row and column
     * @param rowIndex - the row
     * @param columnIndex - the column
     * @return The retrieved value
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (bots.size() == 0) { return ""; }

        Object value = "";
        BotSetting bot = bots.get(rowIndex);
        switch(columnIndex) {
            case 0: // Bot Name
                value = bot.getTemplate().getName();
                break;
            case 1: // Template Name
                value = bot.getTemplate().getTemplateName().replace("T_TFBot_", "");
                break;
            case 2: // Weight #
                value = isForSupport ?
                    bot.getSupportWeight() :
                    bot.getStandardWeight();
                break;
            case 3: // Weight %
                if (zeroOutWeightPercent(bot)) {
                    value = "";
                } else {
                    value = calculateWeightPercentage(bot);
                }
                break;
            case 4: // Low Spawn Range
                value = isForSupport ?
                    bot.getSupportSpawnRange().getLowerBound() :
                    bot.getStandardSpawnRange().getLowerBound();
                break;
            case 5: // High Spawn Range
                value = isForSupport ?
                    bot.getSupportSpawnRange().getUpperBound() :
                    bot.getStandardSpawnRange().getUpperBound();
                break;
            case 6: // Is Standard/Support?
                value = isForSupport ?
                    bot.getIsSupport() :
                    bot.getIsStandard();
                break;
        }

        return value;
    }

    /**
     * Gets the class most appropriate for the given column
     * String if there's no rows int he table
     * @param columnIndex - the column index
     * @return The found class
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (bots.size() == 0) { return String.class; }

        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * Sets the value of the table
     * @param value - the value to set the cell to
     * @param rowIndex - the row
     * @param columnIndex - the column
     */
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (bots.size() == 0) { return; }

        BotSetting bot = bots.get(rowIndex);
        switch(columnIndex) {
            case 0: // Bot Name (not editable)
                break;
            case 1: // Template Name (not editable)
                break;
            case 2: // Weight # - also updates Weight%
                if (isForSupport) {
                    bot.setSupportWeight((int)value);
                } else {
                    bot.setStandardWeight((int)value);
                }
                fireTableDataChanged();
                break;
            case 3: // Weight % (value directly related to Weight#)
                break;
            case 4: // Low Spawn Range
                if (isForSupport) {
                    bot.getSupportSpawnRange().setLowerBound((int)value);
                } else {
                    bot.getStandardSpawnRange().setLowerBound((int)value);
                }
                break;
            case 5: // High Spawn Range
                if (isForSupport) {
                    bot.getSupportSpawnRange().setUpperBound((int)value);
                } else {
                    bot.getStandardSpawnRange().setUpperBound((int)value);
                }
                break;
            case 6: // Is Standard/Support?
                if (isForSupport) {
                    bot.setIsSupport((boolean)value);
                } else {
                    bot.setIsStandard((boolean)value);
                }
                fireTableDataChanged();
                break;
        }
    }

    /**
     * Returns whether the given cell is editable
     * @param row - the row
     * @param column - the column
     * @return True if editable; false otherwise
     */
    @Override
    public boolean isCellEditable(int row, int column)
    {
        // The two template columns and weight % are not editable
        return column != 0 && column != 1 && column != 3;
    }

    /**
     * Calculate the percentage of the weights given the weight of one bot
     * @param bot - the weight of one bot
     * @return The calculated percentage
     */
    private String calculateWeightPercentage(BotSetting bot) {
        int weight = isForSupport ?
            bot.getSupportWeight() :
            bot.getStandardWeight();

        double totalWeight = 0;
        for (BotSetting currentBotSetting : bots) {
            if (!zeroOutWeightPercent(currentBotSetting)) {
                totalWeight += isForSupport ?
                    currentBotSetting.getSupportWeight() :
                    currentBotSetting.getStandardWeight();
            }
        }

        double percentage = ((double)weight / totalWeight) * 100;
        if (totalWeight == 0) { percentage = 0; }
        return String.format("%.2f%%", percentage);
    }

    /**
     * Returns whether the weight percent should be 0
     * @param bot - the bot
     * @return true if we should zero out the weight percent; false otherwise
     */
    private boolean zeroOutWeightPercent(BotSetting bot) {
        if (!isForSupport && !bot.getIsStandard()) {
            return true;
        }
        else if (isForSupport && !bot.getIsSupport()) {
            return true;
        }

        return false;
    }
}
