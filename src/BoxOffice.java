import java.util.*;
/**
 * Created by Jon Suthakaran on 05/10/2016.
 *
 */
public class BoxOffice {
    public static void main(String[] args) {
        ArrayList<Film> films = new ArrayList<>();  // Array list holds all films in the box office

        for (int i = 0; i< 4; i++) {  // Loop to populate the box office
            films = populateFilms(films, i+1);
        }

        showFilms(films);  // Lists all films at the end
    }

    /**
     * Populates the array list with films of object type Film.
     * The fields for the film are received from the user.
     * @param films
     * @param screen
     * @return films
     */
    public static ArrayList<Film> populateFilms(ArrayList<Film> films, int screen) {
        Scanner sc = new Scanner(System.in);
        String title;
        int hour;
        int minute;
        Film film;

            System.out.println("Film for screen " + screen + "? ");
            title = sc.nextLine();
            while (true) {  // Loop until correct time is inputted
                System.out.println("What time does it start? Hour (24 Hour clock - 0-23)");
                hour = sc.nextInt();

                System.out.println("What time does it start? Minutes after hour (0-60)");
                minute = sc.nextInt();

                film = createFilm(title, hour, minute, screen);  // Try create film Returns null if film cant be created

                if (film != null) { // Break loop if film was created
                    break;
                }
            }

        films.add(film);

        System.out.println();
        return films;  // Return the array list of films
    }

    /**
     * Displays all films in the films array, pads title to fit 25 chars
     * @param films
     */
    public static void showFilms(ArrayList<Film> films) {
        System.out.println("CinemaWorld Films Tonight");
        for (Film film: films) {
            System.out.println("Screen " + film.getScreen()
                    + ": " + String.format("%1$-25s",film.getTitle())
                    + " " + film.getHour()
                    + ":" + film.getMinute());
        }
    }

    /**
     * Checks the fields of the film and creates a Film object
     * @param title
     * @param hour
     * @param minute
     * @param screen
     * @return film
     */
    public static Film createFilm(String title, int hour, int minute, int screen) {
        Film film = new Film();
        film.setScreen(screen);
        film.setTitle(title);

        if (errorCheckTime(hour, minute)) {  // If the minute and hours conform to the standards
            if (minute == 60) {  // Rollover the hour if the minute is 60
                if ((hour + 1) == 24) {  // Rollover the hour to midnight if it reaches 24
                    hour = 0;
                } else {
                    hour++;
                }
                minute = 0;

                // If the start time has changed due to rollovers let the user know
                System.out.println("Start time for this film has changed to "
                        + String.format("%02d", hour)
                        + ":"
                        + String.format("%02d", minute));
            }
            film.setHour(String.format("%02d", hour));
            film.setMinute(String.format("%02d", minute));
        } else {
            System.out.println("Error with time, please try again");
            return null;
        }
        return film;
    }

    /**
     * Checks that the time is in range
     * @param hour
     * @param minute
     * @return true/false
     */
    public static boolean errorCheckTime(int hour, int minute) {
        return ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 60));
    }

}

/**
 * Class that represents a single film
 */
class Film {
    private String title;
    private String hour;
    private String minute;
    private int screen;

    String getTitle() { return title; }
    String getHour() { return hour; }
    String getMinute() { return minute; }
    int getScreen() { return screen; }

    void setTitle(String title) { this.title = title; }
    void setHour(String hour) { this.hour = hour; }
    void setMinute(String minute) { this.minute = minute; }
    void setScreen(int screen) { this.screen = screen; }
}
