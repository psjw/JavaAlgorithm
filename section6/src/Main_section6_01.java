import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_section6_01 {
    public static int[] solution(int[] arr){
        String answer = "";
        int temp = 0;
        for(int i= 0 ;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n =Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i= 0; i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for( int x : solution(arr)){
                System.out.print(x+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
