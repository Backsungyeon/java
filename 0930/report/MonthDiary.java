package java2024;

import java.util.Scanner;

class Diary {
    private String memo;

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo == null ? "..." : memo;
    }
}

class MonthDiary {
    private Diary[] days;
    private int year;
    private int month;
    private boolean isFirst = true; 

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        days = new Diary[30];
        for (int i = 0; i < days.length; i++) {
            days[i] = new Diary();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (isFirst) {
            	System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
                isFirst = false; 
            }

            int choice = getMenu(scanner);
            if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice == 1) {
                write(scanner);
            } else if (choice == 2) {
                show();
            }
        }
        scanner.close();
    }

    private int getMenu(Scanner scanner) {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        return scanner.nextInt();
    }

    private void write(Scanner scanner) {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int date = scanner.nextInt();
        String memo = scanner.next();
        
        if (date < 1 || date > 30 || memo.length() > 4) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        
        days[date - 1].setMemo(memo);
    }

    private void show() {
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%d일: %s\n", i + 1, days[i].getMemo());
        }
    }

    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10); // 2024년 10월 다이어리
        monthDiary.run();
    }
}
