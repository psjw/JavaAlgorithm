import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section3_03 {
    public static int solution(int[] a , int k, int max){
        int answer = max;
        int tmp = max;
        for(int i=k;i<a.length;i++){
            tmp = tmp + a[i] - a[i - k];
            if(tmp>answer)
                answer = tmp;
        }
        return answer;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int a[] = new int[n];
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for(int i=0;i<n;i++){

                a[i] = Integer.parseInt(st.nextToken());
                if (i < k) {
                    max+= a[i];
                }
            }
            System.out.println(solution(a,k,max));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
