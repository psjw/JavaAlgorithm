import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_section7_08_sol {
    public static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> q = new LinkedList<>();

    public static int bfs( int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
//                if(x ==  e){
//                    return L;
//                }
                for(int j=0; j < 3;j++){
                    int nx = x + dis[j];
                    if(nx == e) return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(bfs(s, e));
    }
}
