
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    private String name;
    private int score;
    private int totalQuestions;

    Score(String name, int score, int totalQuestions) {
        this.name = name;
        this.score = score;
        this.totalQuestions = totalQuestions;

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        JLabel heading = new JLabel("<html><div style='text-align: center; color: #1aff1a;'>Great job, " + name + "!</div></html>");
        heading.setFont(new Font("Ink Free", Font.BOLD, 26));
        add(heading, BorderLayout.NORTH);

        JLabel scoreLabel = new JLabel("<html><div style='text-align: center; color: #ffffff;'>Your score is " + score + " out of " + totalQuestions + "</div></html>");
        scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(scoreLabel, BorderLayout.CENTER);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setBackground(new Color(30, 144, 255));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(playAgainButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new IP();
    }

    public static void main(String[] args) {
        new Score("User", 5, 10).setVisible(true);
    }
}
