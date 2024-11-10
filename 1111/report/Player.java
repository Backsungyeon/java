import java.util.Scanner;

// 선수를 나타내는 클래스
public class Player {
	private String name; // 선수 이름
	private Scanner scanner = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {return name;}
	
	public void getEnterKey() {
		scanner.nextLine(); // <Enter> 키를 기다린다.
	} 
	
	public boolean turn() {
		System.out.print("[" + name + "]:<Enter>");			
		getEnterKey(); // 참가자가 <Enter>키 입력할 때까지 기다림
		
		int num[] = new int [3]; // 3개의 난수를 저장하기 위한 배열

		// 3개의 난수 생성 
		for (int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*3 + 1); // 1~3까지의 임의의 수 발생
		}
		
		 // 3개의 난수 출력
		System.out.print("\t");
		for (int i=0; i<num.length; i++) {
			System.out.print(num[i]+"  ");
		}
	
		 // 3개의 난수가 같은지 비교
		boolean result = true;
		for (int i=0; i<num.length; i++) {
			if (num[i] != num[0]) { // 하나라도 다르면 false
				result = false; // 같지 않음
				break;
			}
		}
		
		return result; // result가 true 이면 승리
	}
}
