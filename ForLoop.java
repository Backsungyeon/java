package java2024;

public class ForLoop {

	public static void main(String[] args) {
		int sum=0;
		
		for(int i=1; i < 50; i+=3) {
			sum = sum + i;
		}
		System.out.println(sum);
	}

}
