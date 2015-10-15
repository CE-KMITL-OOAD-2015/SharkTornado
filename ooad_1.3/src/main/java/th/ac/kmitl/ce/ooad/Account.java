package th.ac.kmitl.ce.ooad;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nut on 10/12/2015.
 */
public class Account {
    @Id
    private String userId;

    private Profile profile;
    private String username, password;
    private List<CloudAccount> cloudAccounts;

    public Account() {
    }

    public Account(Profile profile, String username, String password) {
        this.profile = profile;
        this.username = username;
        this.password = password;
        cloudAccounts = new ArrayList<>();
    }

    public Profile getProfile() {
        return profile;

    }

    public CloudAccount getCloudAccounts(CloudProvider cloudProvider) {
        for(CloudAccount temp : cloudAccounts){
            if (temp.getCloudProv() == cloudProvider) return temp;
        }
        return null;
    }

    public void addCloud(CloudAccount cloud){
        cloudAccounts.add(cloud);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserId() {
        return userId;
    }

    public List<CloudAccount> getCloudAccounts() {
        return cloudAccounts;
    }

    public void setCloudAccounts(List<CloudAccount> cloudAccounts) {
        this.cloudAccounts = cloudAccounts;
    }

    @Override
    public String toString(){
        return String.format("Account[userId=%s, username=%s] Profile[%s]", userId, username, profile.toString());
    }
}
