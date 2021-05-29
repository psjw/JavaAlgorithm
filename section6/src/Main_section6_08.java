import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section6_08 {

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
            mergeSort(arr, 0, n);
//            for (int x : arr) System.out.print(x + " ");
            System.out.println(solution(arr, n, m));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(int[] arr, int n, int m) {
        int lt = 0, rt = arr.length-1;
        int answer = 0;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(arr[mid] == m){
                answer = mid+1;
                break;
            }else if(arr[mid] < m ){
                lt = mid + 1;
            }else{
                rt = mid - 1;
            }
        }
        return answer;
    }

    private static void mergeSort(int[] arr, int start, int end) {
        int[] tmp = new int[end];
        mergeSort(arr, tmp, start, end - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid & part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }
}
