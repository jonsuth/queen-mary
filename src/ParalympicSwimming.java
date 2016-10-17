import java.util.*;
/**
 * Created by Jon Suthakaran on 30/09/2016.
 * A program to check the legality score of runners in a paralympic relay
 */
public class ParalympicSwimming {
    public static void main(String[] args) {
        int total = 0;

        for (int i = 0; i < 4; i++) {  // Loop until i = 3, loops 4 times
            total += getRunnerScore(i+1);  // Get the score for this runner. Runner number is i+1 because of zero based
        }

        if (checkLegality(total)) {
            System.out.println("That team has " + total + " points so it is legal");
        } else {
            System.out.println("That team has " + total + " points so it is NOT legal");
        }

    }

    /**
     * Get the score for this runner from the user
     * @param i
     * @return runnerScore
     */
    private static int getRunnerScore(int i) {
        Scanner sc = new Scanner(System.in);
        int score;
        while (true) {  // Loop indefinitely
            System.out.println("What is the disability class of runner " + i + "?  (0-10)");
            try {
                score = Integer.parseInt(sc.nextLine());  // Try parse string to int
                if (validateScore(score)) {
                    return score;
                } else {
                    System.out.println("Error, please enter a valid score between 0-10");
                }
            } catch (NumberFormatException e) {  // If string is un-parsable
                System.out.println("Error, please enter a valid score between 0-10");
            }
        }

    }

    /**
     * Checks the legality of the combined score and returns true or false
     * @param total
     * @return legality
     */
    private static boolean checkLegality(int total) { return total < 32; }

    /**
     *
     * @param score
     * @return true/false
     */
    private static boolean validateScore(int score) { return score >= 0 && score <= 10; }
}
