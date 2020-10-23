package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
/**
 * @author Hunter Obendorfer
 */
public class Task {
    protected String name;
    protected String descrip;
    protected Status stat;
    protected Color color;
    protected Catagories cat;
    
    /**
     * Structure of subtasks where every subtask can have a subset of subtasks
     */
    private ArrayList<Subtask> subs = new ArrayList<>();
    
    protected LocalDate mainDueDate;
    protected final LocalDate createdOn; // not going to change so it's final
    
    protected Person assignedTo;
    protected final Person createdBy; // not going to change so it's final
    
    //default Constr.
    public Task(){
        name="empty";
        descrip="empty";
        cat=new Catagories();
        stat=Status.NOT_STARTED;
        color = Color.RED; //default is due on same day
        
        subs=new ArrayList<Subtask>();
        
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
        
        subs=new ArrayList<Subtask>();
        
        mainDueDate=ld;
        createdOn=LocalDate.now();
        color = co;
        
        assignedTo = assigned;
        createdBy = creator;
    }
    public void addSubtask(Subtask s){
        subs.add(s);
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
    /**
     * @param index integer index for array list
     * @return returns subtask object
     * @throws AraayIndexOutOfBoundsException if index > subtask list size
     */
    public Subtask getTask(int index){
        if(subs.size()<index){
            throw(new ArrayIndexOutOfBoundsException());
        }
        return(subs.get(index));
    }
    public int getNumberOfSubTasks(){
        return(subs.size());
    }
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
    public ArrayList<Subtask> getSubtasks(){
        return subs;
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
    @Override
    public boolean equals(Object o){
        if(this == o){
            return(true);
        }
        if(o instanceof Task){
            Task t = (Task) o;
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
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.mainDueDate);
        hash = 53 * hash + Objects.hashCode(this.assignedTo);
        hash = 53 * hash + Objects.hashCode(this.createdBy);
        return hash;
    }
}
