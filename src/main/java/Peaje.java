public class Peaje {
    private String name;
    private double price;

    public Peaje(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Peaje{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
