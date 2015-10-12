package th.ac.kmitl.ce.ooad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class MainController {
    private static final int CHANGE_PASSWORD = 0;
    private static final int CHANGE_USERNAME = 1;
    private static final int CHANGE_NAME = 2;
    private static final int CHANGE_EMAIL = 3;

    public boolean addUser(String username, String passpharse, String name, String email, String imgLoc){
        UserController.getInstance().addUser(username, passpharse, name, email, imgLoc);
        return false;
    }

    public boolean loginUser(){
        return false;
    }

    public boolean changeUser(int command){
        return false;
    }

}
