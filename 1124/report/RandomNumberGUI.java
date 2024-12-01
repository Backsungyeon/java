package Hello.eclipse;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomNumberGUI{
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("West Grid 프레임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // 컨텐트 팬의 레이아웃을 BorderLayout으로 설정
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // WEST 영역: GridLayout으로 10개의 버튼 배치
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(10, 1)); // 10x1 GridLayout

        // 다양한 색상 추가
        Color[] colors = {
            Color.RED, Color.GRAY, Color.YELLOW, Color.BLUE, Color.GREEN,
            Color.PINK, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.LIGHT_GRAY
        };

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton();
            button.setBackground(colors[i]); // 버튼 배경색 설정
            button.setOpaque(true); // Opaque 활성화
            button.setBorderPainted(false); // 테두리 제거
            westPanel.add(button);
        }

        contentPane.add(westPanel, BorderLayout.WEST); // WEST 영역에 추가

        // CENTER 영역: JLabel을 이용해 랜덤 숫자 표시
        JPanel centerPanel = new JPanel(null); // null 레이아웃 사용
        contentPane.add(centerPanel, BorderLayout.CENTER);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(random.nextInt(10))); // 0~9 랜덤 숫자
            label.setFont(new Font("Arial", Font.BOLD, 18)); // 폰트 설정
            label.setForeground(Color.RED); // 글자 색상 설정

            // 랜덤 좌표 설정 (50, 50) ~ (200, 200)
            int x = 50 + random.nextInt(151); // 50~200 범위
            int y = 50 + random.nextInt(151); // 50~200 범위
            label.setBounds(x, y, 20, 20); // 위치와 크기 설정
            centerPanel.add(label);
        }

        // JFrame 보이기 설정
        frame.setVisible(true);
    }
}
