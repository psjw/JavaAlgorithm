import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Stack<Character> stack = new Stack<>();
            int testCase = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCase; i++) {
                String result = "YES";
                stack.clear();
                String tempStr = br.readLine();
                for (Character tempChar : tempStr.toCharArray()) {
                    if (tempChar == '(') {
                        stack.push(tempChar);
                        continue;
                    }
                    if (stack.size() > 0) {
                        stack.pop();
                        continue;
                    }

                    if (stack.size() == 0) {
                        result = "NO";
                        break;
                    }
                }
                if (stack.size() > 0) {
                    result = "NO";
                }
                bw.write(result+"\n");
                bw.flush();
            }
        }
    }
}
