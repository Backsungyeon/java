package java2024;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[100]; 
        int count = 0;

        System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");
        while (true) {
            String input = scanner.next();

            if (input.equals("-1")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);

                
                if (number > 0) {
                    array[count++] = number; // 배열에 저장하고 개수 증가
                } else {
                    System.out.println(number + " 제외"); // 음수에 대한 메시지 추가
                }
            } catch (NumberFormatException e) {
                
                System.out.println(input + " 제외");
            }
        }

        // 평균 계산
        if (count > 0) {
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += array[i];
            }
            double average = (double) sum / count;
            System.out.println("평균은 " + average);
        } else {
            System.out.println("양의 정수가 없습니다.");
        }

        scanner.close();
    }
}
