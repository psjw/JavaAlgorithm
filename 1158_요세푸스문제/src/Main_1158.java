import com.sun.source.doctree.UnknownBlockTagTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            Queue<Integer> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }

            int count = 0;
            while(queue.size()>0){
                Integer firstQueueValue = queue.poll();
                count++;
                if(count == k){
                    count = 0;
                    sb.append(firstQueueValue);
                    if(queue.size() > 0){
                        sb.append(", ");
                    }else{
                        sb.append(">");
                    }

                    continue;
                }
                queue.add(firstQueueValue);

            }
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
