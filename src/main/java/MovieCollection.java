import java.util.ArrayList;

public class MovieCollection
{
    // TODO: Gemmer alle film i en liste
    private ArrayList<Movie> filmListe;

    // TODO: Opretter en tom filmsamling
    public MovieCollection(){
        filmListe = new ArrayList<>();
    }

    // TODO: Tilføjer en film til listen
    public void tilfoejFilm(Movie film){
        filmListe.add(film);
    }

    // TODO: Viser alle film i samlingen
    public void visFilm(){
        for (Movie film : filmListe){
            System.out.println(film.getTitel() + " - "+
                    film.getInstruktoer() + " - " +
                    film.getUdgivelsesaar());
        }
    }
}

//HUSKENOTE:
// ArrayList<Film> = En liste, der kan gemme mange film.
//new ArrayList<>() = Opretter en tom liste.
//add() = Tilføjer en film.
//for = Gennemgår alle film i listen.
