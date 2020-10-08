package peoplePack;

/**
 * @author h_obe
 * <p>
 * Authoritative user of Task Manager.
 * </p>
 * <p>
 * Authority:
 * Can do everything a member can do
 * Can assign tasks/subtasks
 * Can create/delete tasks
 * Can be either a manager or team lead
 * Team lead: cannot delete tasks/subtasks asssigned to them 
 * but can delete subtasks lower in structure assigned to them
 * Manager: needs additional confirmation to delete tasks but not subtasks
 * </p>
 * 
 */
public class Manager implements Person{
    private String fname;
    private String lname;
    private Role role;
    
    public Manager(){
        fname = "empty";
        lname = "empty";
        role= Role.MANAGER;
    }
    /**
     * @param F String first name of new member
     * @param L String last name of new member
     * @param R Role of new manager, either manager or Team Lead
     * @throws peoplePack.MemberManagerException
     */
    public Manager(String F, String L, Role R) throws MemberManagerException{
        fname = F;
        lname = L;
        if(R==Role.MEMBER){
            throw(new MemberManagerException("Bad Role for Manager/Team Lead"
                    ,"A Manager/Team Lead cannot be a member"));
        }
        role = R;
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
