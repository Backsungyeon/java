package java2024;
import java.util.*;

class BinaryArray extends BaseArray{
	int threhold;
	BinaryArray(int size, int threhold){
		super(size);
		this.threhold = threhold;
	}
	public void add(int n) {
		if(n>threhold) {
			super.add(1);
		}else {
			super.add(0);
		}
	}
}

public class Number {
	public static void main(String[] args) {
		int threshold = 50; // 임계값 50
		BinaryArray bArray = new BinaryArray (10, threshold);
		Scanner scanner = new Scanner(System.in);
		System.out.print("»>");
		for (int i=0; i<bArray. length(); i++) {
			int n = scanner.nextInt();
			bArray.add(n);
		}
		bArray.print();
		scanner.close();
	}
}
