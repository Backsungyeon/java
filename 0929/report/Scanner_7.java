package java2024;

import java.util.Scanner;

public class Scanner_7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("양의 정수 입력>>");
		int n = scanner.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=n; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		scanner.close();

	}

}
