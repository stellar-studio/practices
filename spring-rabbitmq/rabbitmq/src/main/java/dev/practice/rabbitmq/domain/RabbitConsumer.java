package dev.practice.rabbitmq.domain;

import com.rabbitmq.client.Channel;
import dev.practice.rabbitmq.domain.remote.gateway.RemoteGatewayApiCaller;
import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;
import dev.practice.rabbitmq.interfaces.message.TransactionRequestMessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitConsumer implements RabbitConsumerService{
    private final RemoteGatewayApiCaller remoteGatewayApiCaller;
    private final TransactionRequestMessageMapper transactionRequestMessageMapper;

    @Override
    @RabbitListener(queues = "remote.transaction.request") // message to remote api gateway from local RabbitMQ
    public void receive(Message message, Channel channel) throws IOException {
        log.info("Received Message: {}", message);

        try{
            TransactionRequestMessageCommand.Transaction txCommand = transactionRequestMessageMapper.of(message);
            try{
                String messageId = remoteGatewayApiCaller.doTransaction(txCommand);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                log.info(" [x] Remote Transaction Success - " + messageId + " received");
            } catch (Exception e){
                Thread.sleep(3000);
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            }
        } catch (Exception e){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
