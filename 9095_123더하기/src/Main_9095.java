import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9095 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());
            int[] sumArr = new int[12];

            for (int i = 0; i < T; i++) {
                int n = Integer.parseInt(br.readLine());
                sumArr[1] = 1;
                sumArr[2] = 2;
                sumArr[3] = 4;
                for (int j = 4; j <= n; j++) {
                    sumArr[j] = sumArr[j - 1] + sumArr[j - 2] + sumArr[j - 3];
                }

                bw.write(String.valueOf(sumArr[n])+"\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
