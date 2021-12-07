package Pop.GUI;

import Pop.GUI.TableModels.WaveItemModel;
import Pop.MVMRandomizer;
import Pop.Settings.WaveSetting;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel dealing with individual wave settings
 */
public class WavePanel extends JPanel {
    /**
     * GUI Componenets
     */
    private IntegerFieldPanel percentRandomSpawn = new IntegerFieldPanel("% random spawn:", new Dimension(30, 20));
    private AutoSelectTable waveTable;
    private WaveItemModel tableModel;
    private JPopupMenu contextMenu;
    private JMenuItem moveDownMenuItem = new JMenuItem("move down");
    private JMenuItem moveUpMenuItem = new JMenuItem("move up");
    private JMenuItem duplicateBelowItem = new JMenuItem("duplicate row to below row");
    private JMenuItem duplicateAboveItem = new JMenuItem("duplicate row to above row");
    private JMenuItem setDefaultValues = new JMenuItem("set default values");

    /**
     * Getters for all the settings
     */
    public int getPercentRandomSpawn() { return percentRandomSpawn.getValue(); }
    public ArrayList<WaveSetting> getWaveSettings() { return tableModel.getWaves(); }

    /**
     * Constructor
     */
    public WavePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tableModel = new WaveItemModel();
        waveTable = new AutoSelectTable(tableModel);
        waveTable.setFillsViewportHeight(true);
        JScrollPane tankScrollPane = new JScrollPane(waveTable);

        centerCellText();
        setUpContextMenu();
        waveTable.getSelectionModel().addListSelectionListener(new RowSelectionListener());

        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(200, 40));
        upperPanel.setMaximumSize(upperPanel.getPreferredSize());
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));

        upperPanel.add(percentRandomSpawn);
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(tankScrollPane, BorderLayout.SOUTH);
        applySettings();
    }

    /**
     * Applies the current settings to the panel
     */
    public void applySettings() {
        percentRandomSpawn.setValue(MVMRandomizer.waveSettings.getPercentRandomSpawn());

        tableModel.clear();
        for (WaveSetting waveSetting : MVMRandomizer.waveSettings.getWaves()) {
            tableModel.addRow(waveSetting);
        }

        tableModel.fireTableDataChanged();
    }

    /**
     * Centers the text displayed in cells
     */
    public void centerCellText() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        waveTable.setDefaultRenderer(Integer.class, centerRenderer);
        waveTable.setDefaultRenderer(String.class, centerRenderer);
    }

    /**
     * Sets up the context menu
     */
    private void setUpContextMenu() {
        contextMenu = new JPopupMenu();
        contextMenu.add(moveDownMenuItem);
        contextMenu.add(moveUpMenuItem);
        contextMenu.addSeparator();
        contextMenu.add(duplicateBelowItem);
        contextMenu.add(duplicateAboveItem);
        contextMenu.addSeparator();
        contextMenu.add(setDefaultValues);

        disableMenuItemsRequiringRowSelection();

        moveDownMenuItem.addActionListener(new MoveDownMenuItemListener());
        moveUpMenuItem.addActionListener(new MoveUpMenuItemListener());
        duplicateBelowItem.addActionListener(new DuplicateBelowMenuItemListener());
        duplicateAboveItem.addActionListener(new DuplicateAboveMenuItemListener());
        setDefaultValues.addActionListener(new SetDefaultValuesMenuItemListener());

        waveTable.setComponentPopupMenu(contextMenu);
    }

    /**
     * Listener for the move down option
     */
    private class MoveDownMenuItemListener implements ActionListener {
        /**
         * Moves the selected row down
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = waveTable.getSelectedRow();
            if (tableModel.moveRowDown(selectedRow)) {
                waveTable.changeSelection(selectedRow + 1, 0, false, false);
            }
        }
    }

    /**
     * Listener for the move up option
     */
    private class MoveUpMenuItemListener implements ActionListener {
        /**
         * Moves the selected row up
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = waveTable.getSelectedRow();
            if (tableModel.moveRowUp(selectedRow)) {
                waveTable.changeSelection(selectedRow - 1, 0, false, false);
            }
        }
    }

    /**
     * Listener for the duplicate below option
     */
    private class DuplicateBelowMenuItemListener implements ActionListener {
        /**
         * Duplicates the selected row's data to the row below it
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = waveTable.getSelectedRow();
            if (tableModel.copyRowToBelowRow(selectedRow)) {
                waveTable.changeSelection(selectedRow + 1, 0, false, false);
            }
        }
    }

    /**
     * Listener for the duplicate above option
     */
    private class DuplicateAboveMenuItemListener implements ActionListener {
        /**
         * Duplicates the selected row's data to the row above it
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = waveTable.getSelectedRow();
            if (tableModel.copyRowToAboveRow(selectedRow)) {
                waveTable.changeSelection(selectedRow - 1, 0, false, false);
            }
        }
    }

    private class SetDefaultValuesMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            tableModel.setRowsToDefaults();
        }
    }

    /**
     * Listener for when rows in the table are selected
     */
    private class RowSelectionListener implements ListSelectionListener {
        /**
         * Disables/enables menu options as appropriate
         * @param e
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = waveTable.getSelectedRow();
            if (selectedRow >= 0) {
                enableAllMenuItems();

                if (selectedRow == 0) {
                    moveUpMenuItem.setEnabled(false);
                    duplicateAboveItem.setEnabled(false);
                }

                if (selectedRow == waveTable.getRowCount() - 1) {
                    moveDownMenuItem.setEnabled(false);
                    duplicateBelowItem.setEnabled(false);

                }
            } else {
                disableMenuItemsRequiringRowSelection();
            }
        }
    }

    /**
     * Disables all options requiring a row in the table to be selected
     */
    private void disableMenuItemsRequiringRowSelection() {
        moveDownMenuItem.setEnabled(false);
        moveUpMenuItem.setEnabled(false);
        duplicateBelowItem.setEnabled(false);
        duplicateAboveItem.setEnabled(false);

    }

    /**
     * Enables all menu items
     */
    private void enableAllMenuItems() {
        moveDownMenuItem.setEnabled(true);
        moveUpMenuItem.setEnabled(true);
        duplicateBelowItem.setEnabled(true);
        duplicateAboveItem.setEnabled(true);
        setDefaultValues.setEnabled(true);
    }

    /**
     * Adjusts the table to be the given size
     * @param - the size to make the table
     */
    public void resizeTable(int size) {
        tableModel.resizeTable(size);
    }
}
