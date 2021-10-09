import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2193 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long[][] result = new long[91][2];
            result[1][1] = 1;
            int n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= n; i++) {
                result[i][0] = result[i - 1][0] + result[i - 1][1];
                result[i][1] = result[i - 1][0];
            }
            bw.write(String.valueOf(Arrays.stream(result[n]).sum()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
