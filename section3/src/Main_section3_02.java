import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_section3_02 {

    private static void merge(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }

    public static String solution(int[] a, int[] b ){
        String answer = "";
        int p1 = 0;
        int p2 = 0;
        while(p1<a.length&&p2<b.length){
            if(a[p1]==b[p2]){
                answer += a[p1]+" ";
                p1++;
                p2++;
            }else  if(a[p1] < b[p2]){
                p1++;
            }else
            {
                p2++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            merge(a);
            merge(b);
            System.out.println(solution(a,b));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
