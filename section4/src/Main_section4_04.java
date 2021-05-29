import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_section4_04 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            String slidingStr = br.readLine();

            System.out.println(solution(str, slidingStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(String str, String slidingStr) {
        int answer = 0;
        HashMap<Character, Integer> slidingMap = new HashMap<>();
        HashMap<Character, Integer> strMap = new HashMap<>();
        int n = str.length();
        int k = slidingStr.length();
        char[] slidingChar = slidingStr.toCharArray();
        char[] strChar = str.toCharArray();
        for (int i = 0; i < k; i++) {
            slidingMap.put(slidingChar[i], slidingMap.getOrDefault(slidingChar[i], 0) + 1);
        }
        for (int i = 0; i < k - 1; i++) {
            strMap.put(strChar[i], strMap.getOrDefault(strChar[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            strMap.put(strChar[rt], strMap.getOrDefault(strChar[rt], 0) + 1);

            for (int j = 0; j < k; j++) {
                if (!strMap.containsKey(slidingChar[j]) || strMap.get(slidingChar[j]) != slidingMap.get(slidingChar[j])) {
                    break;
                }
                if (j == k - 1)
                    answer++;
            }
            strMap.put(strChar[lt], strMap.get(strChar[lt]) - 1);
            if (strMap.get(strChar[lt]) == 0) {
                strMap.remove(strChar[lt]);
            }
            lt++;
        }

        return answer;
    }

}
