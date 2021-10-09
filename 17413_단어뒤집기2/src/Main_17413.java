import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_17413 {
    public static void main(String[] args) {
        // a : 10 , z : 35

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String inputData = br.readLine();
            boolean isCheckTag = false;
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (char input : inputData.toCharArray()) {
                if (input == '<') {
                    getStringByStack(sb, stack);
                    isCheckTag = true;
                    sb.append(input);
                    continue;
                }
                if (input == '>') {
                    sb.append(input);
                    isCheckTag = false;
                    continue;
                }
                if (isCheckTag) {
                    sb.append(input);
                    continue;
                }
                if (input == ' ') {
                    getStringByStack(sb, stack);
                    sb.append(' ');
                    continue;
                }
                if (Character.getNumericValue(input) > -1 && Character.getNumericValue(input) < 36) {
                    stack.push(input);
                    continue;
                }
            }

            if(stack.size()>0){
                getStringByStack(sb, stack);
            }

            bw.write(sb.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getStringByStack(StringBuilder sb, Stack<Character> stack) {
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            sb.append(stack.pop());
        }
    }
}
