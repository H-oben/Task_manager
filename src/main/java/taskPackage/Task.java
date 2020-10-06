package taskPackage;

import java.time.LocalDateTime;
import peoplePack.Person;
/**
 * @author Hunter Obendorfer
 */
public class Task {
    private String name;
    private String descrip;
    private Status stat;
    
    /**
     * Structure of subtasks where every subtask can have a subset of subtasks
     */
    private Subtask subs; //TODO: make a structure for the subtasks
    
    protected LocalDateTime mainDueDate;
    private final LocalDateTime createdOn; // not going to change so it's final
    
    private Person assignedTo;
    private final Person createdBy; // not going to change so it's final
    
    //default Constr.
    public Task(){
        name="empty";
        descrip="empty";
        stat=Status.NOT_STARTED;
        
        subs=null;
        
        mainDueDate=LocalDateTime.now();
        createdOn=LocalDateTime.now();
        
        assignedTo=null;
        createdBy=null;
    }
    
    /**
     * @param n String name of task, mutable
     * @param d String describing task,mutable
     * @param ldt LocalDateTime of the due date, mutable
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that assigned this task, this is immutable so be careful
     */
    public Task(String n, String d, LocalDateTime ldt, Person assigned, Person creator){
        name = n;
        descrip = d;
        stat=Status.NOT_STARTED;
        
        subs=null;
        
        mainDueDate=ldt;
        createdOn=LocalDateTime.now();
        
        assignedTo = assigned;
        createdBy = creator;
    }
    
    //setters
    //TODO: method to add subtask
    public void setName(String n){
        name=n;
    }
    public void setDescription(String d){
        descrip=d;
    }
    public void setStatus(Status s){
        stat=s;
    }
    /**
     * 
     * @param ldt set due date to a LocalDateTime
     * <p>Best practice dictates that the new due date is in the future,
     * not in the past or present.
     * </p>
     */
    public void setDueDate(LocalDateTime ldt){
        mainDueDate = ldt;
    }
    /**
     * @param a change assignment to this person
     */
    public void reassign(Person a){
        assignedTo = a;
    }
    
    //getters
    //TODO: get method for subtasks
    public String getName(){
        return(name);
    }
    public String describe(){
        return(descrip);
    }
    public Status getStatus(){
        return(stat);
    }
    public LocalDateTime getDueDate(){
        return(mainDueDate);
    }
    public LocalDateTime createdOn(){
        return(createdOn);
    }
    /**
     * @return returns the person class that this task was assigned to
     */
    public Person assignment(){
        return(assignedTo);
    }
    /**
     * @return returns the person class that created this class
     */
    public Person creator(){
        return(createdBy);
    }
}
