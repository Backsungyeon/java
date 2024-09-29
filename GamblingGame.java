package java2024;

import java.util.Scanner;

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("***** 갬블링 게임을 시작합니다. *****");

        while (true) {
            System.out.print("엔터키 입력>> ");
            scanner.nextLine(); // 엔터키 입력 대기
            
            // 랜덤한 수 생성
            int num1 = (int)(Math.random() * 3);
            int num2 = (int)(Math.random() * 3);
            int num3 = (int)(Math.random() * 3);

            // 생성된 수 출력
            System.out.print(num1 + "   " + num2 + "   " + num3 + "\n");

            // 모든 수가 같을 때만 성공 메시지 출력
            if (num1 == num2 && num2 == num3) {
                System.out.println("성공! 대박났어요!");
                
                // 계속할지 여부 확인
                System.out.print("계속하시겠습니까?(yes/no)>> ");
                String cont = scanner.nextLine();
                
                if (!cont.equals("yes")) {
                    break; // "yes"가 아니면 게임 종료
                }
            }
        }

        System.out.println("게임을 종료합니다.");
        scanner.close(); // Scanner 자원 해제
    }
}
