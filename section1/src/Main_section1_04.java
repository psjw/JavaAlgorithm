import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_section1_04 {
    public static String solution(String str) {
        String answer = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            answer += str.charAt(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                System.out.println(solution(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
