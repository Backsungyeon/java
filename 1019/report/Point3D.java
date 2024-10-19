package java2024;

public class Point3D extends Point {
	private int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + z + ")의 점";
	}
	
	public void moveUp(int n) { z+=n; }	
	public void moveDown(int n) { z-=n; }
	public void move(int x, int y, int z) { 
		move(x, y);
		this.z = z;
	}
	
	public static void main(String[] args) {
		Point3D p = new Point3D(3, 2, 1);
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(3); // z 축으로 3 이동
		System.out.println(p.toString() + "입니다.");
		p.moveDown(2); // z 축으로 -2 이동
		System.out.println(p.toString() + "입니다.");		
		p.move(5, 5); // x=10, y=10으로 이동
		System.out.println(p.toString() + "입니다.");
		p.move(100, 200, 300);
		System.out.println(p.toString() + "입니다.");
	}

}
