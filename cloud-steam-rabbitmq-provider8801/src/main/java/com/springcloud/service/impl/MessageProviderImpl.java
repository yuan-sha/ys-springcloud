package com.springcloud.service.impl;

import com.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel ouput;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        ouput.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
