import java.util.*;
/**
 * Created by Jon Suthakaran on 05/10/2016.
 * A program that calculates the amount of bonus an employee gains based on their profit and hard work scores.
 */
public class BonusScheme {

    public static void main(String[] args) {
        int profitScore = readProfitScore();
        int hardWorkScore = readHardWorkScore();

        Employee employee = new Employee(profitScore, hardWorkScore);
        // Creates new employee object using the profit and hard work scores.

        employee.setPerformanceScore(calculatePerformanceScore(employee));
        employee.setBonus(calculateBonus(employee.getPerformanceScore()));

        System.out.println("Your performance score this year is " + employee.getPerformanceScore() + " out of 10.");
        System.out.println("Your bonus is " + employee.getBonus() + " pounds.");
    }

    /**
     * Get profit score from user
     * @return profitScore
     */
    private static int readProfitScore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Profit score? ");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Get hard work score from user
     * @return hardWorkScore
     */
    private static int readHardWorkScore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hard work score? ");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Calculate performance score by adjusting the profit score and the hard work score and adding the two.
     * @param employee
     * @return
     */
    private static int calculatePerformanceScore(Employee employee) {
        int newProfitScore = adjustProfitScore(employee.getProfitScore());
        int newHardWorkScore = adjustHardWorkScore(employee.getHardWorkScore());
        return (newProfitScore + newHardWorkScore)/7;
    }

    /**
     * Calculates the new profit score based on the formula.
     * @param profitScore
     * @return adjustedProfitScore
     */
    private static int adjustProfitScore(int profitScore) {
        return profitScore*2;
    }

    /**
     * Calculates the new hard work score based on the formula.
     * @param hardWorkScore
     * @return adjustedHardWorkScore
     */
    private static int adjustHardWorkScore(int hardWorkScore) {
        return hardWorkScore*5;
    }

    /**
     * Calculates the bonus based on the formula.
     * @param performanceScore
     * @return bonusScore
     */
    private static int calculateBonus(int performanceScore) {
        return performanceScore * 5000;
    }
}

/**
 * Employee class
 * Create a new employee given profit score and hard work score.
 */
class Employee {

    private int profitScore;
    private int hardWorkScore;
    private int performanceScore;
    private int bonus;

    int getProfitScore() {
        return profitScore;
    }

    int getHardWorkScore() {
        return hardWorkScore;
    }

    int getPerformanceScore() {
        return performanceScore;
    }

    int getBonus() {
        return bonus;
    }

    void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Employee(int profitScore, int hardWorkScore) {
        this.profitScore = profitScore;
        this.hardWorkScore = hardWorkScore;
    }

}