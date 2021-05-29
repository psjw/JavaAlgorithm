import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_section1_05 {
    public static String solution(String str) {
        String answer = "";
        int lt = 0;
        int rt = str.length()-1;
        char[] charTmp = str.toCharArray();
        while (lt < rt) {
            if (!((97 <= (int)charTmp[lt] && (int)charTmp[lt] <= 122) || (65 <= (int)charTmp[lt] && (int)charTmp[lt] <= 90))) {
                lt++;
            }else if (!((97 <= (int)charTmp[rt] && (int)charTmp[rt] <= 122) || (65 <= (int)charTmp[rt] && (int)charTmp[rt] <= 90))) {
                rt--;
            }else{
                char tmp = charTmp[lt];
                charTmp[lt] = charTmp[rt];
                charTmp[rt] = tmp;
                lt++;
                rt--;
            }


        }
        return String.valueOf(charTmp);

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

