import java.util.ArrayList;
import java.util.Scanner;

public class LocationManagerWithList {
    public static void main(String[] args) {
        ArrayList<Location> locationList = new ArrayList<>();
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
            locationList.add(location);
        }

        System.out.println("\n리스트에 있는 모든 도시 출력:");
        for (Location location : locationList) {
            System.out.println(location);
        }

        while (true) {
            System.out.print("\n도시 이름 >> ");
            String cityName = scanner.nextLine();
            if (cityName.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean found = false;
            for (Location location : locationList) {
                if (location.getCityName().equals(cityName)) {
                    System.out.println(location);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(cityName + "은(는) 없습니다.");
            }
        }

        scanner.close();
    }
}
