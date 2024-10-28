package java2024;

import java.util.*;

abstract class Calc {
	 String errorMsg;
	 int a, b;
	 void setValue(int a, int b){
		 this.a = a;
		 this.b = b;
	 }
	 abstract int calculate();
}

class CalculateAdd extends Calc{
	CalculateAdd(int a, int b) {super.setValue(a, b);}
	int calculate() {return a+b;}
}

class CalculateSub extends Calc{
	CalculateSub(int a, int b) {super.setValue(a, b);}
	int calculate() {return a-b;}
}

class CalculateMul extends Calc{
	CalculateMul(int a, int b) {super.setValue(a, b);}
	int calculate() {return a*b;}
}

class CalculateDiv extends Calc{
	int result;
	CalculateDiv(int a, int b) {super.setValue(a, b);}
	int calculate() {
		try {
			result = a/b;
		}catch(ArithmeticException e) {
			System.out.print("0으로 나눌 수 없음. ");
			errorMsg = e.getMessage();
			result = -1;
		}
		return result;
	}
}

public class Aarry2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("두 정수와 연산자를 입력하시오>>");
			String num = sc.nextLine();
			String[] arr = num.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			String oper = arr[2];
			int result = 0;
			
			CalculateAdd add = new CalculateAdd(a, b);
			CalculateSub sub = new CalculateSub(a, b);
			CalculateMul mul = new CalculateMul(a, b);
			CalculateDiv div = new CalculateDiv(a, b);		
			

			switch(oper) {
			case "+" : result = add.calculate(); break;
			case "-" : result = sub.calculate(); break;
			case "*" : result = mul.calculate(); break;
			case "/" : result = div.calculate(); break;
			}
			
			if(div.result == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.println("계산결과>>" + result);
		}
		
		sc.close();
	}
}
