import java.io.*;

public class FileCopyWithProgress {
    public static void main(String[] args) {
        String sourceFile = "a.jpg"; // 원본 파일 이름
        String destinationFile = "b.jpg"; // 복사할 대상 파일 이름

        System.out.println(sourceFile + "를 " + destinationFile + "로 복사합니다.");
        System.out.println("10%마다 *를 출력합니다.");

        File source = new File(sourceFile);
        File destination = new File(destinationFile);

        if (!source.exists()) {
            System.out.println("원본 파일이 존재하지 않습니다: " + sourceFile);
            return;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            long totalSize = source.length(); // 원본 파일의 크기
            long copiedSize = 0; // 복사된 바이트 크기
            int progress = 0; // 현재 진행 퍼센트
            byte[] buffer = new byte[1024]; // 1KB 버퍼
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead); // 읽은 데이터를 쓰기
                copiedSize += bytesRead;

                int newProgress = (int) (copiedSize * 100 / totalSize); // 현재 진행 퍼센트 계산
                if (newProgress >= progress + 10) { // 10% 단위로 출력
                    progress += 10;
                    System.out.print("*");
                }
            }

            System.out.println("\n복사가 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 중 오류 발생: " + e.getMessage());
        }
    }
}
