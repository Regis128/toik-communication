package main.java.pl.edu.agh.lab.toik.comm;

import main.java.pl.edu.agh.lab.toik.comm.impl.Message;

public interface IMessageObserver {

	public void handleIncomingMessage(Message message);

}
