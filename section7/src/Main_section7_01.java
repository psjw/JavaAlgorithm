import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_section7_01 {
    public static int solution(int a) {
        int result = 0;
        if (a <= 1) {
            return a ;
        } else {
            result = a + solution(a - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int a = Integer.parseInt(br.readLine());
            System.out.println(solution(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
