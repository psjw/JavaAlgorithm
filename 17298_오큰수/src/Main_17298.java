import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_17298 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            String[] inputDataArray = br.readLine().split(" ");
            Stack<Integer> tempStack = new Stack<>();
            Stack<Integer> answerStack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = N - 1; i >= 0; i--) {
                int inputLastNum = Integer.parseInt(inputDataArray[i]);
                while (!tempStack.isEmpty() && (tempStack.peek() <= inputLastNum)) {
                    tempStack.pop();
                }

                if (tempStack.isEmpty()) {
                    answerStack.add(-1);
                } else {
                    answerStack.add(tempStack.peek());
                }
                tempStack.add(inputLastNum);
            }

            while(!answerStack.isEmpty()){
                sb.append(answerStack.pop()+" ");
            }

            bw.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
