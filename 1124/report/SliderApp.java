package Hello.eclipse;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderApp {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("슬라이더와 레이블 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // JLabel 생성 (초기 값 설정)
        JLabel label = new JLabel("Value: 100", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        // JSlider 생성 (범위 100~200)
        JSlider slider = new JSlider(100, 200, 100); // 최소값: 100, 최대값: 200, 초기값: 100
        slider.setMajorTickSpacing(20); // 주요 눈금 간격
        slider.setMinorTickSpacing(5);  // 부가 눈금 간격
        slider.setPaintTicks(true);     // 눈금 표시
        slider.setPaintLabels(true);    // 숫자 라벨 표시

        // 슬라이더 이벤트 처리
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue(); // 슬라이더 값 가져오기
                label.setText("Value: " + value); // 레이블에 값 표시
            }
        });

        // 컴포넌트를 프레임에 추가
        frame.add(slider, BorderLayout.CENTER); // 슬라이더는 중앙에 배치
        frame.add(label, BorderLayout.SOUTH);   // 레이블은 아래쪽에 배치

        // JFrame 표시
        frame.setVisible(true);
    }
}
