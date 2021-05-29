import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_section2_01 {

    public static ArrayList<Integer> solution(int[] a){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(a[0]);
        for(int i=1;i<a.length;i++){
            if(a[i] >  a[i - 1]){
                answer.add(a[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> list=solution(a);
            for(int i: list){
                System.out.print(i+" ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
