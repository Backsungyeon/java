import java.util.HashMap;
import java.util.Scanner;

public class ShoppingWithMap {
    public static void main(String[] args) {
        // 물건과 가격을 HashMap에 저장
        HashMap<String, Integer> items = new HashMap<>();
        items.put("고추장", 3000);
        items.put("만두", 500);
        items.put("새우깡", 1500);
        items.put("콜라", 600);
        items.put("참치캔", 2000);
        items.put("치약", 1000);
        items.put("연어", 2500);
        items.put("삼겹살", 2500);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (String item : items.keySet()) {
            System.out.println("[" + item + ", " + items.get(item) + "]");
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("물건과 개수를 입력하세요>>");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("쇼핑을 종료합니다.");
                break;
            }

            String[] purchases = input.split(" ");
            int totalCost = 0;
            boolean hasError = false;

            for (int i = 0; i < purchases.length; i += 2) {
                try {
                    String item = purchases[i];
                    int quantity = Integer.parseInt(purchases[i + 1]);

                    if (items.containsKey(item)) {
                        totalCost += items.get(item) * quantity;
                    } else {
                        System.out.println(item + "은(는) 없는 상품입니다!");
                        hasError = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("입력에 문제가 있습니다!");
                    hasError = true;
                    break;
                }
            }

            if (!hasError) {
                System.out.println("전체 비용은 " + totalCost + "원입니다.");
            }
        }
        scanner.close();
    }
}
