package java2024;

import java.util.Scanner;

public class GamblingGame {
	private Player [] players;
	private Scanner scanner = new Scanner(System.in);
	
	public GamblingGame() {
		System.out.print("갬블링 게임에 참여할 선수 숫자>>");
		 
		int nPlayers = scanner.nextInt();ㅁ
		scanner.nextLine(); // 버퍼에 입력된 <Enter>키 제거. 
		 
		players = new Player[nPlayers]; // 2대신 3으로 고치면 3명이 하는 게임이 된다.		 
		for(int i=0; i<players.length; i++) {
			System.out.print((i+1)+"번째 선수 이름>>");
			players[i] = new Player(scanner.nextLine());
		}
	}
	
	public void run() {
		int i=0; // i는 선수 번호
		
		// 게임이 끝날 때까지 선수들을 순서대로 돌아가면서 갬블링한다.
		while (true) {
			// i 번째 선수
			if (players[i].turn()) { // 선수 i의 세 수가 모두 같은 경우
				System.out.println(players[i].getName()+"님이 이겼습니다!");
				break;
			}
			else {
				System.out.println("아쉽군요!");
				i++; // 다음 선수
				i = i%players.length; // 선수 수로 나눈 나머지로 다음 선수 결정 
			}
		}
	}
		
	public static void main(String [] args) {
		GamblingGame game = new GamblingGame();
		game.run();
	}
}
