import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14501 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken()) - 1;
                int p = Integer.parseInt(st.nextToken());

                if (i + t > n) {
                    continue;
                }

                int preMax = IntStream.range(0, i).mapToObj(x -> arr[x])
                        .max((x1, x2) -> x1.compareTo(x2))
                        .orElse(0);

                if (arr[i + t] == 0) {
                    arr[i + t] = p + preMax;
                    continue;
                }

                if (arr[i + t] > 0) {
                    arr[i + t] = Math.max(arr[i + t], p + preMax);
                    continue;
                }
            }

            bw.write(String.valueOf(Arrays.stream(arr).max().getAsInt()));
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
