package th.ac.kmitl.ce.ooad.Models;

import th.ac.kmitl.ce.ooad.Report.Report;

import java.util.Date;
/**
 * Created by Nut on 10/23/2015.
 */
public class ReportModel {
    private static ReportModel reportModel = new ReportModel();
    private ReportModel(){

    }

    public static ReportModel getInstance(){
        return reportModel;
    }

    protected void recDailyUsage(){

    }

    protected void genDailyUsage(){

    }

    protected Report[] getReportByDate(Date date){
        return new Report[0];
    }
}
