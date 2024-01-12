
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp implements ActionListener {

    private int score;
    private String name;
    private int seconds ;
    private int secondsHold ;
    private int currentQuestionIndex;
    private String playerName;
    private String selectedSubject;
    private String selectedDifficulty;

    private JFrame frame = new JFrame();
    private JLabel countDown = new JLabel();
    private JLabel remainingTime = new JLabel();
    private JTextArea askedQuestion = new JTextArea();
    private JTextField questionNumber = new JTextField();
    private JRadioButton[] options;
    private JButton submitButton;

    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            countDown.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer(-1);
            }
        }
    });

    public QuizApp(String name, String selectedSubject, String selectedDifficulty) {

        this.name = name;
        this.selectedSubject = selectedSubject;
        this.selectedDifficulty = selectedDifficulty;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.playerName = playerName;

        if(selectedDifficulty=="Easy") {
        	seconds = 30;
        	secondsHold = 30;
        }else if(selectedDifficulty=="Medium") {
        		seconds = 20;
        		secondsHold = 20;
        	 }else {
        		 seconds = 10;	
        		 secondsHold = 10;	
        	 }
        
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        questionNumber.setBounds(0, 0, 650, 50);
        questionNumber.setBackground(new Color(25, 25, 25));
        questionNumber.setForeground(new Color(25, 255, 0));
        questionNumber.setFont(new Font("Ink Free", Font.BOLD, 30));
        questionNumber.setBorder(BorderFactory.createBevelBorder(1));
        questionNumber.setHorizontalAlignment(JTextField.CENTER);
        questionNumber.setEditable(false);
        frame.add(questionNumber);

        askedQuestion.setBounds(0, 50, 650, 75);
        askedQuestion.setLineWrap(true);
        askedQuestion.setWrapStyleWord(true);
        askedQuestion.setBackground(new Color(25, 25, 25));
        askedQuestion.setForeground(new Color(25, 255, 0));
        askedQuestion.setFont(new Font("MV Boli", Font.BOLD, 25));
        askedQuestion.setBorder(BorderFactory.createBevelBorder(1));
        askedQuestion.setEditable(false);
        frame.add(askedQuestion);

        remainingTime.setBounds(175, 150, 100, 25);
        remainingTime.setBackground(new Color(50, 50, 50));
        remainingTime.setForeground(new Color(255, 0, 0));
        remainingTime.setFont(new Font("MV Boli", Font.PLAIN, 30));
        remainingTime.setHorizontalAlignment(JTextField.CENTER);
        remainingTime.setText("Time :");
        frame.add(remainingTime);

        countDown.setBounds(275, 125, 100, 75);
        countDown.setBackground(new Color(25, 25, 25));
        countDown.setForeground(new Color(255, 0, 0));
        countDown.setFont(new Font("Ink Free", Font.BOLD, 40));
        countDown.setBorder(BorderFactory.createBevelBorder(1));
        countDown.setOpaque(true);
        countDown.setHorizontalAlignment(JTextField.CENTER);
        countDown.setText(String.valueOf(seconds));
        frame.add(countDown);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBackground(Color.BLACK);
        optionsPanel.setBounds(0, 200, 650, 300);

        options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            options[i].setForeground(Color.BLACK);
            options[i].setBackground(Color.GRAY);
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        frame.add(optionsPanel);

        submitButton = new JButton("Submit");
        submitButton.setBounds(275, 550, 100, 55);
        submitButton.setBackground(new Color(30, 144, 254));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        frame.add(submitButton);

        displayQuestion();

        frame.setVisible(true);
    }

    private void displayQuestion() {
        if (selectedSubject != null && currentQuestionIndex < getCurrentQuestions().length) {
            questionNumber.setText("Question " + (currentQuestionIndex + 1));
            askedQuestion.setText(getCurrentQuestions()[currentQuestionIndex]);

            for (int i = 0; i < 4; i++) {
                options[i].setText(getCurrentOptions()[currentQuestionIndex][i]);
            }

            timer.start();
        } else {
            showScore();
        }}

    private String[] getCurrentQuestions() {
        return Question.getQuestions(selectedSubject);
    }

    private String[][] getCurrentOptions() {
        return Question.getOptions(selectedSubject);
    }

   
    private void showScore() {
        frame.setVisible(false);
        new Score(playerName, score, Question.getQuestions(selectedSubject).length).setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        submitButton.setEnabled(false);

        if (ae.getSource() == submitButton) {
            displayAnswer(checkAnswer());
        }
    }

    private void displayAnswer(int index) {
        timer.stop();

        if (index != -1) {
            options[index].setForeground(Color.green);
        } else {
            index = Question.getCorrectAnswers(selectedSubject)[currentQuestionIndex];
            options[index].setForeground(Color.green);

            for (int i = 0; i < 4; i++) {
                if (i != index) {
                    options[i].setForeground(Color.red);
                }
            }
        }

        Timer pause = new Timer(2000, e -> {
            for (int i = 0; i < 4; i++) {
                options[i].setForeground(Color.BLACK);
            }

            seconds = secondsHold;
            countDown.setText(String.valueOf(seconds));
            submitButton.setEnabled(true);
            currentQuestionIndex++;
            clearSelection();
            displayQuestion();
        });

        pause.setRepeats(false);
        pause.start();
    }

    private int checkAnswer() {
        int index = -1;
        int[] correctAnswers = Question.getCorrectAnswers(selectedSubject);

        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == correctAnswers[currentQuestionIndex]) {
                score++;
                index = i;
                break;
            }
        }

        return index;
    }

    private void clearSelection() {
        for (int i = 0; i < 4; i++) {
            options[i].setSelected(false);
        }
    }

    
}
