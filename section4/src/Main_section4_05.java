import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_section4_05 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(solution(arr, n, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int h = j+1; h <n; h++) {
                    tSet.add(arr[i] + arr[j] + arr[h]);
                }
            }
        }
//        System.out.println(tSet);
        int count = 0;
//        tSet.remove(143);
//        System.out.println(tSet.size());
//        System.out.println("first : "+tSet.first());//최솟값(오름차순), 최대값(내림차순)
//        System.out.println("last : "+tSet.last());;//최대값(오름차순), 최소값(내림차순)
        for(int x : tSet){
            System.out.println(x);
            count++;
            if(count == k){
                answer = x;
                break;
            }
        }
        return answer;
    }

}
