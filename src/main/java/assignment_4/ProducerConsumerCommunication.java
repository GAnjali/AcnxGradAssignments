package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

public class ProducerConsumerCommunication {
    public static void main(String[] args) {
        Resource resource = new Resource();

        DBConnection dbConnection = new DBConnection();
        Thread producer = new Thread(new Producer(resource, dbConnection));
        Thread consumer = new Thread(new Consumer(resource));

        producer.start();
        consumer.start();
    }
}
