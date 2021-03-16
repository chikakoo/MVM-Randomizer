package Pop.GUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Extension of JTable to auto-select all text and enter edit mode on focus
 */
public class AutoSelectTable extends JTable {
    /**
     * Constructor
     * @param model - the table model
     */
    public AutoSelectTable(AbstractTableModel model) {
        super(model);
        setUpFocusListener();
    }

    /**
     * Sets up the focus listener to enter edit mode and to auto-select text on focus
     */
    private void setUpFocusListener() {
        JTable thisReference = this;

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                int selectedRow = thisReference.getSelectedRow();
                int selectedColumn = thisReference.getSelectedColumn();

                if (thisReference.editCellAt(selectedRow, selectedColumn)) {
                    DefaultCellEditor ed = (DefaultCellEditor)thisReference.getCellEditor();

                    Component component = ed.getComponent();
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField)component;
                        textField.select(0, textField.getText().length());
                        textField.setHorizontalAlignment(SwingConstants.CENTER);
                        textField.requestFocusInWindow();
                    }
                }
            }
        });
    }
}
