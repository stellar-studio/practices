package dev.practice.rabbitmq.infrastructure.remote.gateway;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class RetrofitRemoteGatewayApiResponse {
    @Getter
    @Builder
    @ToString
    public static class Transaction {
        private final String messageId;
    }
}
