import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main_section4_01_sol {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(str, n));
    }

    private static char solution(String str, int n) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
//        System.out.println(map.containsKey('A'));
//        System.out.println(map.size());
//        System.out.println(map.remove('A'));
//        System.out.println(map.size());
        for (char key : map.keySet()) {
//            System.out.println(key+" "+map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

}
