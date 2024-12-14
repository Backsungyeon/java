//여러 컴포넌트를 가진 스윙 응용프로그램 만들기
import java.awt.*;
import javax.swing.*;

public class TextRandomPlaceGame extends JFrame {
	private String text ="I can't help falling in love with you";
	
	public TextRandomPlaceGame() {
		super("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); // 컨텐트팬 알아내기
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);

		setSize(400,300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel { // 컨텐트팬의 NORTH 영역 패널
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY); // 배경색 설정
			setLayout(new FlowLayout()); // FlowLayout 배치관리자 지정
			add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~ "));
			add(new JButton("New Text"));
		}
	}
	
	class SouthPanel extends JPanel { // 컨텐트팬의 NORTH 영역 패널
		public SouthPanel() {
			setBackground(Color.YELLOW); // 배경색 설정
			setLayout(new FlowLayout()); // FlowLayout 배치관리자 지정
			add(new JLabel("이름"));		
			add(new JTextField(10));
		}
	}
	
	class CenterPanel extends JPanel {	// 컨텐트팬의 CENTER 영역 패널
		public CenterPanel() {
			setLayout(null); // 배치관리자 삭제, 절대 위치에 컴포넌트 삽입
			setBackground(Color.WHITE);
			place(this, text);
		}
		private void place(Container c, String text) { // text의 문자열을 단어별로 쪼개 컨테이너 c에 분산 배치 
			String [] words = text.split(" "); // text 문자열을 " "을 기준으로 단어 분리. words [] 단어 배열 생성 
			for(int i=0; i<words.length; i++) { // 각 단어 대해 루프
				JLabel label = new JLabel(words[i]); // 단어를 JLabel로 생성
				int x = (int)(Math.random()*350);
				int y = (int)(Math.random()*180);
				label.setLocation(x,y); // 랜덤한 위치에 배치
				label.setSize(50, 20);
				c.add(label); // 레이블을 CenterPanel에 부착
			}			
		}

	}

	public static void main(String[] args) {
		new TextRandomPlaceGame();
	}

}
