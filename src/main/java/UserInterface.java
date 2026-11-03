import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Controller controller;
    private Scanner scanner;

    public UserInterface() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== FILMSAMLING ===");
            System.out.println("1. Tilføj film");
            System.out.println("2. Vis alle film");
            System.out.println("3. Søg efter film");
            System.out.println("4. Rediger film");
            System.out.println("5. Slet film");
            System.out.println("6. Markér film som set");
            System.out.println("0. Afslut");
            System.out.print("Vælg: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addMovie();
                case "2" -> showMovies(controller.getMovies());
                case "3" -> searchMovies();
                case "4" -> editMovie();
                case "5" -> deleteMovie();
                case "6" -> markMovieAsWatched();
                case "0" -> running = false;
                default -> System.out.println("Ugyldigt valg.");
            }
        }

        System.out.println("Programmet er afsluttet.");
    }

    // Tilføj en ny film
    private void addMovie() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();

        System.out.print("Instruktør: ");
        String director = scanner.nextLine();

        System.out.print("Årstal: ");
        int year = readInt();

        System.out.print("Farvefilm (ja/nej): ");
        boolean color = scanner.nextLine().equalsIgnoreCase("ja");

        System.out.print("Længde i minutter: ");
        int duration = readInt();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        controller.addMovie(title, director, year,
                color, duration, genre);

        System.out.println("Filmen er tilføjet!");
    }

    // Vis alle film
    private void showMovies(ArrayList<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("Ingen film fundet.");
            return;
        }

        for (Movie movie : movies) {
            System.out.println("\n" + movie);
            System.out.println("--------------------");
        }
    }

    // Søg efter film
    private void searchMovies() {
        System.out.print("Søg efter titel: ");
        String title = scanner.nextLine();

        ArrayList<Movie> results = controller.searchMovies(title);
        showMovies(results);
    }

    // Find og vælg en film
    private Movie selectMovie() {
        System.out.print("Søg efter titel: ");
        String title = scanner.nextLine();

        ArrayList<Movie> results = controller.searchMovies(title);

        if (results.isEmpty()) {
            System.out.println("Ingen film fundet.");
            return null;
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " +
                    results.get(i).getTitle());
        }

        System.out.print("Vælg nummer: ");
        int number = readInt();

        if (number < 1 || number > results.size()) {
            System.out.println("Ugyldigt nummer.");
            return null;
        }

        return results.get(number - 1);
    }

    // Rediger film - Enter beholder eksisterende værdi
    private void editMovie() {
        Movie movie = selectMovie();
        if (movie == null) return;

        System.out.println("\nTryk Enter for at beholde værdien.");

        System.out.print("Titel (" + movie.getTitle() + "): ");
        String title = scanner.nextLine();
        if (title.isEmpty()) {
            title = movie.getTitle();
        }

        System.out.print("Instruktør (" + movie.getDirector() + "): ");
        String director = scanner.nextLine();
        if (director.isEmpty()) {
            director = movie.getDirector();
        }

        System.out.print("Årstal (" + movie.getYearCreated() + "): ");
        String yearInput = scanner.nextLine();
        int year = yearInput.isEmpty()
                ? movie.getYearCreated()
                : parseIntOrDefault(yearInput, movie.getYearCreated());

        System.out.print("Farvefilm (" +
                (movie.isInColor() ? "ja" : "nej") + "): ");
        String colorInput = scanner.nextLine();
        boolean color = colorInput.isEmpty()
                ? movie.isInColor()
                : colorInput.equalsIgnoreCase("ja");

        System.out.print("Længde (" +
                movie.getLengthInMinutes() + " minutter): ");
        String durationInput = scanner.nextLine();
        int duration = durationInput.isEmpty()
                ? movie.getLengthInMinutes()
                : parseIntOrDefault(durationInput,
                movie.getLengthInMinutes());

        System.out.print("Genre (" + movie.getGenre() + "): ");
        String genre = scanner.nextLine();
        if (genre.isEmpty()) {
            genre = movie.getGenre();
        }

        controller.updateMovie(movie, title, director,
                year, color, duration, genre);

        System.out.println("Filmen er opdateret:");
        System.out.println(movie);
    }

    // Slet film
    private void deleteMovie() {
        Movie movie = selectMovie();
        if (movie == null) return;

        System.out.print("Er du sikker på, at du vil slette "
                + movie.getTitle() + "? (ja/nej): ");

        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("ja")) {
            if (controller.deleteMovie(movie)) {
                System.out.println("Filmen er slettet!");
            }
        } else {
            System.out.println("Sletning annulleret.");
        }
    }

    private void markMovieAsWatched()
    {
        Movie movie = selectMovie();

        if (movie == null){
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern("dd-MM-uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        while (true){
            System.out.println("Hvornår så du filmen? (dd-MM-yyyy): ");
            String input = scanner.nextLine();

            try {
                LocalDate date = LocalDate.parse(input, formatter);

                if (date.isAfter(LocalDate.now())){
                    System.out.println("Datoen må ikke være i fremtiden");
                    continue;
                }

                movie.markAsWatced(date);

                System.out.println("Filmen er markeret som set!");
                System.out.println(movie);

                return;
            } catch (DateTimeParseException e){
                System.out.println("Ugyldig dato. Prøv igen.");
            }
        }
    }

    // Læs et heltal uden at programmet crasher
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ugyldigt tal. Prøv igen: ");
            }
        }
    }

    // Brug den gamle værdi ved ugyldigt tal
    private int parseIntOrDefault(String input, int defaultValue) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt tal. Beholder gammel værdi.");
            return defaultValue;
        }
    }
}
