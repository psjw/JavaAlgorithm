import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1717 {
    public static int[] parent;
    public static int[] rank;

    public static int find(int x) {
        if (parent[x] == x) {
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int testCase = 0; testCase < m; testCase++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    union(b, c);
                    continue;
                }
                if(a == 1){
                    int x = find(b);
                    int y = find(c);
                    if(x == y ){
                        bw.write("YES\n");
                    }else{
                        bw.write("NO\n");
                    }
                    bw.flush();
                    continue;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
