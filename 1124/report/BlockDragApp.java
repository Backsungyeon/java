package Hello.eclipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BlockDragApp {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("블록 생성 및 드래깅");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null); // 레이아웃 관리자 제거

        // 랜덤 색상 생성기
        Random random = new Random();

        // KeyListener 추가
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') { // 'm' 키가 눌렸을 때
                    // 새로운 블록 생성
                    JLabel block = new JLabel();
                    block.setOpaque(true); // 배경색 적용
                    block.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))); // 랜덤 색상
                    block.setBounds(100, 100, 80, 80); // 초기 위치와 크기 설정

                    // 블록에 마우스 이벤트 추가
                    addDragFunctionality(block);

                    // JFrame에 블록 추가
                    frame.add(block);
                    frame.repaint(); // 화면 갱신
                }
            }
        });

        // JFrame 보이기 설정
        frame.setVisible(true);
    }

    // 블록에 드래깅 기능 추가 메서드
    private static void addDragFunctionality(JLabel block) {
        block.addMouseListener(new MouseAdapter() {
            java.awt.Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint(); // 클릭 위치 저장
            }
        });

        block.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 새로운 위치 계산
                int x = block.getX() + e.getX() - block.getWidth() / 2;
                int y = block.getY() + e.getY() - block.getHeight() / 2;
                block.setLocation(x, y); // 위치 업데이트
            }
        });
    }
}
