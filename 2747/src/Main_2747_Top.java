import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2747_Top {
    public static int memo[] = new int[46];

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return memo[n];
        }

    }

    public static void main(String[] args) {
        //Top - Down
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fibonacci(n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
