package taskPackage;

import java.time.LocalDate;
import peoplePack.Person;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import peoplePack.Manager;
import peoplePack.member;

/**
 * @author Hunter Obendorfer
 */
public class Task {
    //<editor-fold desc="variables" defaultstate="collapsed">
    protected String name;
    protected String descrip;
    protected Status stat;
    protected Color color;
    protected Categories cat;
    protected boolean onTime;
    
    /**
     * Structure of subtasks where every subtask can have a subset of subtasks
     */
    private ArrayList<Subtask> subs = new ArrayList<>();
    
    protected LocalDate mainDueDate;
    protected final LocalDate createdOn; // not going to change so it's final
    protected LocalDate completedOn;
    
    protected Person assignedTo;
    protected final Person createdBy; // not going to change so it's final
    
    private final RecurType type = RecurType.NEVER;
    //</editor-fold>
    
    //default Constr.
    public Task(){
        name="empty";
        descrip="empty";
        cat=new Categories();
        stat=Status.NOT_STARTED;
        color = Color.RED; //default is due on same day
        onTime=true;
        
        subs=new ArrayList<>();
        
        mainDueDate=LocalDate.now();
        createdOn=LocalDate.now();
        
        assignedTo=new member(); //avoids null reference in testing
        createdBy=new Manager();
    }
    
    /**
     * @param n String name of task, mutable
     * @param d String describing task,mutable
     * @param c category 
     * @param co Color input
     * @param ld LocalDate of the due date, mutable
     * @param assigned Person class to assign this task to, mutable
     * @param creator Person class that assigned this task, this is immutable so be careful
     * 
     */
    public Task(String n, String d, Categories c,Color co, LocalDate ld, Person assigned, Person creator){
        name = n;
        cat=c;
        if(d.isBlank() || d.isEmpty()){
            descrip="empty";
        }
        else{
            descrip = d;
        }
        stat=Status.NOT_STARTED;
        onTime=true;
        
        subs=new ArrayList<>();
        
        mainDueDate=ld;
        createdOn=LocalDate.now();
        color = co;
        
        assignedTo = assigned;
        createdBy = creator;
    }
    public void addSubtask(Subtask s){
        subs.add(s);
        s.setParent(this);
    }
    
    //setters
    public void setName(String n){
        name=n;
    }
    public void setDescription(String d){
        descrip=d;
    }
    public void setStatus(Status s){
        if(s==Status.COMPLETE){
            completedOn=LocalDate.now();
        }
        stat=s;
    }
    public void setOnTime(boolean b){
        onTime=b;
    }
    public void setCatagory(Categories c){
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
     */
    public Subtask getTask(int index){
        if(subs.size()<index){
            throw(new IndexOutOfBoundsException());
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
    public LocalDate completedOn(){
        return(completedOn);
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
    public Categories getCategory(){
        return(cat);
    }
    public ArrayList<Subtask> getSubtasks(){
        return subs;
    }
    public boolean contains(Subtask s){
        for(Subtask a : subs){
            if(a.equals(s)){
                return(true);
            }
        }
        return(false);
    }
    public boolean hasDescendants(){
        return(subs.size()>0);
    }
    public boolean isOnTime(){
        return(onTime);
    }
    public RecurType getType(){
        return (type);
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
                        if(this.creator().equals(t.creator())){
                            if(t.getNumberOfSubTasks()==this.getNumberOfSubTasks() && this.describe().equals(t.describe())){
                                if(t.getStatus()==this.getStatus() && t.getColor()==this.getColor()){
                                    for(int x = 0; x<t.getNumberOfSubTasks();x++){
                                        if(!t.getTask(x).equals(t.getTask(x))){
                                            return(false);
                                        }
                                    }
                                    return(true);
                                }
                            }
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
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.mainDueDate);
        hash = 53 * hash + Objects.hashCode(this.assignedTo);
        hash = 53 * hash + Objects.hashCode(this.createdBy);
        return hash;
    }
}
