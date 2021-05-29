import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_section7_08 {

    public static void bfs1(boolean[] visit,int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int L = 0;
        queue.offer(start);

        boolean isCheck = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
//            System.out.print("L : "+L);
            for (int i = 0; i < len; i++) {
                int k=queue.poll();
                if(k<1 || k>10000)
                    continue;
                if(visit[k]){
                    continue;
                }
//                System.out.print(" "+k);
                if(k == end){
                    isCheck = true;
//                    System.out.println(L);
                    break;
                }
                if(k>end+5){
                    continue;
                }
                queue.offer(k + 1);
                queue.offer(k - 1);
                queue.offer(k + 5);
                visit[k] = true;
            }
            if(isCheck){
                System.out.println(L);
                return;
            }
//            System.out.println();
            L++;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[10001];
            bfs1(visit,s, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
