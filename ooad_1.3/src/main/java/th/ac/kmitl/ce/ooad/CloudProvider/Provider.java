package th.ac.kmitl.ce.ooad.CloudProvider;

import th.ac.kmitl.ce.ooad.Dashboard.Cloud;
import th.ac.kmitl.ce.ooad.Plan.Plan;
import th.ac.kmitl.ce.ooad.User.Account;
import th.ac.kmitl.ce.ooad.User.CloudAccount;

/**
 * Created by Nut on 10/14/2015.
 */
public interface Provider {
    public Cloud[] getClouds(Account user);
//    public Plan[] getPlanByUser(Account user);
    public Plan[] getPlanByCloudAccount(CloudAccount cloudAccount);
    public Plan[] getPlanByCloudProv(CloudProvider provider);
    public void changePlan(Account user, Plan newPlan);
}
