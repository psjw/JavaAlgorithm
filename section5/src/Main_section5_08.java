import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//오답
class Person {
    int idx;
    int emergencyRate;

    public Person(int idx, int emergencyRate) {
        this.idx = idx;
        this.emergencyRate = emergencyRate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idx=" + idx +
                ", emergencyRate=" + emergencyRate +
                '}';
    }
}

public class Main_section5_08 {

    public static int solution(int[] arr, int n, int m) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
//        System.out.println(m);
        Person patients = new Person(m, arr[m]);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        int count = 0;

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            count = 0;
            for (Person person : queue) {
                if (person.emergencyRate > tmp.emergencyRate) {
                    queue.offer(tmp);
                    tmp = null;
                    count++;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.idx == m) return answer;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(arr, n, m));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
