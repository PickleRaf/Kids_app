
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
            "What is the square root of 81?",
            "If x + 5 = 12, what is the value of x?",
            "What is the area of a rectangle with length 8 and width 5?",
            "Simplify the expression: 3(2x - 4) = 18",
            "What is the sum of the first 10 prime numbers?",
            "If a = 4 and b = 7, what is the value of a^2 + b^2?",
            "What is the value of pi (π) to two decimal places?",
            "If a triangle has angles of 30°, 60°, and 90°, what is the measure of the smallest angle?"
    };
    private static final String[][] MATH_OPTIONS = {
            {"3", "4", "5", "6"},
            {"2", "4", "6", "10"},
            {"9", "8", "7", "6"},
            {"3", "7", "5", "10"},
            {"40", "13", "56", "48"},
            {"6x - 12", "6x - 24", "6x - 4", "6x - 8"},
            {"90", "129", "143", "77"},
            {"65", "65", "65", "65"},
            {"3.14", "3.15", "3.16", "3.17"},
            {"45°", "60°", "30°", "90°"}
    };

    private static final String[] MUSIC_QUESTIONS = {
            "What's the name of the Rolling Stones lead singer?",
            "Which instrument does Yo-Yo Ma play?",
            "What Beatles album features a zebra crossing on the cover?",
            "Who is known as the 'King of Pop'?",
            "In which year did Elvis Presley die?",
            "What is the name of Adele's debut album?",
            "Which rock band released the album 'Dark Side of the Moon'?",
            "Who is the lead vocalist of Queen?",
            "What is the genre of the song 'Bohemian Rhapsody'?",
            "Which rapper starred in the movie '8 Mile'?"
    };
    private static final String[][] MUSIC_OPTIONS = {
            {"Mick Jagger", "Taylor Swift", "3ami Said", "bo burnham"},
            {"Cello", "Violin", "Piano", "Trumpet"},
            {"Abbey Road", "The White Album", "Revolver", "Sgt. Pepper's Lonely Hearts Club Band"},
            {"Michael Jackson", "Elvis Presley", "Prince", "Justin Bieber"},
            {"1977", "1985", "1995", "2005"},
            {"Hello", "21", "25", "Skyfall"},
            {"The Rolling Stones", "Led Zeppelin", "Pink Floyd", "The Beatles"},
            {"Freddie Mercury", "Mick Jagger", "Axl Rose", "Robert Plant"},
            {"Rock", "Pop", "Opera", "Rap"},
            {"Eminem", "Jay-Z", "Drake", "Kanye West"}
    };

    private static final String[] SCIENCE_QUESTIONS = {
            "What is the chemical symbol for water?",
            "Who developed the theory of relativity?",
            "Which planet is known as the 'Red Planet'?",
            "What is the powerhouse of the cell?",
            "What is the largest organ in the human body?",
            "Which gas do plants absorb during photosynthesis?",
            "Who discovered penicillin?",
            "What is the atomic number of carbon?",
            "What is the speed of light?",
            "What is the main component of Earth's atmosphere?"
    };
    private static final String[][] SCIENCE_OPTIONS = {
            {"H2O", "CO2", "O2", "N2"},
            {"Isaac Newton", "Marie Curie", "Albert Einstein", "Galileo Galilei"},
            {"Mars", "Jupiter", "Venus", "Saturn"},
            {"Mitochondria", "Nucleus", "Endoplasmic Reticulum", "Ribosome"},
            {"Heart", "Brain", "Skin", "Liver"},
            {"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
            {"Alexander Fleming", "Marie Curie", "Louis Pasteur", "Florence Nightingale"},
            {"6", "12", "14", "16"},
            {"299,792,458 m/s", "150,000,000 m/s", "200,000,000 m/s", "100,000,000 m/s"},
            {"Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"}
    };

    private static final int[] MATH_CORRECT_ANSWERS = {1, 2, 0, 3, 0, 1, 2, 3, 1, 2};
    private static final int[] MUSIC_CORRECT_ANSWERS = {0, 0, 0, 0, 1, 1, 2, 0, 3, 0};
    private static final int[] SCIENCE_CORRECT_ANSWERS = {0, 2, 0, 0, 2, 1, 0, 2, 0, 1};

    private Question() {
    }
}

