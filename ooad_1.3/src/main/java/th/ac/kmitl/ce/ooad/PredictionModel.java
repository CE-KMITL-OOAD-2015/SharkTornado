package th.ac.kmitl.ce.ooad;

import java.util.Date;
import java.util.List;

/**
 * Created by Nut on 10/29/2015.
 */
public class PredictionModel {
    private PredictionModel predictionModel = new PredictionModel();
    private PredictionModel() {
    }

    public PredictionModel getInstance(){
        return predictionModel;
    }

    protected Prediction genPrediction(List<Report> reports){
        double[] maxCPU = {0.0};
        double[] maxMem = {0.0};
        int[] maxStorage = {0};
        double[] maxNetwork = {0};
        Prediction prediction = new Prediction();
        //prediction.setTimestamp(new Date());
        //prediction.setCloudProvider(reports.get(0).getCloudProvider());
        for(Report report : reports){
            double temp_cpu = findMax(report.getCpus());
            double temp_mem = findMax(report.getMems());
            double temp_network = findMax(report.getNetworks());
            if(temp_cpu > maxCPU[0]) maxCPU[0] = temp_cpu;
            if(temp_mem > maxMem[0]) maxMem[0] = temp_mem;
            if(temp_network > maxNetwork[0]) maxNetwork[0] = temp_network;
            for(int storage : report.getStorage()){
                if(storage > maxStorage[0]) maxStorage[0] = storage;
            }
        }

        prediction.setCpus(maxCPU);
        prediction.setMems(maxMem);
        prediction.setNetworks(maxNetwork);
        prediction.setStorage(maxStorage);

        return prediction;
    }

    private double findMax(double[] values){
        double re_double = 0.0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > re_double) re_double = values[i];
        }
        return re_double;
    }
}
