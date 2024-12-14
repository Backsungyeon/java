package Report;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentManagementApp {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB URL
    private static final String DB_USER = "system"; // Oracle DB 사용자명
    private static final String DB_PASSWORD = "sys"; // Oracle DB 비밀번호

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtName, txtStudentId, txtScore, txtSearch;

    public StudentManagementApp() {
        SwingUtilities.invokeLater(() -> {
            initializeUI();
            loadDataFromDatabase();
        });
    }

    private void initializeUI() {
        frame = new JFrame("학생 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600); // 충분한 크기 설정
        frame.setLayout(new BorderLayout());

        // JTable 및 테이블 모델 설정
        tableModel = new DefaultTableModel(new String[]{"ID", "이름", "학번", "점수"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 입력 필드 및 버튼 추가
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout()); // UI 요소가 겹치지 않도록 GridBagLayout 사용
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // 요소 간 간격 설정
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtName = new JTextField(10);
        txtStudentId = new JTextField(10);
        txtScore = new JTextField(10);
        txtSearch = new JTextField(15);

        JButton btnAdd = new JButton("추가");
        JButton btnUpdate = new JButton("수정");
        JButton btnDelete = new JButton("삭제");
        JButton btnSearch = new JButton("검색");
        JButton btnReset = new JButton("초기화");

        // 이름 필드
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("이름:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtName, gbc);

        // 학번 필드
        gbc.gridx = 2;
        inputPanel.add(new JLabel("학번:"), gbc);
        gbc.gridx = 3;
        inputPanel.add(txtStudentId, gbc);

        // 점수 필드
        gbc.gridx = 4;
        inputPanel.add(new JLabel("점수:"), gbc);
        gbc.gridx = 5;
        inputPanel.add(txtScore, gbc);

        // 추가 버튼
        gbc.gridx = 6;
        inputPanel.add(btnAdd, gbc);

        // 수정 버튼
        gbc.gridx = 7;
        inputPanel.add(btnUpdate, gbc);

        // 삭제 버튼
        gbc.gridx = 8;
        inputPanel.add(btnDelete, gbc);

        // 검색 필드
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("검색:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 4;
        inputPanel.add(txtSearch, gbc);

        // 검색 버튼
        gbc.gridx = 5; gbc.gridwidth = 1;
        inputPanel.add(btnSearch, gbc);

        // 초기화 버튼
        gbc.gridx = 6;
        inputPanel.add(btnReset, gbc);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // 버튼 동작 연결
        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnSearch.addActionListener(e -> searchStudent());
        btnReset.addActionListener(e -> clearInputFields());

        frame.setVisible(true);
    }

    private void loadDataFromDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement()) {
            String query = "SELECT * FROM STUDENTS";
            ResultSet rs = stmt.executeQuery(query);
            tableModel.setRowCount(0); // 테이블 초기화

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("STUDENT_ID"),
                        rs.getInt("SCORE")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "데이터를 불러오는 중 오류 발생: " + e.getMessage());
        }
    }

    private void addStudent() {
        String name = txtName.getText();
        String studentId = txtStudentId.getText();
        String scoreText = txtScore.getText();

        if (name.isEmpty() || studentId.isEmpty() || scoreText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "모든 필드를 입력해주세요.");
            return;
        }

        try {
            int score = Integer.parseInt(scoreText);
            if (score < 0 || score > 100) {
                JOptionPane.showMessageDialog(frame, "점수는 0에서 100 사이여야 합니다.");
                return;
            }

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = connection.prepareStatement(
                         "INSERT INTO STUDENTS (NAME, STUDENT_ID, SCORE) VALUES (?, ?, ?)")) {
                pstmt.setString(1, name);
                pstmt.setString(2, studentId);
                pstmt.setInt(3, score);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "학생 추가 완료!");
                loadDataFromDatabase();
                clearInputFields();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "점수는 숫자여야 합니다.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "학생 추가 중 오류 발생: " + e.getMessage());
        }
    }

    private void updateStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "수정할 학생을 선택하세요.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String name = txtName.getText();
        String studentId = txtStudentId.getText();
        String scoreText = txtScore.getText();

        if (name.isEmpty() || studentId.isEmpty() || scoreText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "모든 필드를 입력해주세요.");
            return;
        }

        try {
            int score = Integer.parseInt(scoreText);
            if (score < 0 || score > 100) {
                JOptionPane.showMessageDialog(frame, "점수는 0에서 100 사이여야 합니다.");
                return;
            }

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement pstmt = connection.prepareStatement(
                         "UPDATE STUDENTS SET NAME = ?, STUDENT_ID = ?, SCORE = ? WHERE ID = ?")) {
                pstmt.setString(1, name);
                pstmt.setString(2, studentId);
                pstmt.setInt(3, score);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "학생 정보 수정 완료!");
                loadDataFromDatabase();
                clearInputFields();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "점수는 숫자여야 합니다.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "학생 정보 수정 중 오류 발생: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "삭제할 학생을 선택하세요.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(
                     "DELETE FROM STUDENTS WHERE ID = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "학생 삭제 완료!");
            loadDataFromDatabase();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "학생 삭제 중 오류 발생: " + e.getMessage());
        }
    }

    private void searchStudent() {
        String keyword = txtSearch.getText();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM STUDENTS WHERE NAME LIKE ? OR STUDENT_ID LIKE ?")) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            tableModel.setRowCount(0);

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("STUDENT_ID"),
                        rs.getInt("SCORE")
                });
            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(frame, "검색 결과가 없습니다.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "검색 중 오류 발생: " + e.getMessage());
        }
    }

    private void clearInputFields() {
        txtName.setText("");
        txtStudentId.setText("");
        txtScore.setText("");
        txtSearch.setText("");
    }

    public static void main(String[] args) {
        new StudentManagementApp();
    }
}
