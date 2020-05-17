public class Point {
    float x;
    float y;


    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            i+=i;
            System.out.println(i);
        }
    }
}
