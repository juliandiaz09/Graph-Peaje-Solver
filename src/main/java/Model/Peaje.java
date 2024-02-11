package Model;

/**
 * This class represents a Toll with a name and a price.
 */
public class Peaje {
    /** The name of the toll. */
    private String name;
    /** The price of the toll. */
    private double price;

    /** Constructor for the Model.Peaje class.
     * @param name The name of the toll.
     * @param price The price of the toll.
     */
    public Peaje(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /** Retrieves the name of the toll.
     * @return The name of the toll.
     */
    public String getName() {
        return name;
    }

    /** Sets the name of the toll.
     * @param name The new name of the toll.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Retrieves the price of the toll.
     * @return The price of the toll.
     */
    public double getPrice() {
        return price;
    }

    /** Sets the price of the toll.
     * @param price The new price of the toll.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /** Generates a string representation of the toll.
     * @return A string representing the toll.
     */
    @Override
    public String toString() {
        return "Model.Peaje{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
