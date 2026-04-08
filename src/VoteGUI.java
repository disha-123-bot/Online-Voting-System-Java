import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class VoteGUI extends JFrame {

    int userId;

    public VoteGUI(int userId) {
        this.userId = userId;

        setTitle("Vote for Candidate");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Select a Candidate", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        loadCandidates(panel);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadCandidates(JPanel panel) {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");

            while (rs.next()) {
                // DEBUG LINE 👇
                System.out.println(rs.getString(1));

                int cid = rs.getInt("candidate_id");
                String name = rs.getString("name");
                String party = rs.getString("party");

                JButton btn = new JButton(name + " (" + party + ")");
                btn.setFont(new Font("Arial", Font.PLAIN, 14));

                btn.addActionListener(e -> vote(cid));

                panel.add(btn);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vote(int candidateId) {

        if (Vote.hasUserVoted(userId)) {
            JOptionPane.showMessageDialog(this, "You have already voted!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Confirm your vote?",
                "Vote",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Vote.castVote(userId, candidateId);
            JOptionPane.showMessageDialog(this, "Vote cast successfully!");
            dispose();
        }
    }
}