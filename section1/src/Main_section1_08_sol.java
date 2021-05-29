import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_08_sol {

    public static String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]",""); //^ 부정
        String tmp = new StringBuilder(str).reverse().toString();
        if(tmp.equals(str)){
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str=br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
