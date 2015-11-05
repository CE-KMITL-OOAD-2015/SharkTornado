package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class BillModel {
    private static BillModel billModel = new BillModel();
    //private BillRepository repo;
    private BillModel() {
    }

//    public void setRepo(BillRepository repo){
//        this.repo = repo;
//    }

    public static BillModel getInstance(){
        return billModel;
    }

    protected Bill getBill(Account user){
        //Bill bill = repo.findByUserId(user.getUserId());
        return new Bill();
    }

}
