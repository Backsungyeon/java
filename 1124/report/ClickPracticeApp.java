package Hello.eclipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ClickPracticeApp {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("클릭 연습 응용프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null); // 배치관리자 삭제 (null 레이아웃)

        // JLabel 생성
        JLabel label = new JLabel("C", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(100, 100, 30, 30); // 초기 위치 (100, 100), 크기 (30x30)
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);

        // 랜덤 객체 생성
        Random random = new Random();

        // JLabel에 마우스 클릭 이벤트 추가
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 새로운 랜덤 위치 계산
                int x = random.nextInt(350); // 0 ~ 350 범위의 x좌표 (창 크기에 따라 조정)
                int y = random.nextInt(350); // 0 ~ 350 범위의 y좌표
                label.setLocation(x, y); // JLabel 위치 변경
            }
        });

        // JLabel을 JFrame에 추가
        frame.add(label);

        // JFrame 표시
        frame.setVisible(true);
    }
}
