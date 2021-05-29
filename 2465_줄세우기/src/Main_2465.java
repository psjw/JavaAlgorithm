import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2465 {
    static void init(int[] tree, int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = 1;
            return;
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        init(tree, arr, leftNodeIdx, start, mid);
        init(tree, arr, rightNodeIdx, mid + 1, end);
        tree[node] = tree[leftNodeIdx] + tree[rightNodeIdx];
    }

    static void update(int[] tree, int[] visit, int[] tall, int node, int start, int end, int index, int position) {
        tree[node]--;
        if (start == end) {
            visit[index] = tall[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = node * 2 + 1;
        if (position <= tree[leftNodeIdx]) {
            update(tree, visit, tall, leftNodeIdx, start, mid, index, position);
            return;
        }
        if (position > tree[leftNodeIdx]) {
            update(tree, visit, tall, rightNodeIdx, mid + 1, end, index, position - tree[leftNodeIdx]);
            return;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            int tall[] = new int[N + 1];
            int position[] = new int[N + 1];
            int visit[] = new int[N + 1];
            StringTokenizer st;
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (1 << (h + 1)) + 1;
            int tree[] = new int[treeSize];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                tall[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                position[i] = Integer.parseInt(st.nextToken());
            }
            tall = Arrays.stream(tall).sorted().toArray();
            init(tree, tall, 1, 1, N);
            for (int i = N; i >= 1; i--) {
                update(tree, visit, tall, 1, 1, N, i, position[i] + 1);
            }

            for (int i = 1; i <= N; i++) {
                bw.write(visit[i] + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
