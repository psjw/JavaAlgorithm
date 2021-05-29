import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section1_11 {

    public static String solution(String str) {
        char[] s = str.toCharArray();
        char preChar =s[0];
        int preCnt = 0;
        String tmp = "";
        for(int i=0 ; i<str.length();i++){
            if(preChar == s[i]){
                preCnt++;
            }else{
                tmp += preChar;
                if(preCnt>1){
                    tmp += preCnt;
                }
                preCnt = 1;
                preChar = s[i];

            }
            if(i==str.length()-1){
                tmp += s[i];
                if(preCnt>1){
                    tmp += preCnt;
                }
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
