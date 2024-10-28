package java2024;

import java.util.Scanner;

class SortedArray extends BaseArray{
	SortedArray(int size){
		super(size);
	}
	
	public int[] sort() {
		int arr[] = super.array;
		int chage = 0;
		for(int i=0; i<length()-1; i++) {
			for(int j=1; j<length()-i; j++) {
				if(arr[j]<arr[j-1]) {
					chage = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = chage;
				}
			}
		}
		return arr;
	}
	public void print() {
		sort();
		super.print();
	}
}
public class Array {
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner scanner = new Scanner(System.in);
		System.out.print("»>");
		for (int i=0; i<sArray.length(); i++) { 
			int n = scanner.nextInt();
			sArray.add(n);
		}
		sArray.print(); 
		scanner .close();
	}

}
