package java2024;

public class Array_4 {

    public static void main(String[] args) {
        int array[] = new int[10];
        double sum = 0;
        
        for(int i=0; i<array.length; i++) {
        	array[i] = (int)(Math.random()*9) + 11;
        }
        System.out.print("랜덤한 정수들...");
        for(int i=0; i<array.length; i++) {
        	 System.out.print(array[i] + " ");
        	 sum += array[i];
        }
        System.out.println();
        System.out.print("평균은 " + sum/array.length);
    }
}
