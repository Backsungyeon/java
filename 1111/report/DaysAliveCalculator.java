package java2024;

import java.util.Calendar;
import java.util.Scanner;

public class DaysAliveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar today = Calendar.getInstance(); // 현재 날짜와 시간

        System.out.printf("오늘은 %d년 %d월 %d일%n",
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH) + 1,
                today.get(Calendar.DAY_OF_MONTH));

        while (true) {
            System.out.print("생일 입력(년 월 일)>>");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("입력 형식이 잘못되었습니다. 예: 2004 8 15");
                continue;
            }

            try {
                int birthYear = Integer.parseInt(parts[0]);
                int birthMonth = Integer.parseInt(parts[1]) - 1; // Calendar는 0부터 시작
                int birthDay = Integer.parseInt(parts[2]);

                Calendar birthday = Calendar.getInstance();
                birthday.set(birthYear, birthMonth, birthDay);

                if (birthday.after(today)) {
                    // 생일이 미래인 경우
                    long daysUntil = (birthday.getTimeInMillis() - today.getTimeInMillis()) / (1000 * 60 * 60 * 24) + 1;
                    System.out.println(daysUntil + "일 더 살아야 생일이 됩니다.");
                } else {
                    // 생일이 과거 또는 오늘인 경우
                    long daysAlive = (today.getTimeInMillis() - birthday.getTimeInMillis()) / (1000 * 60 * 60 * 24) + 1;
                    System.out.println("오늘까지 " + daysAlive + "일 살아왔습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 잘못되었습니다.");
            }
        }

        scanner.close();
    }
}
