package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        double cottage = getArea();
        double home = another.getArea();

        if (cottage < home) {
            return -1;
        } else if (cottage > home) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
