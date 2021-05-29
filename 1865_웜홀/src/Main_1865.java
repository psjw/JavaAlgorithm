import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RoadEdge {
    private int start;
    private int end;
    private int time;

    public RoadEdge(RoadEdgeBudiler builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.time = builder.time;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTime() {
        return time;
    }

    public static class RoadEdgeBudiler {
        private int start;
        private int end;
        private int time;

        public RoadEdgeBudiler setStart(int start) {
            this.start = start;
            return this;
        }

        public RoadEdgeBudiler setEnd(int end) {
            this.end = end;
            return this;
        }

        public RoadEdgeBudiler setTime(int time) {
            this.time = time;
            return this;
        }

        public RoadEdge build() {
            return new RoadEdge(this);
        }
    }

}


public class Main_1865 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long maxTime = 2 * 2500 * 200;
        try {
            int testCase = Integer.parseInt(br.readLine());
            for (int testCnt = 0; testCnt < testCase; testCnt++) {
                List<RoadEdge> roadEgeList = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer n = Integer.parseInt(st.nextToken());
                Integer m = Integer.parseInt(st.nextToken());
                Integer w = Integer.parseInt(st.nextToken());

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    int time = Integer.parseInt(st.nextToken());

                    roadEgeList.add(new RoadEdge.RoadEdgeBudiler()
                            .setStart(start)
                            .setEnd(end)
                            .setTime(time).build());
                    roadEgeList.add(new RoadEdge.RoadEdgeBudiler()
                            .setStart(end)
                            .setEnd(start)
                            .setTime(time).build());

                }
                for (int i = 0; i < w; i++) {
                    st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    int time = Integer.parseInt(st.nextToken());
                    roadEgeList.add(new RoadEdge.RoadEdgeBudiler()
                            .setStart(start)
                            .setEnd(end)
                            .setTime(-1 * time).build());
                }

                long[] dist = new long[n + 1];
                dist = Arrays.stream(dist).map(x -> x = 0).toArray();

                boolean negativeCycle = false;
                for (int k = 1; k <= n; k++) {
                    for (RoadEdge roadEdge : roadEgeList) {
                        int rStart = roadEdge.getStart();
                        int rEnd = roadEdge.getEnd();
                        int rTime = roadEdge.getTime();
                        if (dist[rEnd] > dist[rStart] + rTime) {
                            dist[rEnd] = dist[rStart] + rTime;
                            if (k == n) {
                                negativeCycle = true;
                            }
                        }
                    }
                }
                if (negativeCycle) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
