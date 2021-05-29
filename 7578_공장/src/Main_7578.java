import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_7578 {
    public static int query(int[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = leftNodeIdx + 1;
        int leftNode = query(tree, leftNodeIdx, start, mid, left, right);
        int rightNode = query(tree, rightNodeIdx, mid + 1, end, left, right);
        return leftNode + rightNode;
    }

    public static void update(int[] tree, int node, int start, int end, int index, int value) {
        if (start > index || end < index) {
            return;
        }
        if(start == end){
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        int leftNodeIdx = node * 2;
        int rightNodeIdx = leftNodeIdx + 1;
        update(tree, leftNodeIdx, start, mid, index, value);
        update(tree, rightNodeIdx, mid + 1, end, index, value);
        tree[node] = tree[leftNodeIdx] + tree[rightNodeIdx];
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N + 1];
            Map<Integer, Integer> bLineMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int bLine = Integer.parseInt(st.nextToken());
                bLineMap.put(bLine, i);
            }

            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (1 << (h + 1)) + 1;
            int tree[] = new int[treeSize];

            long answer = 0L;

            for (int i = 1; i <= N; i++) {
                int aLine = A[i];
                int bLine = bLineMap.get(aLine);

                int visitCount = query(tree, 1, 1, N, bLine + 1, N);
                answer += visitCount;

                update(tree, 1, 1, N, bLine, 1);
            }
            bw.write(String.valueOf(answer));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
