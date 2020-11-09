package Pop.GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * A control with a checkbox and a panel next to it
 */
public class CheckboxPanel extends JPanel {
    /**
     * GUI Components
     */
    private JCheckBox checkBox;

    /**
     * Constructor
     */
    public CheckboxPanel(String labelText) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel checkboxLabel = new JLabel(labelText);
        checkBox = new JCheckBox();

        this.add(checkboxLabel);
        this.add(checkBox);
    }

    /**
     * Gets the value of the panel
     */
    public boolean isChecked() {
        return checkBox.isSelected();
    }

    /**
     * Sets the value of thepanel
     */
    public void setIsChecked(boolean isChecked) {
        checkBox.setSelected(isChecked);
    }

    /**
     * Adds an action listener to the checkbox panel
     * @param actionListener - the action listener
     */
    public void addActionListener(ActionListener actionListener) {
        checkBox.addActionListener(actionListener);
    }
}
