package com.dangdang.hp.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] argss) {

		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// 消费者，消息接收者
		MessageConsumer consumer;
		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.255.209.174:61616");

		try {
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			// 启动  
            connection.start();  
            // 获取操作连接  
            session = connection.createSession(Boolean.FALSE,  
                    Session.AUTO_ACKNOWLEDGE);  
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
//            destination = session.createQueue("FirstQueue");
            destination = session.createTopic("FirstTopic");
            consumer = session.createConsumer(destination);
            
            ConsumerMessageListener listener = new ConsumerMessageListener();
            
            consumer.setMessageListener(listener);
            
            while (true) {  
                try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }  
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static class ConsumerMessageListener implements MessageListener{

		@Override
		public void onMessage(Message message) {
			
			TextMessage tm = (TextMessage) message;
			try {
				System.out.println("---------消息消费---------");
				System.out.println("消息内容:\t" + tm.getText());
				System.out.println("消息ID:\t" + tm.getJMSMessageID());
				System.out.println("消息Destination:\t" + tm.getJMSDestination());
				System.out.println("---------更多信息---------");
//				System.out.println(ToStringBuilder.reflectionToString(tm));
				System.out.println("-------------------------");
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
