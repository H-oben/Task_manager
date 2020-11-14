package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.Objects;

public class Subtask extends Task{
    private Task upper; //for easy traversal 
    public Subtask(){
        super();
        upper = null;
    }
    
    /**
     * @param n String name of subtask
     * @param d String description of subtask
     * @param cat category
     * @param col Color input
     * @param due LocalDateTime of due date
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that made this task
     * @param t parent fo subtask
     */
    public Subtask(String n, String d,Categories cat, Color col,
            LocalDate due, Person assigned, Person creator, Task t){
        super(n,d,cat,col,due,assigned,creator);
        upper = t;
    }

    /**
     * @return returns parent task/subtask
     */
    public Task getParent(){
        return(upper);
    }
    public void setParent(Task t){
        upper=t;
    }
 
    @Override
    public boolean equals(Object o){
        if(this == o){
            return(true);
        }
        if(o instanceof Subtask){
            Subtask t = (Subtask) o;
            if(t.getName().equals(this.getName()) && t.getCategory().equals(this.getCategory())){
                if(t.getDueDate().equals(this.getDueDate()) && t.getStatus()==this.getStatus()){
                    if(t.assignment().equals(this.assignedTo) && this.getParent()==t.getParent()){
                        if(t.getColor().equals(this.getColor()) && this.describe().equals(t.describe())){
                            return(true);
                        }
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
