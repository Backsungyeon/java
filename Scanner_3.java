package java2024;

import java.util.Scanner;

public class Scanner_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int mon;
		System.out.print("금액을 입력하시오>>");
		mon = scanner.nextInt();
		int[] a = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		String[] b = {"오만원권", "만원권", "천원권", "오백원", "백원", "오십원","십원", "일원"};
		
		for(int i=0; i<8; i++) {
			int count = mon / a[i];
			mon -= count*a[i];
			System.out.println(b[i] + count + "매");
		}
		scanner.close();

	}

}
