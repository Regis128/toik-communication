package main.java.pl.edu.agh.lab.toik.comm.exmpl;


import main.java.pl.edu.agh.lab.toik.comm.IMessageObserver;
import main.java.pl.edu.agh.lab.toik.comm.impl.Message;

public class TestMessageHandler implements IMessageObserver {

	public void handleIncomingMessage(Message message) {
		System.out.println(message.getValue());
	}
}
