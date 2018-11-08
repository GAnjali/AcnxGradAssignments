package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    Resource buffer;

    public Consumer(Resource buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Connection connection = null;
        while (true) {
            connection = buffer.consume();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
