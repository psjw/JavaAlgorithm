import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCase = Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < testCase; i++) {
                stack.clear();
                boolean isCheck = false;
                String inputLine = br.readLine();
                for (char inputChar : inputLine.toCharArray()) {
                    if (inputChar == '(') {
                        stack.push(inputChar);
                        continue;
                    }
                    if (inputChar == ')') {
                        if (stack.isEmpty()) {
                            isCheck = true;
                            break;
                        } else {
                            stack.pop();
                            continue;
                        }
                    }
                }
                if (!stack.isEmpty() || isCheck) {
                    bw.write("NO\n");
                } else {
                    bw.write("YES\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
