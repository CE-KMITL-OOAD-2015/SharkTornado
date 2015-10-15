package th.ac.kmitl.ce.ooad;

import com.mongodb.connection.Cluster;
import org.springframework.data.annotation.Id;

/**
 * Created by kohpai on 10/15/15.
 */
public class CloudAccount {
    private CloudProvider cloudProv;
    private String userName;
    private String password;

    public CloudAccount(CloudProvider cloudProv, String userName, String password) {
        this.cloudProv = cloudProv;
        this.userName = userName;
        this.password = password;
    }

    public void setCloudProv(CloudProvider cloudProv) {
        this.cloudProv = cloudProv;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CloudAccount() {

    }

    public String getPassword() {
        return password;
    }

    public CloudProvider getCloudProv() {
        return cloudProv;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "CloudProvider: " + cloudProv + "| username " + userName + "| password " + password;
    }
}
