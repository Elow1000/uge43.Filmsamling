
import java.util.ArrayList;

public class MovieCollection {

    private ArrayList<Movie> movies;

    // Constructor
    public MovieCollection() {
        movies = new ArrayList<>();
    }

    // Tilføj en film
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Vis alle film
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    // Søg efter film ud fra titel
    public ArrayList<Movie> searchMovies(String title) {
        ArrayList<Movie> results = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                results.add(movie);
            }
        }

        return results;
    }

    // Rediger en film
    public void updateMovie(Movie movie, String title,
                            String director, int yearCreated,
                            boolean inColor, int lengthInMinutes,
                            String genre) {
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setYearCreated(yearCreated);
        movie.setInColor(inColor);
        movie.setLengthInMinutes(lengthInMinutes);
        movie.setGenre(genre);
    }

    // Slet en film
    public boolean deleteMovie(Movie movie) {
        return movies.remove(movie);
    }
}
