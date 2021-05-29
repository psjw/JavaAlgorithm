import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_9093 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            for (int testCase = 0; testCase < n; testCase++) {
                stack.clear();
                StringBuilder sb = new StringBuilder();
                String str = br.readLine();
                for (int i = 0; i < str.length(); i++) {
                    char temp = str.charAt(i);
                    if (temp != ' ') {
                        stack.push(temp);
                        continue;
                    }
                    if (temp == ' ') {
                        int size = stack.size();
                        for (int j = 0; j < size; j++) {
                            sb.append(stack.pop());
                        }
                        sb.append(' ');
                        continue;
                    }
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                bw.write(sb.toString()+"\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
