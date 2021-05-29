import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_section6_04 {
    public static int[] solution(int[] job, int n, int[] cache) {

        for (int i = 0; i < n; i++) {
            int idx = cache.length - 1;
            for(int k=0; k<cache.length;k++){
                if(cache[k]== job[i]){
                    idx = k;
                }
            }
            for (int j = idx; j > 0; j--) {
                    cache[j] = cache[j - 1];
            }
            cache[0] = job[i];
        }
        return cache;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] job = new int[n];
            int[] cache = new int[s];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                job[i] = Integer.parseInt(st.nextToken());
            }
            for (int x : solution(job, n, cache))
                System.out.print(x + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
