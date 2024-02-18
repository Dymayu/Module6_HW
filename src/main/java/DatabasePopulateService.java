import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;

public class DatabasePopulateService {

    public void executeUpdate(String path) throws IOException, SQLException {
        Connection conn = Database.getInstance().getConnection();

        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Statement statement = conn.createStatement();

        System.out.println("Executing commands at : " + path);

        StringBuilder builder = new StringBuilder();

        String line;
        int lineNumber = 0;
        int count = 0;

        // Read lines from the SQL file until the end of the
        // file is reached.
        while ((line = bufferedReader.readLine()) != null) {
            lineNumber += 1;
            line = line.trim();

            // Skip empty lines and single-line comments.
            if (line.isEmpty() || line.startsWith("--"))
                continue;

            builder.append(line);
            // If the line ends with a semicolon, it
            // indicates the end of an SQL command.
            if (line.endsWith(";"))
                try {
                    // Execute the SQL command
                    statement.execute(builder.toString());
                    // Print a success message along with
                    // the first 15 characters of the
                    // executed command.
                    System.out.println(
                            ++count
                                    + " Command successfully executed : "
                                    + builder.substring(
                                    0,
                                    Math.min(builder.length(), 15))
                                    + "...");
                    builder.setLength(0);
                }
                catch (SQLException e) {
                    // If an SQLException occurs during
                    // execution, print an error message and
                    // stop further execution.
                    System.err.println(
                            "At line " + lineNumber + " : "
                                    + e.getMessage() + "\n");
                    return;
                }
        }

    }

    public static void main(String[] args) throws SQLException, IOException {


        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.executeUpdate("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\populate_db.sql");


    }
}
