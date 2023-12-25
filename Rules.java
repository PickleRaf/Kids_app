package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {
    private static final String WINDOW_TITLE = "Kids Coding Quiz";
    private static final String START_BUTTON_LABEL = "Start Coding Quiz";
    private static final Color BACKGROUND_COLOR = new Color(0, 21, 50);
    private static final Font LABEL_FONT = new Font("Comic Sans MS", Font.BOLD, 28);
    private static final Font TEXT_AREA_FONT = new Font("Arial", Font.PLAIN, 16);
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(63, 255, 0);
    private static final Color BUTTON_FOREGROUND_COLOR = Color.WHITE;

    private String name;
    private JButton startButton;

    public Rules(String name) {
        this.name = name;
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Welcome " + name + " to " + WINDOW_TITLE);
        heading.setFont(LABEL_FONT);
        heading.setForeground(new Color(63, 255, 0));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);

        JTextArea rulesTextArea = new JTextArea(
                "1. Welcome, young coder! Get ready for some coding fun.\n\n" +
                        "2. Answer the coding questions and earn points.\n\n" +
                        "3. Each correct answer adds to your score. Let's see how high you can go!\n\n" +
                        "4. If a question is tricky, take your time and give it your best shot.\n\n" +
                        "5. Good luck, and enjoy the coding adventure!"
        );
        rulesTextArea.setFont(TEXT_AREA_FONT);
        rulesTextArea.setForeground(new Color(255, 255, 255));
        rulesTextArea.setBackground(BACKGROUND_COLOR);
        rulesTextArea.setEditable(false);
        add(rulesTextArea, BorderLayout.CENTER);

        startButton = new JButton(START_BUTTON_LABEL);
        startButton.setBackground(BUTTON_BACKGROUND_COLOR);
        startButton.setForeground(BUTTON_FOREGROUND_COLOR);
        startButton.setFont(LABEL_FONT);
        startButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setTitle(WINDOW_TITLE);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            setVisible(false);
            new QuizApp();
        }
    }

    public static void main(String[] args) {
        new Rules("Young Coder");
    }
}



