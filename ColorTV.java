package java2024;

class TV2{
	private int size;
	public TV2(int size) {this.size = size;}
	protected int getSize() {return size;}
}
public class ColorTV extends TV2{
	private int color;
	public ColorTV(int size, int color){
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.println(super.getSize() + "인치 " + color + "컬러");
	}
	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(65, 65536);
		myTV.printProperty();
	}
}
