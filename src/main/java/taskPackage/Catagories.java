package taskPackage;

public class Catagories {
    private String cata;
    public Catagories(){
        cata="empty";
    }
    public Catagories(String s){
        if(s.isBlank() || s.isEmpty() || s==null){
            cata="empty";
        }
        else{
            cata=s;
        }
    }
    @Override
    public String toString(){
        return(cata);
    }
}
