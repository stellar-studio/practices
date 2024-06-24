package dev.practice.rabbitmq.domain.transactionRequestMessage;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TransactionRequestMessage {
    private String messageId;
    private String method;
    private String path;
    private String payload;
}
