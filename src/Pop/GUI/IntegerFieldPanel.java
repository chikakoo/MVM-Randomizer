package Pop.GUI;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;

/**
 * An extention of TextFieldPanel, but only allows the user to enter integers
 */
public class IntegerFieldPanel extends TextFieldPanel {
    /**
     * Constructor
     * @param labelText - the text to give the label
     */
    public IntegerFieldPanel(String labelText, Dimension textFieldDimensions) {
        super(labelText);
        this.remove(textField);

        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);

        textField = new JFormattedTextField(formatter);
        textField.setPreferredSize(textFieldDimensions);
        textField.setText("0");

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textField.selectAll();
                    }
                });
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().length() == 0) {
                    textField.setText("0");
                }
            }
        });

        JPanel textFieldContainer = new JPanel();
        textFieldContainer.add(textField);

        this.add(textFieldContainer);
    }

    /**
     * Gets the value out of the text field
     * @return The value from the text field
     */
    public int getValue() {
        return (int)((JFormattedTextField)textField).getValue();
    }

    /**
     * Sets the value in the text field
     * @param value - the value to set
     */
    public void setValue(int value) {
        ((JFormattedTextField)textField).setValue(value);
    }
}
