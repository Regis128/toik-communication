package main.java.pl.edu.agh.lab.toik.comm.impl;

import main.java.pl.edu.agh.lab.toik.comm.INamingService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by regis on 4/14/17.
 */
public class NamingService implements INamingService {
    private HashMap<String, String> namingService;
    private HashMap<String, ArrayList<String>> agents;
    private int workers = 0;

    private NamingService(String conf) {
        namingService = new HashMap<>();
        agents = new HashMap<>();
    }

    public NamingService create(String conf) {
        NamingService ns = new NamingService(conf);
        return ns;
    }

    public String GetWorker(String name) {
        return namingService.get(name);
    }

    public ArrayList<String> GetAgents(String name) {
        return agents.get(name);
    }

    private void CreateWorker(String address) {
        namingService.put("w"+workers++, address);
    }

    private void CreateAgent(String worker) {
        ArrayList<String> list = agents.get(worker);
        list.add(worker+"a"+list.size());
    }
}
