package java2024;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TryCatch3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ids = new int[10];
        int[] scores = new int[10];

        // 학생 학번과 점수 입력
        System.out.println("10명 학생의 학번과 점수 입력");
        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    System.out.print((i + 1) + ">> ");
                    ids[i] = scanner.nextInt();
                    scores[i] = scanner.nextInt();
                    break; // 올바른 입력이면 루프 종료
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                    scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                }
            }
        }

        while (true) {
            System.out.print("학번으로 검색 : 1, 점수로 검색 : 2, 끝내려면 3>> ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("경고!! 정수를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                continue; // 다음 반복으로 넘어감
            }

            if (choice == 1) {
                int id;
                while (true) {
                    System.out.print("학번>> ");
                    try {
                        id = scanner.nextInt();
                        break; // 올바른 입력이면 루프 종료
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                    }
                }

                boolean found = false;
                for (int i = 0; i < 10; i++) {
                    if (ids[i] == id) {
                        System.out.println(scores[i] + "점");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(id + "의 학생은 없습니다.");
                }
            } else if (choice == 2) {
                int score;
                while (true) {
                    System.out.print("점수>> ");
                    try {
                        score = scanner.nextInt();
                        break; // 올바른 입력이면 루프 종료
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                    }
                }

                boolean found = false;
                System.out.print("점수가 " + score + "인 학생은 ");
                for (int i = 0; i < 10; i++) {
                    if (scores[i] == score) {
                        System.out.print(ids[i] + " ");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("없습니다.");
                } else {
                    System.out.println("입니다.");
                }
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}
