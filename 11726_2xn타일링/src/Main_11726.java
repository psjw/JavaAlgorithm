import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11726 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] squareArr = new int[n + 1];
            squareArr[1] = 1;
            squareArr[2] = 2;

            for (int i = 1; i <= n; i++) {
                if (squareArr[i] > 0) {
                    continue;
                }
                if (squareArr[i] == 0) {
                    squareArr[i] = (squareArr[i - 1] + squareArr[i - 2])%10007;
                }
            }

            bw.write(String.valueOf(squareArr[n]%10007));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
