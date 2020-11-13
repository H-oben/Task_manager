package GUI;

import java.awt.*;

//testing class to retrieve objects on screen to manipulate
public class TestUtils {
    static int counter;
    
    public static Component getChildNamed(Component parent, String name){
        if(name.equals(parent.getName())){
            return(parent);
        }
        if(parent instanceof Container){
            Component[] children = ((Container) parent).getComponents();
            for(int x = 0; x< children.length; x++){
                Component child = getChildNamed(children[x], name);
                if(child!=null){
                    return(child);
                }
            }
        }
        return(null);
    }
    
    public static Component getChildIndexed(Component parent, String name, int Index){
        counter=0;
        if(parent instanceof Window){
            Component[] children = ((Window)parent).getOwnedWindows();
            for(int x = 0; x< children.length; x++){
                if(children[x] instanceof Window && !((Window)children[x]).isActive()){
                    continue;
                }
                Component child = getChildIndexedInternal(children[x], name, Index);
                if(child!= null){
                    return(child);
                }
            }
        }
        return(null);
    }

    private static Component getChildIndexedInternal(Component component, String name, int Index) {
        if(component.getClass().toString().endsWith(name)){
            if(counter==Index){
                return(component);
            }
            counter++;
        }
        if(component instanceof Container){
            Component[] children =((Container) component).getComponents();
            for(int x = 0; x<children.length; x++){
                Component child = getChildIndexedInternal(children[x], name, Index);
                if(child!=null){
                    return(child);
                }
            }
        }
        return(null);
    }
}
