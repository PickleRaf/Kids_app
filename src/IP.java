
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IP implements ActionListener {

    private JFrame frame;
    private JTextField nameTextField;
    private JComboBox<String> subjectComboBox;
    private JComboBox<String> difficultyComboBox;
    private JButton startButton;

    public IP() {
        frame = new JFrame("Quiz Subject and Difficulty");
        frame.setSize(650, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        createPanel();

        frame.setVisible(true);
    }

    private void createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBackground(new Color(25, 25, 25));

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setForeground(new Color(25, 255, 0));
        nameTextField = new JTextField();
        nameTextField.setBackground(new Color(25, 25, 25));
        nameTextField.setForeground(new Color(255, 255, 255));

        JLabel subjectLabel = new JLabel("Choose Subject:");
        subjectLabel.setForeground(new Color(25, 255, 0));
        String[] subjects = {"Music", "Math", "Science"};
        subjectComboBox = new JComboBox<>(subjects);
        subjectComboBox.setBackground(new Color(25, 25, 25));
        subjectComboBox.setForeground(new Color(255, 255, 255));

        JLabel difficultyLabel = new JLabel("Choose Difficulty:");
        difficultyLabel.setForeground(new Color(25, 255, 0));
        String[] difficulties = {"Easy", "Medium", "Hard"};
        difficultyComboBox = new JComboBox<>(difficulties);
        difficultyComboBox.setBackground(new Color(25, 25, 25));
        difficultyComboBox.setForeground(new Color(255, 255, 255));

        startButton = new JButton("Start Quiz");
        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(subjectLabel);
        panel.add(subjectComboBox);
        panel.add(difficultyLabel);
        panel.add(difficultyComboBox);
        panel.add(startButton);

        frame.add(panel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JComboBox<String> getSubjectComboBox() {
        return subjectComboBox;
    }

    public void setSubjectComboBox(JComboBox<String> subjectComboBox) {
        this.subjectComboBox = subjectComboBox;
    }

    public JComboBox<String> getDifficultyComboBox() {
        return difficultyComboBox;
    }

    public void setDifficultyComboBox(JComboBox<String> difficultyComboBox) {
        this.difficultyComboBox = difficultyComboBox;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            String playerName = nameTextField.getText();
            String selectedSubject = (String) subjectComboBox.getSelectedItem();
            String selectedDifficulty = (String) difficultyComboBox.getSelectedItem();
            if (playerName.trim().isEmpty() || selectedSubject == null) {
                JOptionPane.showMessageDialog(frame, "Please enter your name and select a subject.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new QuizApp(playerName, selectedSubject, selectedDifficulty);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IP());
    }

    public void addActionListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}


