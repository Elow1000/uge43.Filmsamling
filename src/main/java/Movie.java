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

    // Kontrollerer at filmens titel ikke er tom.
    // Hvis titlen er ugyldig, vises en fejl.
    public void setTitle(String title)
    {
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Filmens titel må ikke være tom");
        }

        this.title = title.trim();
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    // Tjekker at filmens årstal er større end 0.
    // Hvis årstallet er ugyldigt, vises en fejl.
    public void setYearCreated(int yearCreated)
    {
        if (yearCreated <= 0){
            throw new IllegalArgumentException(
                    "Årstallet skal være større end 0.");
        }

        this.yearCreated = yearCreated;
    }

    public void setInColor(boolean inColor)
    {
        this.inColor = inColor;
    }

    // Tjekker at filmens længde er større end 0.
    // Hvis længden er ugyldig, afvises den.
    public void setLengthInMinutes(int lengthInMinutes)
    {
        if (lengthInMinutes <= 0){
            throw new IllegalArgumentException(
                    "Filmens længde skal være større end 0 minutter.");
        }

        this.lengthInMinutes = lengthInMinutes;

    }

    // Tjekker at filmens genre ikke er tom.
    // Gemmer genren, hvis den er gyldig.
    public void setGenre(String genre)
    {
        if (genre == null || genre.trim().isEmpty()){
            throw new IllegalArgumentException(
                    "Filmens genre må ikke være tom");
        }

        this.genre = genre.trim();
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
    public void markAsWatched(LocalDate date)
    {
        this.lastWatched = date;
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