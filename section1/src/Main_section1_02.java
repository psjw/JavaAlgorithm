import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_section1_02 {
    public static String solution(String str) {
        String answer = "";
        //65~90
        //97~122
        for(char c : str.toCharArray()){
            if((int)c >= 97){//소문자
                answer+=(char)((int)c-32);
            }else {
                answer += (char)((int) c + 32);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.println(solution(a));

    }
}

