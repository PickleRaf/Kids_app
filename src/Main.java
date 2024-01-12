
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IP ip = new IP();
            ip.addActionListener(event -> {
                SwingUtilities.invokeLater(() -> {
                    String playerName = ip.getNameTextField().getText();
                    String selectedSubject = (String) ip.getSubjectComboBox().getSelectedItem();
                    String selectedDifficulty = (String) ip.getDifficultyComboBox().getSelectedItem();
                    new QuizApp(playerName, selectedSubject, selectedDifficulty);
                });
            });
        });
    }
}


	


