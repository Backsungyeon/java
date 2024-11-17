import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineNumberPrinter {
    public static void main(String[] args) {
        String filePath = "C:\\Windows\\system.ini";

        System.out.println(filePath + " 파일을 읽어 출력합니다.");

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            int lineNumber = 1; // 라인 번호 초기화

            while (scanner.hasNextLine()) { // 파일에 읽을 내용이 있는 동안
                String line = scanner.nextLine(); // 한 줄 읽기
                System.out.printf("%4d: %s%n", lineNumber, line); // 라인 번호와 함께 출력
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
