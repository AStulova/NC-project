class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] pnt = new int[2];
        pnt[0] = getX();
        pnt[1] = getY();
        return pnt;
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(another.x - this.x, 2) + Math.pow(another.y - this.y, 2));
    }

    public double distance() {
        return Math.sqrt(Math.pow(0 - this.x, 2) + Math.pow(0 - this.y, 2));
    }
}

class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                "]";
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if (v1.distance(v2) == v2.distance(v3) & v2.distance(v3) == v3.distance(v1))
            return "Equilateral"; // never
        else  if (v1.distance(v2) == v1.distance(v3) || v2.distance(v1) == v2.distance(v3) || v3.distance(v2) == v3.distance(v1))
            return "Isosceles";
        else
            return "Scalene";
    }
}

public class MainPoint {
    public static void main(String[] args) {
        MyTriangle triangle1 = new MyTriangle(-4, 2, 0, 2, -4, -2);
        System.out.println(triangle1.toString());
        System.out.println(triangle1.getPerimeter());
        System.out.println(triangle1.getType());

        MyTriangle triangle2 = new MyTriangle(-3, -4, 2, -2, -4, 5);
        System.out.println(triangle2.toString());
        System.out.println(triangle2.getPerimeter());
        System.out.println(triangle2.getType());
    }
}
