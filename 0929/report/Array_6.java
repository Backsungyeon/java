package java2024;

import java.util.Scanner;

public class Array_6 {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int array[][] = new int[4][4];
       
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            	array[i][j]=(int)(Math.random() * 256);
                System.out.print(array[i][j] + "\t"); // 각 요소 사이에 탭 추가
            }
            System.out.println(); // 행 끝마다 줄바꿈
        }
        scanner.close();
    }
}
