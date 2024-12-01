package Hello.eclipse;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.File;

public class AudioPlayerApp {
    private static Clip audioClip;

    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("오디오 연주 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // JMenuBar 생성
        JMenuBar menuBar = new JMenuBar();

        // "오디오" 메뉴 생성
        JMenu audioMenu = new JMenu("오디오");

        // "연주" 및 "종료" 메뉴아이템 생성
        JMenuItem playMenuItem = new JMenuItem("연주");
        JMenuItem stopMenuItem = new JMenuItem("종료");

        // "연주" 메뉴아이템 클릭 이벤트
        playMenuItem.addActionListener(e -> playAudio());

        // "종료" 메뉴아이템 클릭 이벤트
        stopMenuItem.addActionListener(e -> stopAudio());

        // 메뉴에 메뉴아이템 추가
        audioMenu.add(playMenuItem);
        audioMenu.add(stopMenuItem);

        // 메뉴바에 메뉴 추가
        menuBar.add(audioMenu);

        // JFrame에 메뉴바 추가
        frame.setJMenuBar(menuBar);

        // JFrame 표시
        frame.setVisible(true);
    }

    // 오디오 재생 메서드
    private static void playAudio() {
        // JFileChooser로 wav 파일 선택
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a WAV file to play");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File audioFile = fileChooser.getSelectedFile();

            try {
                // 기존에 재생 중인 클립이 있으면 중지
                if (audioClip != null && audioClip.isRunning()) {
                    audioClip.stop();
                    audioClip.close();
                }

                // 오디오 파일 재생 준비
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);
                audioClip.start(); // 재생 시작
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "오디오 파일을 재생할 수 없습니다: " + ex.getMessage());
            }
        }
    }

    // 오디오 종료 메서드
    private static void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
            JOptionPane.showMessageDialog(null, "오디오 재생이 종료되었습니다.");
        }
    }
}
