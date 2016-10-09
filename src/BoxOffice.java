import java.util.*;
/**
 * Created by Jon Suthakaran on 05/10/2016.
 * A program that simulates a simple box office
 * Allows input for film showings and displays the showings at the end of the program
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
    private static ArrayList<Film> populateFilms(ArrayList<Film> films, int screen) {
        String title;
        Film film;
        Time time;
            while (true) {  // Loop until all films have been created

                title = readTitle(screen);
                time = new Time(readHour(), readMinute()); // Create time input with readings from user
                film = createFilm(title, time, screen);  // Try create film Returns null if film cant be created

                if (film != null) { // Break loop if film was created else continue
                    break;
                }
            }

        films.add(film);
        System.out.println();
        return films;  // Return the array list of films
    }

    /**
     * Get title name from user.
     * @param screen
     * @return title
     */
    private static String readTitle(int screen) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Film for screen " + screen + "?");
        return sc.nextLine();
    }

    /**
     * Get film starting hour from user.
     * @return hour
     */
    private static int readHour() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What time does it start? Hour (24 Hour clock - 0-23)");
        return sc.nextInt();
    }

    /**
     * Get film starting minute from user.
     * @return minute
     */
    private static int readMinute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What time does it start? Minutes after hour (0-60)");
        return sc.nextInt();
    }

    /**
     * Displays all films in the films array, pads title to fit 25 chars.
     * @param films
     */
    private static void showFilms(ArrayList<Film> films) {
        System.out.println("CinemaWorld Films Tonight");
        for (Film film: films) {
            System.out.println("Screen " + film.getScreen()
                    + ": " + String.format("%1$-25s",film.getTitle())
                    + " " + String.format("%02d", film.getTime().getHour())
                    + ":" + String.format("%02d", film.getTime().getMinute()));
        }
    }

    /**
     * Checks the fields of the film and creates a Film object.
     * Returns null if film object cant be created (bad fields).
     * @param title
     * @param time
     * @param screen
     * @return film/null
     */
    private static Film createFilm(String title, Time time, int screen) {

        if (checkTime(time.getHour(), time.getMinute())) {  // If the minute and hours conform to the standards
            time = adjustTime(time);  // Adjust time for any rollovers
            return new Film(title, time, screen);
        } else {
            System.out.println("Error with time, please try again");
            return null;
        }
    }

    /**
     * Checks that the time is in range
     * @param hour
     * @param minute
     * @return true/false
     */
    private static boolean checkTime(int hour, int minute) {
        return ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 60));
    }

    /**
     * Rollover the hour and minute if needed else do nothing
     * @param time
     * @return time
     */
    private static Time adjustTime(Time time) {

        if (time.getMinute() == 60) {  // Rollover the hour and minute if the minute is 60
            if ((time.getHour() + 1) == 24) {  // Rollover the hour to midnight(00:--) if it reaches 24
                time.rolloverHour();
            } else {
                time.incrementHour();
            }
            time.rolloverMinute();

            // If the start time has changed due to rollovers let the user know
            System.out.println("Start time for this film has changed to "
                    + String.format("%02d", time.getHour())
                    + ":"
                    + String.format("%02d", time.getMinute()));
        }

        return time;
    }

}

/**
 * Class that represents a single film
 */
class Film {
    private String title;
    private Time time;
    private int screen;

    String getTitle() { return title; }
    Time getTime() { return time; }
    int getScreen() { return screen; }

    Film(String title, Time time, int screen) {
        this.title = title;
        this.time = time;
        this.screen = screen;
    }
}

/**
 * Class that represents time, contains hour and minute
 */
class Time {
    private int hour;
    private int minute;

    int getHour() { return hour; }

    int getMinute() { return minute; }

    void rolloverHour() { this.hour = 0; }

    void rolloverMinute() { this.minute = 0; }

    void incrementHour() { this.hour = this.hour + 1; }

    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
}
