
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
            System.out.println("0. Afslut");
            System.out.print("Vælg: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addMovie();
                case "2" -> showMovies(controller.getMovies());
                case "3" -> searchMovies();
                case "4" -> editMovie();
                case "5" -> deleteMovie();
                case "0" -> running = false;
                default -> System.out.println("Ugyldigt valg.");
            }
        }
    }

    private void addMovie() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();

        System.out.print("Instruktør: ");
        String director = scanner.nextLine();

        System.out.print("Årstal: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Farvefilm (ja/nej): ");
        boolean color = scanner.nextLine().equalsIgnoreCase("ja");

        System.out.print("Længde i minutter: ");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        controller.addMovie(title, director, year,
                color, duration, genre);

        System.out.println("Filmen er tilføjet!");
    }

    private void showMovies(ArrayList<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("Ingen film fundet.");
            return;
        }

        for (Movie movie : movies) {
            System.out.println("\n" + movie);
        }
    }

    private void searchMovies() {
        System.out.print("Søg efter titel: ");
        String title = scanner.nextLine();
        showMovies(controller.searchMovies(title));
    }

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
        int number = Integer.parseInt(scanner.nextLine());

        if (number < 1 || number > results.size()) {
            System.out.println("Ugyldigt nummer.");
            return null;
        }

        return results.get(number - 1);
    }

    private void editMovie() {
        Movie movie = selectMovie();
        if (movie == null) return;

        System.out.print("Ny titel: ");
        String title = scanner.nextLine();

        System.out.print("Ny instruktør: ");
        String director = scanner.nextLine();

        System.out.print("Nyt årstal: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Farvefilm (ja/nej): ");
        boolean color = scanner.nextLine().equalsIgnoreCase("ja");

        System.out.print("Ny længde: ");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print("Ny genre: ");
        String genre = scanner.nextLine();

        controller.updateMovie(movie, title, director,
                year, color, duration, genre);

        System.out.println("Filmen er opdateret!");
    }

    private void deleteMovie() {
        Movie movie = selectMovie();
        if (movie == null) return;

        if (controller.deleteMovie(movie)) {
            System.out.println("Filmen er slettet!");
        }
    }
}
