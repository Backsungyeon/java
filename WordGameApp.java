package java2024;

import java.util.Scanner;
 
class Player{
    String name;
    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
 
public class WordGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");
 
        String word = "아버지";
        int lastIndex = word.length() - 1; 
        char lastChar = word.charAt(lastIndex); 
        char firstChar = word.charAt(0);
 
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        int num = scanner.nextInt();
 
        Player [] p = new Player[num];
 
        for(int i=0; i<num; i++){
            System.out.print("참가자의 이름을 입력하세요>>");
            p[i] = new Player(scanner.next());
        }

        System.out.println("시작하는 단어는 " + word + " 입니다.");
 
        int cnt=0;
        while(true){
            System.out.print(p[cnt].getName() + ">>");
            String nextword = scanner.next();
            firstChar = nextword.charAt(0);
 
            if(firstChar != lastChar){
                System.out.println(p[cnt].getName() + "이 졌습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
            lastIndex = nextword.length() - 1;
            lastChar = nextword.charAt(lastIndex);
            cnt++;
 
            if(cnt > num-1)
                cnt = 0;
        }
    }
}