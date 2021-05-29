import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_section3_04 {
    public static int solution(int[] a,int m) {
        int answer = 0;
        int p1 = 0, p2=0;
        int sum = 0;
        //ArrayList<Integer> list = new ArrayList<>();
        while (p1 < a.length|| p2< a.length) {
            //System.out.println(sum);
            if(p1 == a.length & sum < m){
                break;
            }
             if(sum == m){
                //System.out.println(list);
                answer++;
                sum -= a[p2];
                //list.remove(0);
                p2++;
            }else if(sum<m & p1<a.length){
                sum += a[p1];
                //list.add(a[p1]);
                p1++;
            }else if(sum > m){
                sum -= a[p2];
                //list.remove(0);
                p2++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(a,m));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
