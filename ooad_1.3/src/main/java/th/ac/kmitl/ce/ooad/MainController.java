package th.ac.kmitl.ce.ooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Nut on 10/4/2015.
 */
@RestController
public class MainController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/addUser/{username}/{name}", params = {"email", "password", "imgLocation"})
    @ResponseBody
    public boolean addUser(@PathVariable String username,@RequestParam("password") String passphrase,
                           @PathVariable String name, @RequestParam("email") String email, @RequestParam("imgLocation") String imgLoc){
        System.out.println("Add " + username);
        try {
            return UserModel.getInstance().addUser(username, passphrase, name, email, imgLoc);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurs");
            return false;
        }
    }

    @RequestMapping("/")
    @ResponseBody
    public void init(){
        UserModel.getInstance().setAccountRepository(accountRepository);
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
        return UserModel.getInstance().updateName(username, name);
    }

    @RequestMapping(value = "/update/password/{username}", params = {"password", "newpassword"})
    @ResponseBody
    public boolean updatePwd(@PathVariable String username, @RequestParam("password") String password, @RequestParam("newpassword") String newpassword){
        return UserModel.getInstance().updatePwd(username, password, newpassword);
    }

    @RequestMapping(value = "/update/email/{userId}", params = {"password", "newemail"})
    @ResponseBody
    public boolean updateEmail(@PathVariable String userId, @RequestParam("password") String password, @RequestParam("newemail") String newemail){
        return UserModel.getInstance().updateEmail(userId, password, newemail);
    }

    @RequestMapping(value = "/update/plan/{userId}", params = {"password", "ip", "plan", "cloudProv"})
    @ResponseBody
    public boolean updatePlan(@PathVariable String userId, @RequestParam("cloudProv") int cloudProv, @RequestParam ("password") String password, @RequestParam("ip") String ip, @RequestParam("plan") int plan){
        return PlanModel.getInstance().updatePlan(UserModel.getInstance().getAccountById(userId), cloudProv, plan);
    }

    @RequestMapping(value = "/plan/{userId}", params = {"password", "cloudProv"})
    @ResponseBody
    public Plan[] requestUserPlan(@PathVariable String userId, @RequestParam("password") String password, @RequestParam("cloudProv") int cloudProv){
        return PlanModel.getInstance().getUserPlanByCloud(UserModel.getInstance().getAccountById(userId), cloudProv);
    }

    @RequestMapping(value = "/plan", params = "cloudProv")
    @ResponseBody
    public Plan[] requestCloudPlan(@RequestParam("cloudProv") int cloudProv){
        return PlanModel.getInstance().getAllProviderPlan(cloudProv);
    }

    @RequestMapping(value = "/plan/removeCloudAccount/{userId}", params = {"password", "cloudProv", "cloudUsername"})
    @ResponseBody
    public boolean removeCloudAccount(@PathVariable String userId, @RequestParam("cloudProv") int cloudProv, @RequestParam("password") String password, @RequestParam("cloudUsername") String cloudUsername){
        return UserModel.getInstance().removeCloudAccount(userId, password, cloudProv, cloudUsername);
    }

    @RequestMapping(value = "/plan/addCloudAccount/{userId}", params = {"cloudProv", "password", "cloudUsername", "cloudPassword"})
    @ResponseBody
    public boolean addCloudAccount(@PathVariable String userId, @RequestParam("password") String password, @RequestParam("cloudUsername") String cloudUsername, @RequestParam("cloudPassword") String cloudPassword, @RequestParam("cloudProv") int cloudProv){
        return UserModel.getInstance().addCloudAccount(userId, password, cloudProv, cloudUsername, cloudPassword);
    }

}
