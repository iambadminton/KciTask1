import java.sql.*;

/**
 * Created by a.shipulin on 31.07.18.
 */
public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE Person(id INTEGER , name VARCHAR )");
            statement.execute("insert into person(id, name) values (1, 'ALEX')");
            statement.execute("insert into person(id, name) values (2, 'BOB')");
            ResultSet resultSet = statement.executeQuery("SELECT * from person");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
            connection.close();
            System.out.println(connection.isClosed());

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
