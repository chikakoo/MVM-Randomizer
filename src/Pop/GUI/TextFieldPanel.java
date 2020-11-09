package Pop.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * A control with a text field and a label next to it
 */
public class TextFieldPanel extends JPanel {
    /**
     * GUI Components
     */
    protected JTextField textField;

    /**
     * Constructor
     */
    public TextFieldPanel(String labelText) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel textFieldLabel = new JLabel(labelText);
        textField = new JTextField();

        this.add(textFieldLabel);
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(textField);
    }

    /**
     * Gets the text in the text field
     */
    public String getText() {
        return textField.getText();
    }

    /**
     * Sets the text in the text field
     * @param text - the text to set
     */
    public void setText(String text) {
        textField.setText(text);
    }
}
