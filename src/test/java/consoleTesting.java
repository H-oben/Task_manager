import java.awt.Color;
import taskPackage.*;
import peoplePack.*;
import java.time.LocalDate;
public class consoleTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager m=new Manager();
        Manager T;
        String x = "password";
        char[] pass = new char[x.length()];
        for(int y=0; y<x.length();y++){
            pass[y] = x.charAt(y);
        }
        try{
            T = new Manager("Frank","Furt",pass, Role.TEAMLEAD);
        }
        catch (MemberManagerException a){
            T = new Manager();
        }
        Task t = new Task("Test Task", "", new Categories("test"), new Color(255,255,255), LocalDate.now(),T,m);
        System.out.println(t.toString());
    }
    
}
