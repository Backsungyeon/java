package java2024;

import java.util.Scanner;

class Grade {
   private int java;
   private int web;
   private int os;
   
   Grade(int java, int web, int os) {
      this.java = java;
      this.web = web;
      this.os = os;
   }
   
   public int average() {
      return (java + web + os) / 3;
   }
}

public class CreateClass2 {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
      String name = scanner.next(); 
      int java = scanner.nextInt();
      int web = scanner.nextInt();
      int os = scanner.nextInt();
      
      Grade me = new Grade(java, web, os);
      System.out.println(name + "의 평균은 " + me.average());
      
      scanner.close();
   }
}
