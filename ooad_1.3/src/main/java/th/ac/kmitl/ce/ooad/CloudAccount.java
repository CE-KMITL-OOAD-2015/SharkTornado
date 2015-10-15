package th.ac.kmitl.ce.ooad;

import com.mongodb.connection.Cluster;

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

    public String getPassword() {
        return password;
    }

    public CloudProvider getCloudProv() {
        return cloudProv;
    }

    public String getUserName() {
        return userName;
    }
}
