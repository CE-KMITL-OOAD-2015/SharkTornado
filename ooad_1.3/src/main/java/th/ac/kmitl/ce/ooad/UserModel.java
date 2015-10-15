package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class UserModel {

    private static UserModel user_controller = new UserModel();
    private AccountRepository accountRepository;
    private UserModel(){
    }

    public static UserModel getInstance(){
        return user_controller;
    }

    protected void setAccountRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    protected boolean addUser(String username, String password, String name, String email, String imgLoc){
        Profile profile = new Profile(email, name, imgLoc);
        Account account = new Account(profile, username, password);
        accountRepository.save(account);
        return true;
    }

    protected boolean isExist(String username){
        if(accountRepository.findByUsername(username) != null) return true;
        return false;
    }

    protected boolean authenUser(String username, String password){
        if(isExist(username)){
            String tmp_pwd = accountRepository.findByUsername(username).getPassword();
            if(password.equals(tmp_pwd)) return true;
        }
        return false;
    }

    protected boolean updatePwd(String username, String password, String newpassword){
        if(authenUser(username, password)) {
            Account temp = accountRepository.findByUsername(username);
            System.out.println(temp.toString());
            temp.setPassword(newpassword);
            System.out.println(temp.toString());
            accountRepository.save(temp);
            return true;
        }
        else {
            System.out.println("Authen failed. username " + username + " password " + password);
            return false;
        }
    }


    protected boolean updateName(String username, String newName){
        if(isExist(username)) {
            Account temp = accountRepository.findByUsername(username);
            Profile pro_temp = temp.getProfile();
            pro_temp.setName(newName);
            temp.setProfile(pro_temp);
            accountRepository.save(temp);
            return true;
        }
        return false;
    }

    private String getUserById(String userId){
        return accountRepository.findByUserId(userId).getUsername();
    }

    protected Account getAccountById(String userId){
        return accountRepository.findByUserId(userId);
    }

    protected boolean addCloudAccount(String userId, String password, int cloudProv, String cloudUsername, String cloudPassword) {

        if (authenUser(getUserById(userId), password)) {
            CloudProvider cloudProvider;
            switch (cloudProv) {
                case 0:
                    cloudProvider = CloudProvider.GOOGLE;
                    break;
                case 1:
                    cloudProvider = CloudProvider.AMAZON;
                    break;
                case 2:
                    cloudProvider = CloudProvider.AZURE;
                    break;
                case 3:
                    cloudProvider = CloudProvider.DIGITAL_OCEAN;
                    break;
                case 4:
                    cloudProvider = CloudProvider.VMWARE;
                    break;
                default:
                    cloudProvider = CloudProvider.UNKNOWN;
                    break;
            }
            CloudAccount temp = new CloudAccount(cloudProvider, cloudUsername, cloudPassword);
            System.out.println(temp.toString());
            Account account_tmp = accountRepository.findByUserId(userId);
            account_tmp.addCloud(temp);
            System.out.println(account_tmp.toString());
            System.out.println(getUserById(userId));
            accountRepository.save(account_tmp);
            return true;
        } else {
            System.out.println("Authen failed.");
            return false;
        }
    }
}
