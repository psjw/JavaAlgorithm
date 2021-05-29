import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_07 {
    public static String solution(String str) {
        String answer = "";
//        str = str.toUpperCase(Locale.ROOT);
        char s[] = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        int mid = str.length() / 2;
        int count = 0;
        while(lt<rt){
            if(Character.toUpperCase(s[lt])==Character.toUpperCase(s[rt])){
                count++;
            }
            lt++;
            rt--;
        }

        if(count==mid){
            answer = "YES";
        }else{
            answer = "NO";
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

