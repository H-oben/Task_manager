package peoplePack;

/**
 *
 * @author h_obe
 * <p>
 * Exception class that might help later
 * </p>
 */
public class MemberManagerException extends Exception{
    private String code;
    
    public MemberManagerException(String c, String m){
        super(m);
        this.setCode(c);
    }
    
    public MemberManagerException(String c, String m, Throwable cause){
        super(m, cause);
        this.setCode(c);
    }
    
    public String getCode(){
        return(code);
    }
    public void setCode(String c){
        this.code=c;
    }
}
