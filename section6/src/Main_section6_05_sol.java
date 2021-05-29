import java.util.Arrays;
import java.util.Scanner;

public class Main_section6_05_sol {
    public static String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i =0 ; i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                return "D";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(solution(n,a));
    }
}
