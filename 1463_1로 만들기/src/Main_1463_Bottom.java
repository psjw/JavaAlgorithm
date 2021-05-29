import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_Bottom {
    public static int[] d = new int[1000001];

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            d[0] = 0;
            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 1] + 1;
                if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                    d[i] = d[i / 2] + 1;
                }
                if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                    d[i] = Math.min(d[i], d[i / 3] + 1);
                }
            }
            System.out.println(d[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
