import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuGUI extends JFrame implements ActionListener {

    int userId;
    JButton voteBtn, resultBtn, logoutBtn;

    public MainMenuGUI(int userId) {
        this.userId = userId;

        setTitle("Main Menu");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Online Voting System");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(80, 30, 250, 30);
        add(title);

        voteBtn = new JButton("Vote");
        voteBtn.setBounds(120, 80, 150, 30);
        voteBtn.addActionListener(this);
        add(voteBtn);

        resultBtn = new JButton("View Results");
        resultBtn.setBounds(120, 120, 150, 30);
        resultBtn.addActionListener(this);
        add(resultBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(120, 160, 150, 30);
        logoutBtn.addActionListener(this);
        add(logoutBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == voteBtn) {
            new VoteGUI(userId);
        }

        if (e.getSource() == resultBtn) {
            new ResultGUI();
        }

        if (e.getSource() == logoutBtn) {
            new LoginGUI();
            dispose();
        }
    }
}