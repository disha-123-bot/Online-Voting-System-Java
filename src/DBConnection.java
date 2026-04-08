import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // add this line

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/online_voting",
                    "root",
                    "AS25@rry"
            );

            System.out.println("Connected successfully!");
            return con;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
