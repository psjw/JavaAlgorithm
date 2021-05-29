import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_section1_09_sol {

    public static int solution(String str){
        int answer = 0;
        for(char x: str.toCharArray()){
            if(x>=48 && x<=57){
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
            // x>=48 & x<= 57
            // answer =  answer * 10 + (X-48)
            // 0 = 0 * 10 + 0
            // 1 = 0 * 10 +1
            //12 = 1* 10 +2
            //120 = 12 * 10 + 0
            //1205 = 120 * 10 + 5
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
