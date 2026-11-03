
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void testMovieCreation() {
        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        assertEquals("The Great Gatsby", movie.getTitle());
        assertEquals("Baz Luhrmann", movie.getDirector());
        assertEquals(2013, movie.getYearCreated());
        assertTrue(movie.isInColor());
        assertEquals(143, movie.getLengthInMinutes());
        assertEquals("Drama/Romance", movie.getGenre());
    }

    @Test
    void testUpdateMovie() {
        Movie movie = new Movie(
                "The Great Gatsby",
                "Baz Luhrmann",
                2013,
                true,
                143,
                "Drama/Romance"
        );

        movie.setGenre("Drama");
        movie.setLengthInMinutes(150);

        assertEquals("Drama", movie.getGenre());
        assertEquals(150, movie.getLengthInMinutes());
    }

    @Test
    void testInvalidYear(){

        // Opretter en film og tester, at årstal 0 bliver afvist.


        Movie movie = new Movie(
                "Inception","Christoper Nolan",
                2010, true, 148,"Science Fiction");

        assertThrows(IllegalArgumentException.class, () ->{
            movie.setYearCreated(0);
        });
    }
}
