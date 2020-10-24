package taskPackage;

import java.util.Objects;

public class Categories extends Object{
    private String cata;
    public Categories(){
        cata="empty";
    }
    public Categories(String s){
        if(s.isBlank() || s.isEmpty()){
            cata="empty";
        }
        else{
            cata=s;
        }
    }
    public void setCategory(String s){
        cata=s;
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
        else if(!(o instanceof Categories)){
            return(false);
        }
        else{
            Categories t = (Categories) o;
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
