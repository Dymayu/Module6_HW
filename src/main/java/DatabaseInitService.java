import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DatabaseInitService {

    public void executeFile(String path) throws IOException {

        try (Connection conn = Database.getInstance().getConnection();
             Statement statement = conn.createStatement();) {

            String query = new String(Files.readAllBytes(Paths.get(path)));
            String[] commands = query.split(";",0);

            for (String sqlCommand: commands){
                statement.executeUpdate(sqlCommand);
                System.out.println("Sql Command: " + sqlCommand);
                System.out.println("Table is successfully created! \n");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        DatabaseInitService databaseInitService = new DatabaseInitService();
        databaseInitService.executeFile("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\init_db.sql");

    }

}
