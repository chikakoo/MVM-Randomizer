package Pop.GUI;

import Pop.GUI.TableModels.MapItemModel;
import Pop.MVMRandomizer;
import Pop.Settings.MapSetting;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel for map information
 */
public class MapPanel extends JPanel {
    /**
     * GUI Components
     */
    private AutoSelectTable mapTable;
    private MapItemModel tableModel;
    private JPopupMenu contextMenu;
    private JMenuItem selectStandardMapsMenuItem = new JMenuItem("enable only standard maps");
    private JMenuItem selectCommunityMapsMenuItem = new JMenuItem("enable only community maps");
    private JMenuItem selectEngineerMapsMenuItem = new JMenuItem("enable only Engineer maps");
    private JMenuItem selectAllMapsMenuItem = new JMenuItem("enable all maps");
    private JMenuItem selectNoMapsMenuItem = new JMenuItem("enable no maps");

    /**
     * Constructor
     */
    public MapPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tableModel = new MapItemModel();
        mapTable = new AutoSelectTable(tableModel);
        mapTable.setFillsViewportHeight(true);
        JScrollPane mapScrollPane = new JScrollPane(mapTable);

        centerCellText();
        setUpContextMenu();

        this.add(mapScrollPane);
        applySettings();
    }

    /**
     * Applies all the mvm randomizer fileSettings
     *
     */
    public void applySettings() {
        tableModel.clear();
        for (MapSetting mapSetting : MVMRandomizer.mapSettings.getMapsSettingsForTable()) {
            tableModel.addRow(mapSetting);
        }
        tableModel.fireTableDataChanged();
    }

    /**
     * Centers the text displayed in cells
     */
    private void centerCellText() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        mapTable.setDefaultRenderer(Integer.class, centerRenderer);
        mapTable.setDefaultRenderer(Double.class, centerRenderer);
    }

    /**
     * Sets up the context menu options
     */
    private void setUpContextMenu() {
        contextMenu = new JPopupMenu();
        contextMenu.add(selectStandardMapsMenuItem);
        contextMenu.add(selectCommunityMapsMenuItem);
        contextMenu.add(selectEngineerMapsMenuItem);
        contextMenu.addSeparator();
        contextMenu.add(selectAllMapsMenuItem);
        contextMenu.add(selectNoMapsMenuItem);

        selectStandardMapsMenuItem.addActionListener(new SelectStandardMapsListener());
        selectCommunityMapsMenuItem.addActionListener(new SelectCommunityMapsListener());
        selectEngineerMapsMenuItem.addActionListener(new SelectEngineerMapsListener());
        selectAllMapsMenuItem.addActionListener(new SelectAllMapsListener());
        selectNoMapsMenuItem.addActionListener(new SelectNoMapsListener());

        mapTable.setComponentPopupMenu(contextMenu);
    }

    /**
     * Listener for the select standard maps option
     */
    private class SelectStandardMapsListener implements ActionListener {
        /**
         * Selects only standard maps
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.selectOnlyStandardMaps();
        }
    }

    /**
     * Listener for the select community maps option
     */
    private class SelectCommunityMapsListener implements ActionListener {
        /**
         * Selects only community maps
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.selectOnlyCommunityMaps();
        }
    }

    /**
     * Listener for the select engineer maps option
     */
    private class SelectEngineerMapsListener implements ActionListener {
        /**
         * Selects only engineer maps
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) { tableModel.selectOnlyEngineerMaps(); }
    }

    /**
     * Listener for the select all maps option
     */
    private class SelectAllMapsListener implements ActionListener {
        /**
         * Selects all maps
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.selectAllMaps();
        }
    }

    /**
     * Listener for the select no maps option
     */
    private class SelectNoMapsListener implements ActionListener {
        /**
         * Deselects all maps
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.selectNoMaps();
        }
    }
}
