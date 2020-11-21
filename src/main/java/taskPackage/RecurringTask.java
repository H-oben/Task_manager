package taskPackage;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import peoplePack.Person;

public class RecurringTask extends Task{
    
    private final RecurType type;
    
    public RecurringTask(){
        super();
        type=RecurType.DAILY;
    }
    
    public RecurringTask(String n, String d, Categories c,Color co, LocalDate ld,
            Person assigned, Person creator, RecurType r){
        super(n,d,c,co,ld,assigned,creator);
        type=r;
    }
    
    public RecurType getType(){
        return(type);
    }
    public void complete(){ //assuming all logic to determine complete implemented before calling
        switch(type){
            case DAILY:
                super.mainDueDate=super.mainDueDate.plusDays(1); //if late, assume caught up until tomorrow
                completeSubs(RecurType.DAILY);
                break;
            case WEEKLY:
                super.mainDueDate=super.mainDueDate.plusWeeks(1);
                completeSubs(RecurType.WEEKLY);
                break;
            case MONTHLY:
                super.mainDueDate=super.mainDueDate.plusMonths(1); //handles unequal number of days in months
                completeSubs(RecurType.MONTHLY);
                break;
            case YEARLY:
                super.mainDueDate=super.mainDueDate.plusYears(1); //handles leap years
                completeSubs(RecurType.YEARLY);
                break;
            default: //unreachable
                break;
        }
        super.setStatus(Status.NOT_STARTED);//never really completed
    }
    private void completeSubs(RecurType r){
        ArrayList<Subtask> subs = this.getSubtasks();
        switch(r){
            case DAILY:
                for(Subtask s : subs){
                    s.setStatus(Status.NOT_STARTED);
                    s.getDueDate().plusDays(1);
                }
                break;
            case WEEKLY:
                for(Subtask s : subs){
                    s.setStatus(Status.NOT_STARTED);
                    s.getDueDate().plusWeeks(1);
                }
                break;
            case MONTHLY:
                for(Subtask s : subs){
                    s.setStatus(Status.NOT_STARTED);
                    s.getDueDate().plusMonths(1);
                }
                break;
            default:
                for(Subtask s : subs){
                    s.setStatus(Status.NOT_STARTED);
                    s.getDueDate().plusYears(1);
                }
                break;
        }
    }
    public void deleteTask(){ //finishes Task and "deletes"
        super.setStatus(Status.COMPLETE);
    }
}
