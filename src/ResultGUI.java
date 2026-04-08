import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultGUI extends JFrame {

    public ResultGUI() {

        setTitle("Election Results");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Results", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        ArrayList<String> results = Results.getResults();

        for (String r : results) {
            area.append(r + "\n");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);

        setVisible(true);
    }
}