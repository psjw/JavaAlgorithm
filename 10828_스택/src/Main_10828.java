import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main_10828 {
    static int[] arr = new int[10001];
    static int size = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if ("push".equals(command)) {
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    continue;
                }
                if ("top".equals(command)) {
                    sb.append(top());
                    sb.append("\n");
                    continue;
                }
                if ("size".equals(command)) {
                    sb.append(size());
                    sb.append("\n");
                    continue;
                }
                if ("empty".equals(command)) {
                    sb.append(empty());
                    sb.append("\n");
                    continue;
                }
                if ("pop".equals(command)) {
                    sb.append(pop());
                    sb.append("\n");
                    continue;
                }
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int pop() {
        if (size > 0)
            return arr[--size];
        return -1;
    }

    private static int size() {
        return size;
    }

    private static int top() {
        if (size > 0)
            return arr[size - 1];
        return -1;
    }

    private static void push(int x) {
        arr[size++] = x;
    }

    public static int empty() {
        if (size > 0)
            return 0;
        return 1;
    }

}
