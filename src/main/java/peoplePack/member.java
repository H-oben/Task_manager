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
    
    public member(){
        fname = "empty";
        lname = "empty";
        role= Role.MEMBER;
    }
    /**
     * @param F String first name of new member
     * @param L String last name of new member
     */
    public member(String F, String L){
        fname = F;
        lname = L;
        role = Role.MEMBER;
    }
    
    
    /**
     * @return returns enum object
     */
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
