package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/24/2015.
 */
public class ReportModel {
    private static ReportModel reportModel;
    private ReportRepository repo;

    public static ReportModel getInstance() {
        return reportModel;
    }

    public void setRepo(ReportRepository repo) {
        this.repo = repo;
    }
}
