package java2024;

import java.util.Scanner;

abstract class Box {
    protected int size;

    public Box(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract boolean consume();

    public abstract void print();
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (!isEmpty()) {
            size--;
            return true;
        } else {
            System.out.println(name + " 박스가 비어있습니다.");
            return false;
        }
    }

    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

public class Coffe {
    public static void main(String[] args) {
        IngredientBox coffeeBox = new IngredientBox("커피", 5);
        IngredientBox creamBox = new IngredientBox("프림", 5);
        IngredientBox sugarBox = new IngredientBox("설탕", 5);

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("***** 청춘 커피 자판기 입니다. *****");

        while (true) {
            coffeeBox.print();
            creamBox.print();
            sugarBox.print();

            System.out.print("다방커피: 1, 설탕커피: 2, 블랙커피: 3, 종료: 4 >> ");
            choice = scanner.nextInt();

            if (choice == 1) {
                if (coffeeBox.consume() && creamBox.consume() && sugarBox.consume()) {
                    System.out.println("다방커피 나왔습니다.");
                }
            } else if (choice == 2) {
                if (coffeeBox.consume() && sugarBox.consume()) {
                    System.out.println("설탕커피 나왔습니다.");
                }
            } else if (choice == 3) {
                if (coffeeBox.consume()) {
                    System.out.println("블랙커피 나왔습니다.");
                }
            } else if (choice == 4) {
                System.out.println("자판기를 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }

        scanner.close();
    }
}
