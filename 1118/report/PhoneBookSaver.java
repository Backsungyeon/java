import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "C:\\temp\\phone.txt";

        System.out.println("전화번호 입력 프로그램입니다.");
        try (FileWriter writer = new FileWriter(filePath)) { // FileWriter를 사용하여 파일 열기
            while (true) {
                System.out.print("이름 전화번호 >> ");
                String input = scanner.nextLine();

                if (input.equals("그만")) { // "그만" 입력 시 종료
                    System.out.println(filePath + "에 저장하였습니다.");
                    break;
                }

                writer.write(input + "\n"); // 파일에 입력 저장
            }
        } catch (IOException e) {
            System.out.println("파일 쓰기에 실패했습니다: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
