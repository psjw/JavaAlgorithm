import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section1_10 {
    public static int[] leftDiv;
    public static int[] rightDiv;

    public static void solution(String str, String end) {
        char s[] = str.toCharArray();
        int preIdx = str.indexOf(end);
        int lt = 0;
        int rt = str.length() - 1;
        int ltEndIdx = str.indexOf(end);
        int rtEndIdx = str.lastIndexOf(end);
        for (int i = 0; i < str.length(); i++) {
            if (s[lt] == end.charAt(0)) {
                ltEndIdx = lt;
            }
            leftDiv[lt] = Math.abs(ltEndIdx - lt);
            lt++;
            if (s[rt] == end.charAt(0)) {
                rtEndIdx = rt;
            }
            rightDiv[rt] = Math.abs(rtEndIdx - rt);

            rt--;
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(Math.min(leftDiv[i], rightDiv[i]) + " ");
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String end = st.nextToken();
            leftDiv = new int[str.length()];
            rightDiv = new int[str.length()];
            solution(str, end);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
