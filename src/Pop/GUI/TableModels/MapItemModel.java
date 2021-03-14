package Pop.GUI.TableModels;

import Pop.Enums.Maps;
import Pop.Maps.Map;
import Pop.Settings.MapSetting;
import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 * The map item model for JTables
 */
public class MapItemModel extends AbstractTableModel {
    private ArrayList<MapSetting> maps = new ArrayList<>();
    public ArrayList<MapSetting> getMaps() { return maps; }

    private String[] columnNames = {
        "Map",
        "Spawn Multiplier",
        "Currency Multiplier",
        "Low Starting $", "High Starting $",
        "Enabled"
    };

    /**
     * Adds a row to the table
     * @param mapSetting - the map setting to add
     */
    public void addRow(MapSetting mapSetting) {
        maps.add(mapSetting);
        fireTableDataChanged();
    }

    /**
     * Deletes all rows from the table
     */
    public void clear() {
        maps.clear();
        fireTableDataChanged();
    }

    /**
     * Selects only standard maps
     */
    public void selectOnlyStandardMaps() {
        for (MapSetting mapSetting : maps) {
            mapSetting.setEnabled(Maps.isStandardMap(mapSetting.getMap()));
        }
        fireTableDataChanged();
    }

    /**
     * Selects only community maps
     */
    public void selectOnlyCommunityMaps() {
        for (MapSetting mapSetting : maps) {
            mapSetting.setEnabled(!Maps.isStandardMap(mapSetting.getMap()));
        }
        fireTableDataChanged();
    }

    /**
     * Selects only engineer maps
     */
    public void selectOnlyEngineerMaps() {
        for (MapSetting mapSetting : maps) {
            Map map = Map.getMapFromEnum(mapSetting.getMap());
            mapSetting.setEnabled(map.getCanSpawnEngineers());
        }
        fireTableDataChanged();
    }

    /**
     * Selects all maps
     */
    public void selectAllMaps() {
        for (MapSetting mapSetting : maps) {
            mapSetting.setEnabled(true);
        }
        fireTableDataChanged();
    }

    /**
     * Select no maps
     */
    public void selectNoMaps() {
        for (MapSetting mapSetting : maps) {
            mapSetting.setEnabled(false);
        }
        fireTableDataChanged();
    }

    /**
     * Gets the number of rows in the table
     * @return The number of rows in the table
     */
    @Override
    public int getRowCount() {
        return maps.size();
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
        if (maps.size() == 0) { return ""; }

        Object value = "";
        MapSetting map = maps.get(rowIndex);
        switch(columnIndex) {
            case 0: // Map
                value = map.getMap().getDisplayString();
                break;
            case 1: // Spawn multiplier
                value = map.getSpawnMultiplier();
                break;
            case 2: // Currency Multiplier
                value = map.getCurrencyMultiplier();
                break;
            case 3: // Low Starting $
                value = map.getStartingCurrency().getLowerBound();
                break;
            case 4: // High Starting $
                value = map.getStartingCurrency().getUpperBound();
                break;
            case 5: // Enabled
                value = map.getEnabled();
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
        if (maps.size() == 0) { return String.class; }

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
        if (maps.size() == 0) { return; }

        MapSetting map = maps.get(rowIndex);
        switch(columnIndex) {
            case 0: // Map (not editable)
                break;
            case 1: // Spawn multiplier
                map.setSpawnMultiplier((double)value);
                break;
            case 2: // Currency Multiplier
                map.setCurrencyMultiplier((double)value);
                break;
            case 3: // Low Starting $
                map.getStartingCurrency().setLowerBound((int)value);
                break;
            case 4: // High Starting $
                map.getStartingCurrency().setUpperBound((int)value);
                break;
            case 5: // Enabled
                map.setEnabled((boolean)value);
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
        return column != 0; // Only the map name is not editable
    }
}
