package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Font LABEL_FONT = new Font("Tahoma", Font.PLAIN, 26);
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(30, 144, 255);
    private static final Color BUTTON_FOREGROUND_COLOR = Color.WHITE;

    private String name;
    private int score;
    private int totalQuestions;

    public Score(String name, int score, int totalQuestions) {
        this.name = name;
        this.score = score;
        this.totalQuestions = totalQuestions;

        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND_COLOR);

        JLabel heading = new JLabel("Great job, " + name + "!");
        heading.setFont(LABEL_FONT);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);

        JLabel scoreLabel = new JLabel("Your score is " + score + " out of " + totalQuestions);
        scoreLabel.setFont(LABEL_FONT);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel, BorderLayout.CENTER);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setBackground(BUTTON_BACKGROUND_COLOR);
        playAgainButton.setForeground(BUTTON_FOREGROUND_COLOR);
        playAgainButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(playAgainButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new QuizApp();
    }
}
