import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_2517 {
    static int query(int[] visit, int node, int start, int end, int leftSearch
            , int rightSearch) {
        if (end < leftSearch || start > rightSearch) {
            return 0;
        }
        if (leftSearch <= start && rightSearch >= end) {
            return visit[node];
        }

        int mid = (start + end) / 2;
        int leftNodeIndex = 2 * node;
        int rightNodeIndex = 2 * node + 1;
        int leftNode = query(visit, leftNodeIndex, start, mid, leftSearch
                , rightSearch);
        int rightNode = query(visit, rightNodeIndex, mid + 1, end, leftSearch
                , rightSearch);
        return leftNode + rightNode;
    }

    static void update(int[] visit, int node, int start, int end, int index
            , int value) {
        if (start > index || end < index) {
            return;
        }
        if (start == end) {
            visit[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        int leftNodeIndex = node * 2;
        int rightNodeIndex = node * 2 + 1;

        update(visit, leftNodeIndex, start, mid, index, value);
        update(visit, rightNodeIndex, mid + 1, end, index, value);
        visit[node] = visit[leftNodeIndex] + visit[rightNodeIndex];
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[] answer = new int[N + 1];
            Map<Integer, Integer> indexMap = new HashMap<>();

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                indexMap.put(arr[i], i);
            }
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (1 << (h + 1));
            int[] visit = new int[treeSize];
            int[] sortedArr = Arrays.stream(arr).sorted().toArray();
            for (int k = 1; k <= N; k++) {
                indexMap.put(sortedArr[k], k);
            }
            int start = 0;
            int result = 0;
            for (int i = 1; i <= N; i++) {
                start = indexMap.get(arr[i]);
                update(visit, 1, 1, N, start, 1);
                result = query(visit, 1, 1, N, start, N);
                answer[i] = result;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(answer[i]);
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
