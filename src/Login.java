import java.sql.*;

public class Login {

    public static int loginUser(String email, String password) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM voters WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // return user ID
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1; // login failed
    }
}