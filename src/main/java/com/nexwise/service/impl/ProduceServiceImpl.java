package com.nexwise.service.impl;

import com.nexwise.service.ProduceService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProduceServiceImpl implements ProduceService {

    @Resource(name = "topicJmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "xiaomingTopicDestination")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息:" + message);
    }
}
