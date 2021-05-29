import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section7_12 {
    static int[][] graph;
    static int count = 0;

    public static void dfs(boolean[] visit, int start, int end) {
        visit[start] = true;

        if (start == end) {
            count++;
        } else {
            for (int i = 1; i <= end; i++) {
                int x = graph[start][i];
                if(x==0) continue;
                if (visit[i])
                    continue;
                else {
                    dfs(visit, i, end);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //정점수 n , 간선의수 m
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[n + 1];
            graph = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
//                System.out.println(a+" "+b);
                graph[a][b] = 1;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < graph[i].length; j++)
                    System.out.print(graph[i][j] + " ");
                System.out.println();
            }
            dfs(visit, 1, n);
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
