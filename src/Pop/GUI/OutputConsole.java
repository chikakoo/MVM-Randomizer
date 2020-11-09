package Pop.GUI;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The output console - this is used to display various messages in the application
 */
public class OutputConsole extends JPanel {
    /**
     * The text area
     */
    private static JTextArea textArea = new JTextArea(10, 75);

    /**
     * Tracked messages
     */
    private static HashSet<String> trackedMessages = new HashSet<>();

    /**
     * Constructor
     */
    public OutputConsole() {
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        this.add(scrollableTextArea);
    }

    /**
     * Adds text to the text area
     * @param message - the message to add
     */
    public static void addMessage(String message) {
        textArea.append(message + "\n");
    }

    /**
     * Adds a message, but doesn't add it more than one time per pop file generation
     * @param message - the message to add
     */
    public static void addMessageOnce(String message) {
        if (!trackedMessages.contains(message)) {
            addMessage(message);
            trackedMessages.add(message);
        }
    }

    /**
     * Clears the tracked messages
     */
    public static void clearTrackedMessages() {
        trackedMessages.clear();
    }
}
