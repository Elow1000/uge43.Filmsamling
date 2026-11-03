public class Main
{
    public static void main (String[] args)
    {

        MovieCollection samling = new MovieCollection();

        // TODO: Opretter en film
        Movie film1 = new Movie("Titanic", "James Cameron", 1997);
        Movie film2 = new Movie("Avatar", "James Cameron", 2009);
        Movie film3 = new Movie("Inception", "Christoper Nolan", 2010);

        // TODO: Tilføjer filmene til samlingen
        samling.tilfoejFilm(film1);
        samling.tilfoejFilm(film2);
        samling.tilfoejFilm(film3);

        // TODO: Viser alle film på skærmen
        samling.visFilm();
    }
}

// HUSKENOTE:
// new Filmsamling() = Opretter en tom filmsamling.
// new Film() = Opretter en ny film.
// tilfoejFilm() = Gemmer filmen i listen.
// visFilm() = Viser alle film i listen.