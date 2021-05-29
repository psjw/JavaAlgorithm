
import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Session implements Comparable<Session>{
    int startTime;
    int endTime;

    public Session(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Session{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(Session o) {
        if (this.endTime < o.endTime) {
            return -1;
        } else if (this.endTime == o.endTime) {
            if (this.startTime < o.startTime) {
                return -1;
            } else if (this.startTime == o.startTime) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}


class Result {




    public static int solution(List<Integer> start_time, List<Integer> running_time) {
        // Write your code here
        int last = Integer.MIN_VALUE;
        int answer = 0;
        Session[] sessions = new Session[start_time.size()];
        for (int i=0; i<start_time.size(); i++) {
            int startTime = start_time.get(i);
            int endTime = startTime + running_time.get(i);
            sessions[i] = new Session(startTime, endTime);
        }
        Arrays.sort(sessions);

        for (int i=0; i<sessions.length; i++) {
            if (last <= sessions[i].startTime) {
                last = sessions[i].endTime;
                answer += 1;
            }
        }
        return answer;
    }
}


public class Main_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int start_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> start_time = IntStream.range(0, start_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int running_timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> running_time = IntStream.range(0, running_timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.solution(start_time, running_time);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

