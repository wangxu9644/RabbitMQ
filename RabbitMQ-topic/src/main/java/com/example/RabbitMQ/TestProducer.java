package com.example.RabbitMQ;

/**
 * @author WANGX
 * @version 1.0.0
 * @ClassName TesProducer.java
 * @Description TODO
 * @createTime 2019-10-07  20:51:46
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 分别在
 * 四个路由："usa.news", "usa.weather", "europe.news", "europe.weather"
 * 上发布   "美国新闻",   "美国天气",    "欧洲新闻",     "欧洲天气".
 */
public class TestProducer {

    public final static String EXCHANGE_NAME="topics_exchange";

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
        channel.exchangeDeclare( EXCHANGE_NAME,"topic" );

        String[] routing_keys = new String[] {
                "usa.news","usa.weather","europe.news","europe.weather"
        };

        String[] messages = new String[]{
                "美国新闻","美国天气","欧洲新闻","欧洲天气"
        };

        for (int i = 0; i<routing_keys.length; i++) {

            String routingKey = routing_keys[i];
            String message = messages[i];

            channel.basicPublish( EXCHANGE_NAME,routingKey,null,message.getBytes(  ) );

            System.out.printf("发送消息到路由：%s, 内容是 ：%s%n ",routingKey,message);
        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
