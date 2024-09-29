package java2024;

import java.util.Scanner;

public class Scanner_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("냉장고 상태 입력>> ");
		int str = scanner.nextInt();

        if ((str & 1) == 1) {
            System.out.print("전원 켜져 있음.");
        } else {
            System.out.print("전원 꺼져 있음.");
        }

        if ((str & 2) == 2) {
            System.out.print("문 닫혀 있음.");
        } else {
            System.out.print("문 열려 있음.");
        }

        if ((str & 4) == 4) {
            System.out.print("전구 정상 작동.");
        } else {
            System.out.print("전구 손상 상태.");
        }

        if ((str & 8) == 8) {
            System.out.print("냉장고 온도 3도 미만.");
        } else {
            System.out.print("냉장고 온도 3도 이상.");
        }

		scanner.close();
	}
}
