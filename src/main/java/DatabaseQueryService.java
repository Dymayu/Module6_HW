import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProject() throws SQLException, IOException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement();
        String query = new String(Files.readAllBytes(Paths.get("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\find_longest_project.sql")));
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            String name = resultSet.getString("NAME");
            int monthCount = resultSet.getInt("MONTH_COUNT");
            longestProjectList.add(new LongestProject(name,monthCount));
        }
        statement.close();
        return longestProjectList;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException, IOException {
        List<MaxProjectCountClient> mpccList = new ArrayList<>();

        Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement();
        String query = new String(Files.readAllBytes(Paths.get("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\find_max_projects_client.sql")));
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            String name = resultSet.getString("NAME");
            int projectCount = resultSet.getInt("PROJECT_COUNT");

            mpccList.add(new MaxProjectCountClient(name, projectCount));
        }
        statement.close();
        return mpccList;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException, IOException {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();

        Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement();
        String query = new String(Files.readAllBytes(Paths.get("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\find_max_salary_worker.sql")));
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            String name = resultSet.getString("NAME");
            int salary = resultSet.getInt("SALARY");
            maxSalaryWorkerList.add(new MaxSalaryWorker(name,salary));
        }
        statement.close();
        return maxSalaryWorkerList;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws SQLException, IOException {
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();

        Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement();
        String query = new String(Files.readAllBytes(Paths.get("C:\\Users\\yudy1117\\IdeaProjects\\Developer\\Module6\\SQL\\find_youngest_eldest_workers.sql")));
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            String youngest = resultSet.getString("YOUNGEST");
            String name = resultSet.getString("NAME");
            LocalDate birthday = LocalDate.parse(resultSet.getString("BIRTHDAY"));
            youngestEldestWorkersList.add(new YoungestEldestWorkers(youngest,name, birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }

        statement.close();
        return youngestEldestWorkersList;
    }

    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("\n");
        System.out.println("Find max projects client query output:");
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println(client);
        }

        System.out.println("\n");
        System.out.println("Find longest project query output:");
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        for (LongestProject projects : longestProjects) {
            System.out.println(projects);
        }

        System.out.println("\n");
        System.out.println("Find max salary worker query output:");
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        for (MaxSalaryWorker worker : maxSalaryWorkers) {
            System.out.println(worker);
        }

        System.out.println("\n");
        System.out.println("Find youngest eldest workers query output:");
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        for(YoungestEldestWorkers workers: youngestEldestWorkers){
            System.out.println(workers);
        }

    }
}
