package java2024;

import java.util.Scanner;

public class NamingProgram {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        String[] boyMiddleList = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
	        String[] boyLastList = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
	        String[] girlMiddleList = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
	        String[] girlLastList = {"진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};

	        System.out.println("***** 작명 프로그램이 실행됩니다. *****");

	        while (true) {
	            System.out.print("남/여 선택>>");
	            String gender = scanner.nextLine();

	            if (gender.equals("그만")) {
	                break;
	            } else if (!gender.equals("남") && !gender.equals("여")) {
	                System.out.println("남/여/그만 중에서 입력하세요!");
	                continue;
	            }

	            System.out.print("성 입력>>");
	            String firstName = scanner.nextLine();

	            String name = "";
	            if (gender.equals("남")) {
	                int index = (int)(Math.random()*boyMiddleList.length);
	                String middle = boyMiddleList[index];
	                int index2 = (int)(Math.random()*boyLastList.length);
	                String last = boyLastList[index2];
	                name = firstName + middle + last; // 성 + 중간 + 마지막
	            } else if (gender.equals("여")) {
	            	int index = (int)(Math.random()*girlMiddleList.length);
	                String middle = girlMiddleList[index];
	                int index2 = (int)(Math.random()*girlLastList.length);
	                String last = girlLastList[index2];
	                name = firstName + middle + last; 
	            }
	            System.out.println("추천 이름: " + name);
	        }
	        System.out.println("프로그램이 종료됩니다.");
	        scanner.close(); 
	    }
}
