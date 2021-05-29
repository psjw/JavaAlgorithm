import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_08 {

    public static String solution(String str){
        String answer = "YES";
        int lt = 0;
        int rt = str.length() - 1;
        int count = 0;
        char[] s = str.toUpperCase(Locale.ROOT).toCharArray();
        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])){
                lt++;
                continue;
            }
            if(!Character.isAlphabetic(s[rt])){
                rt--;
                continue;
            }
            if(s[lt] != s[rt]){
                count++;
                break;
            }
            lt++;
            rt--;
        }
//        System.out.println(count+"/"+str.length());
        if(count>0){
            answer = "NO";
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
