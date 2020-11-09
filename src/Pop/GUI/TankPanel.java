package Pop.GUI;

import Pop.GUI.TableModels.TankItemModel;
import Pop.MVMRandomizer;
import Pop.Range;
import Pop.Settings.TankSetting;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The panel for tank spawning
 */
public class TankPanel extends JPanel {
    /**
     * GUI Components
     */
    private IntegerFieldPanel waveSpawnReductionPanel = new IntegerFieldPanel("Wave spawn reduction:", new Dimension(30, 20));
    private JTable tankTable;
    private TankItemModel tableModel;
    private JPopupMenu contextMenu;
    private JMenuItem addMenuItem = new JMenuItem("add");
    private JMenuItem deleteMenuItem = new JMenuItem("delete");
    private JMenuItem duplicateRowMenuItem = new JMenuItem("duplicate row");
    private JMenuItem moveDownMenuItem = new JMenuItem("move down");
    private JMenuItem moveUpMenuItem = new JMenuItem("move up");

    /**
     * Getters for all the settings
     */
    public int getWaveSpawnReduction() { return waveSpawnReductionPanel.getValue(); }
    public ArrayList<TankSetting> getTankSettings() { return tableModel.getTanks(); }

    /**
     * Constructor
     */
    public TankPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tableModel = new TankItemModel();
        tankTable = new JTable(tableModel);
        tankTable.setFillsViewportHeight(true);
        JScrollPane tankScrollPane = new JScrollPane(tankTable);

        centerCellText();
        setUpContextMenu();
        tankTable.getSelectionModel().addListSelectionListener(new RowSelectionListener());

        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(200, 40));
        upperPanel.setMaximumSize(upperPanel.getPreferredSize());
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        upperPanel.add(waveSpawnReductionPanel);

        this.add(upperPanel, BorderLayout.NORTH);
        this.add(tankScrollPane, BorderLayout.SOUTH);
        applySettings();
    }

    /**
     * Applies all the mvm randomizer fileSettings
     *
     */
    public void applySettings() {
        waveSpawnReductionPanel.setValue(MVMRandomizer.tankSettings.getWaveSpawnReduction());

        tableModel.clear();
        for (TankSetting tankSetting : MVMRandomizer.tankSettings.getTanks()) {
            tableModel.addRow(tankSetting);
        }

        tableModel.fireTableDataChanged();
    }

    /**
     * Centers the text displayed in cells
     */
    public void centerCellText() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tankTable.setDefaultRenderer(Integer.class, centerRenderer);
        tankTable.setDefaultRenderer(String.class, centerRenderer);
    }

    /**
     * Sets up the context menu
     */
    private void setUpContextMenu() {
        contextMenu = new JPopupMenu();
        contextMenu.add(addMenuItem);
        contextMenu.add(deleteMenuItem);
        contextMenu.addSeparator();
        contextMenu.add(duplicateRowMenuItem);
        contextMenu.add(moveDownMenuItem);
        contextMenu.add(moveUpMenuItem);

        disableMenuItemsRequiringRowSelection();

        addMenuItem.addActionListener(new AddMenuItemListener());
        deleteMenuItem.addActionListener(new DeleteMenuItemListener());
        duplicateRowMenuItem.addActionListener(new DuplicateRowMenuItemListener());
        moveDownMenuItem.addActionListener(new MoveDownMenuItemListener());
        moveUpMenuItem.addActionListener(new MoveUpMenuItemListener());

        tankTable.setComponentPopupMenu(contextMenu);
    }

    /**
     * Listener for the add option
     */
    private class AddMenuItemListener implements ActionListener {
        /**
         * Adds a row to the end of the table
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            tableModel.addRow();
        }
    }

    /**
     * Listener for the delete option
     */
    private class DeleteMenuItemListener implements ActionListener {
        /**
         * Deletes the selected row
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = tankTable.getSelectedRow();
            tableModel.deleteRow(selectedRow);
        }
    }

    /**
     * Listener for the duplicate row option
     */
    private class DuplicateRowMenuItemListener implements ActionListener {
        /**
         * Duplicates the selected row
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = tankTable.getSelectedRow();
            if(tableModel.duplicateRow(selectedRow)) {
                tankTable.changeSelection(selectedRow + 1, 0, false, false);
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
            int selectedRow = tankTable.getSelectedRow();
            if (tableModel.moveRowUp(selectedRow)) {
                tankTable.changeSelection(selectedRow - 1, 0, false, false);
            }
        }
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
            int selectedRow = tankTable.getSelectedRow();
            if (tableModel.moveRowDown(selectedRow)) {
                tankTable.changeSelection(selectedRow + 1, 0, false, false);
            }
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
            int selectedRow = tankTable.getSelectedRow();
            if (selectedRow >= 0) {
                enableAllMenuItems();

                if (selectedRow == 0) {
                    moveUpMenuItem.setEnabled(false);
                }

                if (selectedRow == tankTable.getRowCount() - 1) {
                    moveDownMenuItem.setEnabled(false);
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
        deleteMenuItem.setEnabled(false);
        duplicateRowMenuItem.setEnabled(false);
        moveDownMenuItem.setEnabled(false);
        moveUpMenuItem.setEnabled(false);
    }

    /**
     * Enables all menu items
     */
    private void enableAllMenuItems() {
        addMenuItem.setEnabled(true);
        deleteMenuItem.setEnabled(true);
        duplicateRowMenuItem.setEnabled(true);
        moveDownMenuItem.setEnabled(true);
        moveUpMenuItem.setEnabled(true);
    }
}
