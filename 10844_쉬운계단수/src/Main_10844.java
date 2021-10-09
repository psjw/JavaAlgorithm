import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_10844 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            long result[][] = new long[101][10];
            long mod = 1000000000;
            for (int i = 1; i <= 9; i++) {
                result[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int k = 0; k <= 9; k++) {
                    if (k > 0) {
                        result[i][k] += (result[i - 1][k - 1] % mod);
                    }
                    if (k < 9) {
                        result[i][k] += (result[i - 1][k + 1] %mod);
                    }
                }
            }
            System.out.println(Arrays.stream(result[n]).sum()%mod);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
