package dev.practice.rabbitmq.infrastructure.remote.gateway;

import dev.practice.rabbitmq.common.response.CommonResponse;
import dev.practice.rabbitmq.domain.remote.gateway.RemoteGatewayApiCaller;
import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;
import dev.practice.rabbitmq.infrastructure.retrofit.RetrofitUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RemoteGatewayApiCallerImpl implements RemoteGatewayApiCaller {
    private final RetrofitUtils retrofitUtils;
    private final RetrofitRemoteGatewayApi retrofitRemoteGatewayApi;

    @Override
    public String doTransaction(TransactionRequestMessageCommand.Transaction request) {
        var call = retrofitRemoteGatewayApi.transaction(request);
        return retrofitUtils.responseSync(call)
                .map(CommonResponse::getData)
                .map(RetrofitRemoteGatewayApiResponse.Transaction::getMessageId)
                .orElseThrow(RuntimeException::new);
    }
}
