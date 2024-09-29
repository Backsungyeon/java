package java2024;

public class ForLoopArray {

	public static void main(String[] args) {
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
		for(int i=0; i<n.length; i++) {
			if(n[i]>0 && n[i] % 4 == 0) {
				System.out.print(n[i] + " ");
			}
		}

	}

}
