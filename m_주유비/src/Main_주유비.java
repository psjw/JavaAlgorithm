import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

1
4 8
3 1 2 7
5 3 6

25

1
4 8
3 1 10 7
5 3 6


1
4 9
3 1 3 7
5 3 8

1
4 4
1 1 1 1
3 3 4

*/
public class Main_주유비 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int testCount = Integer.parseInt(br.readLine());
            for (int testCnt = 0; testCnt < testCount; testCnt++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int totalCityCount = Integer.parseInt(st.nextToken());
                int carCapacity = Integer.parseInt(st.nextToken());
                int currentCapacity = 0;

                st = new StringTokenizer(br.readLine());
                int count = 0;
                //기름가격
                long[] cost = new long[totalCityCount];
                while (st.hasMoreTokens()) {
                    cost[count] = Long.parseLong(st.nextToken());
                    count++;
                }

                count = 0;
                //거리
                long[] distance = new long[totalCityCount - 1];
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    distance[count] = Long.parseLong((st.nextToken()));
                    count++;
                }


                long result = 0;
                long minCost = cost[0];
                boolean isImpossibleCheck = false;
                int currentDistance = 0;
                boolean isCheckDist = false;
                for (int i = 0; i < totalCityCount - 1; i++) {
                    if (distance[i] > carCapacity) {
                        isImpossibleCheck = true;
                        break;
                    }
                    if (cost[i] < minCost) {
                        minCost = cost[i];
                        currentDistance = 0;
                    }
                    currentDistance += distance[i];
                    if (currentDistance > carCapacity) {
                        result += cost[i] * (currentDistance - carCapacity);
                        distance[i] -= (currentDistance - carCapacity);
                        currentDistance -= carCapacity;
                        isCheckDist = true;
                    }
                    result += (minCost * distance[i]);
                    if(isCheckDist){
                        minCost = cost[i];
                        isCheckDist = false;
                    }

                }
                if (isImpossibleCheck) {
                    bw.write("impossible\n");
                } else {
                    bw.write(result + "\n");
                }
                bw.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
