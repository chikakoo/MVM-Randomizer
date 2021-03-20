package Pop.GUI.TableModels;

import Pop.Range;
import Pop.Settings.TankSetting;
import Pop.Settings.WaveSetting;

import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 * The tank item model for JTables
 */
public class WaveItemModel extends AbstractTableModel {
    private ArrayList<WaveSetting> waves = new ArrayList<>();
    public ArrayList<WaveSetting> getWaves() { return waves; }

    private String[] columnNames = {
        "#",
        "Low $", "High $",
        "Low Spawn", "High Spawn",
        "Mission%",
        "Support%",
        "Giant%", "Max Giant Spawns",
        "Tank%"
    };

    /**
     * Adds a row to the table
     * @param waveSetting - the wave setting to add
     */
    public void addRow(WaveSetting waveSetting) {
        waves.add(waveSetting);
        fireTableDataChanged();
    }

    /**
     * Adds a new row to the table with some default values
     */
    public void addRow() {
        int waveNumber = waves.size() + 1;

        Range currencyRange = new Range(400, 600);
        if (waveNumber > 1) {
            WaveSetting previousWave = waves.get(waveNumber - 2); // because -1 is the current one
            currencyRange = new Range(previousWave.getCurrencyRange());
        }

        int lowSpawn = (int) (Math.ceil(waveNumber / 2d) + 1);
        int highSpawn = (int) (Math.ceil((waveNumber + 1) / 2d) + 1);

        int supportPercent = 35;
        if (waveNumber == 1) {
            supportPercent = 10;
        } else if (waveNumber < 4) {
            supportPercent = 20;
        }

        int giantPercent = 50;
        if (waveNumber == 3) {
            giantPercent = 10;
        } else if (waveNumber < 5) {
            giantPercent = 15;
        } else if (waveNumber == 5) {
            giantPercent = 20;
        } else if (waveNumber < 9) {
            giantPercent = 40;
        } else if (waveNumber == 9) {
            giantPercent = 45;
        }

        int maxGiants = 0;
        if (waveNumber > 1) {
            maxGiants = (int)(Math.ceil((waveNumber - 1) / 6)) + 1;
        }

        int percentTanks = 15;
        if (waveNumber == 1) {
            percentTanks = 0;
        } else if (waveNumber < 10) {
            percentTanks = 10;
        }

        waves.add(new WaveSetting(
            currencyRange, // currency
            new Range(lowSpawn, highSpawn), // spawns
            55, // mission%
            supportPercent, // support%
            giantPercent, // giant%
            maxGiants, // max giants
            percentTanks // tank%
        ));
        fireTableDataChanged();
    }

    /**
     * Deletes all rows from the table
     */
    public void clear() {
        waves.clear();
        fireTableDataChanged();
    }

    /**
     * Resizes the table for the given size. This will chop off any records if the new size
     * is smaller, and create new default records if it is any bigger.
     * @param newSize
     */
    public void resizeTable(int newSize) {
        int currentSize = waves.size();
        if (newSize > currentSize) {
            for (int i = currentSize; i < newSize; i++) {
                addRow();
            }
        } else if (newSize < currentSize) {
            for (int i = newSize; i < currentSize; i++) {
                waves.remove(waves.size() - 1);
            }
        }

        fireTableDataChanged();
    }

    /**
     * Sets the table values back to defaults by clearing the waves and resetting it back
     */
    public void setRowsToDefaults() {
        int currentSize = waves.size();
        waves.clear();
        resizeTable(currentSize);
    }

    /**
     * Copies a row information to the row above it
     * @returns True if it copied the data; false otherwise
     */
    public boolean copyRowToAboveRow(int rowIndex) {
        if (indexInRange(rowIndex) && rowIndex != 0) {
            WaveSetting currentTankSetting = waves.get(rowIndex);
            WaveSetting tankSettingToCopyTo = waves.get(rowIndex - 1);

            tankSettingToCopyTo.copySettings(currentTankSetting);
            fireTableDataChanged();
            return true;
        }
        return false;
    }

    /**
     * Copies a row information to the row below it
     * @returns True if it copied the data; false otherwise
     */
    public boolean copyRowToBelowRow(int rowIndex) {
        if (indexInRange(rowIndex) && rowIndex < waves.size() - 1) {
            WaveSetting currentTankSetting = waves.get(rowIndex);
            WaveSetting tankSettingToCopyTo = waves.get(rowIndex + 1);

            tankSettingToCopyTo.copySettings(currentTankSetting);
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
            Collections.swap(waves, rowIndex, rowIndex - 1);
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
        if (indexInRange(rowIndex) && rowIndex < waves.size() - 1) {
            Collections.swap(waves, rowIndex, rowIndex + 1);
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
        return rowIndex >= 0 && rowIndex < waves.size();
    }

    /**
     * Gets the number of rows in the table
     * @return The number of rows in the table
     */
    @Override
    public int getRowCount() {
        return waves.size();
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
        if (waves.size() == 0) { return ""; }

        Object value = "";
        WaveSetting wave = waves.get(rowIndex);
        switch(columnIndex) {
            case 0: // Wave #
                value = rowIndex + 1;
                break;
            case 1: // Low $
                value = wave.getCurrencyRange().getLowerBound();
                break;
            case 2: // High $
                value = wave.getCurrencyRange().getUpperBound();
                break;
            case 3: // Low Spawn
                value = wave.getWaveSpawnRange().getLowerBound();
                break;
            case 4: // High Spawn
                value = wave.getWaveSpawnRange().getUpperBound();
                break;
            case 5: // Mission%
                value = wave.getPercentMissions();
                break;
            case 6: // Support%
                value = wave.getPercentSupport();
                break;
            case 7: // Giant%
                value = wave.getPercentGiants();
                break;
            case 8: // Max Giants
                value = wave.getMaxGiants();
                break;
            case 9: // Tank%
                value = wave.getPercentTanks();
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
        if (waves.size() == 0) { return String.class; }

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
        if (waves.size() == 0) { return; }

        WaveSetting wave = waves.get(rowIndex);
        switch(columnIndex) {
            case 0: // Wave #
                break;
            case 1: // Low $
                wave.getCurrencyRange().setLowerBound((int)value);
                break;
            case 2: // High $
                wave.getCurrencyRange().setUpperBound((int)value);
                break;
            case 3: // Low Spawn
                wave.getWaveSpawnRange().setLowerBound((int)value);
                break;
            case 4: // High Spawn
                wave.getWaveSpawnRange().setUpperBound((int)value);
                break;
            case 5: // Mission%
                wave.setPercentMissions((int)value);
                break;
            case 6: // Support%
                wave.setPercentSupport((int)value);
                break;
            case 7: // Giant%
                wave.setPercentGiants((int)value);
                break;
            case 8: // Max Giants
                wave.setMaxGiants((int)value);
                break;
            case 9: // Tank%
                wave.setPercentTanks((int)value);
                break;
        }
    }

    /**
     * Returns whether the given cell is editable
     * @param row - the row
     * @param column - the column
     * @return True if the column is not 1, as that's the wave number
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }
}
