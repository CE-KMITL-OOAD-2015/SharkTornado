package th.ac.kmitl.ce.ooad.Dashboard;

/**
 * Created by Nut on 10/14/2015.
 */
public class Vm {
    public String vmIP;
    public double rCpu, rMem, rNetwork, Cpu, Mem, Network;
    public int rStorage, Storage;

    public Vm(String vmIP, double rCpu, double rMem, double rNetwork, double cpu, double mem, double network, int rStorage, int storage) {
        this.vmIP = vmIP;
        this.rCpu = rCpu;
        this.rMem = rMem;
        this.rNetwork = rNetwork;
        Cpu = cpu;
        Mem = mem;
        Network = network;
        this.rStorage = rStorage;
        Storage = storage;
    }

}
