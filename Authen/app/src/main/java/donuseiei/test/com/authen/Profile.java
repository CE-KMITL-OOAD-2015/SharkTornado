package donuseiei.test.com.authen;

/**
 * Created by Surasorn on 11/17/2015.
 */
public class Profile {
    private String name;
    private String email;

    public Profile(){}

    public Profile(String username,String email){
        this.name = username;
        this.email = email;
    }

    public String getUsername(){return name;}
    public void setUsername(){this.name = name;}
    public String getEmail(){return email;}
    public void setEmail(){this.email = email;}
}
