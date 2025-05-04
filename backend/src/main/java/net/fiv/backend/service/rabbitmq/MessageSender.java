package net.fiv.backend.service.rabbitmq;

import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Setter
@Service
public class MessageSender {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {

        rabbitTemplate.convertAndSend(queueName, message);

    }

}
