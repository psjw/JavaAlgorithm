import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11727 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] squareArr = new int[n + 1];
            squareArr[1] = 1;
            squareArr[2] = 3;

            for (int i = 3; i <= n; i++) {
                squareArr[i] = (squareArr[i - 1] + 2 * squareArr[i - 2]) % 10007;
            }

            bw.write(String.valueOf(squareArr[n]));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
