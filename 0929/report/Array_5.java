package java2024;

import java.util.Scanner;

public class Array_5 {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("정수 몇 개 저장하시겠습니까>>");
    	int num = scanner.nextInt();
    	
    	int array[] = new int[num];
    	
        double sum = 0;
        
        for(int i=0; i<array.length; i++) {
        	array[i] = (int)(Math.random()* 100) + 1;
        	for(int j=0; j<i; j++) {
        		while(true) {
        			if(array[i] != array[j]) {
        				break;
        			}else {
        				array[i] = (int)(Math.random()* 100) + 1;
        				j=0;
        			}
        		}
        	}
        	sum += array[i];
        }	
        for(int i=0; i<array.length; i++) {
        	System.out.print(array[i] + " ");
        }
        System.out.println("\n평균은 " + (sum / array.length));
        scanner.close();
    }
}
