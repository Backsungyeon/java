package Hello.eclipse;

import javax.swing.*;
import java.awt.*;

public class ColorGrid {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("4x4 Color Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // 컨텐트 팬의 레이아웃을 GridLayout으로 설정 (4x4)
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(4, 4));

        // 색상 배열 정의
        Color[] colors = {
            Color.WHITE, Color.GRAY, Color.RED, Color.BLUE,
            Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA,
            Color.PINK, Color.ORANGE, Color.LIGHT_GRAY, Color.DARK_GRAY,
            Color.BLACK, new Color(128, 0, 128), new Color(0, 128, 128), new Color(128, 128, 0)
        };

        // 16개의 JLabel 생성 및 색상 설정
        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(); // JLabel 생성
            label.setOpaque(true); // 배경색 적용을 위해 Opaque 설정
            label.setBackground(colors[i]); // 배경색 설정
            label.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬
            label.setText("Color " + (i + 1)); // 텍스트 설정
            contentPane.add(label); // 컨텐트 팬에 추가
        }

        // 프레임 보이기 설정
        frame.setVisible(true);
    }
}
