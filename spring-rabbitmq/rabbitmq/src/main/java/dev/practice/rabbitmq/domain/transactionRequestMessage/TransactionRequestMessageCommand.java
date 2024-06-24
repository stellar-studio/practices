package dev.practice.rabbitmq.domain.transactionRequestMessage;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class TransactionRequestMessageCommand {

    @Getter
    @Builder
    @ToString
    public static class Transaction{
        private final String messageId;
        private final String method;
        private final String path;
        private final String payload;
    }
}
