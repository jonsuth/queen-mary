import java.util.*;
/**
 * Created by Jon Suthakaran on 28/09/2016.
 * Program that calculates the users fitness age and indicates whether the user is fitter than their actual age.
 */
public class FitnessAge {
    public static void main(String[] args) {
        int score1 = getScore1();
        int score2 = getScore2();
        int average = (score1+score2)/2;
        int PCFitAge = getPCFitAge(average);
        System.out.println("Your average score is " + average);
        System.out.println("Your PC fit age is " + PCFitAge + " years old.");
        int age = getAge();
        System.out.println("You are " + (age - PCFitAge) + " years away from your PC Fit age");
    }

    /**
     * Get score 1
     * @return score1
     */
    public static int getScore1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Score for fitness test 1? (0-40): ");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Get score 2
     * @return score2
     */
    public static int getScore2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Score for fitness test 2?(0-40): ");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Calculate fitness age
     * @param average
     * @return fitnessAge
     */
    public static int getPCFitAge(int average) { return ((average*8)/5)+10; }

    public static int getAge() {  // Get users actual age
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your actual age? ");
        return Integer.parseInt(sc.nextLine());
    }
}
