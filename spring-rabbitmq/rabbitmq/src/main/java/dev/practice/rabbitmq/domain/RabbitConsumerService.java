package dev.practice.rabbitmq.domain;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

public interface RabbitConsumerService {
    void receive(Message message, Channel channel) throws IOException;
}
