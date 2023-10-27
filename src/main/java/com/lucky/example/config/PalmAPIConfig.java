package com.lucky.example.config;

import com.google.ai.generativelanguage.v1beta3.GenerateTextRequest;
import com.google.ai.generativelanguage.v1beta3.TextServiceClient;
import com.google.ai.generativelanguage.v1beta3.TextServiceSettings;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;

@Configuration
public class PalmAPIConfig {

    @Bean("pALMApiClient")
    public TextServiceClient getClient() throws IOException {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("x-goog-api-key", System.getenv("PALM_API_KEY"));

        TransportChannelProvider provider = InstantiatingGrpcChannelProvider.newBuilder()
            .setHeaderProvider(FixedHeaderProvider.create(headers))
            .build();

        TextServiceSettings settings = TextServiceSettings.newBuilder()
            .setTransportChannelProvider(provider)
            .setCredentialsProvider(FixedCredentialsProvider.create(null))
            .build();

        TextServiceClient client = TextServiceClient.create(settings);
        return client;
    }

}
