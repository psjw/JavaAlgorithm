import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2747_Bottom {
    static int[] memo = new int[46];

    public static int fibonacci(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        //Bottom-Up
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fibonacci(n));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
