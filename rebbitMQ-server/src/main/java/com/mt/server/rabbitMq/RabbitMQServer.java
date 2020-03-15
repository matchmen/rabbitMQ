package com.mt.server.rabbitMq;

import com.mt.server.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author: liqm
 * 2020-02-26
 */
@Slf4j
@Component
public class RabbitMQServer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {


        rabbitTemplate.convertAndSend("欢迎来到RabbitMQ世界！");
        log.info("发送成功");

    }

}
