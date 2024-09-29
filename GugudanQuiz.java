package java2024;

import java.util.Random;
import java.util.Scanner;

public class GugudanQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0; 

        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");

        while (count < 3) {
            int num1 = random.nextInt(9) + 1; 
            int num2 = random.nextInt(9) + 1;
            int correct = num1 * num2;
            
            System.out.print(num1 + " x " + num2 + " = ");
            int comment = scanner.nextInt();

            
            if (comment == correct) {
                System.out.println("정답입니다. 잘했습니다.");
            } else {
            	count++;
                if (count == 3) {
                    System.out.println(count + "번 틀렸습니다. 퀴즈를 종료합니다.");
                } else {
                    System.out.println(count + "번 틀렸습니다. 분발하세요.");
                }
            }
        }
        scanner.close(); 
    }
}

