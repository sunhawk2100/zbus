package io.zbus.mq.client;
 
import java.io.IOException;

import io.zbus.mq.api.Message;
import io.zbus.net.Client.MsgHandler;
import io.zbus.net.IoDriver;
import io.zbus.net.Session;
 
public class MqClientTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		IoDriver ioDriver = new IoDriver();
		
		TcpMqClient client = new TcpMqClient("localhost:8080", ioDriver); 
		
		client.onMessage(new MsgHandler<Message>() { 
			@Override
			public void onMessage(Message data, Session session) throws IOException {
				System.out.println(data);
				
			}
		});
		
		Message message = new Message(); 
		message.setTopic("Hong"); 
		
		client.produce(message);
		
		//client.close();
		//ioDriver.close();
	} 
}
