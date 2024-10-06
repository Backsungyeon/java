package java2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GamePlayer {
    String name;
    int score;

    public GamePlayer(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        score++;
    }

    public String toString() {
        return name + ":" + score;
    }
}

public class GuessGame {
    List<GamePlayer> players = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.print("*** 예측 게임을 시작합니다. ***\n게임에 참여할 선수 수>>");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("선수 이름>>");
            String playerName = scanner.nextLine();
            players.add(new GamePlayer(playerName));
        }

        boolean continueGame = true;
        while (continueGame) {
            int hiddenAnswer = (int) (Math.random() * 100 + 1);
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            int closestDiff = Integer.MAX_VALUE;
            GamePlayer winner = null;

            for (GamePlayer player : players) {
                System.out.print(player.name + ">>");
                int guess = scanner.nextInt();
                int diff = Math.abs(hiddenAnswer - guess);

                if (diff < closestDiff) {
                    closestDiff = diff;
                    winner = player;
                }
            }

            System.out.println("정답은 " + hiddenAnswer + ". " + winner.name + "이 이겼습니다. 승점 1점 확보!");
            winner.addScore();

            System.out.print("계속하려면 yes 입력>>");
            String input = scanner.next();
            continueGame = input.equalsIgnoreCase("yes");
            scanner.nextLine(); // 개행 문자 처리
        }

        System.out.println();
        for (GamePlayer player : players) {
            System.out.print(player + " ");
        }
        GamePlayer finalWinner = players.stream().max((p1, p2) -> Integer.compare(p1.score, p2.score)).orElse(null);
        System.out.println("\n" + finalWinner.name + "이 최종 승리하였습니다.");
    }

    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}
