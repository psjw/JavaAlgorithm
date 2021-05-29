import java.util.HashMap;
import java.util.Scanner;

public class Main_section4_02_sol {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str1 = sc.next();
        System.out.println(solution(str, str1));
    }

    private static String solution(String str, String str1) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : str1.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
                break;
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }
}
