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
}
