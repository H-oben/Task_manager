package peoplePack;

import java.util.Arrays;
import java.util.Objects;

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
    private final Role role;
    private char[] pass;
    private Manager lead;
    
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
    
    @Override
    public boolean equals(Object o){
        if(this == o){
            return(true);
        }
        if(o instanceof member){
            member t = (member) o;
            if(t.getName().equals(this.getName())){
                return(true);
            }
        }
        return(false);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.fname);
        hash = 13 * hash + Objects.hashCode(this.lname);
        hash = 13 * hash + Objects.hashCode(this.role);
        hash = 13 * hash + Arrays.hashCode(this.pass);
        return hash;
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
    
    public void assignTeam(Manager a){
        lead = a;
    }
    public Manager getTeam(){
        return(lead);
    }
    public boolean inTeam(){
        return(lead!=null);
    }
}
