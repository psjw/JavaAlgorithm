import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_1406 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String inputStr = br.readLine();
            int commandCnt = Integer.parseInt(br.readLine());
            Stack<String> leftStack = new Stack();
            Stack<String> rightStack = new Stack<>();
            for (Character tmpChar : inputStr.toCharArray()) {
                leftStack.push(tmpChar.toString());
            }
            for (int i = 0; i < commandCnt; i++) {
                String fullCommand = br.readLine();
                String[] command = fullCommand.split(" ");
                if ("L".equals(command[0])) {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    continue;
                }
                if ("D".equals(command[0])) {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    continue;
                }
                if ("B".equals(command[0])) {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    continue;
                }
                if ("P".equals(command[0])) {
                    leftStack.push(command[1]);
                }
                continue;
            }

            if (!leftStack.isEmpty()) {
                for(String leftStr : leftStack){
                    bw.write(leftStr);
                }
            }

            StringBuilder sb = new StringBuilder();

            if (!rightStack.isEmpty()) {
                for(String rightStr : rightStack){
                    sb.append(rightStr);
                }
                sb.reverse();
            }

            bw.write(sb.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
