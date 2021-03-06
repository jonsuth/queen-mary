import java.util.*;
/**
 * Created by Jon Suthakaran on 30/09/2016.
 * A program for keeping track of the number of endangered animals in the wild
 */
public class Arrays {
    public static void main(String[] args) {
        ArrayList<String> animalNames = populateArray();
        ArrayList<Integer> animalNumbers = new ArrayList<>();  // Integer array list for the numbers of the animal
        // There is a one to one correspondence between the two array lists

        int animalNumber;

        for (String animal : animalNames) {  // For each animal in the array list
            animalNumber = getAnimalNumber(animal);  // Get the number this animal
            animalNumbers.add(animalNames.indexOf(animal), animalNumber);
            System.out.println();
            // Add number to animalNumbers array using the index of the animal from the animalNames array
        }

        showMostEndangered(animalNames, animalNumbers);
    }

    /**
     * Gets the animal number from user, error checks for int input
     * @param animal
     * @return animalNumber
     */
    private static int getAnimalNumber(String animal) {  //
        Scanner sc = new Scanner(System.in);
        int animalNumber;
        while (true) {
            System.out.println(animal);
            System.out.println("How many are left in the wild? ");
            try {
                animalNumber = Integer.parseInt(sc.nextLine());
                if (animalNumber > 0) {
                    return animalNumber;
                } else {
                    System.out.println("Error please enter a valid number > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error please enter a number");
            }
            System.out.println();
        }
    }

    /**
     * Finds the most endangered animal in the array list
     * @param animalNames
     * @param animalNumbers
     */
    private static void showMostEndangered(ArrayList<String> animalNames, ArrayList<Integer> animalNumbers) {
        int min = animalNumbers.get(0);  // Let min be the first value of the array list

        for (int animalNumber : animalNumbers) {
            System.out.println(animalNames.get(animalNumbers.indexOf(animalNumber)) + ", " + animalNumber);
            if (animalNumber <= min) {
                min = animalNumber;
            }
        }
        System.out.println("The most endangered animal is the " + animalNames.get(animalNumbers.indexOf(min)) +
                            ". There are only "  + min +  " in the wild.");
    }

    /**
     * String array list for names of the animal
     * Populates the array list
     * @return animalNames
     */
    private static ArrayList<String> populateArray() {
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add(0, "Komodo Dragon");
        animalNames.add(1, "Manatee");
        animalNames.add(2, "Kakapo");
        animalNames.add(3, "Florida Panther");
        animalNames.add(4, "White Rhino");

        return animalNames;
    }

}