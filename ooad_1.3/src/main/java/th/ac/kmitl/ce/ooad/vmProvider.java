package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/14/2015.
 */
public class vmProvider implements Provider {

    private static vmProvider vmprovider = new vmProvider();
<<<<<<< HEAD
=======

>>>>>>> winut's
    private vmProvider(){
    }

    public static vmProvider getInstance(){
        return vmprovider;
    }

    @Override
    public Cloud[] getClouds(Account user) {
        return new Cloud[0];
    }

    @Override
    public Plan[] getPlanByUser(Account user) {
<<<<<<< HEAD
        return new Plan[0];
=======
        return getPlanByCloudAccount(user.getClouds().get(0));
    }

    public Plan[] getPlanByCloudAccount(CloudAccount account) {
        Plan[] plans = new Plan[1];

        switch (account.getCloudProv()) {
            case GOOGLE:
                plans[0] = new Plan(CloudProvider.GOOGLE, (float)15.6, (float)2.4, (float)1.7, (float)300, 500);

                break;

            case AMAZON:
                plans[0] = new Plan(CloudProvider.AMAZON, (float)15.9, (float)2.4, (float)1.7, (float)300, 1000);
                break;

            case DIGITAL_OCEAN:
                plans[0] = new Plan(CloudProvider.DIGITAL_OCEAN, (float)99.9, (float)2.4, (float)1.7, (float)300, 500);

                break;

            case AZURE:
                plans[0] = new Plan(CloudProvider.AZURE, (float)15.6, (float)3, (float)1.7, (float)300, 500);

                break;

            case VMWARE:
                plans[0] = new Plan(CloudProvider.VMWARE, (float)9.9, (float)2.4, (float)1.7, (float)300, 500);

                break;

            default:
                plans[0] = new Plan(CloudProvider.UNKNOWN, (float)15.6, (float)2.4, (float)1.7, (float)300, 500);
        }

        return plans;
>>>>>>> winut's
    }

    @Override
    public Plan[] getPlanByCloudProv(Account user, String cloudProv) {
        return new Plan[0];
    }

    @Override
    public void changePlan(Account user, Plan newPlan) {

    }
}
