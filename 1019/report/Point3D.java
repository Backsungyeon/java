package java2024;

class PointTow {
    private int x, y;

    public PointTow(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 메서드 이름을 setCoordinates로 변경
    protected void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Point3D extends PointTow {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(int n) {
        z += n; // z 축으로 n 만큼 이동
    }

    public void moveDown(int n) {
        z -= n; // z 축으로 n 만큼 이동
    }

    public void move(int x, int y) {
        setCoordinates(x, y); // x, y 좌표를 이동
    }

    public void move(int x, int y, int z) {
        setCoordinates(x, y); // x, y 좌표를 이동
        this.z = z; // z 축 이동
    }

    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + this.z + ")의 점";
    }

    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);
        System.out.println(p.toString() + "입니다.");
        
        p.moveUp(3); // z 축으로 3 이동
        System.out.println(p.toString() + "입니다.");
        p.moveDown(2); // z 축으로 -2 이동
        System.out.println(p.toString() + "입니다.");		
        p.move(5, 5); // x=5, y=5로 이동
        System.out.println(p.toString() + "입니다.");
        p.move(100, 200, 300); // x=100, y=200, z=300으로 이동
        System.out.println(p.toString() + "입니다.");
    }
}
