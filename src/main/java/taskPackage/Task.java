package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.ArrayList;
/**
 * @author Hunter Obendorfer
 */
public class Task {
    private String name;
    private String descrip;
    private Status stat;
    private Color color;
    private Catagories cat;
    
    /**
     * Structure of subtasks where every subtask can have a subset of subtasks
     */
    private ArrayList<Subtask> subs = new ArrayList<>();
    
    protected LocalDate mainDueDate;
    private final LocalDate createdOn; // not going to change so it's final
    
    private Person assignedTo;
    private final Person createdBy; // not going to change so it's final
    
    //default Constr.
    public Task(){
        name="empty";
        descrip="empty";
        cat=new Catagories();
        stat=Status.NOT_STARTED;
        color = Color.RED; //default is due on same day
        
        subs=null;
        
        mainDueDate=LocalDate.now();
        createdOn=LocalDate.now();
        
        assignedTo=null;
        createdBy=null;
    }
    
    /**
     * @param n String name of task, mutable
     * @param d String describing task,mutable
     * @param c catagory 
     * @param co Color input
     * @param ld LocalDate of the due date, mutable
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that assigned this task, this is immutable so be careful
     * 
     */
    public Task(String n, String d, Catagories c,Color co, LocalDate ld, Person assigned, Person creator){
        name = n;
        cat=c;
        if(d.isBlank() || d.isEmpty()){
            descrip="empty";
        }
        else{
            descrip = d;
        }
        stat=Status.NOT_STARTED;
        
        subs=null;
        
        mainDueDate=ld;
        createdOn=LocalDate.now();
        color = co;
        
        assignedTo = assigned;
        createdBy = creator;
    }
    //TODO: method to add subtask
    public void addSubtask(Subtask s){
        
    }
    
    //setters
    public void setName(String n){
        name=n;
    }
    public void setDescription(String d){
        descrip=d;
    }
    public void setStatus(Status s){
        stat=s;
    }
    public void setCatagory(Catagories c){
        cat=c;
    }
    /**
     * 
     * @param ld set due date to a LocalDateTime
     * <p>Best practice dictates that the new due date is in the future,
     * not in the past or present.
     * </p>
     */
    public void setDueDate(LocalDate ld){
        mainDueDate = ld;
    }
    /**
     * @param a change assignment to this person
     */
    public void reassign(Person a){
        assignedTo = a;
    }
    public void setColor(Color a){
        color = a;
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
    public LocalDate getDueDate(){
        return(mainDueDate);
    }
    public LocalDate createdOn(){
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
    public Color getColor(){
        return(color);
    }
    public Catagories getCatagory(){
        return(cat);
    }
    
    @Override
    public String toString(){
        return("Task: " + name +"\nDescription: " +descrip+"\n"
                + "Status: " + stat +"\nColor: "+color.toString()
                +"\nCatagory: "+ cat.toString()
                + "\nDue Date: " +mainDueDate.toString() +
                "\nCreated On: " +createdOn.toString()+
                "\nAssigned To: "+ assignedTo.getName()+
                "\nCreated By: "+createdBy.getName());
    }
}
