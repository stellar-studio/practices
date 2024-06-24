package dev.practice.rabbitmq.infrastructure.remote.gateway;

import dev.practice.rabbitmq.common.response.CommonResponse;
import dev.practice.rabbitmq.domain.transactionRequestMessage.TransactionRequestMessageCommand;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitRemoteGatewayApi {
    @POST("/api/v1/local-transaction")
    Call<CommonResponse<RetrofitRemoteGatewayApiResponse.Transaction>> transaction(@Body TransactionRequestMessageCommand.Transaction request);
}
