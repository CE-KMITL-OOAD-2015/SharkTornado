package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nut on 10/12/2015.
 */
public class Account {
    private Profile profile;
    private String username, passphrase, userId;
<<<<<<< HEAD
    private List<Cloud> clouds;
=======
    private List<CloudAccount> clouds;
>>>>>>> winut's

    public Account() {
    }

    public Account(Profile profile, String username, String passphrase, String userId) {
        this.profile = profile;
        this.username = username;
        this.passphrase = passphrase;
        this.clouds = new ArrayList<>();
        this.userId = userId;
    }

    public Profile getProfile() {
        return profile;

    }

<<<<<<< HEAD
    public List<Cloud> getClouds() {
        return clouds;
    }

    public void addCloud(Cloud cloud){
=======
    public List<CloudAccount> getClouds() {
        return clouds;
    }

    public void addCloud(CloudAccount cloud){
>>>>>>> winut's
        clouds.add(cloud);
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

    @Override
    public String toString(){
        return String.format("Account[userId=%s, username=%s] Profile[%s]", userId, username, profile.toString());
    }
}
