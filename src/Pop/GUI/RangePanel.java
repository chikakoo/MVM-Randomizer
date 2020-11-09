package Pop.GUI;

import Pop.Range;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * A general panel to represent a range of values
 */
public class RangePanel extends JPanel {
    /**
     * GUI Components
     */
    private JFormattedTextField lowerValueTextField;
    private JFormattedTextField upperValueTextField;
    private JPanel lowerTextFieldPanel = new JPanel();
    private JPanel upperTextFieldPanel = new JPanel();

    /**
     * The lower value
     */
    public int getLowerValue() {
        return lowerValueTextField.getValue() == null ? 0 : (int)lowerValueTextField.getValue();
    }

    /**
     * The upper value
     */
    public int getUpperValue() {
        return upperValueTextField.getValue() == null ? 0 : (int)upperValueTextField.getValue();
    }

    /**
     * The range
     */
    public Range getRange() {
        return new Range(getLowerValue(), getUpperValue());
    }

    /**
     * Constructor
     */
    public RangePanel(String rangeLabelText, Dimension textFieldDimensions) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        setUpTextFields(textFieldDimensions);

        JLabel rangeLabel = new JLabel(rangeLabelText + ":");
        JLabel toLabel = new JLabel("to");

        this.add(rangeLabel);
        this.add(lowerTextFieldPanel);
        this.add(toLabel);
        this.add(upperTextFieldPanel);
    }

    /**
     * Sets up the text fields to only allow integers
     */
    public void setUpTextFields(Dimension textFieldDimensions) {
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);

        lowerValueTextField = new JFormattedTextField(formatter);
        lowerValueTextField.setText("0");
        lowerValueTextField.setPreferredSize(textFieldDimensions);
        lowerTextFieldPanel.add(lowerValueTextField);


        upperValueTextField = new JFormattedTextField(formatter);
        upperValueTextField.setText("0");
        upperValueTextField.setPreferredSize(textFieldDimensions);
        upperTextFieldPanel.add(upperValueTextField);

        lowerValueTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        lowerValueTextField.selectAll();
                    }
                });
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (lowerValueTextField.getText().length() == 0) {
                    lowerValueTextField.setText("0");
                }
            }
        });

        upperValueTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        upperValueTextField.selectAll();
                    }
                });
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (upperValueTextField.getText().length() == 0) {
                    upperValueTextField.setText("0");
                }
            }
        });
    }

    /**
     * Sets the range to the given value
     */
    public void setRange(Range range) {
        int lowerValue = 0;
        int upperValue = 0;

        if (range != null) {
            lowerValue = range.getLowerBound();
            upperValue = range.getUpperBound();
        }

        lowerValueTextField.setValue(lowerValue);
        upperValueTextField.setValue(upperValue);

        try {
            lowerValueTextField.commitEdit();
            upperValueTextField.commitEdit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
