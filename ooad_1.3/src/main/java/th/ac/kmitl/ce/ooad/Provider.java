package th.ac.kmitl.ce.ooad;

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
