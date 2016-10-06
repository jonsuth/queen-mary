import java.util.*;
/**
 * Created by Jon on 30/09/2016.
 * Program to keep a count of the birds seen and their numbers during a bird watch
 */
public class BirdWatch {
    public static void main(String[] args) {

        HashMap<String, Integer> birds = new HashMap<>();
        // Birds are stored in a hash map, key = bird name, val = bird number
        Scanner sc = new Scanner(System.in);
        String inputName;
        String mostCommonBirdName = "";
        int inputNumber;
        int mostCommonBirdNumber = 0;


        while (true) {  // Loop indefinitely until user types break command
            System.out.println("Which bird have you seen? ");
            inputName = sc.nextLine();
            if (inputName.toUpperCase().equals("END")) { break; }   // Break loop

            System.out.println("How many were in your garden at once? ");
            inputNumber = Integer.parseInt(sc.nextLine());

            if (!birds.containsKey(inputName)) {  // If bird does not exist in hash map
                birds.put(inputName, inputNumber);
            } else {
                birds.put(inputName, birds.get(inputName) + inputNumber);
            }

            if (inputNumber > mostCommonBirdNumber) {  // If the bird has been seen the most so far, save it
                mostCommonBirdName = inputName;
                mostCommonBirdNumber = inputNumber;
            }
        }

        System.out.println("You saw " + mostCommonBirdNumber + " " + mostCommonBirdName + "s.");
        System.out.println("It was the most common bird seen at one time in your garden.");

    }
}