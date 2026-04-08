import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Register {

    public static void registerUser() {
        try {
            Connection con = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            System.out.println("\n=== USER REGISTRATION ===");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            // Insert query
            String query = "INSERT INTO voters (name, email, password) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Registration Successful!");
            } else {
                System.out.println("❌ Registration Failed!");
            }

        } catch (Exception e) {
            // Handle duplicate email error
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("⚠ Email already registered!");
            } else {
                e.printStackTrace();
            }
        }
    }
}