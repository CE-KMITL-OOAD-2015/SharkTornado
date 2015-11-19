package th.ac.kmitl.ce.ooad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/29/2015.
 */
public class PredictionModel {
    private static PredictionModel predictionModel = new PredictionModel();
    private PredictionModel() {
    }

    public static PredictionModel getInstance(){
        return predictionModel;
    }

    protected Prediction genPrediction(List<Report> reports){
        List<Double> maxCPU = new ArrayList<>();
        List<Double> maxMem = new ArrayList<>();
        List<Integer> maxStorage = new ArrayList<>();
        List<Double> maxNetwork = new ArrayList<>();

        Prediction prediction = new Prediction();

        double max_cpu = 0.0;
        double max_mem = 0.0;
        double max_net = 0.0;
        int max_str = 0;

        Report report = new Report();

        try{
            for(Report temp : reports){
                if(temp != null){
                    report = temp;
                    break;
                }
            }
        } catch(Exception e){
            System.out.println("GOT CHA!!!!");
        }
        double temp_cpu = findMax(report.getCpus());
        double temp_mem = findMax(report.getMems());
        double temp_net = findMax(report.getNetworks());
        int temp_str = findIntMax(report.getStorage());

        if(temp_cpu > max_cpu) max_cpu = temp_cpu;
        if(temp_mem > max_mem) max_mem = temp_mem;
        if(temp_net > max_net) max_net = temp_net;
        if(temp_str > max_str) max_str = temp_str;
        maxCPU.add(max_cpu*1.4);
        maxMem.add(max_mem*1.4);
        maxNetwork.add(max_net*1.4);
        maxStorage.add(max_str);

        prediction.setCpus(maxCPU);
        prediction.setMems(maxMem);
        prediction.setNetworks(maxNetwork);
        prediction.setStorage(maxStorage);

        return prediction;

    }

    private double findMax(List<Double> values){
        double re_double = 0.0;
        for(Double d : values){
            if(d > re_double) re_double = d;
        }
        return re_double;
    }
    private int findIntMax(List<Integer> values){
        int re = 0;
        for(Integer d : values){
            if(d > re) re = d;
        }
        return re;
    }
}
