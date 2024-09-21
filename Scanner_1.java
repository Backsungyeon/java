package java2024;

import java.util.Scanner;

public class Scanner_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int won;
		double dal;
		System.out.print("원화를 입력하세요(단위 )>>>");
		won = scanner.nextInt();
		dal = won/1100;
		System.out.println(won + "원은 $" + dal + "입니다.");
		scanner.close();
	}

}
