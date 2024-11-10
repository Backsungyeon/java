package java2024;

import java.util.Scanner;
import java.util.Random;

public class WordGameA {
    public static void main(String[] args) {
        String[] words = {"happy", "morning", "package", "together", "lovely", "extract", "nation", "cookie", "present", "connect"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            String word = words[random.nextInt(words.length)];
            String scrambled = scrambleWord(word, random);

            System.out.println(scrambled);

            long startTime = System.currentTimeMillis();

            System.out.print(">>");
            String input = scanner.nextLine().trim();

            long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

            if (input.equalsIgnoreCase("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (input.equalsIgnoreCase(word)) {
                System.out.println("성공!!! " + elapsedTime + "초 경과");
            } else {
                System.out.println("실패!!! " + word + " 입니다. " + elapsedTime + "초 경과");
            }
        }

        scanner.close();
    }

    private static String scrambleWord(String word, Random random) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
