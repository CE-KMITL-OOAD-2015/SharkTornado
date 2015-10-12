package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */

import java.util.UUID;
public class UserRepository {
    public UserRepository(){

    }

    public String addUser(Account newAccount){
        String userId = UUID.randomUUID().toString();

        return userId;
    }

    public void updatePasswd(String userId, String passphrase){

    }

    public void updateEmail(String userId, String email){

    }

    public void updateProImage(String userId, String imgLoc){

    }

    public void updateName(String userId, String name){

    }

    public String getUserIdByEmail(String email){
        return "username";
    }
}
