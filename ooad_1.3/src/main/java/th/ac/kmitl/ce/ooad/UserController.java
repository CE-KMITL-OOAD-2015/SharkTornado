package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class UserController {
    private static UserController user_controller = new UserController();
    private static UserRepository userRepository;
    private UserController(){
        userRepository = new UserRepository();
    }

    public static UserController getInstance(){
        return user_controller;
    }

    protected static String addUser(String username, String passphrase, String name, String email, String imgLoc){
        Profile profile = new Profile(email, name, imgLoc);
        Account account = new Account(profile, username, passphrase, "null");
        return userRepository.addUser(account);
    }

    protected static boolean isExist(String username){
        return userRepository.isExist(username);
    }

    protected static boolean authenUser(String usrname, String passphrase){
        if(isExist(usrname)){
            String tmp_pwd = userRepository.getUserPass(usrname);
            if(passphrase.equals(tmp_pwd)) return true;
        }
        return false;
    }

    protected static boolean updatePwd(String usrname, String passphrase){
        if(isExist(usrname)) {
            userRepository.updatePasswd(userRepository.getUserById(usrname), passphrase);
            return true;
        }
        return false;
    }

    protected static boolean updateName(String usrname, String newName){
        if(isExist(usrname)){
            userRepository.updateName(userRepository.getUserById(usrname), newName);
            return true;
        }
        return false;
    }

    private static String getUserById(String username){
        return userRepository.getUserById(username);
    }
}
