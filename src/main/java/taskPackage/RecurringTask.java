package taskPackage;

import java.awt.Color;
import java.time.LocalDate;
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
                break;
            case WEEKLY:
                super.mainDueDate=super.mainDueDate.plusWeeks(1);
                break;
            case MONTHLY:
                super.mainDueDate=super.mainDueDate.plusMonths(1); //handles unequal number of days in months
                break;
                
            case YEARLY:
                super.mainDueDate=super.mainDueDate.plusYears(1); //handles leap years
                break;
            default: //unreachable
                break;
        }
        super.setStatus(Status.NOT_STARTED);//never really completed
    }
    public void deleteTask(){ //finishes Task and "deletes"
        super.setStatus(Status.COMPLETE);
    }
}
