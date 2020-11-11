package peoplePack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
    private char[] pass;
    private ArrayList<member> members;
    
    public Manager(){
        fname = "empty";
        lname = "empty";
        role= Role.MANAGER;
        pass = "password".toCharArray();
        members=new ArrayList<>();
    }
    /**
     * @param F String first name of new member
     * @param L String last name of new member
     * @param P password in char[]
     * @param R Role of new manager, either manager or Team Lead
     * @throws peoplePack.MemberManagerException
     */
    public Manager(String F, String L,char[] P, Role R) throws MemberManagerException{
        fname = F;
        lname = L;
        if(R==Role.MEMBER){
            throw(new MemberManagerException("Bad Role for Manager/Team Lead"
                    ,"A Manager/Team Lead cannot be a member"));
        }
        role = R;
        if(P.length!=0){
            pass = P;
        }
        else{
            pass = "password".toCharArray();
        }
        members = new ArrayList<>();
    }
    
    public ArrayList<member> getTeamMembers(){
        return (members);
    }
    public boolean addTeamMember(member a){
        if(members.contains(a)){
            return(false);
        }
        else{
            members.add(a);
            return(true);
        }
    }
    public boolean findTeamMember(Person a){
        for(member x:members){
            if(x.equals(a)){
                return(true);
            }
        }
        return(false);
    }
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
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return(true);
        }
        if(obj instanceof Manager){
            Manager a = (Manager) obj;
            if(this.getRole()==a.getRole()){
                if(this.getName().equals(a.getName())){
                    return(true);
                }
            }
        }
        return(false);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.fname);
        hash = 41 * hash + Objects.hashCode(this.lname);
        hash = 41 * hash + Objects.hashCode(this.role);
        hash = 41 * hash + Arrays.hashCode(this.pass);
        return hash;
    }
}
