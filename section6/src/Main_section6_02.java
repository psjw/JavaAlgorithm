import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_section6_02 {
    public static int[] solution(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
           for(int j=0;j<n-i-1;j++){
               if(arr[j]>arr[j+1]){
                   int tmp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = tmp;
               }
           }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int x : solution(a,n)) System.out.print(x+" ");
    }
}
