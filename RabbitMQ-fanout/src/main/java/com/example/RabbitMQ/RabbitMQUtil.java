package com.example.RabbitMQ;

/**
 * @author WANGX
 * @version 1.0.0
 * @ClassName RabbitMQUtil.java
 * @Description TODO
 * @createTime 2019-10-07  18:19:14
 */

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

/**
 * 判断服务器是否启动
 */
public class RabbitMQUtil {
    public static void main(String args[]){
        checkServer();
    }

    public static void checkServer(){
        if (NetUtil.isUsableLocalPort( 15672 )){
            JOptionPane.showMessageDialog( null,"RabbitMQ 服务器未启动" );
            System.exit( 1 );
        }
    }
}
