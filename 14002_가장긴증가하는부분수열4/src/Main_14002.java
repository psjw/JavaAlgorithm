import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14002 {
    static int preIndex[];
    static int input[];
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            preIndex = new int[N+1];
            input = new int[N+1];
            int diffCount[] = new int[N + 1];


            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                preIndex[i] = -1;
                input[i] = Integer.parseInt(st.nextToken());
                diffCount[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (input[i] > input[j] && diffCount[i] < diffCount[j] + 1) {
                        diffCount[i] = diffCount[j] + 1;
                        preIndex[i] = j;
                    }
                }
            }
            int resultCount = Arrays.stream(diffCount).max().getAsInt();
            bw.write(resultCount + "\n");
            bw.flush();

            int maxIndex = 0;
            for (int i=0; i<N; i++) {
                if (resultCount == diffCount[i]) {
                    maxIndex = i;
                }
            }
            dfs(maxIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int index){
        if(index < 0)
            return;
        dfs(preIndex[index]);
        System.out.print(input[index]+" ");
    }
}
