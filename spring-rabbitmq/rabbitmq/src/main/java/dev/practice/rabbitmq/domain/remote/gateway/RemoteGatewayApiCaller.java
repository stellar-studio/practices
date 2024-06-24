package dev.practice.rabbitmq.domain.remote.gateway;

import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessage;
import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;

public interface RemoteGatewayApiCaller {
    String doTransaction(TransactionRequestMessageCommand.Transaction request); //return correlation-id or message-id
}
