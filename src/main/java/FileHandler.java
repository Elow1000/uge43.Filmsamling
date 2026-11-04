import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler
{
    private String fileName;
    private int skippedLineCount;

    public FileHandler(String fileName)
    {
        this.fileName = fileName;
    }

    // Gemmer alle film i en CSV-fil
    public void saveMovies(ArrayList<Movie> movies)
            throws FileNotFoundException
    {

        try (PrintStream output = new PrintStream(new File(fileName)))
        {

            output.println("title;director;yearCreated;inColor;lengthInMinutes;genre;lastWatched");

            for (Movie movie : movies)
            {
                String date = "";

                if (movie.hasBeenWatched())
                {
                    date = movie.getLastWatched().toString();

                }

                output.println(
                        movie.getTitle() + ";" +
                                movie.getDirector() + ";" +
                                movie.getYearCreated() + ";" +
                                movie.isInColor() + ";" +
                                movie.getLengthInMinutes() + ";" +
                                movie.getGenre() + ";" +
                                date
                );
            }
        }
    }

    // Indlæser film fra CSV-filen
    public ArrayList<Movie> loadMovies()
            throws FileNotFoundException
    {

        ArrayList<Movie> movies = new ArrayList<>();
        skippedLineCount = 0;

        try (Scanner scanner = new Scanner(new File(fileName)))
        {

            if (scanner.hasNextLine())
            {
                scanner.nextLine(); // Spring overskriften oveer
            }


            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(";", -1);

                try
                {
                    if (fields.length != 7)
                    {
                        throw new IllegalArgumentException();
                    }

                    Movie movie = new Movie(
                            fields[0],
                            fields[1],
                            Integer.parseInt(fields[2]),
                            Boolean.parseBoolean(fields[3]),
                            Integer.parseInt(fields[4]),
                            fields[5]
                    );

                    if (!fields[6].isEmpty())
                    {
                        movie.markAsWatched(LocalDate.parse(fields[6]));
                    }

                    movies.add(movie);
                } catch (RuntimeException e)
                {
                    skippedLineCount++;
                }

            }
            return movies;
        }
    }
        public int getSkippedLineCount() {
        return skippedLineCount;
    }

    }

