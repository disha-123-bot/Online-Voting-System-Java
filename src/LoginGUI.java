import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {

    JTextField emailField;
    JPasswordField passwordField;
    JButton loginBtn, registerBtn;

    public LoginGUI() {
        setTitle("Online Voting System - Login");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(160, 20, 100, 30);
        add(title);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 80, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 80, 180, 25);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 180, 25);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 180, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 180, 100, 30);
        registerBtn.addActionListener(this);
        add(registerBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {
            loginUser();
        }

        if (e.getSource() == registerBtn) {
            new RegisterGUI();
        }
    }

    private void loginUser() {

        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        int userId = Login.loginUser(email, password);

        if (userId != -1) {
            JOptionPane.showMessageDialog(this, "✅ Login Successful!");

            new MainMenuGUI(userId); // open Main menu screen
            dispose(); // close login

        } else {
            JOptionPane.showMessageDialog(this, "❌ Invalid Email or Password!");
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}