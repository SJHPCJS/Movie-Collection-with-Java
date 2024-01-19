import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MovieCollection class represents a collection of movies, and users can set movies, display the movie list, set details, delete movies, search the movies they want, and calculate the total cost of movies in the collection.
 */
public class MovieCollection {
    static ArrayList<Movie> movies = new ArrayList<>();

    /**
     * The main method start with using the menuList() to display the menu.
     */
    public static void main(String[] args) {
        menuList();
    }

    /**
     * This method allows users to enter movies along with its details, and add the movie into the collection.
     * Users can add as many movies as they want until they choose to stop adding by typing "No".
     * Users can choose if they want to go back to menu after adding the movies.
     */
    public static void setMovies() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter movie title:");
            String title = scanner.nextLine();

            System.out.println("Enter movie director:");
            String director = scanner.nextLine();

            System.out.println("Enter movie running time in minutes:");
            int runTime = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter movie purchase cost:");
            double purchaseCost = scanner.nextDouble();
            scanner.nextLine();

            Movie movie = new Movie(title, director, runTime, purchaseCost);
            movies.add(movie);

            System.out.println("Do you want to add another movie? (YES/NO)");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("NO")) {
                break;
            }
            Movie.returntoMenu();

        }
    }

    /**
     * This method allows users to display all movies with their details in the collections.
     * Users can choose if they want to go back to menu after display the movies.
     */
    public static void displayMovieList() {


        System.out.println("Movie List:");
        for (Movie movie : movies) {
            movie.display();
            System.out.println("-------------------------");
        }
        Movie.returntoMenu();
    }

    /**
     * This method allows users to change details of the movie they have already added.
     * Users can search the movie by typing the title of the movie.
     * If the movie can be found, users can rewrite all the details.
     * If the movie cannot be found, users will receive "Movie not found."
     * After all the behaviors, users can choose if they want to go back to the menu.
     */
    public static void setDetails() {
        for (Movie movie : movies) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the movie's title you want to change:");
            String movieName = scanner.nextLine();
            if (movie.getTitle().equalsIgnoreCase(movieName)) {

                System.out.println("Enter new movie title:");
                String title = scanner.nextLine();

                System.out.println("Enter new movie director:");
                String director = scanner.nextLine();

                System.out.println("Enter new movie running time in minutes:");
                int runTime = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter new movie purchase cost:");
                double purchaseCost = scanner.nextDouble();
                scanner.nextLine();

                movie.setAll(title,director,runTime,purchaseCost);

                System.out.println("Movie has been updated!");
                return;
            }
            Movie.returntoMenu();
        }
        System.out.println("Movie not found.");
            Movie.returntoMenu();
    }

    /**
     * This method allows users to delete the movie they have already added.
     * Users can search the movie by typing the title of the movie.
     * If the movie can be found, the movie will be deleted.
     * If the movie cannot be found, users will receive "Movie not found."
     * After all the behaviors, users can choose if they want to go back to the menu.
     */
    public static void deleteMovie() {

        for (Movie movie : movies) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the movie's title you want to delete:");
            String movieName = scanner.nextLine();

            if (movie.getTitle().equalsIgnoreCase(movieName)) {
                movies.remove(movie);
                System.out.println("Movie successfully deleted.");
                return;
            }
            System.out.println("Movie not found.");
            Movie.returntoMenu();
        }
    }

    /**
     * This method allows users to search the movie they have already added.
     * Users can search the movie by typing the title of the movie.
     * If the movie can be found, all the details of the movie will be displayed.
     * If the movie cannot be found, users will receive "Movie xxx not found."
     * After all the behaviors, users can choose if they want to go back to the menu.
     */
    public static void search() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the movie's title you want to search:");
        String movieName = scanner.nextLine();

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(movieName)) {
                System.out.println("Movie found:");
                movie.display();
                break;
            }
        }
        System.out.println("Movie \"" + movieName + "\" not found.");
        Movie.returntoMenu();
    }

    /**
     * This method can provide a menu to users to choose what they want to do.
     * There are seven number representing seven choices.
     * Users can type number to choose the options.
     */
    public static void menuList() {

        final int ADDMOVIES = 1;
        final int DISPLAYMOVIES = 2;
        final int CHANGEDETAILS = 3;
        final int DELETEMOVIES = 4;
        final int REARCHMOVIES = 5;
        final int TOTALCOST=6;
        final int EXIT = 7;

    while(true){
        Menu.printMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case ADDMOVIES -> setMovies();
            case DISPLAYMOVIES -> displayMovieList();
            case CHANGEDETAILS -> setDetails();
            case DELETEMOVIES -> deleteMovie();
            case REARCHMOVIES -> search();
            case TOTALCOST -> calculateTotalCost();
            case EXIT -> System.exit(0);
        }

        }
    }

    /**
     * This method can add all the purchase cost of the movies in the collection and display the result to the users.
     * Users can choose if they want to go back to menu after seeing the total cost of the movies.
     */
    public static void calculateTotalCost() {
        double totalCost = 0.0;
        for (Movie movie : movies) {
            totalCost += movie.getCost();
        }
        System.out.println("The total cost of movies in the collection:" + totalCost);
        Movie.returntoMenu();
    }

}

