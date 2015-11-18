package th.ac.kmitl.ce.ooad;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * Created by Nut on 10/14/2015.
 */
public class vmProvider implements Provider {

    private static vmProvider vmprovider = new vmProvider();
    private static MongoClient mongoClient = new MongoClient();
    private static MongoDatabase db = mongoClient.getDatabase("cloud_proxy");

    private ArrayList<Plan> plans;

    private vmProvider() {
    }

    public static vmProvider getInstance(){
        return vmprovider;
    }

    @Override
    public List<Cloud> getClouds(Account user) {
        List<Cloud> clouds = new ArrayList<>();

        FindIterable<Document> iterable = db.getCollection("clouds").find(
                new Document("username", user.getUsername()).append("password", user.getPassword())
        );

        iterable.forEach((Block<Document>) document -> {
            try {
                JSONObject obj = new JSONObject(document.toJson());

                clouds.add(toCloud(obj));
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            System.out.println(document);
        });

        return clouds;
    }

//    @Override
//    public Plan[] getPlanByUser(Account user) {
//        return getPlanByCloudAccount(user.getCloudAccounts().get(0));
//    }

    @Override
    public Plan[] getPlanByCloudProv(CloudProvider provider) {
        List<Plan> plans = new ArrayList<>();

        switch (provider) {
            case GOOGLE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "GOOGLE")
                );

                iterable.forEach((Block<Document>) document -> {
                    try {
                        JSONObject obj = new JSONObject(document.toJson());

                        plans.add(toPlan(obj));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(document);
                });

                break;
            }
            case AMAZON: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "AMAZON")
                );

                iterable.forEach((Block<Document>) document -> {
                    try {
                        JSONObject obj = new JSONObject(document.toJson());

                        plans.add(toPlan(obj));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(document);
                });

                break;
            }
            case DIGITAL_OCEAN: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "DIGITAL_OCEAN")
                );

                iterable.forEach((Block<Document>) document -> {
                    try {
                        JSONObject obj = new JSONObject(document.toJson());

                        plans.add(toPlan(obj));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(document);
                });

                break;
            }
            case AZURE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "AZURE")
                );

                iterable.forEach((Block<Document>) document -> {
                    try {
                        JSONObject obj = new JSONObject(document.toJson());

                        plans.add(toPlan(obj));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(document);
                });

                break;
            }
            case VMWARE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "VMWARE")
                );

                iterable.forEach((Block<Document>) document -> {
                    try {
                        JSONObject obj = new JSONObject(document.toJson());

                        plans.add(toPlan(obj));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(document);
                });

                break;
            }
            default:
                break;
        }

        Plan[] array = new Plan[plans.size()];
        array = plans.toArray(array);

        return array;
    }

    @Override
    public List<Plan> getPlanByCloudAccount(Account user, String cloudProv) {
        List<Plan> plans = new ArrayList<>();

        FindIterable<Document> iterable = db.getCollection("clouds").find(
                new Document("username", user.getUsername())
                        .append("password", user.getPassword())
                        .append("provider", cloudProv)
        );

        iterable.forEach((Block<Document>) document -> {
            try {
                JSONObject obj = new JSONObject(document.toJson());
                JSONArray list = obj.getJSONArray("vms");

                for (int count = 0; count < list.length(); count++) {
//                    System.out.println(list.get(count));
                    JSONObject vm = getJsonVm(new ObjectId(list.getJSONObject(count).getString("$oid")));
//                    System.out.println(vm.toString());
                    JSONObject plan = getJsonPlan(new ObjectId(vm.getJSONObject("plan").getString("$oid")));

                    plans.add(toPlan(plan));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        return plans;
    }

    @Override
    public void changePlan(Account user, int newPlan, CloudProvider cloudProvider, String ip) {
        final ObjectId[] newId = new ObjectId[1];

        switch (cloudProvider) {
            case GOOGLE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "GOOGLE").append("planNum", newPlan)
                );

                iterable.forEach((Block<Document>) document -> {
                    newId[0] = document.getObjectId("_id");
                });
            }
            case AMAZON: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "AMAZON").append("planNum", newPlan)
                );

                iterable.forEach((Block<Document>) document -> {
                    newId[0] = document.getObjectId("_id");
                });
            }
            case DIGITAL_OCEAN: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "DIGITAL_OCEAN").append("planNum", newPlan)
                );

                iterable.forEach((Block<Document>) document -> {
                    newId[0] = document.getObjectId("_id");
                });
            }
            case AZURE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "AZURE").append("planNum", newPlan)
                );

                iterable.forEach((Block<Document>) document -> {
                    newId[0] = document.getObjectId("_id");
                });
            }
            case VMWARE: {
                FindIterable<Document> iterable = db.getCollection("plans").find(
                        new Document("provider", "VMWARE").append("planNum", newPlan)
                );

                iterable.forEach((Block<Document>) document -> {
                    newId[0] = document.getObjectId("_id");
                });
            }
            default: {

            }
        }

        db.getCollection("vms").updateOne(
                new Document("ip", ip), new Document("$set", new Document("plan", newId[0]))
        );
    }

    @Override
    public Cloud getCloudStatus(CloudAccount cloudAccount) {
        return new Cloud(cloudAccount.toString(), null);
    }

    @Override
    public Vm getVmStatus(CloudAccount cloudAccount, String vmIP){
        final Vm[] vm = new Vm[1];

        FindIterable<Document> iterable = db.getCollection("vms").find(
                new Document("ip", vmIP)
        );

        iterable.forEach((Block<Document>) document -> {
            try {
                JSONObject obj = new JSONObject(document.toJson());
                vm[0] = toVm(obj, getJsonPlan(document.getObjectId("plan")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        return vm[0];
    }

    @Override
    public Plan getPlanByVM(CloudAccount cloudAccount, String vmIP) {
        final Plan[] plan = new Plan[1];

        FindIterable<Document> iterable = db.getCollection("vms").find(
                new Document("ip", vmIP)
        );

        iterable.forEach((Block<Document>) document -> {
            FindIterable<Document> it = db.getCollection("plans").find(
                    new Document("_id", document.getObjectId("plan"))
            );

            it.forEach((Block<Document>) doc -> {
                try {
                    plan[0] = toPlan(new JSONObject(doc.toJson()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
        });

        return plan[0];
    }

    @Override
    public double getPrice(Plan plan) {
        if(plan != null) return plan.monthlyRate;
        else return 0.0;
    }

    @Override
    public Report getVmReport(String vmIP, Date date) {
        Report report = new Report("0.0.0.0");
        return report;
    }

    private JSONObject getJsonVm(ObjectId id) {
        JSONObject[] obj = {null};

        FindIterable<Document> iterable = db.getCollection("vms").find(
                new Document("_id", id)
        );

        iterable.forEach((Block<Document>) document -> {
            try {
                obj[0] = new JSONObject(document.toJson());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        return obj[0];
    }

    private JSONObject getJsonPlan(ObjectId id) {
        JSONObject[] obj = {null};

        FindIterable<Document> iterable = db.getCollection("plans").find(
                new Document("_id", id)
        );

        iterable.forEach((Block<Document>) document -> {
            try {
                obj[0] = new JSONObject(document.toJson());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });

        return obj[0];
    }
    private Plan toPlan(JSONObject plan) throws JSONException {
        Plan obj;

        switch (plan.getString("provider")) {
            case "GOOGLE":
                obj = new Plan(CloudProvider.GOOGLE, plan.getDouble("monthlyRate"), plan.getDouble("cpu"),
                        plan.getDouble("mem"), plan.getDouble("network"), plan.getInt("storage"), plan.getInt("planNum"));

                break;

            case "AMAZON":
                obj = new Plan(CloudProvider.AMAZON, plan.getDouble("monthlyRate"), plan.getDouble("cpu"),
                        plan.getDouble("mem"), plan.getDouble("network"), plan.getInt("storage"), plan.getInt("planNum"));
                break;

            case "DIGITAL_OCEAN":
                obj = new Plan(CloudProvider.DIGITAL_OCEAN, plan.getDouble("monthlyRate"), plan.getDouble("cpu"),
                        plan.getDouble("mem"), plan.getDouble("network"), plan.getInt("storage"), plan.getInt("planNum"));

                break;

            case "AZURE":
                obj = new Plan(CloudProvider.AZURE, plan.getDouble("monthlyRate"), plan.getDouble("cpu"),
                        plan.getDouble("mem"), plan.getDouble("network"), plan.getInt("storage"), plan.getInt("planNum"));

                break;

            case "VMWARE":
                obj = new Plan(CloudProvider.VMWARE, plan.getDouble("monthlyRate"), plan.getDouble("cpu"),
                        plan.getDouble("mem"), plan.getDouble("network"), plan.getInt("storage"), plan.getInt("planNum"));

                break;

            default:
                obj = new Plan(CloudProvider.UNKNOWN, 0.00, 0.00, 0.00, 0.00, 0, 0);
        }

        return obj;
    }

    private Vm toVm(JSONObject vm, JSONObject plan) throws JSONException {
        return new Vm(vm.getString("ip"), plan.getDouble("cpu"),
                plan.getDouble("mem"), plan.getDouble("network"),
                vm.getDouble("cpu"), vm.getDouble("mem"), vm.getDouble("network"),
                plan.getInt("storage"), vm.getInt("storage"));
    }

    private Cloud toCloud(JSONObject cloud) throws JSONException {
        JSONArray list = cloud.getJSONArray("vms");
        List<Vm> vms = new ArrayList<>();

        for (int count = 0; count < list.length(); count++) {
            JSONObject vm = getJsonVm(new ObjectId(list.getJSONObject(count).getString("$oid")));
            JSONObject plan = getJsonPlan(new ObjectId(vm.getJSONObject("plan").getString("$oid")));

            vms.add(toVm(vm, plan));
        }

        return new Cloud(cloud.getString("provider"), vms);
    }
}
