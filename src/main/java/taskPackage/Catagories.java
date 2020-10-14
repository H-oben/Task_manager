package taskPackage;

public class Catagories {
    private String cata;
    public Catagories(){
        cata="empty";
    }
    public Catagories(String s){
        cata=s;
    }
    @Override
    public String toString(){
        return(cata);
    }
}
