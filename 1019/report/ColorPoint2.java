package java2024;

class Point2 {
    private int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point2 other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }
}

public class ColorPoint2 extends Point2 {
    private String color;

    public ColorPoint2(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void set(int x, int y) {
        setPosition(x, y);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return color + "색의 (" + super.getX() + ", " + super.getY() + ")의 점";
    }

    public static void main(String[] args) {
        ColorPoint2 zeroPoint = new ColorPoint2(0,0, "WHITE"); //(0,0)위치의 "WHITE" 색 점
        System.out.println(zeroPoint.toString());

        ColorPoint2 cp = new ColorPoint2(10,10, "RED"); //(10,10)위치의 "RED" 색 점
        cp.setColor("BLUE");
        cp.set(10,20);
        System.out.println(cp.toString() + "입니다.");

        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100, "BLACK"); //(100,100)위치의 "BLACK" 색 점
        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint) + "입니다.");
    }
}
