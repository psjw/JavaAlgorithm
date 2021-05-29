import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_01 {
    public static int solution(String a, char b) {
        a = a.toUpperCase(Locale.ROOT);
        int mid = a.length() / 2;
        int left = 0;
        int right = a.length() - 1;
        int anwser = 0;
        while (right >= left) {

            char leftStr = a.charAt(left);
            left++;
            if (leftStr == b ){
                anwser++;
            }
            //홀수 일때만
            if(right == mid & mid%2 ==1)
                break;

            char rightStr = a.charAt(right);
            right--;
            if(rightStr ==b){
                anwser++;
            }
        }
        return anwser;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String a = br.readLine();
            char b = br.readLine().toUpperCase(Locale.ROOT).charAt(0);
            System.out.println(solution(a, b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
