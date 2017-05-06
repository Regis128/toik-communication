package main.java.pl.edu.agh.lab.toik.comm.impl;

import main.java.pl.edu.agh.lab.toik.comm.ICommunicator;
import main.java.pl.edu.agh.lab.toik.comm.IMessageObserver;
import main.java.pl.edu.agh.lab.toik.comm.INamingService;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;


public class TCPCommunicator implements ICommunicator {
	private NamingService namingService;
	private String name;
	private MessagingService localService;
	private String ID;

	public void init(String name, INamingService namingService) {
		this.name = name;
		this.namingService = (NamingService) namingService;

		ID = this.namingService.GetWorker(this.name);

		try {
			localService = new MessagingService();
			IMessagingService stub = (IMessagingService) UnicastRemoteObject
					.exportObject(localService, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(idMatcher.group(5), stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String worker, String agent, Message message) {
		try {
			Registry registry = LocateRegistry.getRegistry(idMatcher.group(2));
			IMessagingService remoteService = (IMessagingService) registry
					.lookup(idMatcher.group(5));
			remoteService.invokeCommunication(message);
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMessageObserver(IMessageObserver observer) {
		localService.addMessageHandler(observer);
	}

	public void removeMessageObserver(IMessageObserver observer) {
		localService.removeMessageHandler(observer);
	}

}
