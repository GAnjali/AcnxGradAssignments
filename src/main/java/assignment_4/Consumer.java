package assignment_4;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    Resource buffer;
    ConsumptionInfo consumptionInfo;

    public Consumer(Resource buffer, ConsumptionInfo consumptionInfo) {
        this.buffer = buffer;
        this.consumptionInfo = consumptionInfo;
    }

    @Override
    public void run() {
        Connection connection = null;
        while (true) {
            connection = buffer.consume(consumptionInfo);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
