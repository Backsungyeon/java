package java2024;

class Student {
	private String name;
	private int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "학번이 " + id + "인 황기태";
	}
	
	@Override
	public boolean equals(Object obj) {
		Student b = (Student)obj;
		if(name.equals(b.name) && id == b.id)
			return true;
		else
			return false;
	}
}

public class StudentApp {

	public static void main(String[] args) {
		Student a = new Student("황기태", 23); // id가 23인 황기태 학생
		Student b = new Student("황기태", 77); // id가 77인 황기태 학생
		System.out.println(a);
		if(a.equals(b))
			System.out.println("같은 학생입니다.");
		else
			System.out.println("다른 학생입니다.");
	}

}
