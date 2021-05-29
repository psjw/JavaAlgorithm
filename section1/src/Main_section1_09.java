import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main_section1_09 {

    public static String solution(String str){
        char[] s = str.toCharArray();
        String tmp = "";
        for(char m : s){
            if((int)m<=57&&(int)m>=48){
                if("".equals(tmp)&&(int)m ==48){
                    continue;
                }
                tmp += m;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
//            System.out.println((int)"0".charAt(0));
//            System.out.println((int)"9".charAt(0));
            String str=br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
