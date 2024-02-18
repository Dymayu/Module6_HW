import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MySqlDbExample {
    public static void main(String[] args) throws IOException, SQLException {


        File file = new File("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\select_all_worker.sql");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        Connection conn = Database.getInstance().getConnection();

            try (PreparedStatement preparedStatement = conn.prepareStatement(line);
                 ResultSet resultSet = preparedStatement.executeQuery()) {


                while(line!=null){
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        //int age = resultSet.getInt("age");
                        LocalDate birthday = resultSet.getDate("birthday").toLocalDate();

                        System.out.println("name: " + name);
                        //System.out.println("age: " + age);
                        System.out.println("birthday: " + birthday);
                    }

                    //System.out.println(line);
                    line = reader.readLine();
                }


            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
