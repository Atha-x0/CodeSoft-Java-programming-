import java.util.Scanner;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctAnswer;

    public QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // quiz questions
        QuizQuestion[] questions = {
            new QuizQuestion("2+10", new String[]{"15", "12", "10"}, 2),
            new QuizQuestion("What is the capital of Maharashtra?", new String[]{"Nagpur", "Mumbai", "Lucknow"}, 2),
            new QuizQuestion("What is the capital of India?", new String[]{"Delhi", "Mumbai", "Nagpur"}, 1),
            new QuizQuestion("Which city is famous for Oranges?", new String[]{"Amravti", "Pune", "Nagpur"}, 3),
            new QuizQuestion("Which of the following is brand name of Smartphone manufacture company?", new String[]{"Samsung", "BMW", "Hp"},1 ),
        };

        int score = 0;

        for (QuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            for (int i = 0; i < question.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }

            System.out.print("Enter your answer (1-" + question.getOptions().length + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " +
                        question.getOptions()[question.getCorrectAnswer() - 1]);
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}
