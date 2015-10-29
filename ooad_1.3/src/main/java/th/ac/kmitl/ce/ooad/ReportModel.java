package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class ReportModel {
    private static ReportModel reportModel = new ReportModel();
    private ReportRepository repo;

    public ReportModel() {
    }

    public static ReportModel getInstance() {
        return reportModel;
    }

    public void setRepo(ReportRepository repo) {
        this.repo = repo;
    }
}
