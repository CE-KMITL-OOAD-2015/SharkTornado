package th.ac.kmitl.ce.ooad;

/**
 * Created by Nut on 10/23/2015.
 */
public class Dashboard {
    private Cloud[] clouds;

    public Dashboard(Cloud[] clouds){
        this.clouds = clouds;
    }

    public Dashboard(){

    }

    public Cloud[] getClouds() {
        return clouds;
    }

    public void setClouds(Cloud[] clouds) {
        this.clouds = clouds;
    }

    public String toString(){
        String re = "";
        for(Cloud cloud : clouds){
            re += cloud.toString() + "\n";
        }
        return re;
    }
}
