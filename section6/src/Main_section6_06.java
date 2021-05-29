import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Runtime 에러
public class Main_section6_06 {
    public static String solution(int[] arr) {
        String answer = "";
        int preIdx = -1;
        int lastIdx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = 0;
            // 0  0~ 5 - 0 - 1 4
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    if (preIdx ==  -1)
                        preIdx = i + 1;
                    tmp = arr[j];
                    arr[j] = arr[j];
                    arr[j] = tmp;
                    if(lastIdx <j+1){
                        lastIdx = j+1;
                    }
                }
            }
        }
        answer = preIdx + " " + lastIdx;
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


