package com.mt.client.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * author: liqm
 * 2020-02-26
 */
@Component
@Slf4j
public class RabbitMQClient {


    // 出现异常：
    // Channel shutdown: channel error; protocol method: #method<channel.close>(reply-code=406, reply-text=PRECONDITION_FAILED - unknown delivery tag 1, class-id=60, method-id=80)
    // 解决办法:接入配置-》acknowledge-mode: manual  手动ack
    // 思路：默认是自动ack的，如果我们不配置为手动的，那么框架将自动为我们ack一次，然后我们再ack一次，也就重复了，message也就被ack过了
    //参考文献：https://blog.csdn.net/more_try/article/details/82804387


    @RabbitListener(queues = "queueName")
    public void consume(String msg,Channel channel, Message message) {
        try {
            log.info("queueName-》received msg:{},msgId:{}", msg,message.getMessageProperties().getDeliveryTag());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }



    @RabbitListener(queues = "queueName2")
    public void consume1(String msg,Channel channel, Message message) {
        try {
            log.info("queueName2-》received msg:{},msgId:{}", msg,message.getMessageProperties().getDeliveryTag());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}