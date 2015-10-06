package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/5/2015.
 */
public class Account {
    String name;
    public Account(Account tmp){
        this.name = tmp.getName();
    }

    public String getName(){
        return name;
    }
}
