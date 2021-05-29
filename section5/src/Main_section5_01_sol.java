import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_section5_01_sol {
    public static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x=='(') stack.push('(');
            else{
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));

    }
}
