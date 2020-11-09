package Pop.GUI.TableModels;

import Pop.Range;
import Pop.Settings.TankSetting;
import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 * The tank item model for JTables
 */
public class TankItemModel extends AbstractTableModel {
    private ArrayList<TankSetting> tanks = new ArrayList<>();
    public ArrayList<TankSetting> getTanks() { return tanks; }

    private String[] columnNames = {
        "Amount",
        "Low Spd", "High Spd",
        "Low HP", "High HP",
        "Low Delay", "High Delay",
        "Weight #", "Weight %",
        "Zebra?"
    };

    /**
     * Adds a row to the table
     * @param tankSetting - the tank setting to add
     */
    public void addRow(TankSetting tankSetting) {
        tanks.add(tankSetting);
        fireTableDataChanged();
    }

    /**
     * Adds a new row to the table with some default values
     */
    public void addRow() {
        tanks.add(new TankSetting(
            1, new Range(75, 75), new Range(20000, 20000), new Range(45, 60), false, 100
        ));
        fireTableDataChanged();
    }

    /**
     * Deletes a row from the table
     * @param rowIndex - the row index
     */
    public void deleteRow(int rowIndex) {
        if (indexInRange(rowIndex)) {
            tanks.remove(rowIndex);
            fireTableDataChanged();
        }
    }

    /**
     * Deletes all rows from the table
     */
    public void clear() {
        tanks.clear();
        fireTableDataChanged();
    }

    /**
     * Duplicates a row from the table
     * @returns True if it duplicated a row; false otherwise
     */
    public boolean duplicateRow(int rowIndex) {
        if (indexInRange(rowIndex)) {
            TankSetting currentTankSetting = tanks.get(rowIndex);
            TankSetting newTankSetting = new TankSetting();
            newTankSetting.copySettings(currentTankSetting);

            tanks.add(rowIndex, newTankSetting);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    /**
     * Moves the selected row up
     * @returns True if it duplicated a row; false otherwise
     */
    public boolean moveRowUp(int rowIndex) {
        if (indexInRange(rowIndex) && rowIndex != 0) {
            Collections.swap(tanks, rowIndex, rowIndex - 1);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    /**
     * Moves the selected row down
     * @returns True if it duplicated a row; false otherwise
     */
    public boolean moveRowDown(int rowIndex) {
        if (indexInRange(rowIndex) && rowIndex < tanks.size() - 1) {
            Collections.swap(tanks, rowIndex, rowIndex + 1);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    /**
     * Returns whether the given index is a valid row index
     * @param rowIndex - the row index
     * @return True if the index is in range, false otherwise
     */
    private boolean indexInRange(int rowIndex) {
        return rowIndex >= 0 && rowIndex < tanks.size();
    }

    /**
     * Gets the number of rows in the table
     * @return The number of rows in the table
     */
    @Override
    public int getRowCount() {
        return tanks.size();
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
        if (tanks.size() == 0) { return ""; }

        Object value = "";
        TankSetting tank = tanks.get(rowIndex);
        switch(columnIndex) {
            case 0: // Amount
                value = tank.getAmount();
                break;
            case 1: // Low Spd
                value = tank.getSpeedRange().getLowerBound();
                break;
            case 2: // High Spd
                value = tank.getSpeedRange().getUpperBound();
                break;
            case 3: // Low HP
                value = tank.getHealthRange().getLowerBound();
                break;
            case 4: // High HP
                value = tank.getHealthRange().getUpperBound();
                break;
            case 5: // Low Delay
                value = tank.getSpawnDelay().getLowerBound();
                break;
            case 6: // High Delay
                value = tank.getSpawnDelay().getUpperBound();
                break;
            case 7: // Weight #
                value = tank.getWeight();
                break;
            case 8: // Weight %
                value = calculateWeightPercentage(tank.getWeight());
                break;
            case 9: // Zebra?
                value = tank.getIsZebraStriped();
                break;
        }

        return value;
    }

    /**
     * Gets the class most appropriate for the given column
     * String if there's no rows in the table
     * @param columnIndex - the column index
     * @return The found class
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tanks.size() == 0) { return String.class; }

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
        if (tanks.size() == 0) { return; }

        TankSetting tank = tanks.get(rowIndex);
        switch(columnIndex) {
            case 0: // Amount
                tank.setAmount((int)value);
                break;
            case 1: // Low Spd
                tank.getSpeedRange().setLowerBound((int)value);
                break;
            case 2: // High Spd
                tank.getSpeedRange().setUpperBound((int)value);
                break;
            case 3: // Low HP
                tank.getHealthRange().setLowerBound((int)value);
                break;
            case 4: // High HP
                tank.getHealthRange().setUpperBound((int)value);
                break;
            case 5: // Low Delay
                tank.getSpawnDelay().setLowerBound((int)value);
                break;
            case 6: // High Delay
                tank.getSpawnDelay().setUpperBound((int)value);
                break;
            case 7: // Weight # - also updates Weight %
                tank.setWeight((int)value);
                fireTableDataChanged();
                break;
            case 8: // Weight % (not editable by the user)
                break;
            case 9: // Zebra?
                tank.setIsZebraStriped((boolean)value);
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
        return column != 8; // Only weight % is not editable
    }

    /**
     * Calculate the percentage of the weights given the weight of one tank
     * @param weight - the weight of one tank
     * @return The calculated percentage
     */
    private String calculateWeightPercentage(int weight) {
        double totalWeight = 0;
        for (TankSetting tank : tanks) {
            totalWeight += tank.getWeight();
        }

        double percentage = ((double)weight / totalWeight) * 100;
        return String.format("%.2f%%", percentage);
    }
}
