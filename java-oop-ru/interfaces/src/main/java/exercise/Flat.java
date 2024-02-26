package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    }

    public int compareTo(Home another) {
        double flat = getArea();
        double home = another.getArea();

        if (flat < home) {
            return -1;
        } else if (flat > home) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " +  floor + " этаже";
    }
}
// END
