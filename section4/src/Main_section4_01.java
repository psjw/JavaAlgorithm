import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_section4_01 {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            System.out.println(solution(str,n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(String str, int n) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] s = str.toCharArray();
        int answer = 0;
        String candiate = "";
        for(char x : s){
            if(hashMap.containsKey(x)){
                int count = hashMap.get(x);
                hashMap.put(x, ++count);
                if(count>answer){
                    answer = count;
                    candiate = String.valueOf(x);
                }
            }else{
                hashMap.put(x, 1);
            }
        }
        return candiate;

    }

}
