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
        try{
            T = new Manager("Frank","Furt", Role.TEAMLEAD);
        }
        catch (MemberManagerException a){
            T = new Manager();
        }
        Task t = new Task("Test Task", "", new Catagories("test"), LocalDate.now(),T,m);
        System.out.println(t.toString());
    }
    
}
