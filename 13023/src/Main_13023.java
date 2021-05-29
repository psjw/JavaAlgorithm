import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023 {
    public static ArrayList<Integer>[] graph;
    static boolean[] visit;


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            List<Integer> node = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            int result = 0;

            for (int i = 0; i < n; i++) {
                if (isExist)
                    break;
                visit = new boolean[n + 1];
                dfs(visit, i, 0);
            }

            if (isExist) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist = false;

    public static void dfs(boolean[] visit, int node, int count) {
        if (isExist)
            return;
        if (count >= 5) {
            isExist = true;
            return;
        }
        for (int i = 0; i < graph[node].size(); i++) {
            int x = graph[node].get(i);
            if (visit[x])
                continue;
            visit[x] = true;
            dfs(visit, x, count + 1);
            visit[x] = false;
        }
    }
}
