import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingWithList {
    public static void main(String[] args) {
        // 물건과 가격을 ArrayList에 저장
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();

        items.add("고추장"); prices.add(3000);
        items.add("만두"); prices.add(500);
        items.add("새우깡"); prices.add(1500);
        items.add("콜라"); prices.add(600);
        items.add("참치캔"); prices.add(2000);
        items.add("치약"); prices.add(1000);
        items.add("연어"); prices.add(2500);
        items.add("삼겹살"); prices.add(2500);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + items.get(i) + ", " + prices.get(i) + "]");
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

                    if (items.contains(item)) {
                        int index = items.indexOf(item);
                        totalCost += prices.get(index) * quantity;
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
