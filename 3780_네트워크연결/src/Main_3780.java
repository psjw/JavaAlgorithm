import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3780 {
    static int[] dist;
    static int[] parent;

    public static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        int root = find(parent[i]);
        dist[i] += dist[parent[i]];
        parent[i] = root;
        return root;
    }

    public static void union(int i, int j) {
        parent[i] = j;
        dist[i] = (Math.abs(i - j) % 1000);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());
            for (int test = 0; test < t; test++) {
                int n = Integer.parseInt(br.readLine());
                dist = new int[n + 1];
                parent = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    parent[i] = i;
                }
                while (true) {
                    String line = br.readLine();
                    if ("O".equals(line)) {
                        break;
                    }
                    StringTokenizer st = new StringTokenizer(line);
                    String c = st.nextToken();
                    int i = Integer.parseInt(st.nextToken());
                    if ("E".equals(c)) {
                        find(i);
                        bw.write(dist[i] + "\n");
                        bw.flush();
                        continue;
                    }
                    if ("I".equals(c)) {
                        int j = Integer.parseInt(st.nextToken());
                        union(i, j);
                    }
                }
            }
        }
    }
}
