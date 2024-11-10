package java2024;

import java.util.*;

public class CalendarApp {
	public static void makeCalendar(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year); // 캘린더 객체에 년도를 year로 지정

		for (int i = 0; i < 12; i++) { // 12 달을 출력하기 위해 12번 반복
			System.out.println("\n" + year + "년 " + (i+1)+ "월 ");
			System.out.println("일\t월\t화\t수\t목\t금\t토");

			calendar.set(Calendar.MONTH, i); // 캘린더 객체에 달을 i로 지정. i=0이 1월을 뜻함
			calendar.set(Calendar.DAY_OF_MONTH, 1); // 캘린더 객체에 날짜를 1일로 지정

			// 캘린더 객체에는 년도, 달, 날짜가 지정되어 있음
			// 이제 캘린더 객체에 설정된 날이 주의 몇 번째 날인지를 알아냄
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

			// 일요일부터 어제까지 빈 칸(탭) 출력
			for (int j = 0; j < dayOfWeek - 1; j++)
				System.out.print("\t");

			// 캘린더 객에에 설정된 달이 며칠까지 있는지 알아냄
			int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); 

			for (int j = 1; j <= lastDay; j++) { // 현재 달의 날을 모두 출력한다.
				System.out.print(j + "\t");
				if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) // 오늘이 토요일이면 다음 줄로 넘어간다.
					System.out.println();
				calendar.set(Calendar.DAY_OF_MONTH, j + 1); // 오늘의 날짜를 1 증가시킨다.
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("년도 입력(-1이면 종료)>>");
			int year = scanner.nextInt();
			if (year == -1)
				break;
			makeCalendar(year);
		}
		scanner.close();		
	}
}

