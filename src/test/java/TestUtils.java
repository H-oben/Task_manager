import javax.swing.*;
import java.awt.*;

public class TestUtils {
    static int counter;
    
    public static Component getChildNamed(Component parent, String name){
        if(name.equals(parent.getName())){
            return(parent);
        }
        if(parent instanceof Container){
            Component[] children = ((Container) parent).getComponents();
        }
        return(null);
    }
}
