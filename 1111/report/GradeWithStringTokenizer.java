package java2024;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeWithStringTokenizer {

	public static void error(String msg, String input) {
		System.out.println(msg + ":" + input);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
			String line = scanner.nextLine(); // 성적 입력
			if(line.equals("그만"))
				break;
			line = line.toUpperCase(); // 대문자로 수정
			
			StringTokenizer st = new StringTokenizer(line, " "); // 빈 칸으로 분리
			int count = st.countTokens(); // 토큰 수, line에 들어 있는 문자열 개수
			boolean errorFlag = false;
			double sum = 0;
			while(st.hasMoreTokens()) { // st에 들어 있는 전체 토큰(문자열) 개수 만큼 루프
				String s = st.nextToken(); // st로부터 토큰(문자열) 얻어내기
				switch(s) {
				case "A": sum += 100; break;
				case "B": sum += 90; break;
				case "C": sum += 80; break;
				case "D": sum += 70; break;			
				case "F": sum += 0; break;
				default:
					error("입력 오류", s);
					errorFlag = true;
					break;
				}				
			}
			if(errorFlag == false)
				System.out.println("평균은 " + sum/count);
		}
		scanner.close();
	}

}
