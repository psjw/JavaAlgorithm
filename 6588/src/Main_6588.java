import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6588 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 1000000;
        boolean[] visit = new boolean[max + 1];
        int[] prime = new int[max + 1];
        int index = 0;
        try {
            for (int i = 2; i <= max; i++) {
                if (visit[i])
                    continue;
                prime[index] = i;
                index++;
                for (int j = i + i; j <= max; j += i) {
                    visit[j] = true;
                }
            }

            int count = 0;
            while (true) {
                String temp = br.readLine();
                count = 0;

                int a = Integer.parseInt(temp);
                if (a == 0)
                    break;

                for (int k = 0; k < index; k++) {
                    if (a - prime[k] < 0) {
                        break;
                    } else if (visit[a - prime[k]] == false) {
                        count++;
                        System.out.println(a + " = " + prime[k] + " + " + (a - prime[k]));
                        break;
                    }
                }
                if (count == 0 && a != 0) {
                    System.out.println("Goldbach's conjecture is wrong.");
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
