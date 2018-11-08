package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

public class ProducerConsumerCommunication {
    public static void main(String[] args) {
        /*Resource resource = new Resource();
        Thread producer = new Thread(new Producer(resource, 1));
        Thread consumer = new Thread(new Consumer(resource));

        producer.start();
        consumer.start();*/

        //DB Connection Test
        DBConnection dbConnection = new DBConnection();
        try {
            System.out.println(dbConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
