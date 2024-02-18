
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    private static final Database DATABASE;

    static {
        try {
            DATABASE = new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/megasoft", "root", "4521368");
    }

    public static Database getInstance() {
        return DATABASE;
    }


    public static Connection getConnection() throws SQLException {
        return connection;
    }
}
