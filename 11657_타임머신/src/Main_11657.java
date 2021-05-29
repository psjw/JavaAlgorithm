import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


class BusEdge {
    private Integer start;
    private Integer end;
    private Integer cost;

    private BusEdge(BusEdgeBuilder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.cost = builder.cost;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getCost() {
        return cost;
    }

    public static class BusEdgeBuilder {
        private int start;
        private int end;
        private int cost;

        public BusEdgeBuilder() {
        }

        public int getStart() {
            return start;
        }

        public BusEdgeBuilder setStart(int start) {
            this.start = start;
            return this;
        }

        public int getEnd() {
            return end;
        }

        public BusEdgeBuilder setEnd(int end) {
            this.end = end;
            return this;
        }

        public int getCost() {
            return cost;
        }

        public BusEdgeBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }

        public BusEdge build() {
            return new BusEdge(this);
        }

    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", cost=" + cost +
                '}';
    }
}


public class Main_11657 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<BusEdge> edgeList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edgeList.add(new BusEdge.BusEdgeBuilder()
                        .setStart(start)
                        .setEnd(end)
                        .setCost(cost).build());
            }

            long dist[] = new long[n + 1];
            // 1 - > N 10000*N
            int maxCost = 500 * 10000;
            dist = Arrays.stream(dist).map(x -> x = maxCost).toArray();
            dist[1] = 0;
            //음수사이클
            boolean negativeCycle = false;
            for (int i = 1; i <= n; i++) {
                for (BusEdge busEdge : edgeList) {
                    int start = busEdge.getStart();
                    int end = busEdge.getEnd();
                    int cost = busEdge.getCost();
                    if (dist[start] != maxCost&& dist[end]> dist[start] + cost) {
                        dist[end] = dist[start] + cost;
                        if( i == n){
                            negativeCycle = true;
                        }
                    }
                }
            }
            if(negativeCycle){
                System.out.println("-1");
            }else{
                for(int i=2 ; i<=n; i++){
                    if(dist[i]==maxCost){
                        dist[i] = -1;
                    }
                    System.out.println(dist[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
