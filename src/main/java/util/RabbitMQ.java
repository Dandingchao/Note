package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;

import java.io.IOException;


public class RabbitMQ {
    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.30.123.240");
        factory.setPort(5672);
        factory.setVirtualHost("testhost");
        factory.setUsername("rj");
        factory.setPassword("rjrjrj");
        Connection connection = factory.newConnection();
        return connection;
    }
}
