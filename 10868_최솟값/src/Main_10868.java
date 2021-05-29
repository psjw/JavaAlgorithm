import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10868 {

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

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (1 << (h + 1));
            int[] arr = new int[N + 1];
            int[] tree = new int[treeSize];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            init(tree, arr, 1, 0, N - 1);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken())-1;
                int right = Integer.parseInt(st.nextToken())-1;
//                System.out.println("a : " + left + " / b: " + right);
                int result = query(tree, 1, 0, N - 1, left, right);
                bw.write(result + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

