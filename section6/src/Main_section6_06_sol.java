import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_section6_06_sol {
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();//깊은 복사
        Arrays.sort(tmp);
        for(int i =0 ; i<arr.length-1;i++){
            if(arr[i] != tmp[i]){
                answer.add(i+1);
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

        for (int x : solution(n, a)) System.out.print(x + " ");
    }
}
