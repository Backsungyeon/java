package java2024;

import java.util.Scanner;

public class CreditPprogram {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
	        String[] grade = {"A", "B+", "B", "A+", "D"};


	        while (true) {
	            System.out.print("과목>> ");
	            String courseName = scanner.nextLine();

	            if (courseName.equals("그만")) {
	                break; 
	            }

	            int subjects;
	            for (subjects = 0; subjects < course.length; subjects++) {
	                if (course[subjects].equals(courseName)) {
	                    System.out.println(courseName + " 학점은 " + grade[subjects]);
	                    break;
	                }
	            }
	            if (subjects == course.length) {
	                System.out.println(courseName + "는 없는 과목입니다.");
	            }
	        }

	        System.out.println("프로그램이 종료됩니다.");
	        scanner.close(); 
	    }
}
