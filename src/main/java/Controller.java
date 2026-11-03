
import java.util.ArrayList;

public class Controller {

    private MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public void addMovie(String title, String director,
                         int yearCreated, boolean inColor,
                         int lengthInMinutes, String genre) {

        Movie movie = new Movie(title, director, yearCreated,
                inColor, lengthInMinutes, genre);

        movieCollection.addMovie(movie);
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
    }

    public boolean deleteMovie(Movie movie) {
        return movieCollection.deleteMovie(movie);
    }
}
