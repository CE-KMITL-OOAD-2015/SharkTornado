package th.ac.kmitl.ce.ooad;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Nut on 10/24/2015.
 */
public class ReportModel {
    private final int SIZE = 3;
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

/*    protected List<Report> getAlltoPayReports(String vmIP){
        List<Report> reports = repo.findByvmIP(vmIP);
        List<Report> re_reports = new ArrayList<>();
        for(Report report : reports){
            if(!report.isPaid()) re_reports.add(report);
        }
        return re_reports;
    }*/

    protected List<Report> getReportByMonth(String vmIP, String startMonth, String endMonth){
        repo.save(new Report(vmIP));
        List<Report> reports = repo.findByvmIP(vmIP);
        List<Report> re_reports = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        Date startDate, endDate;
        try{
            startDate = formatter.parse("1 " + startMonth);
            endDate = formatter.parse("28 " + endMonth);
        }
        catch (Exception e){
            System.out.println("Method getReportByMonth's inputs error.");
            e.printStackTrace();
            return null;
        }
        if(reports.size() == 0){
            fetchReports(vmIP, startDate);
        }
        for(Report report : reports){
            if(report.getTimestamp().after(startDate) && report.getTimestamp().before(endDate)){
                re_reports.add(report);
            }
        }
        return re_reports;
    }

    private void fetchReports(String vmIP, Date startDate){
        Date today = new Date();
        while(startDate.before(today)){
            putVmReports(vmIP, startDate);
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.MONTH, 1);
            startDate = c.getTime();
        }
    }

    protected void putVmReports(String vmIP, Date date){
        Report new_report = null;
        List<Report> reports = repo.findByvmIP(vmIP);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH");
        //formatter.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
        String[] s_date = formatter.format(date).split(" ");

        List<Double> cpus;
        List<Double> mems;
        List<Double> networks;
        List<Integer> storages;

        //get old report to update
        for(Report report : reports){
            String[] r_date = formatter.format(report.getTimestamp()).split(" ");
            if(s_date[1].equals(r_date[1]) && s_date[2].equals(r_date[2])){
                new_report = report;
                break;
            }
        }

        Vm vm = vmProvider.getInstance().getVmStatus(null, vmIP);

        if(new_report != null){
            cpus = new_report.getCpus();
            mems = new_report.getMems();
            networks = new_report.getNetworks();
            storages = new_report.getStorage();

            cpus = updateValue(cpus, vm.Cpu, Integer.parseInt(s_date[0]));
            mems = updateValue(mems, vm.Mem, Integer.parseInt(s_date[0]));
            networks = updateValue(networks, vm.Network, Integer.parseInt(s_date[0]));
            storages = updateValue(storages, vm.Storage, Integer.parseInt(s_date[0]));

            new_report.setCpus(cpus);
            new_report.setMems(mems);
            new_report.setNetworks(networks);
            new_report.setStorage(storages);
            new_report.setTimestamp(new Date());
            repo.save(new_report);
        }
        else {
            cpus = new ArrayList<>();
            mems = new ArrayList<>();
            networks= new ArrayList<>();
            storages = new ArrayList<>();

            cpus = updateValue(cpus, vm.Cpu, Integer.parseInt(s_date[0]));
            mems = updateValue(mems, vm.Mem, Integer.parseInt(s_date[0]));
            networks = updateValue(networks, vm.Network, Integer.parseInt(s_date[0]));
            storages = updateValue(storages, vm.Storage, Integer.parseInt(s_date[0]));

            new_report = new Report(CloudProvider.UNKNOWN, cpus, mems, networks, storages, vmIP);
            repo.save(new_report);
        }
    }

    private List<Double> updateValue(List<Double> data, double value, int index){
        if (data.get(index) == null || data.get(index) < value){
            data.add(index, value);
        }
        return data;
    }

    private List<Integer> updateValue(List<Integer> data, int value, int index){
        if (data.get(index) == null || data.get(index) < value){
            data.add(index, value);
        }
        return data;
    }

    protected String testReport(String vmIP, String start, String end){
        Report report = new Report(vmIP);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        Date startDate, endDate;
        try{
            startDate = formatter.parse("1 " + start);
            endDate = formatter.parse("28 " + end);
        }
        catch (Exception e){
            System.out.println("Method getReportByMonth's inputs error.");
            e.printStackTrace();
            return null;
        }
        report.setTimestamp(startDate);
        System.out.println("return Report");
        return startDate.toString();
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
