import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    static long[] arr;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr = Arrays.stream(arr).sorted().toArray();
            long left = 0;
            long right = arr[N - 1];
            long sum;
            while (left <= right) {
                sum = 0;
                long mid = (left + right) / 2;
                sum = Arrays.stream(arr).filter(x -> x >= mid).map(x -> x - mid).sum();
                if (sum < H) {
                    right = mid - 1;
                    continue;
                }
                if (sum >= H) {
                    left = mid + 1;
                    continue;
                }
            }
            bw.write(String.valueOf(right));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
