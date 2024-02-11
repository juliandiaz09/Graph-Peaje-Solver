package Model;

/**
 * This class represents a Model.City with a name.
 */
public class City {
    /** The name of the city. */
    private String name;

    /** Constructor for the Model.City class.
     * @param name The name of the city.
     */
    public City(String name) {
        this.name = name;
    }

    /** Retrieves the name of the city.
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /** Sets the name of the city.
     * @param name The new name of the city.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Generates a string representation of the city.
     * @return A string representing the city.
     */
    @Override
    public String toString() {
        return " -> " + name + "\n";
    }
}
