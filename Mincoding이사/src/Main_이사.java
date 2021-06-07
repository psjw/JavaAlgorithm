import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이사 {
    static int[][] graph;
    static int[] dist;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new int[n + 1][n + 1];

            boolean visit[] = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b]=1;
                graph[b][a]=1;

            }
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());


            bfs(visit, start, cnt);

            int resultCnt = 0;
            for(int i =0; i<visit.length;i++){
                if(visit[i]==true){
                    resultCnt++;
                }
            }
            bw.write(String.valueOf(resultCnt));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(boolean[] visit, int start, int count) {
        int depth = 0;
        queue.add(start);
        visit[start] = true;
        int resultCnt = 0;
        while (!queue.isEmpty()) {
            if(depth==count){
                break;
            }
            int size = queue.size();
            for(int i =0;i<size;i++){
                int v = queue.poll();
                for(int k =1;k<graph[v].length;k++){
                    if(graph[v][k]==1&&visit[k]==false){
                        queue.add(k);
                        visit[k] = true;
                    }
                }
            }
            depth++;
        }
    }

}

