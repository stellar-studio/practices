package dev.practice.rabbitmq.infrastructure.retrofit;

import dev.practice.rabbitmq.infrastructure.remote.gateway.RetrofitRemoteGatewayApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitServiceRegistry {

    @Value("${config.remote.gateway.host}")
    private String remoteGatewayHost;

    @Bean
    public RetrofitRemoteGatewayApi retrofitRemoteGatewayApi() {
        var retrofit = RetrofitUtils.initRetrofit(remoteGatewayHost);
        return retrofit.create(RetrofitRemoteGatewayApi.class);
    }
}
