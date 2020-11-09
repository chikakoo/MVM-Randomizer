package Pop.GUI;

import Pop.Enums.JsonSerializableEnum;

import javax.swing.*;
import java.awt.*;

public class EnumComboBoxRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Object item = value;

        if (item instanceof JsonSerializableEnum) {
            item = ((JsonSerializableEnum )item).getDisplayString();
        }
        return super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
    }
}
