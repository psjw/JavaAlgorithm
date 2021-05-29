import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section6_05 {
    public static String solution(int[] arr) {
        String answer = "U";
        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1; j<arr.length;j++){
                if(arr[i] ==  arr[j]){
                    answer = "D";
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


