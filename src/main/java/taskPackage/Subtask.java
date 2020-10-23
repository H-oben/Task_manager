package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.Objects;

public class Subtask extends Task{
    
    public Subtask(){
        super();
    }
    
    /**
     * @param n String name of subtask
     * @param d String description of subtask
     * @param cat catagory
     * @param col Color input
     * @param due LocalDateTime of due date
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that made this task
     */
    public Subtask(String n, String d,Catagories cat, Color col, LocalDate due, Person assigned, Person creator){
        super(n,d,cat,col,due,assigned,creator);
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
