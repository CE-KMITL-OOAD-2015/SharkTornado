package th.ac.kmitl.ce.ooad;

import org.springframework.web.bind.annotation.*;
/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class MainController {

    @RequestMapping(value = "/addUser/{username}/{name}", params = {"email", "password", "imgLocation"})
    @ResponseBody
    public boolean addUser(@PathVariable String username,@RequestParam("password") String passphrase,
                           @PathVariable String name, @RequestParam("email") String email, @RequestParam("imgLocation") String imgLoc){
        System.out.println("Add " + username);
        String tmp = UserModel.getInstance().addUser(username, passphrase, name, email, imgLoc);
        if(tmp != null)System.out.println("Add " + username + " successfully.");
        else System.out.println("Add " + username + " not successfully.");
        return tmp != null;
    }

    @RequestMapping(value = "/login/{username}", params = "password")
    @ResponseBody
    public boolean loginUser(@PathVariable String username, @RequestParam("password") String passphrase){
        return UserModel.getInstance().authenUser(username, passphrase);
    }

    @RequestMapping(value = "/login/{username}")
    @ResponseBody
    public boolean isUser(@PathVariable String username){
        return UserModel.getInstance().isExist(username);
    }

    @RequestMapping(value = "/update/name/{username}", params = {"name", "password"})
    public boolean updateName(@PathVariable String username, @RequestParam("name") String name, @RequestParam("password") String pwd){
        if(UserModel.getInstance().authenUser(username, pwd)){
            UserModel.getInstance().updateName(username, name);
        }
        return false;
    }

    @RequestMapping(value = "/update/password/{username}", params = {"password", "newpassword"})
    @ResponseBody
    public boolean updatePwd(@PathVariable String username, @RequestParam("password") String pwd, @RequestParam("newpassword") String passphrase){
        if(UserModel.getInstance().authenUser(username, pwd)){
            UserModel.getInstance().updatePwd(username, passphrase);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/plan/{userId}", params = {"password"})
    @ResponseBody
    public Plan[] requestUserPlan(@PathVariable String userId, @RequestParam("password") String password){
        return PlanModel.getInstance().getPlan(UserModel.getInstance().getAccountById(userId));
    }

    @RequestMapping(value = "/plan/{userId}/{cloud}", params = {"password"})
    @ResponseBody
    public Plan[] requestCloudPlan(@PathVariable String userId, @RequestParam("password") String password, @PathVariable String cloud){
        return PlanModel.getInstance().getAllPlan(UserModel.getInstance().getAccountById(userId), cloud);
    }

    @RequestMapping(value = "/update/plan/{userId}/{cloud}", params = {"password", "ip", "plan"})
    @ResponseBody
    public boolean updatePlan(@PathVariable String userId, @PathVariable String cloud, @RequestParam ("password") String password, @RequestParam("ip") String ip, @RequestParam("plan") int plan){
        return PlanModel.getInstance().updatePlan(UserModel.getInstance().getAccountById(userId), cloud, plan);
    }

}
