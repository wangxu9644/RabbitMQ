package com.example.RabbitMQ;

/**
 * @author WANGX
 * @version 1.0.0
 * @ClassName TestProducer.java
 * @Description TODO
 * @createTime 2019-10-07  19:29:19
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息生产者
 */
public class TestProducer {
    public final static String QUEUE_NAME = "direct_queue";

    public static void main(String args[]) throws IOException, TimeoutException {
        RabbitMQUtil.checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ相关信息
        factory.setHost( "localhost" );

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        for (int i = 0; i<100; i++) {
            String message = "direct 消息" + i;

            //发送消息到队列中
            channel.basicPublish( "" ,QUEUE_NAME,null,message.getBytes("UTF-8"));
            System.out.println("发送消息" + message);
        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }


}
