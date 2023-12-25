package ihm;

public final class Question {
    private static String playerName;

    public static void setName(String name) {
        playerName = name;
    }

    public static String[] getQuestions(String selectedSubject) {
        switch (selectedSubject) {
            case "Math":
                return MATH_QUESTIONS;
            case "Music":
                return MUSIC_QUESTIONS;
            case "Science":
                return SCIENCE_QUESTIONS;
            default:
                return new String[0];
        }
    }

    public static String[][] getOptions(String selectedSubject) {
        switch (selectedSubject) {
            case "Math":
                return MATH_OPTIONS;
            case "Music":
                return MUSIC_OPTIONS;
            case "Science":
                return SCIENCE_OPTIONS;
            default:
                return new String[0][0];
        }
    }

    public static int[] getCorrectAnswers(String selectedSubject) {
        switch (selectedSubject) {
            case "Math":
                return MATH_CORRECT_ANSWERS;
            case "Music":
                return MUSIC_CORRECT_ANSWERS;
            case "Science":
                return SCIENCE_CORRECT_ANSWERS;
            default:
                return new int[0];
        }
    }

    private static final String[] MATH_QUESTIONS = {
            "What is the result of 2 + 2?",
            "Solve the equation: 3x - 7 = 5.",
            "What is the square root of 81?"
    };
    private static final String[][] MATH_OPTIONS = {
            {"3", "4", "5", "6"},
            {"2", "4", "6", "10"},
            {"9", "8", "7", "6"}
    };

    private static final String[] MUSIC_QUESTIONS = {
            "What did Taylor Swift have for dinner?",
            "Which instrument does Yo-Yo Ma play?",
            "What Beatles album features a zebra crossing on the cover?"
    };
    private static final String[][] MUSIC_OPTIONS = {
            {"Food", "Something", "Your Mom", "She Serves Doesn't Eat"},
            {"Cello", "Violin", "Piano", "Trumpet"},
            {"Abbey Road", "The White Album", "Revolver", "Sgt. Pepper's Lonely Hearts Club Band"}
    };

    private static final String[] SCIENCE_QUESTIONS = {
            "What is the chemical symbol for water?",
            "Who developed the theory of relativity?",
            "Which planet is known as the 'Red Planet'?"
    };
    private static final String[][] SCIENCE_OPTIONS = {
            {"H2O", "CO2", "O2", "N2"},
            {"Isaac Newton", "Marie Curie", "Albert Einstein", "Galileo Galilei"},
            {"Mars", "Jupiter", "Venus", "Saturn"}
    };

    private static final int[] MATH_CORRECT_ANSWERS = {1, 2, 0};
    private static final int[] MUSIC_CORRECT_ANSWERS = {0, 0, 0};
    private static final int[] SCIENCE_CORRECT_ANSWERS = {0, 2, 0};

    private Question() {
    }
}



