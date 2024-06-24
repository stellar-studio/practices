package dev.practice.rabbitmq.interfaces.message;

import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface TransactionRequestMessageMapper {
    TransactionRequestMessageCommand.Transaction of(Message message);
}
