import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_1 {


    public static long sum(long[] tree, int a) {
        long answer = 0;
        while (a > 0) {
            answer += tree[a];
            a -= (a & -a); //양수 음수 and연산
        }
        return answer;
    }


    public static void update(long[] tree, int a, long diff) {
        while (a < tree.length) {
            tree[a] += diff;
            a += (a & -a);
        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[] tree = new long[n + 1];
            long[] ftree = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken());
                ftree[i] = a;
                update(tree, i, ftree[i]);
            }


            for (int i = 0; i < m + k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    int b = Integer.parseInt(st.nextToken());
                    long c = Long.parseLong(st.nextToken());
                    long diff = c - ftree[b];
                    ftree[b] = c;
                    update(tree, b, diff);
                } else {
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    long sum = sum(tree, c) - sum(tree, b - 1);
                    System.out.println(sum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
