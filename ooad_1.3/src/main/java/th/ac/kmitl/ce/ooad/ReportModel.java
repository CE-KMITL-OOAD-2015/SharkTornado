package th.ac.kmitl.ce.ooad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    protected List<Report> getAllVmReports(String vmIP){
        return repo.findByvmIP(vmIP);
    }

    protected List<Report> getAlltoPayReports(String vmIP){
        List<Report> reports = repo.findByvmIP(vmIP);
        List<Report> re_reports = new ArrayList<>();
        for(Report report : reports){
            if(!report.isPaid()) re_reports.add(report);
        }
        return re_reports;
    }

    protected List<Report> getReportByMonth(String vmIP, String startMonth, String endMonth){
        List<Report> reports = repo.findByvmIP(vmIP);
        List<Report> re_reports = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM yyyy");
        Date startDate, endDate;
        try{
            startDate = formatter.parse(startMonth);
            endDate = formatter.parse(endMonth);
        }
        catch (Exception e){
            System.out.println("Method getReportByMonth's inputs error.");
            e.printStackTrace();
            return null;
        }
        for(Report report : reports){
            if(report.getTimestamp().after(startDate) && report.getTimestamp().before(endDate)){
                re_reports.add(report);
            }
        }
        return re_reports;
    }
/*
    protected List<Report> testReport(){
        List<Report> reports = new ArrayList<>();
        reports.add(new Report("1.1.1.1", true));
        reports.add(new Report("2.2.2.2", true));
        reports.add(new Report("1.1.1.1", false));
        List<Report> re_reports = new ArrayList<>();
        for(Report report : reports){
            int i = 0;
            if(!report.isPaid()) re_reports.add(report);
        }
        return re_reports;
    }*/
}
