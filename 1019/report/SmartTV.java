package java2024;

class TV3{
	private int size;
	public TV3(int size) {this.size = size;}
	protected int getSize() {return size;}
}
class ColorTV2 extends TV3{
	private int color;
	public ColorTV2(int size, int color){
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.println(super.getSize() + "인치 " + color + "컬러");
	}
}
public class SmartTV extends ColorTV2{
	private String address;
	public SmartTV(String address, int size, int color) {
		super(size, color);
		this.address = address;
	}
	public void printProperty() {
		System.out.print("나의 SmartTV는 " + address + " 주소의 ");
		super.printProperty();
	}
	public static void main(String[] args) {
		SmartTV smartTv = new SmartTV("192.168.0.5", 77, 20000000);
		smartTv.printProperty();
	}
}
