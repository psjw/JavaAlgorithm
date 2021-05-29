import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_section3_01 {
    public static ArrayList<Integer> solution(int[] a, int[] b, int size ){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < a.length-1 && p2 < b.length-1) {
            if(a[p1] <b[p2]){
                answer.add(a[p1]);
                p1++;
            }else{
                answer.add(b[p2]);
                p2++;
            }
        }

        for(int i=p1;i<a.length-1;i++){
            answer.add(a[i]);
        }

        for(int j=p2;j<b.length-1;j++){
            answer.add(b[j]);
        }

        return answer;


    }

    public static void main(String[] args) {
        //O(logN) 6000* 16 -> O(N)으로변경
        //정렬된 상태로 들어옴 two Pointer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int size = n;

            if (size < m) {
                size = m;
            }
            ArrayList<Integer> arrList = solution(a, b, size);
            for(Integer k :arrList)
                System.out.print(k+" ");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
