import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_section5_02 {
    public static String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char[] s = str.toCharArray();
        for(int i =0 ;i<str.length();i++){
            if(s[i]=='(' ||  s[i] !=')'){
                stack.push(s[i]);
//                System.out.println(stack);
            }else{
                while(!stack.isEmpty()){
                    if(stack.pop()=='('){
                        break;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            answer = stack.pop()+answer;
//            System.out.println(answer);
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
