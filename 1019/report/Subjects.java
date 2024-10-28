package java2024;

import java.util.*;

abstract class PairMap{
	protected String keyArray [];
	protected String valueArray [];
	abstract public String get(String key); //검색
	abstract public void put(String key, String value); //추가 
	abstract public String delete(String key); //삭제 
	abstract public int length(); //길이 
}

class Dictionary extends PairMap{
	int size;
	int in = 1;
	Dictionary(int size) {
		this.size = size;
		keyArray = new String [size];
		valueArray = new String [size];
	}
	public String get(String key) {
		int index = Arrays.asList(keyArray).indexOf(key);
		return (index==-1)?null:valueArray[index];
	}

	public void put(String key, String value) {
		if(Arrays.asList(keyArray).indexOf(key) == -1) {
			keyArray[in] = key;
			valueArray[in] = value;
			in++;
		}else {
			valueArray[Arrays.asList(keyArray).indexOf(key)] = value;			
		}
	} 

	public String delete(String key) {
		int index = Arrays.asList(keyArray).indexOf(key);
		String val = valueArray[index];
		valueArray[index] = null;
		keyArray[index] = null;		
		in--;
		return val;
	}

	public int length() {
		return in-1;
	}
	
}

public class Subjects {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary (10);
		dic.put ("황기태", "자바");
		dic. put ("이재문", "파이선");
		dic. put ("이재문", "C++"); // 이재문의 값을 C++로 수정 
		System.out.println("이재문의 값은 "+ dic.get ("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}

}
