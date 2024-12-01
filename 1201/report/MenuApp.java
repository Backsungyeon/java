
package Hello.eclipse;

import javax.swing.*;

public class MenuApp {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("메뉴 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // JMenuBar 생성
        JMenuBar menuBar = new JMenuBar();

        // 4개의 메뉴 생성 ("파일", "편집", "보기", "입력")
        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        JMenu inputMenu = new JMenu("입력");

        // "보기" 메뉴에 2개의 메뉴아이템 추가 ("화면확대", "쪽윤곽")
        JMenuItem zoomMenuItem = new JMenuItem("화면확대");
        JMenuItem outlineMenuItem = new JMenuItem("쪽윤곽");

        // "보기" 메뉴에 메뉴아이템 추가
        viewMenu.add(zoomMenuItem);
        viewMenu.add(outlineMenuItem);

        // 메뉴바에 메뉴 추가
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(inputMenu);

        // JFrame에 메뉴바 설정
        frame.setJMenuBar(menuBar);

        // JFrame 표시
        frame.setVisible(true);
    }
}
