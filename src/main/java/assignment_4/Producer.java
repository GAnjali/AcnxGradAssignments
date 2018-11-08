package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

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
            try {
                buffer.produce(dbConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
