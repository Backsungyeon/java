package java2024;

class Point3DColor extends Point{
	int z;
	String color;
	public Point3DColor(int x, int y, int z, String color) {
		super(x, y);
		this.z = z;
		this.color = color;
	}
	
	void move(Point3DColor q) {
		move(q.getX(), q.getY());
		z = q.z;
	}
	public String toString() {
		return "(" + getX() + "," + getY() + "," + z + ")" + color + "점";
	}
	boolean equals(Point3DColor r) {
		if(r.getX()==getX() && r.getY()==getY() && r.z==z && r.color==color) {
			return true;
		}else {
			return false;
		}
	}
}

public class Red {
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor (10, 20, 30, "RED");
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
		p.move(q); 
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor r = new Point3DColor (1, 2, 3, "RED");
		System.out.println(r.toString() + "입니다.");
		if(p.equals(r)) { System.out.println("예. 같은 위치 같은 색깔의 점입니다."); }
		else { System.out.println("아니오."); }
	}

}
