package Pop.GUI.TableModels;

import Pop.Enums.ClassDistrubutionType;
import Pop.MVMRandomizer;
import Pop.Settings.ClassPercentage;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Table model for class distributions - that is, values where each class needs a certain weight
 */
public class ClassDistributionModel extends AbstractTableModel {
    private ArrayList<ClassDistrubtionItem> classes = new ArrayList<>();
    private ClassDistrubutionType type;
    private String[] columnNames = { "Class", "Weight Value", "Weight %" };

    /**
     * Default constructor
     */

    public ClassDistributionModel() {
        initializeForStandardBots();
    }

    /**
     * Constructor
     */
    public ClassDistributionModel(boolean isForSupportBots) {
        if (isForSupportBots) {
            initializeForSupportBots();
        } else {
            initializeForStandardBots();
        }
    }

    /**
     * Initializes the model with default values
     */
    public void initializeForStandardBots() {
        clear();
        type = ClassDistrubutionType.STANDARD;
        setClassesForNonSupportBots(MVMRandomizer.botSettings.getStandardBotDistributions());
    }

    /**
     * Initializes the model with default values
     */
    public void initializeForGiantBots() {
        clear();
        type = ClassDistrubutionType.GIANT;
        setClassesForNonSupportBots(MVMRandomizer.botSettings.getGiantBotDistributions());
    }

    /**
     * Sets up classes for non support bots
     * @param distributions
     */
    private void setClassesForNonSupportBots(ClassPercentage distributions) {
        classes = new ArrayList<>(Arrays.asList(
            new ClassDistrubtionItem("Demoman", distributions.getDemomanPercentage()),
            new ClassDistrubtionItem("Heavy", distributions.getHeavyPercentage()),
            new ClassDistrubtionItem("Medic", distributions.getMedicPercentage()),
            new ClassDistrubtionItem("Pyro", distributions.getPyroPercentage()),
            new ClassDistrubtionItem("Scout", distributions.getScoutPercentage()),
            new ClassDistrubtionItem("Soldier", distributions.getSoldierPercentage()),
            new ClassDistrubtionItem("Sniper", distributions.getSniperPercentage()),
            new ClassDistrubtionItem("Spy", distributions.getSpyPercentage())
        ));
    }

    /**
     * Initializes the model with default values
     */
    public void initializeForSupportBots() {
        clear();
        type = ClassDistrubutionType.SUPPORT;

        ClassPercentage supportBotDistributions = MVMRandomizer.botSettings.getSupportBotDistributions();
        classes = new ArrayList<>(Arrays.asList(
            new ClassDistrubtionItem("Demoman", supportBotDistributions.getDemomanPercentage()),
            new ClassDistrubtionItem("Heavy", supportBotDistributions.getHeavyPercentage()),
            new ClassDistrubtionItem("Medic", supportBotDistributions.getMedicPercentage()),
            new ClassDistrubtionItem("Pyro", supportBotDistributions.getPyroPercentage()),
            new ClassDistrubtionItem("Scout", supportBotDistributions.getScoutPercentage()),
            new ClassDistrubtionItem("Soldier", supportBotDistributions.getSoldierPercentage()),
            new ClassDistrubtionItem("Sniper", supportBotDistributions.getSniperPercentage()),
            new ClassDistrubtionItem("Spy", supportBotDistributions.getSpyPercentage()),
            new ClassDistrubtionItem("Engineer", supportBotDistributions.getEngineerPercentage())
        ));
    }

    /**
     * Deletes all rows from the table
     */
    private void clear() {
        classes.clear();
        fireTableDataChanged();
    }

    /**
     * Gets the number of rows in the table
     * @return The number of rows in the table
     */
    @Override
    public int getRowCount() {
        return classes.size();
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
        if (classes.size() == 0) { return ""; }

        Object value = "";
        ClassDistrubtionItem classDistrubtionItem = classes.get(rowIndex);
        switch(columnIndex) {
            case 0: // Class
                value = classDistrubtionItem.getClassName();
                break;
            case 1: // Weight Value
                value = classDistrubtionItem.getWeight();
                break;
            case 2: // Weight %
                value = calculateWeightPercentage(classDistrubtionItem);
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
        if (classes.size() == 0) { return String.class; }

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
        if (classes.size() == 0) { return; }

        ClassDistrubtionItem classDistrubtionItem = classes.get(rowIndex);
        switch(columnIndex) {
            case 0: // Class
                classDistrubtionItem.setClassName((String)value);
                break;
            case 1: // Weight Value - also updates Weight %
                classDistrubtionItem.setWeight((int)value);
                fireTableDataChanged();
                break;
            case 2: // Weight % (not editable by the user)
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
    public boolean isCellEditable(int row, int column) {
        return column != 2; // Only weight % is not editable
    }

    /**
     * Calculates the weight percentage of the given class
     * @param classDistrubtionItem - the class
     * @return The calculated percentage
     */
    private String calculateWeightPercentage(ClassDistrubtionItem classDistrubtionItem) {
        int weight = classDistrubtionItem.getWeight();
        if (type.equals(ClassDistrubutionType.SUPPORT)) {
            String className = classDistrubtionItem.getClassName();
            boolean isMissionBot = className.equals("Engineer") || className.equals("Sniper") || className.equals("Spy");
            if (isMissionBot) {
                return calculateMissionBotWeightPercentage(weight);
            }

            return calculateSupportBotWeightPercentage(weight);
        }

        return calculateWeightPercentageForAllClasses(weight);
    }

    /**
     * Calculate the percentage of the weights given the weight of one class
     * @param weight - the weight of the class
     * @return The calculated percentage
     */
    private String calculateWeightPercentageForAllClasses(int weight) {
        double totalWeight = 0;
        for (ClassDistrubtionItem classDistrubtionItem : classes) {
            totalWeight += classDistrubtionItem.getWeight();
        }

        double percentage = ((double)weight / totalWeight) * 100;
        return String.format("%.2f%%", percentage);
    }

    /**
     * Calculate the percentage of the weights given the weight of one class
     * @param weight - the weight of the class
     * @return The calculated percentage
     */
    private String calculateMissionBotWeightPercentage(int weight) {
        double totalWeight = 0;
        for (int i = classes.size() - 3; i < classes.size(); i++) {
            totalWeight += classes.get(i).getWeight();
        }

        double percentage = ((double)weight / totalWeight) * 100;
        return String.format("%.2f%%", percentage);
    }

    /**
     * Calculate the percentage of the support class given the class
     * @param weight - he weight of the class
     * @return The calculated percentage
     */
    private String calculateSupportBotWeightPercentage(int weight) {
        double totalWeight = 0;
        for (int i = 0; i < classes.size() - 3; i++) {
            totalWeight += classes.get(i).getWeight();
        }

        double percentage = ((double)weight / totalWeight) * 100;
        return String.format("%.2f%%", percentage);
    }

    /**
     * Class for each item of this table
     */
    private class ClassDistrubtionItem {
        /**
         * The name of the class
         */
        private String className;
        public String getClassName() { return className; }
        public void setClassName(String className){ this.className = className; }

        /**
         * The weight of the item
         */
        private int weight;
        public int getWeight() { return weight; }
        public void setWeight(int weight) { this.weight = weight; }

        /**
         * Constructor
         */
        public ClassDistrubtionItem(String className, int weight) {
            this.className = className;
            this.weight = weight;
        }
    }
}
