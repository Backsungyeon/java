package java2024;

import java.util.Scanner;
import java.util.InputMismatchException;

public class gugudan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        
        while (true) {
            System.out.print("곱하고자 하는 정수 2개 입력>>");
            try {
                n = scanner.nextInt(); 
                m = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요!");
                scanner.nextLine(); 
            }
        }
        
        System.out.println(n + " x " + m + " = " + (n * m));
        scanner.close(); // Scanner 자원 해제

	}

}
