import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10845 {
    private static int[] arr = new int[100001];
    private static int index = 0;


    public static void push(int input) {
        arr[index] = input;
        index++;
    }

    public static int pop() {
        if (index == 0) {
            return -1;
        }
        int result = arr[0];
        index--;
        for (int i = 0; i < index; i++) {
            arr[i] = arr[i + 1];
        }
        return result;
    }

    public static int size() {
        return index;
    }

    public static int empty() {
        int result = 0;
        if (index == 0) {
            result = 1;
        }
        return result;
    }

    public static int front() {
        int result = -1;
        if (index > 0) {
            result = arr[0];
        }
        return result;
    }

    public static int back() {
        int result = -1;
        if (index > 0) {
            result = arr[index - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                String[] commands = br.readLine().split(" ");
                if ("push".equals(commands[0])) {
                    push(Integer.parseInt(commands[1]));
                    continue;
                }

                if ("pop".equals(commands[0])) {
                    bw.write(String.valueOf(pop()) + "\n");
                    continue;
                }

                if ("size".equals(commands[0])) {
                    bw.write(String.valueOf(size()) + "\n");
                    continue;
                }

                if ("empty".equals(commands[0])) {
                    bw.write(String.valueOf(empty()) + "\n");
                    continue;
                }

                if ("front".equals(commands[0])) {
                    bw.write(String.valueOf(front()) + "\n");
                    continue;
                }

                if ("back".equals(commands[0])) {
                    bw.write(String.valueOf(back()) + "\n");
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
