package GUI;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class JTableButtonRender implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton b = (JButton) value;
        if(isSelected){
            b.setForeground(table.getSelectionForeground());
            b.setBackground(table.getSelectionBackground());
        }
        else{
            b.setForeground(table.getForeground());
            b.setBackground(UIManager.getColor("Button.background"));
        }
        return b;
    }
    
}
