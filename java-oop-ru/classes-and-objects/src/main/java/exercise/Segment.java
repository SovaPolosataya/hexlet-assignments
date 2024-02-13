package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        var midX = beginPoint.getX() + (endPoint.getX() - beginPoint.getX()) / 2;
        var midY = beginPoint.getY() + (endPoint.getY() - beginPoint.getY()) / 2;
        Point midPoint = new Point(midX, midY);
        return midPoint;
    }
}
// END
