//묵찌바 게임 만들기
import java.util.Scanner;

// 선수를 추상화한 추상 클래스
// next() 메소드가 추상 메소드이며, 상속받는 클래스는 next()를 구현하여야 한다.
abstract class Player {
	protected String bet[] = {"묵", "찌", "빠" };
	protected String name; // 선수 이름
	protected String lastBet = null; // 선수가 최근에 낸 값
	
	protected Player(String name) { this.name = name; }

	public String getName() { return name; }
	public String getBet() { return lastBet; }
	abstract public String next(); // 선수가 묵, 찌, 빠 중에서 1개를 결정하여 리턴
}

// 사람 선수를 표현하는 클래스. Player 추상 클래스를 상속받아 next() 구현
class Human extends Player {
	private Scanner scanner = new Scanner(System.in);
	
	public Human(String name) {
		super(name);
	}
	
	// 추상 메소드 구현
	@Override
	public String next() {
		while(true) { // "묵", "찌", "빠" 중에 입력할 때까지 반복
			System.out.print(name + ">>");
			String curBet = scanner.next(); // 사용자로부터 낸 것을 입력받기
			for(String b : bet) {
				if(curBet.equals(b)) { // 사용자가 낸 것이 bet[] 배열에 있는 "묵", "찌", "빠" 중의 하나라면
					lastBet = curBet;
					return lastBet;
				}
			}
			System.out.println("묵 찌 빠 중에서 다시 입력하세요.");
		}
	}
}

// 컴퓨터 선수를 표현하는 클래스. Player 추상 클래스를 상속받아 next() 구현
class Computer extends Player {
	public Computer(String name) {
		super(name);
	}

	// 추상 메소드 구현
	@Override
	public String next() { // bet에서 랜덤하게 한 개 선택하여 리턴
		int index = (int)(Math.random() * bet.length);
		System.out.println(name + ">> 결정하였습니다.");
		lastBet = bet[index]; 
		return lastBet;
	}
}

class Game {
	private Player [] players = new Player[2]; // 두 명의 선수 객체
	private Scanner scanner = new Scanner(System.in);
	
	public Game() { }
	
	private void createPlayer() { // 2명의 선수 객체 생성
		System.out.print("선수이름 입력>>");
		String name = scanner.next();
		players[0] = new Human(name);
		
		System.out.print("컴퓨터이름 입력>>");
		name = scanner.next();
		players[1] = new Computer(name);
		System.out.println("2명의 선수를 생성 완료하였습니다...\n");			
	}
	
	public void run() {
		System.out.println("***** 묵찌빠 게임을 시작합니다. *****");
		createPlayer(); // 2명의 선수 객체 생성
		int ownerIndex = 0; // 0번 선수부터 시작
		while(true) {
			String owner = players[ownerIndex].next(); // 오너에게 묵찌빠 중에서 받기
			int opponentIndex = (ownerIndex + 1)%2;
			String opponent = players[opponentIndex].next(); // 상대편에게 묵찌빠 중에서 받기
			
			// 2명의 선수가 낸 것을 출력
			System.out.println(players[ownerIndex].getName() + " : " + players[ownerIndex].getBet() +
					", " + players[opponentIndex].getName() + " : " + players[opponentIndex].getBet());
			
			//  owner가 승리하였는지 판단
			if(owner.equals(opponent)) { // owner의 승리
				System.out.println("\n" + players[ownerIndex].getName() + "이 이겼습니다.");
				break;
			}
			
			// 가위, 바위, 보의 규칙에 따라 owner가 이기지 않은 경우, owner는 상대편으로 바뀜
			if((owner.equals("묵") && opponent.equals("빠")) ||
				(owner.equals("찌") && opponent.equals("묵")) ||
				(owner.equals("빠") && opponent.equals("찌"))) { // owner가 가위,바위, 보 규칙에서 진 경우
				ownerIndex = opponentIndex; // owner 변경
				System.out.println("오너가 " + players[ownerIndex].getName() + "로 변경되었습니다.");
			}
			System.out.println();
		}
		
		System.out.println("게임을 종료합니다...");
	}
}

public class MGPApp {

	public static void main(String[] args) {
		new Game().run();
	}

}
