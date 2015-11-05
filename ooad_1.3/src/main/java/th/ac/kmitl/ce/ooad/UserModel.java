package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class UserModel {

    private static UserModel user_controller = new UserModel();
    private UserRepository repo;
    private UserModel(){
    }

    public static UserModel getInstance(){
        return user_controller;
    }

    protected void setRepo(UserRepository repo){
        this.repo = repo;
    }

    protected boolean addUser(String username, String password, String name, String email, String imgLoc){
        Profile profile = new Profile(email, name, imgLoc, password);
        Account account = new Account(profile, username, password);
        if(repo.findByUsername(username) == null){
            repo.save(account);
            return true;
        }
        else {
            System.out.println("Deplicated user");
            return false;
        }
    }

    protected boolean isExist(String username){
        if(repo.findByUsername(username) != null) return true;
        return false;
    }

    protected boolean authenUser(String username, String password){
        if(isExist(username)){
            String tmp_pwd = repo.findByUsername(username).getPassword();
            if(password.equals(tmp_pwd)) return true;
            else return false;
        }
        else {
            System.out.println("Failed to login as " + username);
            return false;
        }
    }

    protected boolean updatePwd(String username, String password, String newpassword){
        if(authenUser(username, password)) {
            Account temp = repo.findByUsername(username);
            System.out.println(temp.toString());
            temp.setPassword(newpassword);
            System.out.println(temp.toString());
            repo.save(temp);
            return true;
        }
        else {
            System.out.println("Authen failed. username " + username + " password " + password);
            return false;
        }
    }


    protected boolean updateName(String username, String newName){
        if(isExist(username)) {
            Account temp = repo.findByUsername(username);
            Profile pro_temp = temp.getProfile();
            pro_temp.setName(newName);
            temp.setProfile(pro_temp);
            repo.save(temp);
            return true;
        }
        else {
            System.out.println("User " + username + "doesn't exist.");
            return false;
        }

    }

    private String getUserById(String userId){
        return repo.findByUserId(userId).getUsername();
    }

    protected Account getAccountById(String userId){
        return repo.findByUserId(userId);
    }

    protected Account getAccountByUsername(String username){
        return repo.findByUsername(username);
    }

    protected boolean addCloudAccount(String userId, String password, int cloudProv, String cloudUsername, String cloudPassword) {
        if (authenUser(getUserById(userId), password)) {
            CloudProvider cloudProvider = CloudProvider.toEnum(cloudProv);
            CloudAccount temp = new CloudAccount(cloudProvider, cloudUsername, cloudPassword);
            System.out.println(temp.toString());
            Account account_tmp = repo.findByUserId(userId);
            account_tmp.addCloudAccount(temp);
            System.out.println(account_tmp.toString());
            System.out.println(getUserById(userId));
            repo.save(account_tmp);
            return true;
        }
        else {
            System.out.println("Authen failed.");
            return false;
        }
    }

    protected boolean removeCloudAccount(String userId, String password, int cloudProv, String cloudUsername) {
        if (authenUser(getUserById(userId), password)) {
            CloudProvider cloudProvider = CloudProvider.toEnum(cloudProv);
            Account account_temp = repo.findByUserId(userId);
            return account_temp.removeCloudAccount(CloudProvider.toEnum(cloudProv), cloudUsername);
        }
        else {
            System.out.println("Authen failed.");
            return false;
        }
    }

    protected boolean updateEmail(String userId, String password, String newemail) {
        if (authenUser(getUserById(userId), password)){
            Account account_temp = repo.findByUserId(userId);
            Profile profile = account_temp.getProfile();
            profile.setEmail(newemail);
           // account_temp.setUsername(newemail); //Comment this if don't want system to change username to new email address.
            account_temp.setProfile(profile);
            repo.save(account_temp);
            return true;
        }
        else {
            System.out.println("Failed to update email for " + getUserById(userId));
            return false;
        }
    }

}
