package assignment_4;

import java.sql.Connection;
import java.util.ArrayList;

public class Resource {
    private ArrayList<Connection> buffer = new ArrayList<Connection>();
    static final int BUFFER_LIMIT = 5;

    public synchronized void produce(Connection connection) {
        while (buffer.size() >= BUFFER_LIMIT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Produced: " + connection);
        buffer.add(connection);
        notifyAll();
    }

    public synchronized Connection consume() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection removedConnection = buffer.remove(0);
        System.out.println("Consumed: " + removedConnection);
        notifyAll();
        return removedConnection;
    }
}
