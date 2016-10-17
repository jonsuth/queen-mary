import java.util.*;
/**
 * Created by Jon Suthakaran on 30/09/2016.
 * A program that gives information about paintings in an art gallery
 */
public class ArtGallery {
    public static void main(String[] args) {

        Painting painting1 = new Painting("on the left",
                "Olga Boznanska",
                "Girl with Chrysanthemums",
                1894, 88.5, 69.0);

        Painting painting2 = new Painting("ahead of you",
                "Mary Cassatt",
                "Woman with a Pearl Necklace in a Loge",
                1879, 81.3, 59.7);

        Painting painting3 = new Painting("ahead of you",
                "Rembrandt",
                "Self-Portrait with Beret and Turned-Up Collar",
                1659, 84.5, 66.0);

        Painting painting4 = new Painting("on your right",
                "Claude Monet",
                "Impression, Sunrise",
                1872, 48.0, 63.0);
        // Initialise the 4 paintings

        Scanner sc = new Scanner(System.in);
        String input;
        int inputToInt;  // Holds the int parsed version of the string

        while (true) {  // Loop indefinitely
            System.out.println("What room are you in? (press 'q' to quit) ");
            input = sc.nextLine();
            if (input.toLowerCase().equals("q")) {  // Exit loop
                break;
            } else {
                try {
                    inputToInt = Integer.parseInt(input);  // Parse to int and check for room
                    if (inputToInt == 1) {
                        paintingDescriptor(painting1);
                    } else if (inputToInt == 2) {
                        paintingDescriptor(painting2);
                    } else if (inputToInt == 3) {
                        paintingDescriptor(painting3);
                    } else if (inputToInt == 4) {
                        paintingDescriptor(painting4);
                    } else {
                        System.out.println("That room does not exist, please try again");
                    }
                } catch (Exception e ) {  // Catch error for parsing
                    System.out.println("That room does not exist, please try again");
                }
            }

            System.out.println();
        }
    }
        /**
         * Creates the description for this painting and prints it out
         * @param painting
         */
    private static void paintingDescriptor(Painting painting) {  // Prints out the paintings description
        System.out.println("The painting " + painting.getDirection() + " is by "
                + painting.getArtist() + ". It was painted in "
                + painting.getYear() + " and is called "
                + painting.getTitle() + ". It is "
                + painting.getHeight() + "cm by "
                + painting.getWidth() + "cm.");
    }
}

/**
 * Painting class, defines a painting
 */
class Painting {
    private String direction;
    private String artist;
    private String title;
    private int year;
    private double height;
    private double width;

    String getDirection() { return direction; }
    String getArtist() { return artist; }
    String getTitle() { return title; }
    int getYear() { return year; }
    double getHeight() { return height; }
    double getWidth() { return width; }

    Painting(String direction, String artist, String title, int year, double height, double width) {
        this.direction = direction;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.height = height;
        this.width = width;
    }
}
