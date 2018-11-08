package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Resource {
    private ArrayList<Connection> buffer = new ArrayList<Connection>();
    static final int BUFFER_LIMIT = 25;

    public synchronized void produce(DBConnection dbconnection) throws SQLException {
        while (buffer.size() == BUFFER_LIMIT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection connection = dbconnection.getConnection();
        System.out.println("Produced: " + connection);
        buffer.add(connection);
        notifyAll();
    }

    public synchronized Connection consume(ConsumptionInfo consumptionInfo) {
        while (buffer.isEmpty() || consumptionInfo.checkSelfishness(Thread.currentThread())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection removedConnection = buffer.remove(0);
        System.out.println("Consumed: " + removedConnection + " by " + Thread.currentThread().getName());
        notifyAll();
        return removedConnection;
    }
}
