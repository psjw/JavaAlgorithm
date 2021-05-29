import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section2_02 {
    static int[] arr;

    public static void solution(int n) {
        int max = arr[0];
        int count = 1;
        for(int i=0;i<n;i++){
            if(arr[i] > max ){
                max = arr[i];
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for(int i=0; i<n;i++){

                arr[i]=Integer.parseInt(st.nextToken());
            }
            solution(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
