package java2024;

import java.util.Scanner;

public class Array_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("양의 정수 10개 입력>>");
        int array[] = new int[10];
        
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("3의 배수는... ");
        for (int i = 0; i < 10; i++) {
            if (array[i]%3 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        scanner.close(); 
    }
}
