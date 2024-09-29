package java2024;

public class DoWhileLoop {

	public static void main(String[] args) {
		int sum=0, i=1;
		
		do {
			if(i>50) {
				break;
			}
			sum = sum + i;
			i += 3;			
		}while(true);
		System.out.println(sum);
	}

}
