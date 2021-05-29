import java.util.Scanner;

public class Main_section1_03_sol2 {
    public static String solution(String str) {

        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length()>m){
            answer = str;
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(solution(a));
        return;
    }
}
