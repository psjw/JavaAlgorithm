import java.util.Scanner;

public class Main_section1_09_sol2 {

    public static int solution(String str){
        String answer = "";
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
            // x>=48 & x<= 57
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
