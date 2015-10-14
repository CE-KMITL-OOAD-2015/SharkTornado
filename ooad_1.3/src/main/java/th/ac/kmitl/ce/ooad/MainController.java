package th.ac.kmitl.ce.ooad;

import org.springframework.web.bind.annotation.*;
/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class MainController {

    @RequestMapping(value = "/addUser/{username}/{name}", params = {"e", "p", "i"})
    @ResponseBody
    public boolean addUser(@PathVariable String username,@RequestParam("p") String passphrase,
                           @PathVariable String name, @RequestParam("e") String email, @RequestParam("i") String imgLoc){
        System.out.println("Add " + username);
        String tmp = UserModel.getInstance().addUser(username, passphrase, name, email, imgLoc);
        if(tmp != null)System.out.println("Add " + username + " successfully.");
        else System.out.println("Add " + username + " not successfully.");
        return tmp != null;
    }

    @RequestMapping(value = "/login/{username}", params = "p")
    @ResponseBody
    public boolean loginUser(@PathVariable String username, @RequestParam("p") String passphrase){
        return UserModel.getInstance().authenUser(username, passphrase);
    }

    @RequestMapping(value = "/login/{username}")
    @ResponseBody
    public boolean isUser(@PathVariable String username){
        return UserModel.getInstance().isExist(username);
    }

    @RequestMapping(value = "/update/name/{usrname}", params = {"name", "pwd"})
    public boolean updateName(@PathVariable String usrname, @RequestParam("name") String name, @RequestParam("pwd") String pwd){
        if(UserModel.authenUser(usrname, pwd)){
            UserModel.getInstance().updateName(usrname, name);
        }
        return false;
    }

    @RequestMapping(value = "/update/pwd/{usrname}", params = {"pwd", "newpwd"})
    @ResponseBody
    public boolean updatePwd(@PathVariable String usrname, @RequestParam("pwd") String pwd, @RequestParam("newpwd") String passphrase){
        if(UserModel.authenUser(usrname, pwd)){
            UserModel.getInstance().updatePwd(usrname, passphrase);
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
        return PlanModel.getInstance().getAllPlan(cloud);
    }

    @RequestMapping(value = "/update/plan/{userId}/{cloud}", params = {"password", "ip", "plan"})
    @ResponseBody
    public boolean updatePlan(@PathVariable String userId, @PathVariable String cloud, @RequestParam ("password") String password, @RequestParam("ip") String ip, @RequestParam("plan") int plan){
        return PlanModel.getInstance().updatePlan(UserModel.getInstance().getAccountById(userId), cloud, plan);
    }

}
