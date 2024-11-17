public class Location {
    private String cityName;
    private double latitude;  // 위도
    private double longitude; // 경도

    // 생성자
    public Location(String cityName, double latitude, double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 도시 이름 반환
    public String getCityName() {
        return cityName;
    }

    // 위도 반환
    public double getLatitude() {
        return latitude;
    }

    // 경도 반환
    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return cityName + " " + latitude + " " + longitude;
    }
}
