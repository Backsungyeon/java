package java2024;

public class WhileLoop {

	public static void main(String[] args) {
		int sum=0, i=1;
		while(true) {
			if(i>50) {
				break;
			}
			sum = sum+i;
			i += 3;
		}
		System.out.println(sum);
	}

}
