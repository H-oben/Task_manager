package peoplePack;

/**
 * @author h_obe
 * <p>
 * Main user of Task Manager.
 * </p>
 * <p>
 * Authority:
 * Can change color of tasks
 * Can re-arrange tasks in predefined orders or their own orders
 * Can change status of tasks/subtasks assigned to them
 * </p>
 * 
 */
public class member implements Person{
    private String fname;
    private String lname;
    private Role role;
    private char[] pass;
    
    public member(){
        fname = "empty";
        lname = "empty";
        role= Role.MEMBER;
        String x = "password";
        pass = new char[x.length()];
        for(int y=0; y<x.length();y++){
            pass[y] = x.charAt(y);
        }
    }
    /**
     * @param F String first name of new member
     * @param L String last name of new member
     * @param P password input
     */
    public member(String F, String L, char[] P){
        fname = F;
        lname = L;
        role = Role.MEMBER;
        if(P.length!=0){
            pass = P;
        }
        else{
            String x = "password";
            pass = new char[x.length()];
            for(int y=0; y<x.length();y++){
                pass[y] = x.charAt(y);
            }
        }
    }
    
    
    /**
     * @return returns enum object
     */
    @Override
    public boolean testPassword(char[] a){
        if(a.length!= pass.length){
            return(false);
        }
        else{
            for(int x = 0; x< a.length;x++){
                if(a[x]!= pass[x]){
                    return(false);
                }
            }
            return(true);
        }
    }
    @Override
    public Role getRole(){
        return(role);
    }
    /**
     * @return returns name in format: "first_name last_Name"
     */
    @Override
    public String getName(){
        return(fname + " " + lname);
    }
    public void setName(String f, String l){
        fname=f;
        lname=l;
    }
}
