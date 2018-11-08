package assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String url = "jdbc:postgresql://localhost:5432/books_library";
    private String username = "postgres";
    private String password = "postgres";

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(this.url, this.username, this.password);
        return connection;
    }
}
