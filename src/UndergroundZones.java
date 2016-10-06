import java.util.*;
/**
 * Created by Jon Suthakaran on 28/09/2016.
 * A program that tells people the underground zone of a station
 */
public class UndergroundZones {
    public static void main(String[] args) {
        while (true) {  // Loop indefinitely until told to break
            Scanner sc = new Scanner(System.in);
            System.out.println("What station do you need to know the zone of? (press 'q' to quit): ");
            String input = sc.nextLine();
            if (input.equals("q")){
                break;  // Break the loop
            } else {
                int zone = zoneChecker(input);
                if (zone == 0) {  // 0 if invalid input is given
                    System.out.println("Invalid input, please enter a valid station name");
                } else {
                    System.out.println(input + " is in Zone " + zone);
                }
            }
        }
    }

    /**
     * Checks the station name of the user input and returns the result of the corresponding method
     * @param input
     * @return station
     */
    public static int zoneChecker(String input) {  //
        // Converts user input to lower case for better comparison
        if (input.toLowerCase().equals("mile end")) {
            return mileEndStation();
        } else if (input.toLowerCase().equals("victoria")) {
            return victoriaStation();
        } else if (input.toLowerCase().equals("walthamstow central")) {
            return walthamstowStation();
        } else if (input.toLowerCase().equals("woodford")) {
            return woodfordStation();
        } else if (input.toLowerCase().equals("cockfosters")) {
            return cockfostersStation();
        } else {
            return 0;  // Return 0 if the station name is not on the list of invalid
        }
    }

    public static int victoriaStation() {
        return 1;
    }

    public static int mileEndStation() {
        return 2;
    }

    public static int walthamstowStation() {
        return 3;
    }

    public static int woodfordStation() {
        return 4;
    }

    public static int cockfostersStation() {
        return 5;
    }
}
