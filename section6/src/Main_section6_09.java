import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//못품 오담
public class Main_section6_09 {

    public static int solution(int[] arr, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int max = Arrays.stream(arr).sum();
        int lt = arr[0], rt = max;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
//            System.out.println("mid : "+mid);
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum >= mid) {
                    sum = arr[i];
                    count++;
                }
            }
            if (count < m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
            if (count == m) {
                answer =mid;
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
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(arr, n, m));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
