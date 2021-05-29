import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visit;
    public static ArrayList<Integer> result;
    public static Queue<Integer> queue = new LinkedList();

    public static void dfs(boolean[] visit, int node) {
        if (visit[node])
            return;
        visit[node] = true;
        result.add(node);
        for (int i = 0; i < graph[node].size(); i++) {
            int x = graph[node].get(i);
            if (visit[x])
                continue;
            dfs(visit, x);
        }
    }


    private static void bfs(boolean[] visit, int node) {
        queue.add(node);
        visit[node] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v);
            for (int i = 0; i < graph[v].size(); i++) {
                int x = graph[v].get(i);
                if (!visit[x]) {
                    queue.add(x);
                    visit[x] = true;

                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            for (int i = 1; i <= n; i++) {
                Collections.sort(graph[i]);
            }
            result = new ArrayList<>();
            visit = new boolean[n + 1];
            dfs(visit, v);
            for (int k : result) {
                System.out.print(k + " ");
            }
            System.out.println();
            result.clear();
            visit = new boolean[n + 1];
            bfs(visit, v);
            for (int k : result) {
                System.out.print(k + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
