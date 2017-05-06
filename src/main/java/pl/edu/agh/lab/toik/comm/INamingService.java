package main.java.pl.edu.agh.lab.toik.comm;

import main.java.pl.edu.agh.lab.toik.comm.impl.NamingService;

import java.util.ArrayList;

/**
 * Created by regis on 5/6/17.
 */
public interface INamingService {
    public NamingService create(String conf);

    public String GetWorker(String name);

    public ArrayList<String> GetAgents(String name);
}
