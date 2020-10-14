package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;

public class Subtask extends Task{
    private String name;
    private String descrip;
    private Status stat;
    private Color color;
    
    private Subtask[] sub; //TODO: make structure for subclasses
    
    protected LocalDate dueDate;
    private final LocalDate createdOn; // not going to change so it's final
    
    private Person assignedTo;
    private final Person createdBy; // not going to change so it's final
    
    public Subtask(){
        name="empty";
        descrip="empty";
        stat=Status.NOT_STARTED;
        
        sub=null;
        
        dueDate=super.mainDueDate;
        createdOn=LocalDate.now();
        
        
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
    public Subtask(String n, String d, LocalDate due, Person assigned, Person creator){
        name = n;
        descrip=d;
        stat=Status.NOT_STARTED;
        
        sub=null;
        
        dueDate=due;
        createdOn=LocalDate.now();
        
        if(createdOn.compareTo(mainDueDate)<=0){ //decide color based on due date
            color=Color.RED;
        }
        else if(createdOn.compareTo(mainDueDate)<=7){
            color=Color.YELLOW;
        }
        else if(createdOn.compareTo(mainDueDate)>7){
            color=Color.GREEN;
        }
        else{                                   //default color is blue
            color=Color.BLUE;
        }
        
        assignedTo = assigned;
        createdBy = creator;
    }
    
    /**
     * @param ld set due date to a LocalDateTime
     * <p>Best practice dictates that the new due date is in the future,
     * not in the past or present.
     * </p>
     */
    @Override
    public void setDueDate(LocalDate ld){
        dueDate=ld;
    }
    
    /**
     * @return returns the subtask due date
     */
    @Override
    public LocalDate getDueDate(){
        return(dueDate);
    }
}
