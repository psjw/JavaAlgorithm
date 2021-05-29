import java.util.Scanner;

public class Main_section1_03_sol {
    public static String solution(String str) {

        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len = x.length();
            if(len > m){
                m = len;
                answer = x;
            }
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
