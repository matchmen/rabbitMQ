package com.mt.server.task;

import com.mt.server.rabbitMq.RabbitMQServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * author: liqm
 * 2020-02-26
 */
@Component
public class Task {

    @Autowired
    RabbitMQServer rabbitMQServer;

    @Scheduled(cron = "0/5 * * * * ?")
    public void send() {
        rabbitMQServer.send();
    }


}
