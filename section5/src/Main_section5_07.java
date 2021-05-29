import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_section5_07 {
    public static String solution(String str, String str1) {
        String answer = "NO";
        char[] s = new char[str.length()];

        Queue<Character> queue = new LinkedList<>();
        Queue<Character> time = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            time.add(str.charAt(i)) ;
        }
//        System.out.println(str + "/" + str1);
        for (int i = 0; i < str1.length(); i++) {
            queue.add(str1.charAt(i));
        }
        while (!queue.isEmpty()) {
            if(time.peek()==queue.poll()){
                time.poll();
            }
            if(time.isEmpty()){
                answer = "YES";
                break;
            }
        }


//        System.out.println(queue);
        return answer;
    }



    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            String str1 = br.readLine();
            System.out.println(solution(str, str1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
