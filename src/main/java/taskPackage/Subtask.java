package taskPackage;

import java.time.LocalDateTime;
import peoplePack.Person;

public class Subtask extends Task{
    private String name;
    private String descrip;
    private Status stat;
    
    private Subtask sub; //TODO: make structure for subclasses
    
    protected LocalDateTime dueDate;
    private final LocalDateTime createdOn; // not going to change so it's final
    
    private Person assignedTo;
    private final Person createdBy; // not going to change so it's final
    
    public Subtask(){
        name="empty";
        descrip="empty";
        stat=Status.NOT_STARTED;
        
        sub=null;
        
        dueDate=super.mainDueDate;
        createdOn=LocalDateTime.now();
        
        assignedTo=null;
        createdBy=null;
    }
    
    /**
     * @param n String name of subtask
     * @param d String description of subtask
     * @param due LocalDateTime of due date
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that made this task
     */
    public Subtask(String n, String d, LocalDateTime due, Person assigned, Person creator){
        name = n;
        descrip=d;
        stat=Status.NOT_STARTED;
        
        sub=null;
        
        dueDate=due;
        createdOn=LocalDateTime.now();
        
        assignedTo = assigned;
        createdBy = creator;
    }
    
    /**
     * @param ldt set due date to a LocalDateTime
     * <p>Best practice dictates that the new due date is in the future,
     * not in the past or present.
     * </p>
     */
    @Override
    public void setDueDate(LocalDateTime ldt){
        dueDate=ldt;
    }
    
    /**
     * @return returns the subtask due date
     */
    @Override
    public LocalDateTime getDueDate(){
        return(dueDate);
    }
}
