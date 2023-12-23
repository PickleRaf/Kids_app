
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizApp extends JFrame implements ActionListener {

    private String name;
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;

    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;

    public QuizApp(String name) {
        this.name = name;
        this.questions = initializeQuestions();
        this.currentQuestionIndex = 0;
        this.score = 0;

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBackground(Color.WHITE);

        options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            options[i].setBackground(Color.WHITE);
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setBackground(new Color(30, 144, 254));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        displayQuestion();

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ArrayList<Question> initializeQuestions() {
        // Add your coding questions here
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What does HTML stand for?", "Hyper Text Markup Language", "Hyper Transfer Markup Language", "High Text Markup Language", "Hyper Technical Markup Language", 0));
        questions.add(new Question("What is the output of the following code: print(2 + 3 * 4)", "20", "14", "15", "23", 3));
        // Add more questions as needed
        return questions;
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);

            questionLabel.setText(currentQuestion.getQuestion());

            for (int i = 0; i < 4; i++) {
                options[i].setText(currentQuestion.getOptions()[i]);
            }
        } else {
            showScore();
        }
    }

    private void showScore() {
        setVisible(false);
        new Score(name, score, questions.size()).setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == nextButton) {
            checkAnswer();
            currentQuestionIndex++;
            clearSelection();
            displayQuestion();
        }
    }

    private void checkAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == currentQuestion.getCorrectOption()) {
                score++;
                break;
            }
        }
    }

    private void clearSelection() {
        for (int i = 0; i < 4; i++) {
            options[i].setSelected(false);
        }
    }

}



