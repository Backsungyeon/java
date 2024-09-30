package java2024;

import java.util.Scanner;

public class Array_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("양의 정수 10개 입력>>");
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("자리수의 합이 9인 것은... ");
        
        for (int number : array) {
            int sum = 0;
            int temp = number; 

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10; 
            }

            if (sum == 9) {
                System.out.print(number + " ");
            }
        }

        scanner.close();
    }
}
