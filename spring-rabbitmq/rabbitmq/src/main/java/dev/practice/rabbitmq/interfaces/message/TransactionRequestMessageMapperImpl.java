package dev.practice.rabbitmq.interfaces.message;

import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class TransactionRequestMessageMapperImpl implements TransactionRequestMessageMapper {

    @Override
    public TransactionRequestMessageCommand.Transaction of(Message message){
        var txBuilder = TransactionRequestMessageCommand.Transaction.builder();

        txBuilder.messageId(message.getMessageProperties().getHeader("x-message-id"));
        txBuilder.method(message.getMessageProperties().getHeader("x-http-method"));
        txBuilder.path(message.getMessageProperties().getHeader("x-dest-api"));
        txBuilder.payload(new String(message.getBody()));

        return txBuilder.build();
    }
}
