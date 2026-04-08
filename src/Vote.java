import java.sql.*;

public class Vote {

    public static boolean hasUserVoted(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT has_voted FROM voters WHERE candidate_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("has_voted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void castVote(int userId, int candidateId) {
        try {
            Connection con = DBConnection.getConnection();

            // Add vote
            String voteQuery = "UPDATE candidates SET votes = votes + 1 WHERE candidate_id=?";
            PreparedStatement ps1 = con.prepareStatement(voteQuery);
            ps1.setInt(1, candidateId);
            ps1.executeUpdate();

            // Mark user as voted
            String userQuery = "UPDATE voters SET has_voted = TRUE WHERE candidate_id=?";
            PreparedStatement ps2 = con.prepareStatement(userQuery);
            ps2.setInt(1, userId);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}