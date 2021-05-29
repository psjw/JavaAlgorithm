import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {
    static int arr[];
    static int N;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr = Arrays.stream(arr).sorted().toArray();

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                sb.append(binarySearch(Integer.parseInt(st.nextToken())) + " ");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int binarySearch(int searchNum) {
        int left = 0;
        int right = N - 1;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == searchNum) {
                result = 1;
                break;
            }
            if (arr[mid] < searchNum) {
                left = mid + 1;
                continue;
            }
            if (arr[mid] > searchNum) {
                right = mid - 1;
                continue;
            }
        }
        return result;
    }
}
