import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_몇번째순열 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            String inputs = br.readLine();
            long[] factorial = new long[17];
            boolean[] visit = new boolean[17];
            Arrays.fill(factorial, 1);
            for (int i = 1; i <= 16; i++) {
                factorial[i] = i * factorial[i - 1];
            }
            int count = 0;
            int result = 1;
            for (char input : inputs.toCharArray()) {
                int k = (int) input - 64;
                for (int j = 1; j < k; j++) {
                    if (!visit[j]) {
                        result += factorial[N - count - 1];
                    }
                }
                count++;
                visit[k] = true;
            }

            bw.write(String.valueOf(result));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
