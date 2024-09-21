package java2024;

import java.util.Scanner;

public class Scanner_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		System.out.print("2자리수 정수 입력(10~99)>>");
		number = scanner.nextInt();
		if(number%11 == 0) {
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		}else {
			System.out.println("No! 10의 자리와 1의 자리가 같지 않습니다.");
		}
		scanner.close();

	}

}
