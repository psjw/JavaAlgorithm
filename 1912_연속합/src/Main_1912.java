import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result[] = new int[n + 1];
            int input[] = new int[n + 1];
            Arrays.fill(result,Integer.MIN_VALUE);
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                if (i > 0) {
                    result[i] = result[i - 1] + input[i];
                }
                if (input[i] > result[i]) {
                    result[i] = input[i];
                }
            }

            bw.write(String.valueOf(Arrays.stream(result).max().getAsInt()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
