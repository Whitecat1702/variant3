import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FutureSimpleTest {
    public static void main(String[] args) {
        Map<String, String> questions = createQuestions();
        int totalQuestions = questions.size();
        int correctAnswers = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Future Simple Test!");
        System.out.println("Answer the following 5 questions by entering the corresponding letter (a, b, c, or d).");
        System.out.println("Enter 'q' at any time to quit.");

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();

            System.out.println("\n" + question);

            String userAnswer;
            while (true) {
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine();

                if (userAnswer.equals("q")) {
                    System.out.println("Test aborted.");
                    return;
                } else if (userAnswer.matches("[a-d]")) {
                    break;
                } else {
                    System.out.println("Invalid option. Please enter a valid answer (a, b, c, or d).");
                }
            }

            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect!");
                System.out.println("The correct answer is: " + answer);
            }
        }

        double score = (double) correctAnswers / totalQuestions * 100;
        System.out.println("\nTest completed!");
        System.out.println("Your score: " + score + "%");

        System.out.print("Enter password to view correct answers (or 'q' to quit): ");
        String password = scanner.nextLine();
        if (password.equals("q")) {
            System.out.println("Program terminated.");
        } else if (password.equals("1111")) {
            System.out.println("\nCorrect answers:");
            for (Map.Entry<String, String> entry : questions.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            System.out.println("Invalid password. Program terminated.");
        }
    }

    private static Map<String, String> createQuestions() {
        Map<String, String> questions = new HashMap<>();
        questions.put("1. Choose the correct form of the verb: We _______ to the party tomorrow.",
                "c");
        questions.put("a) will go\nb) go\nc) are going\nd) goes", "a");
        questions.put("2. She _______ her exams next week.",
                "b");
        questions.put("a) will finish\nb) finishes\nc) finished\nd) finish", "a");
        questions.put("3. They _______ a new house next month.",
                "d");
        questions.put("a) buy\nb) will buy\nc) bought\nd) are going to buy", "b");
        questions.put("4. I _______ you later tonight.",
                "a");
        questions.put("a) will call\nb) calls\nc) called\nd) call", "a");
        questions.put("5. The train _______ at 10 AM tomorrow.",
                "c");
        questions.put("a) arrives\nb) arrived\nc) will arrive\nd) arriving", "c");
        return questions;
    }
}
