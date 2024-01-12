
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    private String name;
    private JButton startButton;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("<html><div style='text-align: center; color: #1aff1a;'>Welcome " + name + " to the Coding Quiz</div></html>");
        heading.setFont(new Font("Ink Free", Font.BOLD, 28));
        add(heading, BorderLayout.NORTH);

        JLabel rulesLabel = new JLabel("<html><div style='text-align: center; color: #ffffff;'>" +
                "1. Welcome, " + name + "! Get ready for an exciting coding quiz." + "<br><br>" +
                "2. Answer the coding questions and test your knowledge." + "<br><br>" +
                "3. Each correct answer adds to your score. Let's see how well you do!" + "<br><br>" +
                "4. If a question is challenging, take your time and give it your best shot." + "<br><br>" +
                "5. Good luck, and enjoy the quiz!" +
                "</div></html>");
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(rulesLabel, BorderLayout.CENTER);

        startButton = new JButton("Start Quiz");
        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new IP());
        }
    }

    public static void main(String[] args) {
        new Rules("Quiz Taker");
    }
}



