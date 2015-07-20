package com.services.impls;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.services.interfaces.AlertService;

public class AlertServiceImpl implements AlertService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendAlertMessage(String message) {
		// TODO Auto-generated method stub
		jmsTemplate.send("test.queue", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createObjectMessage(message);
			}
		});
	}

	@Override
	public String getAlert() {
		//这个接收方法是同步的，没有消息会一直处于等待状态 
		ObjectMessage oMessage = (ObjectMessage)jmsTemplate.receive("test.queue");
		try {
			return (String)oMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
