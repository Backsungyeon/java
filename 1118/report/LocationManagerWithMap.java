import java.util.HashMap;
import java.util.Scanner;

public class LocationManagerWithMap {
    public static void main(String[] args) {
        HashMap<String, Location> locationMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String[] data = input.split(", ");
            String cityName = data[0];
            double longitude = Double.parseDouble(data[1]);
            double latitude = Double.parseDouble(data[2]);

            Location location = new Location(cityName, latitude, longitude);
            locationMap.put(cityName, location);
        }

        System.out.println("\n해시맵에 있는 모든 도시 출력:");
        for (String city : locationMap.keySet()) {
            System.out.println(locationMap.get(city));
        }

        while (true) {
            System.out.print("\n도시 이름 >> ");
            String cityName = scanner.nextLine();
            if (cityName.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Location location = locationMap.get(cityName);
            if (location == null) {
                System.out.println(cityName + "은(는) 없습니다.");
            } else {
                System.out.println(location);
            }
        }

        scanner.close();
    }
}
