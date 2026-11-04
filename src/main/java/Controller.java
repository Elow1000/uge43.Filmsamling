
import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection;

    private FileHandler fileHandler;

    public Controller() {
        movieCollection = new MovieCollection();
        fileHandler = new FileHandler("movies.txt");

        try {
            for (Movie movie : fileHandler.loadMovies()) {
                movieCollection.addMovie(movie);
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Ingen gemte film fundet endnu.");
        }
    }

    public void addMovie(String title, String director,
                         int yearCreated, boolean inColor,
                         int lengthInMinutes, String genre) {

        Movie movie = new Movie(title, director, yearCreated,
                inColor, lengthInMinutes, genre);

        movieCollection.addMovie(movie);
        saveMovies();
    }

    public ArrayList<Movie> getMovies() {
        return movieCollection.getMovies();
    }

    public ArrayList<Movie> searchMovies(String title) {
        return movieCollection.searchMovies(title);
    }

    public void updateMovie(Movie movie, String title,
                            String director, int yearCreated,
                            boolean inColor, int lengthInMinutes,
                            String genre) {

        movieCollection.updateMovie(movie, title, director,
                yearCreated, inColor, lengthInMinutes, genre);
        saveMovies();
    }

    public boolean deleteMovie(Movie movie) {

        // Forsøger at slette filmen fra samlingen.
        boolean deleted = movieCollection.deleteMovie(movie);

        // Gemmer ændringen, hvis filmen blev slettet.
        if (deleted) {
            saveMovies();
        }

        // Fortæller, om sletningen lykkedes.
        return deleted;
    }

    private void saveMovies() {

        //  Forsøger at gemme alle film i filen.
        try {
            fileHandler.saveMovies(movieCollection.getMovies());
        }

        //  Viser en besked, hvis filen ikke kan gemmes.
        catch (java.io.FileNotFoundException e) {
            System.out.println("Kunne ikke gemme filmene.");
        }
    }

    public void markMovieAsWatched(Movie movie, java.time.LocalDate date) {

        // Registrerer datoen, hvor filmen blev set.
        movie.markAsWatched(date);

        // Gemmer den nye dato i movies.txt.
        saveMovies();
    }
}

// Opretter en tom filmsamling.

// Vælger filen, hvor filmene gemmes.

// try: Forsøger at hente tidligere gemte film.

// for: Tilføjer de gemte film én ad gangen.

// catch: Sørger for, at programmet fortsætter,
// selvom filen ikke findes endnu.
