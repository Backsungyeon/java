import java.io.File;
import java.util.Scanner;

public class SimpleFileExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File currentDirectory = new File("C:\\"); // 초기 디렉토리 설정

        System.out.println("***** 파일 탐색기입니다. *****");

        while (true) {
            System.out.println("\n[" + currentDirectory.getAbsolutePath() + "]");

            // 현재 디렉토리의 파일 및 디렉토리 목록 출력
            File[] files = currentDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.printf("dir\t%s%n", file.getName());
                    } else {
                        System.out.printf("file\t%s\t%d바이트%n", file.getName(), file.length());
                    }
                }
            } else {
                System.out.println("현재 디렉토리를 읽을 수 없습니다.");
            }

            System.out.print("\n>> ");
            String input = scanner.nextLine();

            // 상위 디렉토리 이동
            if (input.equals("..")) {
                File parent = currentDirectory.getParentFile();
                if (parent != null) {
                    currentDirectory = parent;
                } else {
                    System.out.println("더 이상 상위 디렉토리가 없습니다.");
                }
            }
            // 종료 명령
            else if (input.equalsIgnoreCase("exit")) {
                System.out.println("파일 탐색기를 종료합니다.");
                break;
            }
            // 하위 디렉토리 이동
            else {
                File newDirectory = new File(currentDirectory, input);
                if (newDirectory.exists() && newDirectory.isDirectory()) {
                    currentDirectory = newDirectory;
                } else {
                    System.out.println(input + "은(는) 디렉토리가 아니거나 존재하지 않습니다.");
                }
            }
        }

        scanner.close();
    }
}
