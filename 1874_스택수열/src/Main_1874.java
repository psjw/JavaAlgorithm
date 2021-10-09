import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Stack<Integer> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            int index = 1;
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(br.readLine());
                for (int j = index; j <= k; j++) {
                    stack.push(j);
                    sb.append("+\n");
                    index = j + 1;
                }
                if (stack.peek() != k) {
                    break;
                }

                int peek = stack.peek();
                for (int j = peek; j >= k; j--) {
                    stack.pop();
                    sb.append("-\n");
                }
            }

            if (stack.size() == 0) {
                bw.write(sb.toString());
            } else {
                bw.write("NO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
