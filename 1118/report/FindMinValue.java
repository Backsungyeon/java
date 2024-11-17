import java.util.Scanner;
import java.util.Vector;

public class FindMinValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();

        System.out.println("정수 입력(-1이면 입력 끝)>>");

        while (true) {
            int input = scanner.nextInt();
            if (input == -1) {
                break; // 입력 종료
            }
            if (input > 0) { // 양의 정수만 추가
                numbers.add(input);
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("입력된 양의 정수가 없습니다.");
        } else {
            int min = numbers.get(0); // 벡터의 첫 번째 값을 최소값으로 초기화
            for (int num : numbers) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("제일 작은 수는 " + min);
        }

        scanner.close();
    }
}
