package java2024;

public class Average {
    private int[] numbers; 
    private int nextIndex; 

    public Average() {
        numbers = new int[10]; 
        nextIndex = 0; 
    }

    public void put(int number) {
        if (nextIndex < 10) { 
            numbers[nextIndex] = number;
            nextIndex++;
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public double getAvg() {
        if (nextIndex == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < nextIndex; i++) {
            sum += numbers[i];
        }
        return sum / nextIndex; 
    }

    
    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10); 
        avg.put(15); 
        avg.put(100); 
        avg.showAll(); 
        System.out.print("평균은 " + avg.getAvg()); 
    }
}

