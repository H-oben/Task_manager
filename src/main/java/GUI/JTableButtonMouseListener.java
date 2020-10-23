package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;

public class JTableButtonMouseListener extends MouseAdapter{
    private final JTable table;
    
    public JTableButtonMouseListener(JTable t){
        table = t;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        int c = table.getColumnModel().getColumnIndexAtX(e.getX());
        int r = e.getY()/table.getRowHeight();
        if(r<table.getRowHeight() && r>=0 && c<table.getColumnCount() && c>=0){
            Object v = table.getValueAt(r, c);
            if(v instanceof JButton){
                ((JButton) v).doClick(); //TODO: make button clicks Function
            }
        }
    }
}
