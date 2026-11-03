import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Movie
{

    // Attributter
    private String title;
    private String director;
    private int yearCreated;
    private boolean inColor;
    private int lengthInMinutes;
    private String genre;
    private LocalDate lastWatched;



    // Constructor
    public Movie(String title, String director, int yearCreated,
                 boolean inColor, int lengthInMinutes, String genre)
    {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.inColor = inColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    // Getters
    public String getTitle()
    {
        return title;
    }

    public String getDirector()
    {
        return director;
    }

    public int getYearCreated()
    {
        return yearCreated;
    }

    public boolean isInColor()
    {
        return inColor;
    }

    public int getLengthInMinutes()
    {
        return lengthInMinutes;
    }

    public String getGenre()
    {
        return genre;
    }

    // Setters
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public void setYearCreated(int yearCreated)
    {
        this.yearCreated = yearCreated;
    }

    public void setInColor(boolean inColor)
    {
        this.inColor = inColor;
    }

    public void setLengthInMinutes(int lengthInMinutes)
    {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    // Udskriv filmens oplysninger
    @Override
    public String toString()
    {
        String watchedText = "Sidst set: aldrig";

        if (lastWatched != null){
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy");

            long days = getDaysSinceWatched(LocalDate.now());

            watchedText = "Sidst set: " +
                    lastWatched.format(formatter) +
                    " (for " + days + " dage siden)";
        }
        return title + " (" + yearCreated + ")" +
                "\nInstruktør:" + director +
                "\nGenre: " + genre +
                "\nLængde: " + lengthInMinutes +
                "\nFarvefilm: " + (inColor ? "Ja" : "Nej") +
                "\n"+ watchedText;
    }

    // Henter datoen, hvor filmen sidst blev set
    public LocalDate getLastWatched()
    {
        return lastWatched;
    }

    // Tjekker om filmen er blevet set
    public boolean hasBeenWatched()
    {
        return lastWatched != null;
    }

    // Gemmer datoen, hvor filmen blev set
    public void markAsWatced(LocalDate date)
    {
        lastWatched = date;
    }

    // Beregner hvor mange dage siden filmen blev set
    public long getDaysSinceWatched(LocalDate today)
    {
        return ChronoUnit.DAYS.between(lastWatched, today);

    }
}

// HUSKENOTE:
// toString() viser alle filmens oplysninger.
// Hvis filmen er set, vises datoen og antal dage siden.
// Hvis filmen ikke er set, vises "Sidst set: aldrig".