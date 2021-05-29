import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816 {
    static int[] arr;
    static int N;
    static int M;

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

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int result = 0;
            for (int i = 0; i < M; i++) {
                int k = Integer.parseInt(st.nextToken());
                sb.append((upperBoundBinarySearch(k) - lowBoundBinarySearch(k))+" ") ;
            }
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int lowBoundBinarySearch(int searchNum){
        int left = 0;
        int right = N - 1;
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid]== searchNum){
                result = mid;
                right = mid - 1;
                continue;
            }
            if(arr[mid] < searchNum){
                left = mid + 1;
                continue;
            }
            if(arr[mid]>searchNum){
                right = mid - 1;
                continue;
            }
        }
        return result;
    }


    private static int upperBoundBinarySearch(int searchNum) {
        int left = 0;
        int right = N - 1;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == searchNum) {
                result = mid + 1;
                left = mid + 1;
                continue;
            }
            if (arr[mid] > searchNum) {
                right = mid - 1;
                continue;
            }
            if (arr[mid] < searchNum) {
                left = mid + 1;
                continue;
            }
        }
        return result;
    }
}
