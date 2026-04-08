import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterGUI extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JButton registerBtn;

    public RegisterGUI() {
        setTitle("Register");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 50, 80, 25);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 180, 25);
        add(nameField);

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 90, 80, 25);
        add(email);

        emailField = new JTextField();
        emailField.setBounds(150, 90, 180, 25);
        add(emailField);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(50, 130, 80, 25);
        add(pass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 180, 25);
        add(passwordField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(140, 180, 100, 30);
        registerBtn.addActionListener(this);
        add(registerBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO voters (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, nameField.getText());
            ps.setString(2, emailField.getText());
            ps.setString(3, new String(passwordField.getPassword()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registered Successfully!");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error or Email already exists!");
        }
    }
}