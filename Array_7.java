package java2024;

import java.util.Scanner;

public class Array_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[][] = new int[4][4];

        // 4x4 배열에 랜덤한 값을 저장하고 출력
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = (int) (Math.random() * 256);
                System.out.print(array[i][j] + "\t"); // 각 요소 사이에 탭 추가
            }
            System.out.println(); 
        }

        System.out.print("임계값 입력>>");
        int threshold = scanner.nextInt();

        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > threshold) {
                    array[i][j] = 255;
                } else {
                    array[i][j] = 0; 
                }
            }
        }
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t"); // 각 요소 사이에 탭 추가
            }
            System.out.println(); 
        }

        scanner.close(); 
    }
}
