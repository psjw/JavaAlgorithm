import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_section7_13 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        bfs(1);
        for(int i=2; i<=n;i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
