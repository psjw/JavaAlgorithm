import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int input[] = new int[N + 1];
            int diffCount[] = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                diffCount[i] = 1;
                input[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    if (input[j] < input[i] && diffCount[i] < diffCount[j] + 1) {
                        diffCount[i] = diffCount[j] + 1;
                    }
                }
            }
            bw.write(String.valueOf(Arrays.stream(diffCount).max().getAsInt()));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
