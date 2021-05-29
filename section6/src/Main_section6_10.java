import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


//못품 오담
public class Main_section6_10 {

    public static int solution(int[] arr, int n, int c) {
        int answer = 0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }


        return answer;
    }

    private static int count(int[] arr, int dist) {
        int count = 1;
        int endPoint = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]- endPoint >= dist){
                count++;
                endPoint = arr[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(arr,n, m));
    }
}
