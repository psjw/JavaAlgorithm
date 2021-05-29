import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14438 {
    public static void init(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        init(tree, arr, leftNodeIdx, start, mid);
        init(tree, arr, rightNodeIdx, mid + 1, end);
        tree[node] = Math.min(tree[leftNodeIdx], tree[rightNodeIdx]);
    }

    public static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }
        if (start >= left && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        int leftNode = query(tree, leftNodeIdx, start, mid, left, right);
        int rightNode = query(tree, rightNodeIdx, mid + 1, end, left, right);
        if (leftNode == -1) {
            return rightNode;
        }
        if (rightNode == -1) {
            return leftNode;
        }
        return Math.min(leftNode, rightNode);
    }

    public static void update(int[] tree, int node, int start, int end, int index, int value) {
        if (index < start || index > end) {
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
        tree[node] = Math.min(tree[leftNodeIdx], tree[rightNodeIdx]);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (1 << (h + 1));
            int[] tree = new int[treeSize];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            init(tree, arr, 1, 1, N);
            int M = Integer.parseInt(br.readLine());
            for (int k = 0; k < M; k++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                if (command == 1) {
                    int i = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    update(tree, 1, 1, N, i, v);
                    continue;
                }
                if (command == 2) {
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    int result = query(tree, 1, 1, N, i, j);
                    bw.write(result + "\n");
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

