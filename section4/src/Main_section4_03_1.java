import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_section4_03_1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(arr, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(int[] arr, int k) {
//        String answer = "";
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        answer.append(hashMap.size());
        answer.append(" ");




        for (int i = k; i < arr.length; i++) {

            if (hashMap.containsKey(arr[i - k])) {
                if (hashMap.get(arr[i - k]) - 1 == 0) {
                    hashMap.remove(arr[i - k]);
                } else {
                    hashMap.put(arr[i - k], hashMap.get(arr[i - k]) - 1);
                }
            }
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
            answer.append(hashMap.size());
            answer.append(" ");
        }
        return answer.toString();
    }

}
