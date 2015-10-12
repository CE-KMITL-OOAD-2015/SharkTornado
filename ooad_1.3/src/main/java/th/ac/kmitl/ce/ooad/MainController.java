package th.ac.kmitl.ce.ooad;

import org.springframework.web.bind.annotation.*;
/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class MainController {
    private static final int CHANGE_PASSWORD = 0;
    private static final int CHANGE_USERNAME = 1;
    private static final int CHANGE_NAME = 2;
    private static final int CHANGE_EMAIL = 3;

    @RequestMapping(value = "/addUser/{username}/{name}", params = {"e", "p", "i"})
    @ResponseBody
    public boolean addUser(@PathVariable String username,@RequestParam("p") String passphrase,
                           @PathVariable String name, @RequestParam("e") String email, @RequestParam("i") String imgLoc){
        System.out.println("Add " + username);
        String tmp = UserController.getInstance().addUser(username, passphrase, name, email, imgLoc);
        if(tmp == null)System.out.println("Add " + username + " successfully.");
        else System.out.println("Add " + username + " not successfully.");
        return tmp != null;
    }

    @RequestMapping(value = "/login/{username}", params = "p")
    @ResponseBody
    public boolean loginUser(@PathVariable String username, @RequestParam("p") String passphrase){
        return UserController.getInstance().authenUser(username, passphrase);
    }

    @RequestMapping(value = "/login/{username}")
    @ResponseBody
    public boolean isUser(@PathVariable String username){
        return UserController.getInstance().isExist(username);
    }

    public boolean changeUser(int command){
        return false;
    }

}
