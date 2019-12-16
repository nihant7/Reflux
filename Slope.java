public class Slope {

    Point p;


    public static float slope(Point p1, Point p2) {
        float m = ( p2.y - p1.y ) / (p2.x - p1.x);
        return m;
    }

    public static void main(String[] args) {
            Point p1 = new Point (3, 5);
            Point p2 =  new Point(1,13);

            System.out.println(slope(p1,p2));

    }
}
