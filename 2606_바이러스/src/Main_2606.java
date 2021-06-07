import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606 {
    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    public static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);
        if (findX == findY) {
            return;
        }
        if (rank[findX] < rank[findY]) {
            int temp = findX;
            findX = findY;
            findY = temp;
        }
        parent[findY] = findX;
        if (rank[findX] == rank[findY]) {
            rank[findX] = rank[findY] + 1;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int answer = 0;
            StringTokenizer st;
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i =1; i<=n;i++){
                parent[i] = i;
            }

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }

            for (int i = 2; i <= n; i++) {
                if (find(1) == find(i)){
                    answer++;
                }
            }
            bw.write(String.valueOf(answer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
