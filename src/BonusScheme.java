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
        int performanceScore = calculatePerformanceScore(employee);
        int bonus = calculateBonus(performanceScore);

        System.out.println("Your performance score this year is " + performanceScore + " out of 10.");
        System.out.println("Your bouns is " + bonus + " pounds.");
    }

    public static int readProfitScore() {  // Get profit score from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Profit score? ");
        return Integer.parseInt(sc.nextLine());
    }

    public static int readHardWorkScore() {  // Get hard work score from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Hard work score? ");
        return Integer.parseInt(sc.nextLine());
    }

    public static int calculatePerformanceScore(Employee employee) {
        int newProfitScore = calculateNewProfitScore(employee.getProfitScore());
        int newHardWorkScore = calculateNewHardWorkScore(employee.getHardWorkScore());
        return (newProfitScore + newHardWorkScore)/7;
    }

    public static int calculateNewProfitScore(int profitScore) {   // Calculates the new profit score based on the formula.
        return profitScore*2;
    }

    public static int calculateNewHardWorkScore(int hardWorkScore) {  // Calculates the new hard work score based on the formula.
        return hardWorkScore*5;
    }

    public static int calculateBonus(int performanceScore) {  // Calculates the bonus based on the formula.
        return performanceScore * 5000;
    }
}

/**
 * Employee class
 * Contains profit score and hard work score fields
 */
class Employee {

    int profitScore;
    int hardWorkScore;

    public int getProfitScore() {
        return profitScore;
    }

    public void setProfitScore(int profitScore) {
        this.profitScore = profitScore;
    }

    public int getHardWorkScore() {
        return hardWorkScore;
    }

    public void setHardWorkScore(int hardWorkScore) {
        this.hardWorkScore = hardWorkScore;
    }

    public Employee(int profitScore, int hardWorkScore) {
        this.profitScore = profitScore;
        this.hardWorkScore = hardWorkScore;
    }
}