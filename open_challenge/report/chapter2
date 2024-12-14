//가위바위보 게임
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");

        // 철수 입력
        System.out.print("철수 >> ");
        String chulsooChoice = scanner.nextLine();

        // 영희 입력
        System.out.print("영희 >> ");
        String youngheeChoice = scanner.nextLine();

        // 결과 판별
        String result = determineWinner(chulsooChoice, youngheeChoice);

        // 결과 출력
        System.out.println(result);

        scanner.close();
    }

    // 승자 판별 메소드
    public static String determineWinner(String chulsoo, String younghee) {
        if (chulsoo.equals(younghee)) {
            return "비겼습니다!";
        } else if ((chulsoo.equals("가위") && younghee.equals("보")) ||
                   (chulsoo.equals("바위") && younghee.equals("가위")) ||
                   (chulsoo.equals("보") && younghee.equals("바위"))) {
            return "철수가 이겼습니다!";
        } else {
            return "영희가 이겼습니다!";
        }
    }
}
