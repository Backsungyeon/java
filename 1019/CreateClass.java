package java2024;

class TV{
	public String company;
	public int price;
	public int size;

	public TV(String company, int price, int size) {
		this.company = company;
		this.price = price;
		this.size = size;
	}
	public void show() {
		System.out.print(company + "에서 만든 " + price  + "만원짜리의 " + size + "인치 TV");
	}

}


public class CreateClass {
	public static void main(String[] args) {
		TV myTv = new TV("Samsung", 300, 50);
		myTv.show();

	}

}