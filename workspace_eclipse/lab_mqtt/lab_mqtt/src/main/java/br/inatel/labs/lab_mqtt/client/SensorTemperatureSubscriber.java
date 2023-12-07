package br.inatel.labs.lab_mqtt.client;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SensorTemperatureSubscriber {
	public static void main(String [] args) {
		String subscriberId = UUID.randomUUID().toString();
		IMqttClient subscriber = null;
		
		try {
			subscriber = new MqttClient(MyConstants.URI_BROKER, subscriberId);
			
			MqttConnectOptions options = new MqttConnectOptions();
			options.setAutomaticReconnect(true);
			options.setCleanSession(true);
			options.setConnectionTimeout(10);
			subscriber.connect(options);
			System.out.println("Subscriber conectado e aguardando msg");
			
			subscriber.subscribe(Myconstants.TOPIC_SENSOR,(topic, msg)->{
				byte[] payload = msg.getPayload();
				System.out.println("Payload recebido: " + payload);
				System.out.println("Topic especifico: " + topic);
			});
		}catch(MqttException e) {
			e.printStackTrace();
		}finally {
			try {
				subscriber.close();
			}catch (MqttException e) {
				
			}
		}
	}
}
