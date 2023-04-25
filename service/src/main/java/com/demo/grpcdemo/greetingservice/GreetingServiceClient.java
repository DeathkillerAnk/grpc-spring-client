package com.demo.grpcdemo.greetingservice;

import com.demo.grpc.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

//https://medium.com/turkcell/grpc-implementation-with-spring-boot-7d6f98349d27
@Service
public class GreetingServiceClient {


    @GrpcClient("greeting")
    private GreetingServiceGrpc.GreetingServiceBlockingStub greetingServiceBlockingStub;

    public String greet(String greetingMessage) {
        GreetingRequest greetingRequest = GreetingRequest.newBuilder().setMessage(greetingMessage).build();
        greetingServiceBlockingStub = greetingServiceBlockingStub.withMaxInboundMessageSize(Integer.MAX_VALUE).withMaxOutboundMessageSize(Integer.MAX_VALUE);
        GreetingResponse greetingResponse = greetingServiceBlockingStub.greeting(greetingRequest);
        return greetingResponse.getMessage();
    }
}