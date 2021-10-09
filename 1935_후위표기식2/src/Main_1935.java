import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.Stack;

public class Main_1935 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            String postfix = br.readLine();
            Stack<Double> stack = new Stack<>();


            System.out.println(Character.getNumericValue('A'));
            System.out.println(Character.getNumericValue('Z'));
            for (char postfixStr : postfix.toCharArray()) {
                double preValue = 0;
                double lastValue = 0;
                int preNumValue = 0;
                int lastNumValue = 0;
                if (Character.getNumericValue(postfixStr) >= 10 && Character.getNumericValue(postfixStr) <= 35) {

                }


                System.out.println(stack);
                if (postfixStr == '*') {
                    lastValue = stack.pop();
                    preValue = stack.pop();
                    stack.add(preValue * lastValue);
                    continue;
                }

                if (postfixStr == '-') {
                    lastValue = stack.pop();
                    preValue = stack.pop();
                    stack.add(preValue - lastValue);
                    continue;
                }

                if (postfixStr == '/') {
                    lastValue = stack.pop();
                    preValue = stack.pop();
                    stack.add(preValue / lastValue);
                    continue;
                }


                if (postfixStr == '+') {
                    lastValue = stack.pop();
                    preValue = stack.pop();
                    stack.add(preValue + lastValue);
                    continue;
                }
                int postfixInt = (Character.getNumericValue(postfixStr) - 65);
                stack.add(Double.valueOf((char) postfixInt));

            }

            stack.stream().forEach(result -> {
                try {
                    bw.write(result.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
