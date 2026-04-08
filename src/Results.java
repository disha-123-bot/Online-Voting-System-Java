import java.sql.*;
import java.util.ArrayList;

public class Results {

    public static ArrayList<String> getResults() {
        ArrayList<String> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");

            while (rs.next()) {
                String data = rs.getString("name") + " (" +
                        rs.getString("party") + ") - Votes: " +
                        rs.getInt("votes");

                list.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}