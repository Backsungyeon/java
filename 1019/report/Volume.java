package java2024;

import java.util.*;

interface IStack{
	int capacity();
	int length();
	boolean push(String val);
	String pop();
}

class StringStack implements IStack {
	int size;
	String arr[];
	int top;
	StringStack(int size){
		this.size = size;
		arr = new String [size];
		top = 0;
	}
	public int capacity() {
		return size;
	}

	public int length() {
		return top;
	}

	public boolean push(String val) {
		if(length() < size) {
			arr[top] = val;
			top++;
			return true;
		}else {
			return false;			
		}
	}

	public String pop() {
		if(length() >= 0) {
			String top = arr[this.top];
			arr[this.top] = null;
			this.top--;
			return top;
		}
		return null;
	}
	
}

public class Volume {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("스택용량>>");
		StringStack st = new StringStack(sc.nextInt());
		System.out.print(st.length());
		while(true) {
			System.out.print("문자열 입력>>");
			String voca = sc.next();
			System.out.print(st.length());
			if(voca.equals("그만")) { break; }
			if(st.push(voca) == false) { System.out.println("스택이 꽉 차서 디지털 저장 불가"); }
		}
		st.top--;
		System.out.print("스택에 저장된 문자열 팝>>");
		while(true) {
			String top = st.pop();
			if(top==null) { break; }
			System.out.print(top + " ");
		}
		sc.close();
	}
}
