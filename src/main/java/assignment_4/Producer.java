package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    Resource buffer;
    DBConnection dbConnection;

    public Producer(Resource buffer, DBConnection dbConnection) {
        this.buffer = buffer;
        this.dbConnection = dbConnection;
    }


    @Override
    public void run() {
        while (true) {
            Connection connection = null;
            try {
                connection=dbConnection.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            buffer.produce(connection);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
