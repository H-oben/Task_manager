package peoplePack;

public interface Person{

    /**
     * @param a password to be input
     * @return returns if passwords match
     */
    public boolean testPassword(char[] a);
    public String getName();
    public Role getRole();

    /**
     *
     * @param o object
     * @return 
     */
    @Override
    public boolean equals(Object o);
}
