package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/14/2015.
 */
public interface Provider {
    public Cloud[] getClouds(Account user);
    public Plan[] getPlanByUser(Account user);
    public Plan[] getPlanByCloudProv(Account user, String cloudProv);
    public void changePlan(Account user, Plan newPlan);
}
