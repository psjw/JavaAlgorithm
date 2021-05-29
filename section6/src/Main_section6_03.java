import java.util.Scanner;

public class Main_section6_03 {
    public static int[] solution(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i] ,  j;
            for ( j = i - 1; j >=0; j--) {
                if(arr[j] > tmp){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = tmp;
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

        for (int x : solution(a, n)) System.out.print(x + " ");
    }
}
