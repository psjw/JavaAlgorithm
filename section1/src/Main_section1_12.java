import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_section1_12 {

    public static String solution(String str,int n) {
        String answer = "";
        int splitIdx = str.length() / n;
        int cnt = splitIdx-1;
        char[] s = str.toCharArray();
        int tmp = 0;
        for(int i=0; i<str.length();i++){

            if(str.charAt(i)=='#'){
                    tmp += Math.pow(2, cnt);
            }
            cnt--;
            if( cnt < 0){
                cnt = 6;
                answer += (char) tmp;
                tmp = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            System.out.println(solution(str,n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
