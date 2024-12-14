//홀짝 맞추기 게임 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OddOrEvenGameFrame extends JFrame {
	public OddOrEvenGameFrame() {
		super("홀짝 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,230);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel { // 컨텐트팬
		private int answer; // 숨겨진 정수(정답). 1~10 사이의 랜덤한 정수
		private JLabel label = new JLabel("?");
		private JLabel msg = new JLabel("무엇일까요?");
		private JButton [] btns = { new JButton("홀"), new JButton("짝"), new JButton("확인"), new JButton("다시")  };
		
		public MyPanel() {
			setLayout(null); // 배치 관리자 제거
			
			// '?'를 출력하는 마젠타 색의 레이블(박스)
			label.setFont(new Font("고딕", Font.PLAIN, 30));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setForeground(Color.YELLOW);
			label.setBackground(Color.MAGENTA);
			label.setOpaque(true);
			label.setSize(80, 80);
			label.setLocation(100, 20);
			add(label);
			refresh(); // 새로운 정수(1~10)를 랜덤하게 생성하여 answer에 저장 
			
			// 메시지를 출력하는 레이블
			msg.setSize(130, 50);
			msg.setLocation(70, 100);
			msg.setHorizontalAlignment(JLabel.CENTER);
			add(msg);

			MyAction myAction = new MyAction(); // 액션 리스너
			
			for(int i=0; i<btns.length; i++) {
				JButton b = btns[i];
				b.addActionListener(myAction); // 액션 리스너를 버튼에 부착
				b.setSize(60, 30);
				b.setLocation(10 + i*65, 150);
				add(b);
			}
			
		}
		
		private void refresh() {
			answer = (int)(Math.random()*10) + 1; // 1에서 10까지의 정수, [1,10]
			label.setText("?");
			msg.setText("무엇일까요?");
		}
		
		class MyAction implements ActionListener {
			private String user; // 사용자가 선택한 답. "홀"이나 "짝" 중 하나

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				switch(b.getText()) {
					case "홀" : // "홀" 버튼을 클릭한 경우
						user = "홀"; break;
					case "짝" : // "짝" 버튼을 클릭한 경우
						user = "짝"; break;							
					case "확인" : // "확인" 버튼을 클릭한 경우
						check(); // 승리한 것인지 실패한 것인지 판단
						user = ""; // 사용자의 이전 선택 내용 지우기					
						break;
					case "다시" :
						user = ""; // 사용자의 이전 선택 내용 지우기
						refresh(); 
						break;												
				}
			}
			
			private void check() { // 승리한 것인지 실패한 것인지 판단
				if(user == null || user.length() == 0) {
					msg.setText("홀이나 짝 먼저 선택!");
					return; // 사용자가 홀이나 짝 중 선택한 적이 없는 경우
				}
				
				label.setText(Integer.toString(answer));
				String res;
				if(answer%2 == 1) // 정답이 홀 인 경우
					res = "홀";
				else // 정답이 짝 인 경우
					res = "짝";
				
				if(user.equals(res)) 
					res += "! 맞았어요.";
				else
					res += "! 아쉽군요";
				msg.setText(res);
			}
		}
	}
	
	public static void main(String[] args) {
		new OddOrEvenGameFrame();
	}

}
