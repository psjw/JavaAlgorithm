import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2042 {

    public static void init(long[] tree, long[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        init(tree, arr, leftNodeIdx, start, mid);
        init(tree, arr, rightNodeIdx, mid + 1, end);
        tree[node] = tree[leftNodeIdx] + tree[rightNodeIdx];
    }


    public static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        long leftNode = query(tree, leftNodeIdx, start, mid, left, right);
        long rightNode = query(tree, rightNodeIdx, mid + 1, end, left, right);
        return leftNode + rightNode;
    }

    public static void update(long[] tree, int node, int start, int end, int index, long value) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        update(tree, leftNodeIdx, start, mid, index, value);
        update(tree, rightNodeIdx, mid + 1, end, index, value);
        tree[node] = tree[leftNodeIdx] + tree[rightNodeIdx];
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[] arr = new long[n + 1];
            long[] tree = new long[n * 4];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken());
                arr[i] = a;
            }
            init(tree, arr, 1, 1, n);
            for (int i = 0; i < m + k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    int b = Integer.parseInt(st.nextToken());
                    long c = Long.parseLong(st.nextToken());
                    update(tree, 1, 1, n, b, c);
                } else {
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    long sum = query(tree, 1, 1, n, b, c);
                    bw.write(sum + "\n");
                }
                bw.flush();
            }
        }
    }
}

