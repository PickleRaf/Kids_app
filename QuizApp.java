package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp implements ActionListener {
    private int score;
    private String name;
    private int seconds = 5;
    private int currentQuestionIndex;
    private String selectedSubject;

    private JFrame frame = new JFrame();
    private JPanel initialPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Enter Your Name:");
    private JTextField nameField = new JTextField();
    private JLabel subjectLabel = new JLabel("Choose Subject:");
    private JComboBox<String> subjectComboBox = new JComboBox<>(new String[]{"Math", "Music", "Science"});
    private JButton startButton = new JButton("Start Quiz");

    private JLabel countDown = new JLabel();
    private JTextArea askedQuestion = new JTextArea();
    private JTextField questionNumber = new JTextField();
    private JRadioButton[] options;
    private JButton submitButton;

    private Timer timer;

    public QuizApp() {
        SwingUtilities.invokeLater(() -> {
            initializeInitialPanel();
            frameSettings();
        });
    }

    private void frameSettings() {
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        frame.setContentPane(initialPanel);
        frame.setVisible(true);
    }

    private void initializeInitialPanel() {
        initialPanel.setLayout(new GridLayout(4, 2, 10, 10));
        initialPanel.setBackground(Color.BLACK);

        nameLabel.setForeground(new Color(25, 255, 0));
        nameLabel.setFont(new Font("Ink Free", Font.BOLD, 20));

        nameField.setBackground(new Color(25, 25, 25));
        nameField.setForeground(new Color(25, 255, 0));
        nameField.setFont(new Font("Ink Free", Font.PLAIN, 16));

        subjectLabel.setForeground(new Color(25, 255, 0));
        subjectLabel.setFont(new Font("Ink Free", Font.BOLD, 20));

        subjectComboBox.setBackground(new Color(25, 25, 25));
        subjectComboBox.setForeground(new Color(25, 255, 0));
        subjectComboBox.setFont(new Font("Ink Free", Font.PLAIN, 16));

        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);

        initialPanel.add(nameLabel);
        initialPanel.add(nameField);
        initialPanel.add(subjectLabel);
        initialPanel.add(subjectComboBox);
        initialPanel.add(startButton);
    }

    private void initializeQuizPanel() {
        JPanel quizPanel = new JPanel();
        quizPanel.setLayout(new GridLayout(7, 1));

        countDown.setForeground(new Color(25, 255, 0));
        countDown.setFont(new Font("Ink Free", Font.BOLD, 20));

        askedQuestion.setBackground(new Color(25, 25, 25));
        askedQuestion.setForeground(new Color(25, 255, 0));
        askedQuestion.setFont(new Font("Ink Free", Font.PLAIN, 16));
        askedQuestion.setLineWrap(true);
        askedQuestion.setWrapStyleWord(true);
        askedQuestion.setEditable(false);

        questionNumber.setBackground(new Color(25, 25, 25));
        questionNumber.setForeground(new Color(25, 255, 0));
        questionNumber.setFont(new Font("Ink Free", Font.PLAIN, 16));
        questionNumber.setHorizontalAlignment(JTextField.CENTER);
        questionNumber.setEditable(false);

        options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBackground(Color.BLACK);
            options[i].setForeground(new Color(25, 255, 0));
            options[i].setFont(new Font("MV Boli", Font.PLAIN, 16));
            group.add(options[i]);
            quizPanel.add(options[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(30, 144, 254));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        quizPanel.add(submitButton);

        frame.add(quizPanel);
    }

    private void displayQuestion() {
        if (currentQuestionIndex < getQuestions().length) {
            SwingUtilities.invokeLater(() -> {
                questionNumber.setText("Question " + (currentQuestionIndex + 1));
                askedQuestion.setText(getQuestions()[currentQuestionIndex]);

                for (int i = 0; i < 4; i++) {
                    options[i].setText(getOptions()[currentQuestionIndex][i]);
                }

                startTimer();
            });
        } else {
            showScore();
        }
    }

    private void startTimer() {
        seconds = 5;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds--;
                SwingUtilities.invokeLater(() -> countDown.setText(String.valueOf(seconds)));

                if (seconds <= 0) {
                    displayAnswer(-1);
                }
            }
        });
        timer.start();
    }

    private String[] getQuestions() {
        switch (selectedSubject) {
            case "Math":
                return Question.getQuestions(selectedSubject);
            case "Music":
                return Question.getQuestions(selectedSubject);
            case "Science":
                return Question.getQuestions(selectedSubject);
            default:
                return new String[0];
        }
    }

    private String[][] getOptions() {
        switch (selectedSubject) {
            case "Math":
                return Question.getOptions(selectedSubject);
            case "Music":
                return Question.getOptions(selectedSubject);
            case "Science":
                return Question.getOptions(selectedSubject);
            default:
                return new String[0][0];
        }
    }

    private int[] getCorrectAnswers() {
        switch (selectedSubject) {
            case "Math":
                return Question.getCorrectAnswers(selectedSubject);
            case "Music":
                return Question.getCorrectAnswers(selectedSubject);
            case "Science":
                return Question.getCorrectAnswers(selectedSubject);
            default:
                return new int[0];
        }
    }

    private void showScore() {
        frame.setVisible(false);
        new Score(name, score, getQuestions().length).setVisible(true);
    }

    private int checkAnswer() {
        int index = -1;
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == getCorrectAnswers()[currentQuestionIndex]) {
                score++;
                index = i;
                break;
            }
        }
        return index;
    }

    private void displayAnswer(int index) {
        timer.stop();

        if (index != -1) {
            options[index].setForeground(Color.green);
        } else {
            index = getCorrectAnswers()[currentQuestionIndex];
            options[index].setForeground(Color.green);

            for (int i = 0; i < 4; i++) {
                if (i != index) {
                    options[i].setForeground(Color.red);
                }
            }
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetQuestionDisplay();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    private void resetQuestionDisplay() {
        for (int i = 0; i < 4; i++) {
            options[i].setForeground(Color.BLACK);
        }

        seconds = 5;
        countDown.setText(String.valueOf(seconds));
        submitButton.setEnabled(true);
        currentQuestionIndex++;
        clearSelection();
        displayQuestion();
    }

    private void clearSelection() {
        for (int i = 0; i < 4; i++) {
            options[i].setSelected(false);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        submitButton.setEnabled(false);

        if (ae.getSource() == submitButton) {
            displayAnswer(checkAnswer());
        } else if (ae.getSource() == startButton) {
            name = nameField.getText();
            selectedSubject = (String) subjectComboBox.getSelectedItem();

            SwingUtilities.invokeLater(() -> {
                frame.getContentPane().removeAll();
                initializeQuizPanel();
                displayQuestion();
                frame.repaint();
            });
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}



