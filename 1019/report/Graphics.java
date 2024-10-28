package java2024;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape {
    private Shape next;

    public Shape() {
        next = null;
    }

    public void setNext(Shape obj) {
        next = obj;
    }

    public Shape getNext() {
        return next;
    }

    public abstract void draw();
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void insertShape() {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int shapeType = scanner.nextInt();
        Shape shape = null;
        switch (shapeType) {
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }
        shapes.add(shape);
    }

    public void deleteShape() {
        System.out.print("삭제할 도형의 위치>>");
        int index = scanner.nextInt();
        if (index >= 1 && index <= shapes.size()) {
            shapes.remove(index - 1);
        } else {
            System.out.println("삭제할 수 없습니다.");
        }
    }

    public void showAllShapes() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    insertShape();
                    break;
                case 2:
                    deleteShape();
                    break;
                case 3:
                    showAllShapes();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

public class Graphics {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}
