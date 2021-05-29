import java.io.*;

public class Main_1463_Top {
    public static int[] d ;


    public static int makeOne(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];

        d[n] = makeOne(n - 1) + 1;
        if (n % 2 == 0) {
            int tmp = makeOne(n / 2) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        if (n % 3 == 0) {
            int tmp = makeOne(n / 3) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        return d[n];
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            d = new int[n + 1];
            bw.write(makeOne(n)+"\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
