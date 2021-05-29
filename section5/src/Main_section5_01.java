import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main_section5_01 {
    public static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.add('(');
            }else{
                if(stack.size()>0)
                    stack.pop();
                else{
                    answer = "NO";
                    return answer;
                }
            }
        }
        if(stack.size() >0 ){
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            System.out.println(solution(str));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
