import java.util.Scanner;
/**
 * The Movie class represents a movie with its title, director, runtime and purchase cost.
 */
public class Movie {

    private String title;
    private String director;
    private int runtime;
    private double cost;

    /**
     * Construct a new Movie object with the specified title, director, runtime, and purchase cost.
     * @param title The title of the movie.
     * @param director The director of the movie.
     * @param runtime The runtime of the movie.
     * @param cost The purchase cost of the movie.
     */
    public Movie(String title, String director, int runtime, double cost) {
        this.title = title;
        this.director = director;
        this.runtime = runtime;
        this.cost = cost;
    }

    /**
     * Get the title of the movie.
     * @return the title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the movie.
     * @param title The title of the movie.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the director of the movie.
     * @return the director of the movie.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Set the director of the movie.
     * @param director The director of the movie.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Get the runtime of the movie.
     * @return the runtime of the movie.
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * Set the runtime of the movie.
     * @param runtime The runtime of the movie.
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /**
     * Get the purchase cost of the movie.
     * @return the purchase cost of the movie.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set the purchase cost of the movie.
     * @param cost The purchase cost of the movie.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     *  Display the title, director, runtime and purchase cost of the specific movie.
     */
    public void display() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Runtime: " + this.getRuntime() + " minutes");
        System.out.println("Cost: " + this.getCost());
        System.out.println();
    }

    /**
     * Set all the attributes for the movie.
     * @param title The title of the specific movie.
     * @param director The director of the specific movie.
     * @param runTime The runtime of the specific movie.
     * @param purchaseCost The purchase cost of the specific movie.
     */
    public void setAll(String title,String director, int runTime, double purchaseCost){
        setTitle(title);
        setDirector(director);
        setRuntime(runTime);
        setCost(purchaseCost);
    }

    /**
     * Give users options to decide whether they want to go back to the menu.
     */
    public static void returntoMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to return to the menu? (YES/NO)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("YES")) {
            return;
        }
    }
}


