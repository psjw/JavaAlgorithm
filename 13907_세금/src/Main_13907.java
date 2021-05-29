import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class RoadEdge {
    private int start;
    private int end;
    private int tax;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTax() {
        return tax;
    }

    public RoadEdge(RoadEdgeBuilder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.tax = builder.tax;
    }

    public static class RoadEdgeBuilder {
        private int start;
        private int end;
        private int tax;

        public RoadEdgeBuilder setStart(int start) {
            this.start = start;
            return this;
        }

        public RoadEdgeBuilder setEnd(int end) {
            this.end = end;
            return this;
        }

        public RoadEdgeBuilder setTax(int tax) {
            this.tax = tax;
            return this;
        }

        public RoadEdge build() {
            return new RoadEdge(this);
        }
    }
}

public class Main_13907 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            ArrayList<RoadEdge> roadEdgeList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int tax = Integer.parseInt(st.nextToken());

                roadEdgeList.add(new RoadEdge.RoadEdgeBuilder()
                        .setStart(start)
                        .setEnd(end)
                        .setTax(tax).build());

                roadEdgeList.add(new RoadEdge.RoadEdgeBuilder()
                        .setStart(end)
                        .setEnd(start)
                        .setTax(tax).build());
            }
            int increseTax = 0;
            int dist[] = new int[N + 1];
            int maxTax = 30000 * 30000;
            dist = Arrays.stream(dist).map(x -> x = maxTax).toArray();
            dist[1] = 0;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i <= K; i++) {
                if (i > 0) {
                    st = new StringTokenizer(br.readLine());
                    increseTax += Integer.parseInt(st.nextToken());
                }
                dist = getBellmanFordArray(roadEdgeList, dist, N, increseTax);
                bw.write(dist[D]);
            }
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] getBellmanFordArray(ArrayList<RoadEdge> roadEdgeList, int[] dist, int n, int increseTax) {
        int maxTax = 30000 * 30000;
        dist = Arrays.stream(dist).map(x -> x = maxTax).toArray();
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (RoadEdge roadEdge : roadEdgeList) {
                int a = roadEdge.getStart();
                int b = roadEdge.getEnd();
                int w = roadEdge.getTax();
                if (dist[a] != maxTax && dist[b] > dist[a] + w + increseTax) {
                    dist[b] = dist[a] + w + increseTax;
                }
            }
        }
        return dist;
    }

}

