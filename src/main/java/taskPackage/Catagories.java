package taskPackage;

import java.util.Objects;

public class Catagories extends Object{
    private String cata;
    public Catagories(){
        cata="empty";
    }
    public Catagories(String s){
        if(s.isBlank() || s.isEmpty()){
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
    @Override
    public boolean equals(Object o){
        if(o ==this){
            return(true);
        }
        else if(!(o instanceof Catagories)){
            return(false);
        }
        else{
            Catagories t = (Catagories) o;
            return (t.toString().toLowerCase().equals(this.toString().toLowerCase()));
        }
    }
    //generated
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cata);
        return hash;
    }
}
