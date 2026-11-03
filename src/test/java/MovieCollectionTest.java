import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieCollectionTest {

    @Test
    void testAddMovie() {
        MovieCollection collection = new MovieCollection();

        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        collection.addMovie(movie);

        assertEquals(1, collection.getMovies().size());
        assertEquals(movie, collection.getMovies().get(0));
    }

    @Test
    void testSearchMovie() {
        MovieCollection collection = new MovieCollection();

        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        collection.addMovie(movie);

        assertEquals(1, collection.searchMovies("gatsby").size());
        assertEquals(0, collection.searchMovies("Batman").size());
    }

    @Test
    void testUpdateMovie() {
        MovieCollection collection = new MovieCollection();

        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        collection.addMovie(movie);

        collection.updateMovie(
                movie,
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                150,
                "Drama"
        );

        assertEquals(150, movie.getLengthInMinutes());
        assertEquals("Drama", movie.getGenre());
    }

    @Test
    void testDeleteMovie() {
        MovieCollection collection = new MovieCollection();

        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        collection.addMovie(movie);

        assertTrue(collection.deleteMovie(movie));
        assertEquals(0, collection.getMovies().size());
    }
}
