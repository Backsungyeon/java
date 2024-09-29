package java2024;

import java.util.Scanner;

public class TryCatch2 {
    public static void main(String[] args) {
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};
        Scanner scanner = new Scanner(System.in);

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        while (true) {
            System.out.print("주문>>");
            String order = scanner.nextLine();

            if (order.equals("그만")) {
            	System.out.println("주문을 종료합니다.");
                break; 
            }

            String[] glasses = order.split(" ");
            if (glasses.length != 2) {
                continue;
            }

            String coffeeName = glasses[0];
            String count = glasses[1];

            // 커피 이름 확인
            int coffeeIndex = -1;
            for (int i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(coffeeName)) {
                    coffeeIndex = i;
                    break;
                }
            }

            if (coffeeIndex == -1) {
                System.out.println(coffeeName + "은 없는 메뉴입니다.");
                continue;
            }

            try {
                int quantity = Integer.parseInt(count);
                if (quantity <= 0) {
                    throw new NumberFormatException();
                }

                int totalPrice = price[coffeeIndex] * quantity;
                System.out.println("가격은 " + totalPrice + "원입니다.");
            } catch (NumberFormatException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
            }
        }

        scanner.close();
    }
}
