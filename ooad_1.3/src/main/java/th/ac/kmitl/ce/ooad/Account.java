package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/12/2015.
 */
public class Account {
    Profile profile;
    String username, passphrase, userId;

    public Account(Profile profile, String username, String passphrase, String userId) {
        this.profile = profile;
        this.username = username;
        this.passphrase = passphrase;

        this.userId = userId;
    }

    public Profile getProfile() {
        return profile;

    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
