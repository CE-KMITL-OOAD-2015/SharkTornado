package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class ReportModel {
    private static ReportModel reportModel = new ReportModel();
    private ReportRepository repo;

    private ReportModel() {
    }

    public static ReportModel getInstance() {
        return reportModel;
    }

    protected void setRepo(ReportRepository repo) {
        this.repo = repo;
    }
}
