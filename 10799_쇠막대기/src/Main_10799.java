import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_10799 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String inputData = br.readLine();
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            int count = 0;
            for (char input : inputData.toCharArray()) {
                if (input == '(') {
                    stack.push(count);
                    count++;
                    continue;
                }
                if (input == ')') {
                    int temp = stack.pop();
                    if ((count - temp) == 1) {
                        answer += stack.size();
                    } else {
                        answer += 1;
                    }
                    continue;
                }
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
