import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_07_sol {
    public static String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase(Locale.ROOT);
        int len = str.length();
        for(int i=0;i<len/2;i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                answer = "NO";
                break;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

