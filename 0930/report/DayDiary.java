package java2024;

public class DayDiary {
    private String memo;

    public DayDiary() {
        this.memo = ""; // 초기값은 빈 문자열
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo.isEmpty() ? "•••" : memo; // 메모가 없으면 "•••" 반환
    }
}
