package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

public class Subtask extends Task{
    private String name;
    private String descrip;
    private Status stat;
    private Color color;
    
    private ArrayList<Subtask> subs = new ArrayList<Subtask>();
    
    protected LocalDate dueDate;
    private final LocalDate createdOn; // not going to change so it's final
    
    private Person assignedTo;
    private final Person createdBy; // not going to change so it's final
    
    public Subtask(){
        name="empty";
        descrip="empty";
        stat=Status.NOT_STARTED;
        
        dueDate=super.mainDueDate;
        createdOn=LocalDate.now();
        
        
        assignedTo=null;
        createdBy=null;
    }
    
    /**
     * @param n String name of subtask
     * @param d String description of subtask
     * @param c Color input
     * @param due LocalDateTime of due date
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that made this task
     */
    public Subtask(String n, String d, Color c, LocalDate due, Person assigned, Person creator){
        name = n;
        descrip=d;
        stat=Status.NOT_STARTED;
        
        dueDate=due;
        createdOn=LocalDate.now();
        
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
    @Override
    public boolean equals(Object o){
        if(this == o){
            return(true);
        }
        if(o instanceof Task){
            Subtask t = (Subtask) o;
            if(t.getName().equals(this.getName())){
                if(t.getDueDate().equals(this.getDueDate())){
                    if(t.assignment().equals(this.assignedTo)){
                        return(true);
                    }
                }
            }
        }
        return(false);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.stat);
        hash = 37 * hash + Objects.hashCode(this.assignedTo);
        hash = 37 * hash + Objects.hashCode(this.createdBy);
        return hash;
    }
}
