import java.util.*;
/**
 * Created by Jon Suthakaran on 30/09/2016.
 * A program for keeping track of the number of endangered animals in the wild
 */
public class Arrays {
    public static void main(String[] args) {
        ArrayList<String> animalNames = new ArrayList<>();  // String array list for names of the animal
        ArrayList<Integer> animalNumbers = new ArrayList<>();  // Integer array list for the numbers of the animal
        // There is a one to one correspondence between the two array lists
        // Array list is used since itr maintains insertion order

        int animalNumber;

        // Populate the array list
        animalNames.add(0, "Komodo Dragon");
        animalNames.add(1, "Manatee");
        animalNames.add(2, "Kakapo");
        animalNames.add(3, "Florida Panther");
        animalNames.add(4, "White Rhino");

        for (String animal : animalNames) {  // For each animal in the array list
            animalNumber = getAnimalNumber(animal);  // Get the number this animal
            animalNumbers.add(animalNames.indexOf(animal), animalNumber);
            System.out.println();
            // Add number to animalNumbers array using the index of the animal from the animalNames array
        }

        showMostEndangered(animalNames, animalNumbers);
    }

    /**
     * Gets the animal number from user
     * @param animal
     * @return animalnumber
     */
    public static int getAnimalNumber(String animal) {  //
        Scanner sc = new Scanner(System.in);
        System.out.println(animal);
        System.out.println("How many are left in the wild? ");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * Finds the most endangered animal in the array list
     * @param animalNames
     * @param animalNumbers
     */
    public static void showMostEndangered(ArrayList<String> animalNames, ArrayList<Integer> animalNumbers) {
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

}