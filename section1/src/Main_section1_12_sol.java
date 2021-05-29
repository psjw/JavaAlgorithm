import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_section1_12_sol {

    public static String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
//            System.out.println(tmp+" "+num);
            s = s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(str, n));
    }
}
