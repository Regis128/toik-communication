package main.java.pl.edu.agh.lab.toik.comm.exmpl.tcp;

import main.java.pl.edu.agh.lab.toik.comm.ICommunicator;
import main.java.pl.edu.agh.lab.toik.comm.impl.Message;
import main.java.pl.edu.agh.lab.toik.comm.MessageType;
import main.java.pl.edu.agh.lab.toik.comm.exmpl.TestMessageHandler;
import main.java.pl.edu.agh.lab.toik.comm.impl.TCPCommunicator;

public class TCPHost2 {

	public static void main(String[] args) throws InterruptedException {
		ICommunicator communicator = new TCPCommunicator();
		communicator.init("http://192.168.2.4:8081/host2");
		communicator.addMessageObserver(new TestMessageHandler());

		Message message = new Message();
		message.setType(MessageType.REPORT);
		message.setValue("testMessageFromHost2");

		while (true) {
			communicator.sendMessage(message, "http://192.168.2.8:8081/host1");
			Thread.sleep(2000);
		}
	}

}