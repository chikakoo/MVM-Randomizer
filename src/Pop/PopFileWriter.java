package Pop;

import java.io.*;

/**
 * Contains some useful shortcut functions for the FileWriter
 */
public class PopFileWriter extends FileWriter {
    /**
     * Constructor- takes the filename
     * @param fileName - the name of the file
     * @throws IOException
     */
    public PopFileWriter(String fileName) throws IOException {
        super(fileName);
    }

    /**
     * Writes a line to the file, followed by a newline character
     * @param text - the text to write
     * @param numberOfTabs - the number of tabs to include in the line
     * @throws IOException
     */
    public void write(String text, int numberOfTabs) throws IOException {
        write(getTabString(numberOfTabs) + text);
    }

    /**
     * Returns \t, times the given number
     * @param numberOfTabs - the number of tabs to include
     * @return a string representation of the number of tabs given
     */
    private String getTabString(int numberOfTabs) {
        String tabString = "";
        for (int i = 0; i < numberOfTabs; i++) {
            tabString += "\t";
        }

        return tabString;
    }

    /**
     * Writes a line to the file, followed by a newline character
     * @param text - the text to write
     * @throws IOException
     */
    public void writeLine(String text) throws IOException {
        write(text + "\n");
    }

    /**
     * Writes a line to the file, followed by a newline character
     * @param text - the text to write
     * @param numberOfTabs - the number of tabs to include in the line
     * @throws IOException
     */
    public void writeLine(String text, int numberOfTabs) throws IOException {
        write(text + "\n", numberOfTabs);
    }

    /**
     * Writes a newline character to the file
     * @throws IOException
     */
    public void writeLine() throws IOException {
        write("\n");
    }

    /**
     * Adds a comment border to the file
     * @throws IOException
     */
    public void AddCommentBorder() throws IOException {
        writeLine("//---------------------------------------------------------------");
    }

    /**
     * Adds a comment surrounded by borders - doesn't expect newlines
     * @param comment - the comment to add
     * @throws IOException
     */
    public void AddCommentInBorders(String comment) throws IOException {
        AddCommentBorder();
        writeLine("// " + comment);
        AddCommentBorder();
    }

    public void writePopObjectRepsentation(PopObjectRepresentation popObjectRepresentation) throws IOException {
        writePopObject(popObjectRepresentation.getPopObject());
    }

    /**
     * Writes the given PopObject to the file
     * @param popObject - the PopObject to write
     * @throws IOException
     */
    public void writePopObject(PopObject popObject) throws IOException {
        writePopObject(popObject, 0);
    }

    /**
     * Writes the given PopObject to the file
     * @param popObject - the PopObject to write
     * @param tabCount - the number of tabs to start each line with
     * @throws IOException
     */
    public void writePopObject(PopObject popObject, int tabCount) throws IOException {
        writeLine();
        writeLine(popObject.getName(), tabCount);
        writeLine("{", tabCount);

        for(PopObjectMember member : popObject.getMembers()) {
            if (member.isAttribute()) {
                writePopObjectAttribute((PopObjectAttribute)member, tabCount + 1);
            } else if (member.isObject()) {
                writePopObject((PopObject)member, tabCount + 1);
            }
        }

        writeLine("}", tabCount);
    }

    /**
     * Writes the given PopObjectAttribute to the file
     * @param attribute - the attribute to write
     * @throws IOException
     */
    public void writePopObjectAttribute(PopObjectAttribute attribute) throws IOException {
        writePopObjectAttribute(attribute, 0);
    }

    /**
     * Writes the given PopObjectAttribute to the file
     * @param name - the name of the attribute
     * @param value - the value of the attribute
     * @throws IOException
     */
    public void writePopObjectAttribute(String name, String value) throws IOException {
        writePopObjectAttribute(new PopObjectAttribute(name, value));
    }

    /**
     * Writes the given PopObjectAttribute to the file
     * @param attribute - the attribute to write
     * @param tabCount - the number of tabs to include
     * @throws IOException
     */
    private void writePopObjectAttribute(PopObjectAttribute attribute, int tabCount) throws IOException {
        String attributeLine = String.format("%s %s", attribute.getName(), attribute.getValue());
        writeLine(attributeLine, tabCount);
    }
}
