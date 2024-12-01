package Hello.eclipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TextGame {
    private static JFrame frame;
    private static JPanel wordPanel;
    private static JLabel resultLabel;
    private static String[] texts = {
        "This is a fun game",
        "Java programming is powerful",
        "I love learning new things",
        "Swing makes GUI easy",
        "Random words are interesting"
    };
    private static String selectedText = "";
    private static String[] selectedWords;
    private static ArrayList<String> userSequence = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        // JFrame 설정
        frame = new JFrame("Text Combination Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // 상단에 "New Text" 버튼 추가
        JButton newTextButton = new JButton("New Text");
        frame.add(newTextButton, BorderLayout.NORTH);

        // 중앙에 단어를 표시할 패널
        wordPanel = new JPanel();
        wordPanel.setLayout(null);
        frame.add(wordPanel, BorderLayout.CENTER);

        // 하단에 결과 표시할 레이블
        resultLabel = new JLabel("Click on the words in order to complete the sentence.", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(resultLabel, BorderLayout.SOUTH);

        // "New Text" 버튼 클릭 이벤트
        newTextButton.addActionListener(e -> loadNewText());

        // JFrame 표시
        frame.setVisible(true);
    }

    // 새 텍스트 로드
    private static void loadNewText() {
        // 텍스트 랜덤 선택
        selectedText = texts[random.nextInt(texts.length)];
        selectedWords = selectedText.split(" ");
        userSequence.clear();

        // 단어 섞기
        ArrayList<String> shuffledWords = new ArrayList<>();
        Collections.addAll(shuffledWords, selectedWords);
        Collections.shuffle(shuffledWords);

        // 패널 초기화
        wordPanel.removeAll();

        // 단어 버튼 생성 및 배치
        for (String word : shuffledWords) {
            JButton wordButton = new JButton(word);
            wordButton.setFont(new Font("Arial", Font.BOLD, 14));

            // 랜덤 위치 설정
            int x = random.nextInt(wordPanel.getWidth() - 100) + 10;
            int y = random.nextInt(wordPanel.getHeight() - 50) + 10;
            wordButton.setBounds(x, y, 100, 30);

            // 단어 버튼 클릭 이벤트
            wordButton.addActionListener(e -> handleWordClick(wordButton));

            // 패널에 추가
            wordPanel.add(wordButton);
        }

        wordPanel.repaint();
        resultLabel.setText("Click on the words in order to complete the sentence.");
    }

    // 단어 클릭 처리
    private static void handleWordClick(JButton wordButton) {
        String word = wordButton.getText();

        // 클릭된 단어가 올바른 순서인지 확인
        if (userSequence.size() < selectedWords.length && word.equals(selectedWords[userSequence.size()])) {
            userSequence.add(word);
            resultLabel.setText(String.join(" ", userSequence)); // 결과 업데이트
            wordButton.setEnabled(false); // 버튼 비활성화

            // 문장을 완성했는지 확인
            if (userSequence.size() == selectedWords.length) {
                resultLabel.setText("Congratulations! You completed the sentence: " + selectedText);
                JOptionPane.showMessageDialog(frame, "You completed the sentence!");
            }
        } else {
            // 잘못된 순서로 클릭한 경우
            JOptionPane.showMessageDialog(frame, "Wrong word! Try again.");
        }
    }
}
